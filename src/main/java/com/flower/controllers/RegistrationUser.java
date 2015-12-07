package com.flower.controllers;
/**
 * Created by user on 18.11.2015.
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import com.flower.User;
import com.flower.dao.DAO;
import com.flower.util.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import static com.flower.util.ClassNameUtil.getCurrentClassName;


public class RegistrationUser extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String answerMessage = "";
        Boolean errorEmail = false;
        Boolean errorAlreadyRegistered = false;
        Boolean errorPassword = false;
        Boolean errorVerifyPassword = false;
        Boolean errorFirstName = false;
        Boolean errorLastName = false;
        Boolean errorPhone = false;

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String verifyPassword = req.getParameter("verifyPassword");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");

        logger.info(email);

        EmailValidator emailValidator = new EmailValidator();
        if (emailValidator.validate(email) == false) {
            errorEmail = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
            //boolean validEmail = emailValidator.validate(email);
            //logger.info(email + " " + validEmail);
        }
        DAO checkUser = new DAO();
        if (checkUser.checkUserEmail(email) != 0) {
            errorAlreadyRegistered = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        PasswordValidator passwordValidator = new PasswordValidator();
        if (passwordValidator.validate(password) == false) {
            errorPassword = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
            //boolean validPassword = passwordValidator.validate(password);
            //logger.info(password + " " + validPassword);
        }

        if (password.equals(verifyPassword) == false) {
            errorVerifyPassword = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        CharacterValidator characterValidatorFN = new CharacterValidator();
        if (characterValidatorFN.validate(firstName) == false) {
            errorFirstName = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        CharacterValidator characterValidatorLN = new CharacterValidator();
        if (characterValidatorLN.validate(lastName) == false) {
            errorLastName = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }


        DigitalValidator digitalValidator = new DigitalValidator();
        if (digitalValidator.validate(phone) == false) {
            errorPhone = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        if (errorEmail == true) {
            answerMessage = answerMessage + "<li>incorrect e-mail field</li>";
        }

        if (errorAlreadyRegistered == true) {
            answerMessage = answerMessage + "<li>this email is already registered, please choose another one</li>";
        }

        if (errorPassword == true) {
            answerMessage = answerMessage + "<li>incorrect password field</li>";
        }

        if (errorVerifyPassword == true) {
            answerMessage = answerMessage + "<li>password mismatch</li>";
        }

        if (errorFirstName == true) {
            answerMessage = answerMessage + "<li>enter your first name</li>";
        }

        if (errorLastName == true) {
            answerMessage = answerMessage + "<li>enter your last name</li>";
        }

        if (errorPhone == true) {
            answerMessage = answerMessage + "<li>enter your phone number</li>";
        }

        if ((errorEmail == true) || (errorPassword == true) || (errorVerifyPassword == true) || (errorFirstName == true) || (errorLastName == true) || (errorPhone == true) || (errorAlreadyRegistered == true)) {
            answerMessage = answerMessage + "<ul>";

            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            mapper.writeValue(out, answerMessage);
        } else {

            String passwordSalt = email + password;
            User newUser = new User();

            CalcMD5 passwordSaltMD5 = new CalcMD5();
            newUser.setEmail(email);
            newUser.setPassword(passwordSaltMD5.getHash(passwordSalt));
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setPhone(phone);

            logger.info(newUser.toString());

            DAO createNewUser = new DAO();
            try {

                User registeredUser = createNewUser.createNewUser(newUser);
                CalcMD5 emailMD5 = new CalcMD5();
                EmailSender emailSender = new EmailSender("onlinemasteriza@gmail.com", "Masteriza_9910360");

                String emailText = "You have been registered Internet provider Flower. To activate the account click on the link " +
                        "http://localhost:8888/Flower/ActivationUserAccount?id=" + registeredUser.getIdUser() + "&email=" + emailMD5.getHash(registeredUser.getEmail());

                emailSender.send("Confirmation of registration", emailText, "flower@gmail.com", registeredUser.getEmail());

                req.getSession().setAttribute("Message", "THANK YOU FOR REGISTERING! <br/>" +
                        "Check your email and click the link to confirm your registration");

                ObjectMapper mapper = new ObjectMapper();
                resp.setContentType("application/json;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                mapper.writeValue(out, "");

                //String contextPath = req.getContextPath();
                //resp.sendRedirect(contextPath + "/message.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //logger.info(passwordSalt);
        }
    }
}