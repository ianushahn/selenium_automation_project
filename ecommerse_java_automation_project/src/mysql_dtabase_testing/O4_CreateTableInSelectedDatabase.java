package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class O4_CreateTableInSelectedDatabase 
{
	public static void main(String[] args) {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecoders", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database  and selected ecoders database.");
	            
	            try (PreparedStatement ps = conn.prepareStatement(
	                    "create table if not exists workers(" +
	                    "id int(45) primary key auto_increment, " +
	                    "name varchar(50) not null, " +
	                    "email varchar(50) unique)"
	            )) {
	                ps.executeUpdate();
	                System.out.println("Table created successfully.");
	            }
	            catch(Exception ex)
	            {
	            	ex.printStackTrace();
	            	System.out.println("Unable to create the table.");
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
//	     what is the need of this try catch  *************************************************** 
	}
}
