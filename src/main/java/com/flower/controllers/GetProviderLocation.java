package com.flower.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flower.Service;
import com.flower.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import static com.flower.util.ClassNameUtil.getCurrentClassName;

public class GetProviderLocation extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        /*DAO location = new DAO();
        List qwe = location.getProvider();


        PrintWriter out = resp.getWriter();
        logger.info("Это###################################################### информационное сообщение!");
        out.print("<h1>Hello Servlet</h1>");*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //PrintWriter out = resp.getWriter();
        //resp.setContentType("text/html");
        //resp.setHeader("Cache-control", "no-cache, no-store");
        /*resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Expires", "-1");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Max-Age", "86400");*/

        DAO serviceProvider = new DAO();
        List<Service> services = null;
        services = serviceProvider.getService();
        logger.info(services);

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //logger.info(resp.getWriter());
        mapper.writeValue(out, services);
        /*for (Service service : services) {
            logger.info(service);
            mapper.writeValue(out, service);

        }*/
        // out.println(serviceProvider.getService());
        //out.print("doPost Work!!!");

        //super.doPost(req, resp);
    }


}
