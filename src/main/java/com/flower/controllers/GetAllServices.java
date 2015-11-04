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
import java.util.List;

import org.apache.log4j.Logger;

import static com.flower.util.ClassNameUtil.getCurrentClassName;

public class GetAllServices extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        DAO allServices = new DAO();
        List<Service> services = null;
        services = allServices.getAllServices();
        logger.info(services);

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        mapper.writeValue(out, services);
    }
}
