/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.service;

import com.mycompany.e.commerce.restapi.db.DatabaseConnector;
import com.mycompany.e.commerce.restapi.db.DatabaseUtils;
import com.mycompany.e.commerce.restapi.model.Order;
import com.mycompany.e.commerce.restapi.model.CustomerOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author jonathanlun
 */
public class OrderService {
    
    public static CustomerOrder getAllOrders(int customer) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            //Get the orders based on cid value
            String sqlQueryOrder = "SELECT * FROM orders WHERE cid = (cid) VALUES (?)";
            ResultSet orderResult = DatabaseUtils.performDBGetAllOrders(connection, sqlQueryOrder, customer);
            ArrayList<Order> orderList = new ArrayList<Order>();
            while(orderResult.next()) {
                Order oneorder = new Order(orderResult.getDouble("total"),
                        orderResult.getString("pid"),
                        orderResult.getInt("quantity"));
                orderList.add(oneorder);
            }
            
            //Gets customer information based on cid
            String sqlQueryCustomer = "SELECT * FROM customers WHERE cid (cid) VALUES (?)";
            ResultSet customerResult = DatabaseUtils.performDBGetAllOrders(connection, sqlQueryCustomer, customer);
            customerResult.next();
            CustomerOrder overall = new CustomerOrder(customerResult.getString("fname"),
                                                        customerResult.getString("lname"),
                                                        customerResult.getString("email"),
                                                        customerResult.getString("phone"),
                                                        customerResult.getString("street_address"),
                                                        customerResult.getString("city"),
                                                        customerResult.getString("us_state"),                                  
                                                        customerResult.getString("zip"),
                                                        orderList);
            
            //gets creditcard information based on cid
            String sqlQueryCredit = "SELECT * FROM creditcards WHERE cid (cid) VALUES (?)";
            ResultSet creditResult = DatabaseUtils.performDBGetAllOrders(connection, sqlQueryCredit, customer);
            creditResult.next();
            overall.setCcnum(creditResult.getString("ccnum"));
            overall.setExpiration(creditResult.getString("expiration"));
            
            return overall;
            
        }catch (Exception e) {
            System.out.println("[ERROR]: " + e.toString());
            e.printStackTrace();
            return null;
        }

    }
}
