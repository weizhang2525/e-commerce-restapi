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
    
    public static boolean insertForm(Form form, List<Order> order){
        boolean updateStatus = true;
        
        Connection connection = DatabaseConnector.getConnection();
        String ccSql = "INSERT INTO creditcards (cid, ccnum, cvv, expiration) VALUES (?, ?, ?, ?)";
        String customerSql = "INSERT INTO customers (fname, lname, email, phone, street_address, city, us_state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String orderSql = "INSERT INTO orders (cid, ccnum, pid, quantity, order_date, total) VALUES (?, ?, ?, ?, ?, ?)";
        
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        
        int cid = DatabaseUtils.performDBSubmitCustomer(connection, customerSql, form.getFname(), form.getLname(), form.getEmail(), form.getPhone(), form.getAddress1(), form.getState(), form.getCity(), form.getZip());
        
        System.out.println(cid);
        
        DatabaseUtils.performDBSubmitCC(connection, ccSql, String.valueOf(cid), form.getCcnum(), form.getCvv(), form.getExpiration());
        
        for(Order o: order){
            updateStatus = DatabaseUtils.performDBSubmitOrder(connection, orderSql, String.valueOf(cid), form.getCcnum(), o.getPid(), String.valueOf(o.getQuantity()), currentTime, String.valueOf(o.getTotal()));
        }
        
        return updateStatus;
        
    }
    
    
}
