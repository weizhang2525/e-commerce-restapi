<%-- 
    Document   : product-page
    Created on : Jun 1, 2020, 10:42:00 AM
    Author     : weizhang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/product-page.css">
    <!--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="js/product-info.js"></script>
    <script src = "js/form.js"></script>
    <script>
        $(document).ready(function() {
            
            
            $.get("productPage", function(data){
                console.log(data);
                
                
                var array = data.split("@");
                console.log("ARRAY");
                console.log(array);
                
                var pid = array[0];
                var subpid = pid.substring(0, 3);
                var pname = array[1];
                var price = array[2];
                var dec = array[3];
                var quantity = array[4];
                var srcOne = array[5];
                var srcTwo = array[6];
                var srcThree = array[7];
                var alt = array[8];
                
                $('#pid').text("Product ID: " + subpid);
                $('#name').text(pname);
                $('#price').text(price);
                $('#descr').text(dec);
                $('#first-image').attr("src", srcOne);
                $('#second-image').attr("src", srcTwo);
                $('#third-image').attr("src", srcThree);
                
                
         
            });
            
            
            $("#addToCart").click(function() {                
                    var pid = $('#pid').text();
                    var quantity = $('#quantity option:selected').text();
                    var name = $("#name").text();
                    var price = $("#price").text();
                    $.ajax({
                    type: 'POST',
                    data: {
                        pid: pid,
                        quantity: quantity,
                        name: name,
                        price: price,
                        actionType: "addToCart"
                    },
                    url: 'CartSession',
                    success: function(data){
                        console.log(data);
                        alert("Item added to cart");
                    },
                    error: function(){
                        alert("Error");
                    }
                });
//                

                
            });
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
                    <a href="index.html">Apparel</a>
                    <a href="about.html">About</a>
                    <a href="checkout-page.jsp">Checkout</a>
                </div>
            </div>

        </div>
    </nav>

    <!-- Product info on the top -->

    

    <div class="Product">
        <div class="row">
            <div class="col-md-5">
                    <!-- Carousel was taken from the Bootstrap website with modifcations -->
                    <!-- <img id="img" class="d-block w-100" alt="Product img"> -->
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                          <div class="carousel-item active">
                            <img class="d-block w-100" id="first-image" alt="First slide">
                          </div>
                          <div class="carousel-item">
                            <img class="d-block w-100" id="second-image" alt="Second slide">
                          </div>
                          <div class="carousel-item">
                            <img class="d-block w-100" id="third-image" alt="Third slide">
                          </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                          <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                          <span class="sr-only">Next</span>
                        </a>
                      </div>        
                    
                              
            </div>
            <div class="col-md-7">
                <h2 id="name"></h2>
                <p id="prd-color"></p>
                <p id="descr"></p>
                <img src ="assets/5-star-png-12.png" class="rating">
                <p id = "pid"></p>
                <p class="price" id="price"></p>
        
                <label for="size">Select a size</label>
                <select id="sizes">
                    <option value="Small">Small</option>
                    <option value="Medium">Medium</option>
                    <option value="large">Large</option>
                </select>
          
                <br><label for="quantity">Select quantity</label>
                <select id="quantity" name = "quantity">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    
                    
                    
                </select>
                
                <p><b>Brand:</b>Nuance9</p>

                

                 <button class="btn btn-default cart" id="addToCart">
                    Add to cart
                 </button>
                


            </div>
            
            <p id="result"></p>

        </div>
           
    <!-- End of Product Info -->

    <!-- Actual Buying of Product -->


    </div>
</body>



