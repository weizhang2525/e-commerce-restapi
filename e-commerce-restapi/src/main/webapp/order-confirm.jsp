<%-- 
    Document   : order-confirm
    Created on : Jun 3, 2020, 4:19:46 AM
    Author     : jonathanlun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.e.commerce.restapi.model.CustomerOrder"%>
<%@page import="com.mycompany.e.commerce.restapi.model.OrderProduct"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/order_info.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <!--
    <script>
        $(document).ready(function(){
            $.get("OrderConfirm", function(data){
                console.log(data);
                var orderUI = $("#order");
                var orderJSON = JSON.parse(data);
                orderUI.append("<p class = 'secondelem'> Order Date: ");
                orderUI.append(orderJSON[0].date);
                orderUI.append("</p>");
                
                orderUI.append("<h5> Customer Information </h5>");
                orderUI.append("<p class = 'secondelem'>Name: ");
                orderUI.append(orderJSON[1].name);
                orderUI.append("</p>");
                orderUI.append("<p class = 'secondelem'> Email: ");
                orderUI.append(orderJSON[1].email);
                orderUI.append("</p>");
                orderUI.append("<p class = 'secondelem'> Phone: ");
                orderUI.append(orderJSON[1].phone);
                orderUI.append("</p>");
                orderUI.append("<p class = 'secondelem'> Address: </br>");
                orderUI.append(orderJSON[1].address);
                orderUI.append("</br>");
                orderUI.append(orderJSON[1].csz);
                orderUI.append("</p>");

                orderUI.append("<h5> Payment Info </h5>");
                orderUI.append("<p class = 'secondelem'>Credit card number: ");
                orderUI.append(orderJSON[2].ccnum);
                orderUI.append("</p>");
                orderUI.append("<p class = 'secondelem'> Expiration Date: ");
                orderUI.append(orderJSON[2].exp);
                orderUI.append("</p>");
                orderUI.append("<h5> Total </h5>");
//                for(var i = 3; i < orderJSON.length - 1; i++){
////                    console.log(orderJSON[i]);
//                    orderUI.append("<p class = 'secondelem'>ProductID: "+ orderJSON[i].pid+ " Name: "+ orderJSON[i].name + " Qty: "+ orderJSON[i].quantity + "</p>");
//                }
                orderUI.append("$" + orderJSON[orderJSON.length -1].t)
            });
        });
    </script>
    -->
    <script>
        $(document).ready(function(){

            console.log("TEST 0 - LOADED");

            $.ajax({
                url: '/e-commerce-restapi/restapi/confirmpage/loadpage',
                type: 'GET',
                success: function(customer) {
                    // Get the results from the service
                    console.log(customer);
                    generateOrderConfirm(customer, "order");
                },
                error: function() {
                    alert("Error");
                }
                });
                
            function generateOrderConfirm(customer, container) {
                DOM_products_container = document.getElementById(container);
                    
                //Products info
                order_details = this.document.createElement("h5");
                order_details.innerHTML = "Product Information";
                order_details = this.document.createElement("ul");
                products = customer.items;
                for (var i = 0; i < products.length; i++) {
                    order_details = this.document.createElement("li");
                    order_details.classList.add("service-list");
                    order_details = this.document.createElement("IMG");
                    order_details.src = products[i].srcOne;
                    DOM_products_container.appendChild(order_details);
                    order_details = this.document.createElement("p")
                    order_details.innerHTML = "Product ID: " + products[i].pid + " Name: " + products[i].name + " Quantity: " + products[i].quantity + " Price: " + products[i].price;
                    DOM_products_container.appendChild(order_details);
                }


                //Customer info
                customer_details = this.document.createElement("h5");
                customer_details.innerHTML = "Customer Information";
                DOM_products_container.appendChild(customer_details);
                customer_details = this.document.createElement("p");
                customer_details.classList.add("secondelem");
                customer_details.innerHTML = "Name: " + customer.fname + " " + customer.lname;
                DOM_products_container.appendChild(customer_details);
                customer_details = this.document.createElement("p");
                customer_details.classList.add("secondelem");
                customer_details.innerHTML = "Email: " + customer.email;
                DOM_products_container.appendChild(customer_details);
                customer_details = this.document.createElement("p");
                customer_details.classList.add("secondelem");
                customer_details.innerHTML = "Phone: " + customer.phone;
                DOM_products_container.appendChild(customer_details);
                customer_details = this.document.createElement("p");
                customer_details.classList.add("secondelem");
                customer_details.innerHTML = "Address: " + customer.street_address + "</br>" + customer.city + ", " + customer.state + " " + customer.zip;

                DOM_products_container.appendChild(customer_details);

                //Credit Card info
                cc_details = this.document.createElement("h5");
                cc_details.innerHTML = "Credit Card Information";
                DOM_products_container.appendChild(cc_details);
                cc_details = this.document.createElement("p");
                cc_details.classList.add("secondelem");
                cc_details.innerHTML = "Credit Card Number: " + customer.ccnum;
                DOM_products_container.appendChild(cc_details);
                cc_details = this.document.createElement("p");
                cc_details.classList.add("secondelem");
                cc_details.innerHTML = "Credit Card Expiration: " + customer.expiration;

                DOM_products_container.appendChild(cc_details);
                
                //Total
                total_details = this.document.createElement("h3");
                total_details.innerHTML = "Total: " + customer.total;
                DOM_products_container.appendChild(total_details);
            }
        });
    </script>
</head>

<body>

    <!-- Nav Bar -->
    <nav class="navbar navbar-expand-lg fixed-top">
        <div class="container">
            <a class="navbar-brand" href="index.html">
                <img src="assets/Nuance9-Logo.png" alt="Nuance 9 Logo">
            </a>
            <div class="nav-bar-links-container">
                <div class="topnav" id="nav-bar-tabs">
                    <a href="index.jsp">Apparel</a>
                    <a href="about.html">About</a>
                </div>
            </div>

        </div>
    </nav>

    <div class="container">
        <div class="about" id ="order">
            <h1 class = "heading-title">
                Order Details
            </h1>
        </div>
    </div>
</body>
</html>
