<%-- 
    Document   : index
    Created on : Jun 1, 2020, 10:44:57 AM
    Author     : weizhang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/home_page_stye.css">
    <!-- <script src="js/home-page.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <script>
        $(document).ready(function(){

            console.log("TEST 0 - LOADED")
            console.log("HELLO")

            // This is where I call the RESTful Web Service, take note of the URL and the TYPE used here
            // Look at ProductResource.java to see where the request is intercepted
            $.ajax({
                url: '/e-commerce-restapi/restapi/homepage/loadpage',
                type: 'GET',
                success: function(productList) {
                    // Get the results from the service. In this case its an array of products
                    console.log(productList);
                    generateProductCards(productList, "products-container");
                },
                error: function() {
                    alert("Error");
                }
                });

                // generateProductCards(homePageResponse["recentlyVisitedList"], "recently-visited-container");


            // APON PUT YOUR CODE HERE
            function handleCardClick() {
                var pid = this.classList[0]
                console.log(pid);
//                $.ajax({
//                type: 'POST',
//                data: { pid: pid },
//                url: 'UserSessionTrackingServlet',
//                success: function(data){},
//                error: function(){ alert("Error"); }
//                });
//                
//                $.ajax({
//                type: 'POST',
//                data: { prod: pid },
//                url: '/e-commerce-restapi/restapi/productPage/getProduct',
//                success: function(data){
//                    console.log(data);
//                },
//                error: function(){ alert("Error"); }
//                });
                
                   
//                window.location.replace("product-page.html");
                window.location.href = "product-page.jsp?prod="+pid;
                  
                
            }

            function generateProductCards(productList, container) {
                DOM_products_contaner = document.getElementById(container)

                for (var i = 0; i < productList.length; i++) {
                    var product = productList[i];

                    // Create the product card container with column formatting
                    new_product_container = this.document.createElement("div")
                    new_product_container.classList.add("col-lg-6")
                    new_product_container.classList.add("col-md-6")
                    new_product_container.classList.add("col-sm-6")
                    new_product_container.classList.add("col-6")

                    // new_product_container.classList.add("mb-6")
                    new_product_container.classList.add("product-card")

                    // Create the product card
                    new_product_card = this.document.createElement("div")
                    new_product_card = this.document.createElement("a")
                    new_product_card.classList.add(product.pid); // IMPORTANT DON'T MOVE!!!!!!!!!!!
                    new_product_card.classList.add("card")
                    new_product_card.classList.add("h-100")
                    // new_product_card.href = "product-page.html";
                    new_product_card.onclick = handleCardClick; // IMPORTANT!!!!!!!!!!!

                    // Create the image container for this product
                    image_container = this.document.createElement("a")
                    image_container.classList.add("image-container")
                    img = this.document.createElement("img")
                    img.classList.add("card-img-top")
                    img.src = product.srcOne;
                    img.alt = product.alt;

                    // Card body
                    card_body = this.document.createElement("div")
                    card_body.classList.add("card-body")

                    // Card title
                    card_title = this.document.createElement("h4");
                    card_title.classList.add("card-title");

                    // Product title clickable a
                    card_title_a = this.document.createElement("a")
                    card_title_a.classList.add("product-title")
                    card_title_a.classList.add("product-title-test")
                    card_title_a.innerHTML = product.pname
                    
                    // Price
                    card_cost = this.document.createElement("h5")
                    card_cost.classList.add("card-cost")
                    card_cost.innerHTML = product.price

                    // Card text
                    card_text = this.document.createElement("p");
                    card_text.classList.add("card-text")
                    card_text.innerHTML = product.desc


                    // Add everything together
                    image_container.appendChild(img)
                    card_title.appendChild(card_title_a)

                    card_body.appendChild(card_title)
                    card_body.appendChild(card_cost)
                    card_body.appendChild(card_text)
                    new_product_card.appendChild(image_container)
                    new_product_card.appendChild(card_body)
                    new_product_container.appendChild(new_product_card)

                    // Now add it to the DOM
                    DOM_products_contaner.appendChild(new_product_container)
                }
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
                    <a href="index.html">Apparel</a>
                    <a href="about.html">About</a>
                    <a href="checkout-page.html">Checkout</a>
                </div>
            </div>

        </div>
    </nav>

    <!-- Shop Content  -->
    
            
    <div class="container">
        
              

        <div class="row">
        <div class="col-lg-12 sm-p-100 products">
            <div class="row" id="products-container">
                
                
            

        <!-- [DON'T DELETE THIS, ITS A REFERNCE] ------------------
    
            <div class="col-lg-6 col-md-6 mb-6 product-card">
                <div class="card h-100">
                <a href="#" class="image-container">
                    <img class="card-img-top" src="assets/Product-1-v0.jpg" alt="">
                </a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#" class="product-title">Amalgam Fleece+Snyth</a>
                    </h4>
                    <h5 class="card-cost">$224.99</h5>
                    <p class="card-text">An amalgamation of different materials stiched together to form the pertect hoodie.</p>
                </div>
                </div>
            </div>
            
        ---- [DON'T DELETE THIS, ITS A REFERNCE] ----------------->

            </div>
        </div>
        </div>
    </div>


    <!-- Recently Visited Bar  -->
    <div style="background-color: #d8b9c3;">
        <h1 style="text-align: center; padding-top: 2%;">
            Recently Viewed Products
        </h1>
        <div class="container">

            <div class="row">
            <div class="col-lg-12 col-md-12 mb-12 sm-p-100 recently-visited">
                <div class="row" id="recently-visited-container">

            <!-- [DON'T DELETE THIS, ITS A REFERNCE] ------------------
        
                    <div class="col-lg-4 col-md-4 col-sm-4 col-4 product-card">
                        <div class="card h-100">
                            <a class="image-container">
                                <img class="card-img-top" src="assets/Product-9-v0.jpg" alt="clothes">
                            </a><div class="card-body">
                                <h4 class="card-title">
                                    <a class="product-title product-title-test">The Vest</a>
                                </h4>
                                <h5 class="card-cost">$54.99</h5>
                                <p class="card-text">Black wrap around best. 5 deep pockets making it easy to carry things, and easy to wash.</p>
                            </div>
                        </div>
                    </div>

            ---- [DON'T DELETE THIS, ITS A REFERNCE] ----------------->
    
                </div>
            </div>
            </div>
        </div>
    </div>
</body>
</html>

