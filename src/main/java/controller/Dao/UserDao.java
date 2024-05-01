package controller.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.model.User;

public class UserDao 
{
	private static Connection con;
	
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    

    public UserDao(Connection con) {
        this.con = con;
    }

    public User userLogin(String username, String password) {
        User user = new User();
        try {
            String query = "SELECT * FROM user WHERE username=? AND password=?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, username);
                pst.setString(2, password);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                      
                       
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                    }else {
                    	user = null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException appropriately, logging or throwing an exception as needed
        }
        return user;
    }

	/*public static boolean addUser(User user) {
		
		// TODO Auto-generated method stub
		
		String query = "INSERT INTO user"
		+ "(fullname, phonenumber, email, username, password, dateofbirth, confirmpassword, gender) "
		+ "VALUES (?,?,?,?,?,?,?,?)";
		try(PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, fullname);
            pst.setString(2, phonenumber);
            pst.setString(3, email);
            pst.setString(4, username);
            pst.setString(5, password);
            pst.setString(6, dateofbirth);
            pst.setString(7, confirmpassword;
            pst.setString(8, gender);
            try (ResultSet rs = pst.executeQuery()){
            	
            }
		
		return true;
	}
}*/
    public static boolean addUser(User user) {
        String query = "INSERT INTO user "
                + "(fullname, phonenumber, email, username, password, dateofbirth, gender) "
                + "VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            // Set parameters from the user object
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getPhoneNumber());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getUsername());
            pst.setString(5, user.getPassword());
            pst.setString(6, user.getDateOfBirth());
           
            pst.setString(7, user.getGender());

            // Execute the update (not query) since it's an insert operation
            int rowsAffected = pst.executeUpdate();
System.out.println("output" + (rowsAffected > 0));
            // Check if insertion was successful
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Log the exception instead of printing it
            System.out.println("Error adding user: " + e.getMessage());
            // Return false to indicate failure
            return false;
        }
    }

    
}
