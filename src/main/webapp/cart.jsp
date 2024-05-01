<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="controller.Dao.ProductDao" %>
<%@page import="java.util.*" %>
<%@page import="controller.connection.DBCon"%>
<%@page import="controller.model.*"%>


<% 
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProduct = null;
    if(cart_list != null){
    	ProductDao pDao = new ProductDao(DBCon.getConnection());
    	cartProduct = pDao.getCartProducts(cart_list);
    	
    	request.setAttribute("cart_list", cart_list);
    	
    }
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/cart.css" />
</head>
<body>
<div class="cart-container">
      <div class="cart-header">
        <h2>Total Price: Rs</h2>
        <button class="checkout-btn">Check Out</button>
      </div>
      <div class="table-header">
        <p>Name</p>
        <p>Price</p>
        <p>Buy Now</p>
        <p>Cancel</p>
      </div>
      
     <div class="cart-container">
    <div class="cart-header">
        <h2>Total Price: Rs</h2>
        <button class="checkout-btn">Check Out</button>
    </div>
    <div class="table-header">
        <p>Name</p>
        <p>Price</p>
        <p>Buy Now</p>
        <p>Cancel</p>
    </div>
    
    <% if(cart_list != null) {
            for(Cart c : cartProduct) { %>
                <form action="add-to-cart" method="post">
                    <div class="product-controls">
                        <input type="hidden" name="id" value="<%= c.getId() %>"> <!-- Include product ID -->
                        <p><%= c.getName() %></p> <!-- Retrieve product name -->
                        <p><%= c.getPrice() %></p> <!-- Retrieve product price -->
                        <div class="form-group">
                            <button class="btn-decrement">-</button>
                            <input type="text" class="shopping-input" value="1" />
                            <button class="btn-increment">+</button>
                        </div>
                        <button class="buy-btn">Buy</button>
                        <button class="remove-btn">Remove</button>
                    </div>
                </form>
    <%      }
        } %>
</div>


</body>
</html>