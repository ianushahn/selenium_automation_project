package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class O2_SeeAllTheDatabases {
	public static void main(String[] args) {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database.");
//	            after connection prepare an sql statements
//	           PreparedStatement --> it will prepare an sql statement for conn object
	            // and that sql statement is "show databases"
	            
	            PreparedStatement ps = conn.prepareStatement("show databases");
	            ResultSet rs = ps.executeQuery();
//	              ResultSet inbuilt class .. it will execute the query
	            System.out.println("*****************************");
	            System.out.println("Databases List");
	            System.out.println("*****************************");
//	            reference var rs knows knows about all the databases
	            while(rs.next())
//	            	rs.next() keep on printing the row values 
//	            	since we don't know the end condition we will use "do -while" loop 
	            {
	            	System.out.println(rs.getString(1));
	            	// print all the string value of first column 
	            }
	            
	            System.out.println("*****************************");
	            
	            
	        } else {
	            System.out.println("Unable to connect to MySQL database");
	            System.out.println("Unable to fetch databases.");
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
