//package com.flower.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.flower.User;
//import com.flower.dao.DAO;
//import com.flower.util.CalcMD5;
//import com.flower.util.EmailValidator;
//import com.flower.util.PasswordValidator;
//import org.apache.log4j.Logger;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import static com.flower.util.ClassNameUtil.getCurrentClassName;
//
///**
// * Created by user on 04.12.2015.
// */
//public class CheckUserAuthentication extends HttpServlet {
//    private static final Logger logger = Logger.getLogger(getCurrentClassName());
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        User user = new User();
//
//        String uri = ((HttpServletRequest) req).getRequestURI();
//        logger.info(uri);
//
//        String url = ((HttpServletRequest) req).getRequestURI();
//        logger.info(url);
//
//        HttpSession session = ((HttpServletRequest) req).getSession();
//
//        int iduser = (Integer) session.getAttribute("iduser");
//        String hash = (String) session.getAttribute("session");
//
//
//        DAO CheckUserAuthentication = new DAO();
//        user = CheckUserAuthentication.checkUserAuthentication(iduser, hash);
//
//
//        if (user.getIdUser() == 0) {
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
//            requestDispatcher.forward(req, resp);
//        } else {
//            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/sec/useraccount.jsp");
//            requestDispatcher.forward(req, resp);
//        }
//
//
//    }
//
//}
