/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.model;

import java.util.Date;

/**
 *
 * @author weizhang
 */
public class Order {
    private String pid;
    private int quantity;
    private String date;
    private double total;
    private double price;

    public Order(String pid, int quantity,  double price) {
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Order(String pid, int quantity, double total, String date){
        this.pid = pid;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }
    
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;  
   }

    public String getPid() {
        return pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public double getTotal() {
        total = Math.round(price * quantity*100.0)/100.0;
        return total;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal() {
        this.total = price * quantity;
    }
    
    
    
}
