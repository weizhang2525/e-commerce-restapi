/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.db;

import java.sql.*;

/**
 *
 * @author weizhang
 */
public class DatabaseConnector {
    
    private DatabaseConnector() {

    }

    public static Connection getConnection() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Nuance9?useSSL=false&serverTimezone=PST",
                    "test", "test");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
