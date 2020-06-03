package com.mycompany.e.commerce.restapi;

import com.mycompany.e.commerce.restapi.service.ProductService;
import com.mycompany.e.commerce.restapi.model.Product;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import javax.ws.rs.*;

/**
 *
 * @author Apon
 */
@Path("/findProduct/")
public class findProduct {

    /**
     * This is where the GET request for the homepage is handled. It asks the ProductService for all the products
     * and then returns them to the front end. The front end will then display those products.
     * 
     * NOTE: The objects returned are not JSON objects, but rather objects that we define in the .model package.
     */
    @GET
    @Path("product")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Product> getProducts(){        
        ArrayList<Product> productList = ProductService.getAllProducts();
        return productList;
    }
}