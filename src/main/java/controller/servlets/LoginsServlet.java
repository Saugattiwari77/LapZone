//LoginServlet.java
package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.connection.DBCon;
import controller.Dao.UserDao;
import controller.model.User;

@WebServlet("/user-logins")


public class LoginsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("login-username");
			String password = request.getParameter("login-password");

			try {
				UserDao udao = new UserDao(DBCon.getConnection());

				User user = udao.userLogin(username, password);
System.out.println(user.getFullName());
				if (user != null) {
					
					request.getSession().setAttribute("auth", user);
					

					response.sendRedirect("index.jsp");

				} else {
					// System.out.println(email +" "+password);
					out.print("user login failed");
					
				}

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}

		}
	}

}
