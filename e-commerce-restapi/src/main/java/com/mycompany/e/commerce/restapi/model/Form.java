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
public class Form {
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String address1;
    private String state;
    private String city;
    private String zip;
    private String ccnum;
    private String cvv;
    private String expiration;

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

    public void setAdddress1(String address1) {
        this.address1 = address1;
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

    public void setCcv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
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

    public String getAddress1() {
        return address1;
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

    public String getCvv() {
        return cvv;
    }

    public String getExpiration() {
        return expiration;
    }
    
    public String getPhone(){
        return phone;
    }
    
    
    
}
