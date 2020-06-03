/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi;
import javax.ws.rs.*;
import com.mycompany.e.commerce.restapi.model.Form;
import com.mycompany.e.commerce.restapi.model.Order;
import com.mycompany.e.commerce.restapi.model.Product;
import com.mycompany.e.commerce.restapi.service.OrderService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author weizhang
 */
@Path("/confirmpage/")
public class OrderResource {
    
    /**
     * This is where the GET request for the confirm is handled. It asks the OrderService for all the orders with the session's cid
     * and then returns them to the front end. The front end will then display those orders.
     * 
     * NOTE: The objects returned are not JSON objects, but rather objects that we define in the .model package.
     */
    
    @GET
    @Path("loadpage")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Order> getProducts(HttpServletRequest request){ 
        HttpSession session = request.getSession();
        int customer = (Integer)(session.getAttribute("cid"));
        ArrayList<Order> orderList = OrderService.getAllOrders(customer);
        return orderList;
    }
    
}
