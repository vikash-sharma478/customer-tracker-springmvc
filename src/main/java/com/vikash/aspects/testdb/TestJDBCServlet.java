package com.vikash.crm.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TestJDBCServlet - Verifies database connection from the web application.
 * Author: Vikash Kumar
 */
@WebServlet("/testdb")
public class TestJDBCServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
        String dbUser = "springstudent";
        String dbPassword = "springstudent";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            response.getWriter().println("✅ Successfully connected to: " + jdbcUrl);
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("❌ Database connection failed: ", e);
        }
    }
}
