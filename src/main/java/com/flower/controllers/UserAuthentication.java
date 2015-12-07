package com.flower.controllers;
/**
 * Created by user on 29.11.2015.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flower.User;
import com.flower.dao.DAO;
import com.flower.util.CalcMD5;
import com.flower.util.EmailValidator;
import com.flower.util.PasswordValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import org.apache.log4j.Logger;

import static com.flower.util.ClassNameUtil.getCurrentClassName;


public class UserAuthentication extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String answerMessage = "";
        Boolean errorEmail = false;
        Boolean errorPassword = false;
        Boolean errorUnregisteredUser = false;

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        EmailValidator emailValidator = new EmailValidator();
        if (emailValidator.validate(email) == false) {
            errorEmail = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }
        DAO checkUser = new DAO();
        if (checkUser.checkUserEmail(email) == 0) {
            errorUnregisteredUser = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        PasswordValidator passwordValidator = new PasswordValidator();
        if (passwordValidator.validate(password) == false) {
            errorPassword = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        if ((errorEmail == true) || (errorPassword == true)) {
            answerMessage = answerMessage + "<li>Incorrect email or password</li>";
        }

        if (errorUnregisteredUser == true) {
            answerMessage = answerMessage + "<li>Your email address is not registered</li>";
        }

        if ((errorEmail == true) || (errorPassword == true) || (errorUnregisteredUser == true)) {
            answerMessage = answerMessage + "</ul>";


            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("error", answerMessage);

            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            mapper.writeValue(out, answerMessage);

        } else {

            String passwordSalt = email + password;
            User user = new User();

            CalcMD5 passwordSaltMD5 = new CalcMD5();
            user.setEmail(email);
            user.setPassword(passwordSaltMD5.getHash(passwordSalt));

            DAO checkEmailPassword = new DAO();
            checkEmailPassword.checkEmailAndPassword(user);
            if (user.getIdUser() == 0) {
                answerMessage = "<p>You must correct the following errors:</p><ul>" +
                        "<li>Incorrect email or password</li>" +
                        "<li>account is not activated</li></ul>";
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("error", answerMessage);

            } else {
                req.getSession().setAttribute("iduser", user.getIdUser());
                req.getSession().setAttribute("session", passwordSaltMD5.getHash(passwordSalt));

                ObjectMapper mapper = new ObjectMapper();
                resp.setContentType("application/json;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                mapper.writeValue(out, "");
            }


        }

    }
}