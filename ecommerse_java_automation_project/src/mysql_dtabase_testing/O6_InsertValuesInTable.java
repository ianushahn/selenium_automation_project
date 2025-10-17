package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class O6_InsertValuesInTable {
	public static void main(String[] args) {
	    Connection conn = null;

	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the worker name\n");
	    String name = sc.nextLine(); 
	    // next() it will take only one word eg: anusha
//	    nextLine() we can give multiple words eg: anusha nagesh hassan 
	    
	    // scanner class is used in order to take input from user
	    System.out.println("enter the workers email\n");
	    String email = sc.next();
	    
	    // in order to take input from user 
	    
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database  and selected ecoders database.");
	            
	            try (PreparedStatement ps = conn.prepareStatement("insert into workers(name, email) values (? ,?)")) {
	                ps.setString(1, name);
//	                ps is setting first string value as name
	                ps.setString(2, email);
//	                ps is setting second string value as email
	            	ps.executeUpdate();
	                System.out.println("Values inserted into worker table successfully.");
	            }
	            catch(Exception ex)
	            {
	            	ex.printStackTrace();
	            	System.out.println("Unable to insert values into the table worker.");
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
