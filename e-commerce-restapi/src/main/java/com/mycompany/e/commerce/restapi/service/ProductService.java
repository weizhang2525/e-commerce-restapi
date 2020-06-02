package com.mycompany.e.commerce.restapi.service;

import com.mycompany.e.commerce.restapi.db.DatabaseConnector;
import com.mycompany.e.commerce.restapi.db.DatabaseUtils;
import com.mycompany.e.commerce.restapi.model.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;

public class ProductService {

    /**
     * This is where DB results are processed and turned into Product objects. It establishes a connection, creates a query,
     * and then gets the results using that query. It then iterates over the results and creates a list of products.
     */
    public static ArrayList<Product> getAllProducts() {
        try {
            Connection connection = DatabaseConnector.getConnection();
            String sqlQuery = "SELECT * FROM products";
            ResultSet queryResult = DatabaseUtils.performDBGetAllProduct(connection, sqlQuery);
            ArrayList<Product> productList = new ArrayList<Product>();
    
            while(queryResult.next()) {
                Product newProduct = new Product(queryResult.getString("pid"),
                                                 queryResult.getString("pname"),
                                                 Double.parseDouble(queryResult.getString("price").replace("$", "")),
                                                 queryResult.getString("desc"),
                                                 Double.parseDouble(queryResult.getString("quantity")),
                                                 queryResult.getString("srcOne"),
                                                 queryResult.getString("srcTwo"),
                                                 queryResult.getString("srcThree"),
                                                 queryResult.getString("alt"));
                productList.add(newProduct);
            }

            return productList;

        } catch (Exception e) {
            System.out.println("[ERROR]: " + e.toString());
            e.printStackTrace();
            return null;
        }

    }
}