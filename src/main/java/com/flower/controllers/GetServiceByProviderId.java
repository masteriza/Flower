package com.flower.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flower.Service;
import com.flower.dao.DAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.flower.util.ClassNameUtil.getCurrentClassName;

public class GetServiceByProviderId extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String strIdProvider = req.getParameter("idProvider");
        int idProvider = Integer.parseInt(strIdProvider);
        logger.info(idProvider);

        DAO service = new DAO();
        List<Service> currentService = null;
        currentService = service.getServiceByProviderId(idProvider);


        //logger.info(currentService);

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        mapper.writeValue(out, currentService);
    }
}
