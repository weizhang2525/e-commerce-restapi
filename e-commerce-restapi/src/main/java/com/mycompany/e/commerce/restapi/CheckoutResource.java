/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi;
import javax.ws.rs.*;
import com.mycompany.e.commerce.restapi.model.Form;
import com.mycompany.e.commerce.restapi.model.Order;
import com.mycompany.e.commerce.restapi.service.CheckoutService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author weizhang
 */
@Path("/submitform/")
public class CheckoutResource {
    
    
    
    @GET
    @Path("test")
//    @Consumes({MediaType.APPLICATION_JSON})
    public String getIt(){
        return "Got it!";
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public Response submitOrders(@FormParam("fname") String fname, @FormParam("lname") String lname, @FormParam("email") String email, @FormParam("phone") String phone,
    @FormParam("address1") String address1, @FormParam("city") String city, @FormParam("state") String state, @FormParam("zip") String zip, @FormParam("ccnum") String ccnum,
    @FormParam("expiration") String expiration, @FormParam("cvv") String cvv, @Context
    HttpServletRequest request){
        HttpSession session = request.getSession();
        Form form = new Form(fname, lname, email, phone, address1, city, state, zip, ccnum, cvv, expiration);
        
//        List<Order> orders = (ArrayList<Order>)session.getAttribute("cart");

        List<Order> orders = new ArrayList<Order>();
        
        Order order1 = new Order("1A", 3, 2.23);
        Order order2 = new Order("2R", 2, 3.23);
        orders.add(order1);
        orders.add(order2);
        
        if(CheckoutService.insertForm(form, orders)){
            return Response.ok().entity("Order Added Successfully").build();
        }
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    
}
