package controller.servlets;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Dao.OrderDao;
import controller.Dao.ProductDao;
import controller.connection.DBCon;
import controller.model.Product;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String action = request.getServletPath();
		System.out.println(action);
		switch(action) {
		case"/admin/new":
			System.out.println("jshd");
			showNewform(request,response);
			break;
		case"/admin/insert":
			try {
				insertProduct(request, response);
				}catch (SQLException e) {
					e.printStackTrace();
				}
			break;
		case"/admin/delete":
			try {
			deleteProduct(request,response );
			}catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case"/admin/edit":
			try {
			showEditform(request, response);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			break;
		case"/admin/update":
			try {
				updateProduct(request, response);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			break;
			default:
				try {
					listProduct(request, response);
					}catch(SQLException e) {
						e.printStackTrace();
					}
				break;
		}
	}

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
        try {
            // Assuming getConnection() method returns the database connection
            ProductDao productDao = new ProductDao(DBCon.getConnection());
            List<Product> listProduct = productDao.getAllProducts();
            request.setAttribute("listProduct", listProduct);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-list.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
        }
    

    private void showNewform(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
        try {
            
            ProductDao productDao = new ProductDao(DBCon.getConnection());
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price")); // Parse to double
            String image = request.getParameter("image");
            Product product = new Product(id, name, price, image, description);
            productDao.updateProduct(product);
            response.sendRedirect("list");
        }  catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
        }
    

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        
        try {
            
            ProductDao productDao = new ProductDao(DBCon.getConnection());
            int id = Integer.parseInt(request.getParameter("id"));
            productDao.deleteProduct(id);
            response.sendRedirect("list");
        }  catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
        }
    

    private void showEditform(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));
            Product existingProduct = new ProductDao(DBCon.getConnection()).getSingleProducts(id);
            request.setAttribute("product", existingProduct);
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-form.jsp");
            dispatcher.forward(request, response);
        }  catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
      
        try {
            
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price")); // Parse to double
            String image = request.getParameter("image");
            Product product = new Product(0, name, price, image, description); // ID will be generated by the database
            new ProductDao(DBCon.getConnection()).insertProduct(product);
            response.sendRedirect("list");
        }  catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
    }



	
	

}
