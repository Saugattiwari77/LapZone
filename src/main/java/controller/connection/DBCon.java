package controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lapzone", "root", "root");
                System.out.println("Connected to the database");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error during connection: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        }
        return connection;
    }
}
