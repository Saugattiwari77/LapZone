package controller.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.connection.DBCon;
import controller.Dao.UserDao;
import controller.model.User;

/**
 * Servlet implementation class SignupsServlet
 */
@WebServlet("/user-signups")
public class SignupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fullname = request.getParameter("fullname");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dateofbirth = request.getParameter("dateofbirth");
		
		String gender = request.getParameter("gender");
        
       

        User user = new User();
        user.setFullName(fullname);
        user.setPhoneNumber(phonenumber);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setDateOfBirth(dateofbirth);
        
        user.setGender(gender);
       
       

        try {
			UserDao udao = new UserDao(DBCon.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//UserDao userDao = new UserDaoImpl();
        if (UserDao.addUser(user)) {
            response.sendRedirect("login.jsp?registration=success");
        } else {
            response.sendRedirect("signup.jsp?error=1");
        }
		
	
}
	

}
