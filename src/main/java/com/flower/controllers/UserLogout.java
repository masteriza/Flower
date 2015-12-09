package com.flower.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flower.dao.DAO;
import com.flower.util.CalcMD5;
import com.flower.util.EmailSender;
import com.flower.util.EmailValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.flower.util.ClassNameUtil.getCurrentClassName;

/**
 * Created by user on 04.12.2015.
 */
public class UserLogout extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }
    }
}