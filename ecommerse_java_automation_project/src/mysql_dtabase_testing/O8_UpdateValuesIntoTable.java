package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class O8_UpdateValuesIntoTable {
	public static void main(String[] args) {
	    Connection conn = null;

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the  worker's new name\n");
	    String name = sc.nextLine(); 
	    
	    
	    System.out.println("enter the  worker's new email\n");
	    String email = sc.next();
	    
	    System.out.println("Enter the id,of the worker whom you want to update the values");
	    int id = sc.nextInt();
	    
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database  and selected ecoders database.");
	            
	            try (PreparedStatement ps = conn.prepareStatement("update workers set name = ?, email = ? where id = ?")) 
	            {
	                ps.setString(1, name);
	                ps.setString(2, email);
	                ps.setInt(3, id);
	            	ps.executeUpdate();
	                System.out.println("Values updated into worker table successfully.");
	            }
	            catch(Exception ex)
	            {
	            	ex.printStackTrace();
	            	System.out.println("Unable to update values into the table worker.");
	            }
	        } 
	        else 
	        {
	            System.out.println("Unable to connect to MySQL database");
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        System.out.println("Unable to connect on to MySQL database");
	    } finally {
	        try {
	            if (conn != null) conn.close();
	        } catch (SQLException ignore) {}
	    }
	}

}
