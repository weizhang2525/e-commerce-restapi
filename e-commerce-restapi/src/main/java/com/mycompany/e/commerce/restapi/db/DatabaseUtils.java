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
    
    public static int performDBSubmitCustomer(Connection connection, String sql, String... params){
        PreparedStatement preparedStatement = null;
        int cid = 0;
        try{
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            int i = 1;
            for (String param : params) {

                preparedStatement.setString(i++, param);
                
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if(rs.next()){
                    cid = Integer.parseInt(rs.getString(1));
                }

            }

            preparedStatement.executeUpdate();
            
            return cid;
            
        }
        catch (SQLException e) {
            return -1;
        }
    }
}
