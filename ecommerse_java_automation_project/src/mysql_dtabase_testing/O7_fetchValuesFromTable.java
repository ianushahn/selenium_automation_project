package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class O7_fetchValuesFromTable {
	public static void main(String[] args) {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database.");
	            
	            PreparedStatement ps = conn.prepareStatement("select * from workers");
	            ResultSet rs = ps.executeQuery();
	            
	            System.out.println("*****************************");
	            System.out.println("ID | Name | Email ");
	            System.out.println("*****************************");
	            
	            while(rs.next())
	            {
	            	System.out.println(rs.getInt(1)+ " | " + rs.getString(2) + " | " + rs.getString(3));
	            }
	            
	            System.out.println("*****************************");
	            
	            
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
