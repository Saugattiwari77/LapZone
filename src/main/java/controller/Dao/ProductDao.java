package controller.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.model.Cart;
import controller.model.Product;
import controller.model.User;

public class ProductDao {
private static Connection con;
	
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
	
	
    public ProductDao(Connection con) {
        this.con = con;
    }

    public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		
		try {
			query = "select * from product";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
				row.setDescription(rs.getString("description"));
				products.add(row);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
    }
    public Product getSingleProducts(int id){
 		
    	Product products = new Product();
    	int Id = id;
    	 try {
             String query = "SELECT * FROM product WHERE id=?";
             try (PreparedStatement pst = con.prepareStatement(query)) {
                 pst.setInt(1, id);
                
                 try (ResultSet rs = pst.executeQuery()) {
                     if (rs.next()) {
                       
                        
                         products.setId(rs.getInt("id"));
                         products.setName(rs.getString("name"));
                         products.setPrice(rs.getDouble("price"));
                         products.setDescription(rs.getString("description"));
                         products.setImage(rs.getString("image"));
                         
                         
                     }else {
                     	products = null;
                     }
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle SQLException appropriately, logging or throwing an exception as needed
         }
         return products;
     }
    
    
    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		  List<Cart> products = new ArrayList<Cart>();
	  
	 try {
		 if(cartList.size()>0) {
			 for(Cart item:cartList) {
				query = "select * from product where id=?";
				pst = this.con.prepareStatement(query);
				pst.setInt(1,item.getId());
				rs = pst.executeQuery();
				while(rs.next()) {
					Cart row = new Cart();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					
					row.setPrice(rs.getDouble("price")*item.getQuantity());
					row.setQuantity(item.getQuantity());
					products.add(row);
					
					
				}
			 }
		 }
	 }catch(Exception e) {
		 System.out.println(e.getMessage());
//		 e.printStackTrace();
	 }
		  
		  return products;
	  }
    
    public double getTotalCartPrice(ArrayList<Cart> cartList) {
		 double sum = 0;
		 try {
			 if(cartList.size()>0) {
				 for(Cart item:cartList) {
					 query = "select price from product where id=?"; 
					 pst = this.con.prepareStatement(query);
					 pst.setInt(1, item.getId());
					 rs = pst.executeQuery();
					 
					 while(rs.next()) {
						 sum+=rs.getDouble("price")*item.getQuantity();
					 }
				 }
			 }
			 
		 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return sum;
	 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Product> getSearchProducts(String q){
		List<Product> products = new ArrayList<Product>();
		
		try {
			String searchTerm = "%"+q+"%";
			query = "select * from product where name like ?";
			
			pst = this.con.prepareStatement(query);
			pst.setString(1, searchTerm);
			rs = pst.executeQuery();
			
			
			
			while(rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
				row.setDescription(rs.getString("description"));
				products.add(row);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
    }

 }



