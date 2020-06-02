/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.model;

/**
 *
 * @author weizhang
 */

public class Product {

    private String pid;
    private String name;
    private double price;
    private String desc;
    private double quantity;
    private String srcOne;
    private String srcTwo;
    private String srcThree;
    private String alt;

    public Product(String pid, String name, double price, String desc, double quantity, String srcOne, String srcTwo, String srcThree, String alt) {
        this.pid = pid;
        this.price = price;
        this.name = name;
        this.desc = desc;
        this.quantity = quantity;
        this.srcOne = srcOne;
        this.srcTwo = srcTwo;
        this.srcThree = srcThree;
        this.alt = alt;
    }

    public Product(String pid, double price, String name){
        this.pid = pid;
        this.price = price;
        this.name = name;
    }

    public String getPid(){
        return this.pid;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getPrice(){
        return this.price;
    }

    public String getDesc(){
        return this.desc;
    }

    public double getQuantity(){
        return this.quantity;
    }
    
    public String getSrcOne(){
        return this.srcOne;
    }

    public String getSrcTwo(){
        return this.srcTwo;
    }

    public String getSrcThree(){
        return this.srcThree;
    }

    public String getAlt(){
        return this.alt;
    }
}

