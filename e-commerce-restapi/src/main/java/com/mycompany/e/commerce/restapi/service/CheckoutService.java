/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.service;

import com.mycompany.e.commerce.restapi.db.DatabaseConnector;
import com.mycompany.e.commerce.restapi.db.DatabaseUtils;
import com.mycompany.e.commerce.restapi.model.Form;
import com.mycompany.e.commerce.restapi.model.Order;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weizhang
 */
public class CheckoutService {
    
    public static void insertForm(Form form, List<Order> order){
        Connection connection = DatabaseConnector.getConnection();
        String ccSql = "INSERT INTO creditcards (cid, ccnum, cvv, expiration) VALUES (?, ?, ?, ?)";
        String customerSql = "INSERT INTO customers (fname, lname, email, phone, street_address, city, us_state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String orderSql = "INSERT INTO orders (cid, ccnum, pid, quantity, order_date, total) VALUES (?, ?, ?, ?, ?, ?)";
        
        int cid = DatabaseUtils.performDBSubmitCustomer(connection, customerSql, form.getFname(), form.getLname(), form.getEmail(), form.getPhone(), form.getAddress1(), form.getState(), form.getCity(), form.getZip());
        
        DatabaseUtils.performDBSubmitCC(connection, ccSql, String.valueOf(cid), form.getCcnum(), form.getCvv(), form.getExpiration());
        
        for(int i = 0; i < order.size(); i++){
            DatabaseUtils.performDBSubmitOrder(connection, orderSql, String.valueOf(cid), form.getCcnum(), order.get(i).getPid(), String.valueOf(order.get(i).getQuantity()), order.get(i).getDate(), String.valueOf(order.get(i).getTotal()));
        }
        
    }
}
