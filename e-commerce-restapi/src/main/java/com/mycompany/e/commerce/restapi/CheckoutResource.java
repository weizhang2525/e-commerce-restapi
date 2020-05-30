/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.e.commerce.restapi;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author weizhang
 */
@Path("/")
public class CheckoutResource {
    @GET
    @Path("/test")
//    @Consumes({MediaType.APPLICATION_JSON})
    public String getIt(){
        return "Got it!";
    }
    
}
