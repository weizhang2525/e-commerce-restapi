/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.model;

/**
 *
 * @author jonathanlun
 */
public class OrderProduct {
    private String pid;
    private String name;
    private String price;
    private double quantity;
    private String srcOne;
    private String alt;

    public OrderProduct(String pid, String name, String price, double quantity, String srcOne, String alt) {
        this.pid = pid;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.srcOne = srcOne;
        this.alt = alt;
    }
    public String getPid(){
        return this.pid;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPrice(){
        return this.price;
    }

    public double getQuantity(){
        return this.quantity;
    }
    
    public String getSrcOne(){
        return this.srcOne;
    }

    public String getAlt(){
        return this.alt;
    }
}
