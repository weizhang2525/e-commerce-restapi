<%-- 
    Document   : Checkout-Page
    Created on : May 29, 2020, 1:49:04 PM
    Author     : weizhang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel= "stylesheet" href = "css/checkout-page.css">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src = "js/form.js"></script>


    <script>
        $(document).ready(function(){
            $.get("CartSession", function(data){
                var cartUI = $("#cart");
                var productJSON = JSON.parse(data);
                var total = 0;
                for(var i = 0; i < productJSON.length; i++){
//                    console.log(productJSON[i]);
                    cartUI.append("<p>ProductID: "+ productJSON[i].productID+ " Name: "+ productJSON[i].name + " Price: "+ productJSON[i].price + " Qty: "+ productJSON[i].quantity + "</p>");
                    total += productJSON[i].price*productJSON[i].quantity;
                }
                cartUI.append("<p class = 'total'>Total: $" + total + "</p>")
            });
        });
    </script>
        
    </head>
    <body>
        <div class = "row">
            <div class = "col-md-7">
                <form class = "container form"  method = "POST" action = "FormSubmission" >
                    <h3>Order Form</h3>
                    <div class = "form-row">
                        <div class="form-group col-md-6">
                            <label for="fname">First Name</label>
                            <input type="text" class = "form-control" id="fname"  name = "fname" required >
                        </div>

                        <div class="form-group col-md-6">
                            <label for="lname">Last Name</label>
                            <input type="text" class = "form-control" id="lname" name = "lname" required>
                        </div>
                    </div>

                    <div class = "form-row">

                        <div class="form-group col-md-6">
                            <label for="email">Email</label>
                            <input class="form-control" type="email" id="email" name="email" placeholder="youremail@domain.com" required>
                        </div>

                        <div class="form-group col-md-6">
                            <label for="phone">Phone Number</label>
                            <input class="form-control" type="tel" id="phone" name="phone" placeholder="123-456-7890 or +1 123-456-7890" required>
                        </div>

                    </div>

                    <div class = "form-row">
                        <div class="form-group col-md-6">
                            <label for="address1">Address</label>
                            <input class="form-control" type="text" id="address1" name="address1" placeholder="Street and number, P.O. box c/o" required pattern = "^\s*\S+(?:\s+\S+){2}$">
                        </div>
                    </div>

                    <div class = "form-row">
                        <div class="form-group col-md-6">
                            <label for="address2">Address 2</label>
                            <input class="form-control" type="text" id="address2" name="address2" placeholder="Apartment, studio, or floor (optional)">
                        </div>
                     </div>

                    <div class = "form-row">
                        <div class="form-group col-md-5">
                            <label for="address2">City</label>
                            <input class = "form-control" type="text" id="city" name="city"  required>
                        </div>

                        <div class="form-group col-md-4">
                            <label for="state">State</label>
                            <input class="form-control" type= "text" id="state" name="state">

                           
                        </div>

                        <div class="form-group col-md-3">
                            <label for="zip">Zip</label>
                            <input class="form-control" type="text" id="zip" name="zip" required>
                        </div>
                    </div>

                     <label for="shipping">Shipping</label>
                        <div class = "form-row">

                            <div class="form-group col-md-4">
                                <input type="radio" id="standard" name="shipping">
                                <label for="standard">Standard Shipping</label>
                            </div>

                            <div class = "form-group col-md-4">
                                <input type="radio" id="two-day" name="shipping">
                                <label for="two-day">Two-Day Shipping</label>
                            </div>

                            <div class="form-group col-md-4">
                                <input type="radio" id="overnight" name="shipping" checked>
                                <label for="two-day">Overnight Shipping</label>
                            </div>
                        </div>

                     <div class="form-row">
                         <div class = "form-group col-md-5">
                            <label for="ccnum">Card Card Number</label>
                            <input class="form-control" type="text" id="ccnum" name="ccnum" pattern="[0-9]{16}">
                        </div>

                        <div class="form-group col-md-4">
                            <label for="expiration">Expiration </label>
                            <input class="form-control" type="text" id="expiration" name="expiration" placeholder= "01/10" required pattern="[0-9]{2}/[0-9]{2}">
                         </div>

                         <div class="form-group col-md-3">
                            <label for="cvv">CVV</label>
                            <input class="form-control" type="text" id="cvv" name="cvv" placeholder="000" pattern="[0-9]{3}">
                        </div>
                     </div> 

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
            
            
            <div class = "col-md-4 cart">
                <div class = "container" id = "cart">
                    <h4>Cart</h4>
                    
                    
                </div>
            </div>
        </div>
    </body>
</html>

