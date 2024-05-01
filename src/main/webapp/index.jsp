<%@page import="java.util.*"%>

<%@page import="controller.Dao.ProductDao"%>
<%@page import="controller.connection.DBCon"%>
<%@page import="controller.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

 
 
 <% int price = 0;
    ProductDao pd = new ProductDao(DBCon.getConnection());
    List<Product> products;
    String queryString = request.getQueryString();
    if(queryString != null && queryString.contains("s=")) {
        // If query string contains 's=', indicating a search query
        String searchQuery = queryString.substring(queryString.indexOf("s=") + 2); // Extract the search query
        products = pd.getSearchProducts(searchQuery);
    } else {
        // If there is no query string or it doesn't contain 's=', fetch all products
        products = pd.getAllProducts();
    }
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/home.css" />

</head>
<body>
<%@include file="header.jsp"%> 


<section id="second-section" class="sec">
<h3 class="h3">Available Laptops</h3>

	 
  

<div class="img-div" >

<%
  if(!products.isEmpty()){
	  for(Product p:products){%>
		    <div class="samed"><a href="productdetails.jsp?id=<%= p.getId() %>">
	        <img src="./laptop-images/<%= p.getImage() %>" width="auto" height="175px">
	        <h2><%= p.getName() %></h2>
	        <p>Price: Rs<%= p.getPrice() %></p>
	    </a></div>
	        

	
       

<%}
			}else{
				%>	<div><h1>No products found<h1></div> <% 
			}
			%>
			</div>
		 </section>	






<%@include file="footer.jsp"%>   
</body>
</html>