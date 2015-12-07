package com.flower.controllers;

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
import java.util.Calendar;


import static com.flower.util.ClassNameUtil.getCurrentClassName;

/**
 * Created by user on 07.12.2015.
 */
public class RecoveryUserPassword extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String answerMessage = "";
        Boolean errorEmail = false;
        Boolean errorRegisteredEmail = false;

        String email = req.getParameter("recovery_email");

        logger.info(email);

        EmailValidator emailValidator = new EmailValidator();
        if (emailValidator.validate(email) == false) {
            errorEmail = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        DAO checkUser = new DAO();
        if (checkUser.checkUserEmail(email) == 0) {
            errorRegisteredEmail = true;
            answerMessage = "<p>You must correct the following errors:</p><ul>";
        }

        if (errorEmail == true) {
            answerMessage = answerMessage + "<li>incorrect e-mail field</li>";
        }

        if (errorRegisteredEmail == true) {
            answerMessage = answerMessage + "<li>this email is newer registered, please choose another one</li>";
        }


        if ((errorEmail == true) || (errorRegisteredEmail == true)) {
            answerMessage = answerMessage + "<ul>";

            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            mapper.writeValue(out, answerMessage);
        } else {
            String password = "P@ssw0rd";

            logger.info(password);
            CalcMD5 passwordMD5 = new CalcMD5();
            String hashPassword = passwordMD5.getHash(password);

            DAO updateUserPassword = new DAO();
            updateUserPassword.updateUserPasswordByEmail(email, hashPassword);
            EmailSender emailSender = new EmailSender("onlinemasteriza@gmail.com", "Masteriza_9910360");
            String emailText = "Your password has been changed. Now your password is " + password;
            emailSender.send("Change password", emailText, "flower@gmail.com", email);
            req.getSession().setAttribute("Message", "Your password has been changed! Check your email");

            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            mapper.writeValue(out, "");
        }
    }
}