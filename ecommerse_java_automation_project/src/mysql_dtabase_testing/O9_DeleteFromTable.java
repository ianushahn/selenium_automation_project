package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class O9_DeleteFromTable 
{
	public static void main(String[] args) {
	    Connection conn = null;

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the id of worker whom you want to delete.\n");
	    int id = sc.nextInt(); 
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database  and selected ecoders database.");
	            
	            try (PreparedStatement ps = conn.prepareStatement("delete from workers where id = ?")) {
	                ps.setInt(1, id);
	            	ps.executeUpdate();
	                System.out.println("worker delete from table successfully.");
	            }
	            catch(Exception ex)
	            {
	            	ex.printStackTrace();
	            	System.out.println("Unable to delete worker from table.");
	            }
	        } 
	        else 
	        {
	            System.out.println("Unable to connect to MySQL database");
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
