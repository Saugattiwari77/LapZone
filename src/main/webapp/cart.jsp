<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.Dao.ProductDao"%>
<%@page import="java.util.*"%>
<%@page import="controller.connection.DBCon"%>
<%@page import="controller.model.*"%>


<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

List<Cart> cartProduct = null;
if (cart_list != null) {

	ProductDao pDao = new ProductDao(DBCon.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/cart.css" />
</head>
<body>
<%@include file="header.jsp"%>
	<div class="cart-container">
		<div class="cart-header">
			<span>Total Price: Rs ${ total }</span>
			<a class="checkout-btn" href="cart-check-out">Check Out</a>
		</div>
		<div class="table-header">
			<p>Name</p>
			<p>Price</p>
			<p>Buy Now</p>
			<p>Cancel</p>
		</div>



		<%
		if (cart_list != null) {
			for (Cart c : cartProduct) {
		%>
		<form action="order-now" method="get" class="form-inline">
			<div class="product-controls">
				<input type="hidden" name="id" value="<%=c.getId()%>">
				<!-- Include product ID -->
				<p><%=c.getName()%></p>
				<!-- Retrieve product name -->
				<p><%=c.getPrice()%></p>
				<!-- Retrieve product price -->
				<div class="form-group">
					<a class="btn-decrement"
						href="product-inc-dec?action=dec&id=<%=c.getId()%>">-</a> <input
						type="number" class="shopping-input"
						value="<%=c.getQuantity()%>" /> <a class="btn-increment"
						href="product-inc-dec?action=inc&id=<%=c.getId()%>">+</a>
					 <input type="hidden" name="quantity" value="<%= c.getQuantity() %>">
            <input type="hidden" name="id" value="<%= c.getId() %>">
            <button class="buy-btn" type="submit">Buy</button>
				</div>


			</div>
		</form>


		<a class="remove-btn" href="remove-cart?id=<%=c.getId()%>">Remove</a>

		<%
		}
		}
		%>
	</div>

<%@include file="footer.jsp"%>
</body>
</html>