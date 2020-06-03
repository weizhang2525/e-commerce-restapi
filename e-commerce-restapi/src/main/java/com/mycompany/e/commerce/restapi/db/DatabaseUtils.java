/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.db;

import java.io.Console;
import java.sql.*;


/**
 *
 * @author weizhang
 */
public class DatabaseUtils {
    
    public static boolean performDBSubmitCC(Connection connection, String sql, String... params){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);


            int i = 1;
            for (String param : params) {

                if(i==1){
                     preparedStatement.setInt(i++, Integer.valueOf(param));
                }
                else{
                    preparedStatement.setString(i++, param);
                }

            }

            return preparedStatement.executeUpdate() > 0 ;
        }
        catch (SQLException e) {
            return false;
        }
    }  
    
    public static boolean performDBSubmitOrder(Connection connection, String sql, String... params){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);


            int i = 1;
            for (String param : params) {

                if(i==1 || i ==4){
                     preparedStatement.setInt(i++, Integer.valueOf(param));
                }
                else if(i == 6){
                    preparedStatement.setDouble(i++, Double.valueOf(param));
                }
                else{
                    preparedStatement.setString(i++, param);
                }

            }

            return preparedStatement.executeUpdate() > 0 ;
        }
        catch (SQLException e) {
            return false;
        }
    }  
    
    public static int performDBSubmitCustomer(Connection connection, String sql, String... params){
        PreparedStatement preparedStatement = null;
        int cid = 0;
        try{
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            int i = 1;
            for (String param : params) {

                preparedStatement.setString(i++, param);
            }

            preparedStatement.executeUpdate();
            
             ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                cid = Integer.parseInt(rs.getString(1));
            }
            
            return cid;
            
        }
        catch (SQLException e) {
            return -1;
        }
    }

    /**
     * This is where the DB is queried and the results are returned.
     */
    public static ResultSet performDBGetAllProduct(Connection connection, String sqlQuery){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeQuery();
            ResultSet queryResult = preparedStatement.getResultSet();
            return queryResult;
            
        } catch (SQLException e) {
            System.out.println("[ERROR]: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
    public static ResultSet performDBGetAllOrders(Connection connection, String sqlQuery, int customer){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, customer);
            preparedStatement.executeQuery();
            ResultSet queryResult = preparedStatement.getResultSet();
            return queryResult;
            
        } catch (SQLException e) {
            System.out.println("[ERROR]: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
