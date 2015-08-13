package com.flower.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDAO {
    private DataSource dataSource;

    public MyDAO() throws ServletException {
        if (dataSource != null) {
            return;
        }
        try {
            Context ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/ConnectionPool");
        } catch (NamingException ex) {
            throw new ServletException(
                    "Cannot retrieve java:comp/env/jdbc/ConnectionPool", ex);
        }
    }

    public Connection getConnection() throws ServletException {
        try {
            Connection conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException ex) {
            throw new ServletException(
                    "Cannot obtain connection", ex);
        }
    }

    public void releaseConnection(Connection conn) throws ServletException {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new ServletException(
                    "Cannot release connection2", ex);
        }
    }

    public List<Emp> getAllEmp() throws ServletException {
        List<Emp> allEmp = new ArrayList<Emp>();
        Connection conn = null;
        try {
            conn = getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT USER_ID, CREATED_BY FROM DBUSER");
            while (rs.next()) {
                allEmp.add(new Emp(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {

            throw new ServletException("Cannot obtain connection3", ex);
        } finally {
            if (conn != null) {
                releaseConnection(conn);
            }
        }
        return allEmp;
    }
}