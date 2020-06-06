/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi.model;

import com.mycompany.e.commerce.restapi.model.OrderProduct;
import java.util.ArrayList;
/**
 *
 * @author jonathanlun
 */
public class CustomerOrder {
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String street_address;
    private String state;
    private String city;
    private String zip;
    private String ccnum;
    private String expiration;
    private ArrayList<OrderProduct> items;
    private double total;
    
    public CustomerOrder (String fname, String lname, String email, String phone, String street_address, String city, String state, String zip, ArrayList<OrderProduct> items, double total) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.items = items;
        this.total = total;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCcnum(String ccnum) {
        this.ccnum = ccnum;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
    
    public void setItems(ArrayList<OrderProduct> items) {
        this.items = items;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
   

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getCcnum() {
        return ccnum;
    }

    public String getExpiration() {
        return expiration;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public ArrayList<OrderProduct> getItems(){
        return items;
    }
    
    public double getTotal(){
        return total;
    }
}
