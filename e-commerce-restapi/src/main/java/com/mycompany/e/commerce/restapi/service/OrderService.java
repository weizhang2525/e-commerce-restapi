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
import com.mycompany.e.commerce.restapi.model.OrderProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author jonathanlun
 */
public class OrderService {
    
    public static CustomerOrder getAllOrders() {
        try {
            System.out.println("getAllOrders");
            Connection connection = DatabaseConnector.getConnection();
            String sqlMaxOrder = "SELECT MAX(orderid) AS LastOrder FROM orders";
            ResultSet max = DatabaseUtils.performDBMaxCustomer(connection, sqlMaxOrder);
            max.next();
            int maxorder = max.getInt("LastOrder");
            String sqlMaxCust = "SELECT * FROM orders WHERE orderid = ?";
            ResultSet maxCust = DatabaseUtils.performDBGetAllOrders(connection, sqlMaxCust, maxorder);
            maxCust.next();
            int customer = maxCust.getInt("cid");
            //Get the orders based on cid value
            String sqlQueryOrder = "SELECT * FROM orders WHERE cid = ?";
            System.out.println("***************************order");
            ResultSet orderResult = DatabaseUtils.performDBGetAllOrders(connection, sqlQueryOrder, customer);
            ArrayList<OrderProduct> orderList = new ArrayList<OrderProduct>();
            double total = 0;
            while(orderResult.next()) {
                total += orderResult.getDouble("total");
                String product = orderResult.getString("pid");
                System.out.println(product);
                String sqlQueryProduct = "SELECT * FROM products WHERE pid = ?";
                System.out.println("***********************products");
                ResultSet productResult = DatabaseUtils.performDBGetProduct(connection, sqlQueryProduct, product);
                productResult.next();
                OrderProduct oneproduct = new OrderProduct(productResult.getString("pid"),
                                                            productResult.getString("pname"),
                                                            productResult.getString("price"),
                                                            orderResult.getDouble("quantity"),
                                                            productResult.getString("srcOne"),
                                                            productResult.getString("alt"));
                orderList.add(oneproduct);
            }
            total = Math.round(total * 100.0) / 100.0;
            
            //Gets customer information based on cid
            String sqlQueryCustomer = "SELECT * FROM customers WHERE cid = ?";
            System.out.println("****************************customer");
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
                                                        orderList,
                                                        total);
            

            //gets creditcard information based on cid
            String sqlQueryCredit = "SELECT * FROM creditcards WHERE cid = ?";
            System.out.println("*****************************cc");
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
