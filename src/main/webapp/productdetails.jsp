<%@page import="java.util.*"%>

<%@page import="controller.Dao.ProductDao"%>
<%@page import="controller.connection.DBCon"%>
<%@page import="controller.model.*"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
  <%
//id = "id = 3"
String id = request.getQueryString();
  String[] parts = id.split("=");

//1 kina ligya vane 3 lina 0 ligya vaye 1d= aauthyo
int pid = Integer.parseInt(parts[1]);

    ProductDao pd = new ProductDao(DBCon.getConnection());
    Product products = pd.getSingleProducts(pid);


%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/productdetails.css" />
</head>
<body>

<section>
      <div class="head-div">
        <div class="pic-div">
          <img src="./laptop-images/<%= products.getImage() %>" height="500px" width="auto" />
        </div>
        <div class="desc-div">
   
          <h2><%= products.getName() %></h2>
          <h3>Rs <%= products.getPrice() %></h3>
          <p>
            <%= products.getDescription() %>
          </p>
        </div>
        <div class="twoa">
          <a id="bn" href="">Buy Now</a>
          <a id="atc" href="add-to-cart?id=<%= products.getId()%>">Add To Cart</a>
        </div>
      </div>
    </section>
    
</body>
</html>