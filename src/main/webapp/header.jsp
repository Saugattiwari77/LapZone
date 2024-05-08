<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="controller.Dao.ProductDao" %>
     <%@page import="controller.Dao.UserDao" %>
<%@page import="java.util.*" %>
<%@page import="controller.connection.DBCon"%>
<%@page import="controller.model.*"%>
    <% 
   
  
    
    
    
ArrayList<Cart> headercart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

    List<Cart> headerCartProduct = null;
    if(headercart_list != null){
    	
    	ProductDao pDao = new ProductDao(DBCon.getConnection());
    	headerCartProduct = pDao.getCartProducts(headercart_list);
    	
    	request.setAttribute("cart_list", headercart_list);
    	
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/header.css" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
</head>
<body>
<header>
    <div class="container">
        <div class="nav-part">
            <div id="leftsh">
                <h1><a href="index.jsp">LapZone</a></h1>
            </div>
          
            <div id="middlesh">
                <form id="searchForm">
                    <input type="text" placeholder="Search in Lapzone" name="search" id="searchInput"/>
                    <button type="submit">Search</button>
                </form>
            </div>

            <div class="rightsh">
            <%
            User auth = (User)session.getAttribute("auth");

            if(auth != null){
            	
            
            %>
                <div id="userf">
                    <a href="login.jsp">
                        <i class="fa-regular fa-user" ></i>
                        <p id="ln">Log Out</p>
                    </a>
                </div>
                <div id="lsc">
                    hello
                    <a href="cart.jsp">
                    <i class="fa-solid fa-cart-shopping" id="cart" ><span class="badge">${ cart_list.size()}</span></i>
                    </a>
                </div>
                <% }else{
                	
                	%>
                	<div id="userf">
                    <a href="login.jsp">
                        <i class="fa-regular fa-user" ></i>
                        <p id="ln">Login</p>
                    </a>
                </div>
                <div id="lsc">
                    <a href="signup.jsp">
                        <p id="sup">Sign up</p>
                    </a>
                    
                </div>
               <%  }%>
                
            </div>
        </div>
        <div id="tcont">
            <ul>
                <li>
                    <a href="#">HOME</a>
                </li>
                <li>
                    <a href="#">ABOUT US</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<script src="https://kit.fontawesome.com/1be6f8ccbb.js" crossorigin="anonymous"></script>
<script>
        document.getElementById("searchForm").addEventListener("submit", function(event) {
            event.preventDefault();
            var searchValue = document.getElementById("searchInput").value;
            var baseUrl = window.location.origin + window.location.pathname; // Get base URL dynamically without query parameters
            window.location.href = baseUrl + "?s=" + encodeURIComponent(searchValue);
        });
    </script>
</body>
</html>
