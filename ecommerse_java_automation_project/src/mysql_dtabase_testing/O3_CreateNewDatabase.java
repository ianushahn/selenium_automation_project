package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class O3_CreateNewDatabase {
	public static void main(String[] args) {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database.");
	            
	            PreparedStatement ps = conn.prepareStatement("create database if not exists anusha_kumari");
	             int result = ps.executeUpdate();
	             //ps.executeUpdate(); creating new database and also update it if updated result=1 if not created result=0
	             
	             if(result > 0)
	             {
	            	 System.out.println("Database created successfully.");
	             }
	             else
	             {
	            	 System.out.println("Unable to crate the database.");
	             }
	            
	            
	        } else {
	            System.out.println("Unable to connect to MySQL database");
	            System.out.println("Unable to fetch databases.");
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        System.out.println("Unable to connect to MySQL database");
	    } finally {
	        try {
	            if (conn != null) conn.close();
	        } catch (SQLException ignore) {}
	    }
	}

}
