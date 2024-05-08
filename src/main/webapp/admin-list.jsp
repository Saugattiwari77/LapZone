<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>

<%@page import="controller.Dao.ProductDao"%>
<%@page import="controller.connection.DBCon"%>
<%@page import="controller.model.*"%>

<% ProductDao pd = new ProductDao(DBCon.getConnection());
    List<Product> products;
    products = pd.getAllProducts();
    
   %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/admin-list.css" />
</head>
<body>

   
  </head>
  <body>
    <div class="admin-panel">
      <div class="admin-panel-title">Admin Panel</div>
      <div>
      <form action = "admin/new" method = "get">
        <button class="add-p" type="submit"> Add Product</button>
        
        </form>
      </div>
      <table>
        <thead>
          <tr>
          
            <th>Product Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Image</th>

            <th>Control</th>
          </tr>
        </thead>
        
        
        <tbody>
        <%
  if(!products.isEmpty()){
	  for(Product p:products){%>
		    <tr>
          
            <td><%= p.getName() %></td>
            <td><%= p.getDescription() %></td>
            
            <td>Price: Rs<%= p.getPrice() %></td>
            <td><img src="./laptop-images/<%= p.getImage() %>" width="auto" height="100px"></td>

            <td class="edit"><button>Edit</button> <button>Delete</button></td>
          </tr>

	
       

<%}
			}else{
				%>	<div><h1>No products found<h1></div> <% 
			}
			%>
         
        </tbody>
      </table>
    </div>
  </body>
</html>

</body>
</html>