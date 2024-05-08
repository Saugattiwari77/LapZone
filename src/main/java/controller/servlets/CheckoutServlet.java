package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Dao.OrderDao;
import controller.connection.DBCon;
import controller.model.*;


/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/cart-check-out")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			//getting all cart products
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			
			User auth = (User)request.getSession().getAttribute("auth");
			
			if(cart_list != null && auth != null) {
				//preparing the order object
				for(Cart c: cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					//instancing dao class
					OrderDao ODao = new OrderDao(DBCon.getConnection());
					//calling insert method
					boolean result = ODao.insertOrder(order);
					if(!result)break;
				}
				cart_list.clear();
				response.sendRedirect("order.jsp");
				
			}else {
				if(auth == null) response.sendRedirect("login.jsp");
				response.sendRedirect("cart.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
