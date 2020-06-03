/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.service;

import com.mycompany.e.commerce.restapi.db.DatabaseConnector;
import com.mycompany.e.commerce.restapi.db.DatabaseUtils;
import com.mycompany.e.commerce.restapi.model.Product;
import com.mycompany.e.commerce.restapi.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author jonathanlun
 */
public class OrderService {
    
    public static ArrayList<Order> getAllOrders(int customer) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            String sqlQuery = "SELECT * FROM orders WHERE cid =";
            sqlQuery += customer;
            ResultSet queryResult = DatabaseUtils.performDBGetAllOrders(connection, sqlQuery);
            ArrayList<Order> orderList = new ArrayList<Order>();
    
            while(queryResult.next()) {
                Order oneorder = new Order(queryResult.getString("pid"),
                        queryResult.getInt("quantity"),
                        queryResult.getDouble("total"),
                        queryResult.getString("date"));
                orderList.add(oneorder);
            }

            return orderList;

        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.toString());
            e.printStackTrace();
            return null;
        }

    }
}
