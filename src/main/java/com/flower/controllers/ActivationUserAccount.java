package com.flower.controllers;

import com.flower.User;
import com.flower.dao.DAO;
import com.flower.util.CalcMD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

import static com.flower.util.ClassNameUtil.getCurrentClassName;

/**
 * Created by user on 25.11.2015.
 */
public class ActivationUserAccount extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String strIdUser = req.getParameter("id");
        int idUser = Integer.parseInt(strIdUser);

        String emailMD5 = req.getParameter("email");

        logger.info(String.valueOf(idUser));
        logger.info(emailMD5);

        DAO activationUserAccount = new DAO();
        User user = activationUserAccount.getUserById(idUser);

        CalcMD5 emailDBMD5 = new CalcMD5();
        String contextPath = req.getContextPath();

        if (emailMD5.equals(emailDBMD5.getHash(user.getEmail())) == true) {
            user.setIsActive(1);
            activationUserAccount.updateUserById(idUser);

            //req.getSession().setAttribute("UserID", user.getIdUser());
            //req.getSession().setAttribute("SessionID", user.getPassword());
            req.getSession().setAttribute("Message", "Congratulations, you successfully completed the registration. <br/>" +
                    "Now you can log in the site");

            //logger.info(contextPath);
            resp.sendRedirect(contextPath + "/message.jsp");
        } else {
            resp.sendRedirect(contextPath + "/index.jsp");
        }


        //logger.info(currentService);

        /*ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        mapper.writeValue(out, currentService);*/
    }
}
