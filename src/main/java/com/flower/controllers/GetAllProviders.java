package com.flower.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flower.Provider;
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

public class GetAllProviders extends HttpServlet {
    private static final Logger logger = Logger.getLogger(getCurrentClassName());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        DAO allProviders = new DAO();
        List<Provider> providers = null;
        providers = allProviders.getAllProviders();
        logger.info(providers);

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        mapper.writeValue(out, providers);
    }
}
