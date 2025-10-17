package mysql_dtabase_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class O1_ConnectToMysqlDatabase {
//	public static void main(String[] args) 
//	{
//		Connection conn = null; 
//connection is a inbuilt class which will be imported from java.sql 
// if we use connecting jar(cj) we will get all the classes
//		
//		try
//		{
//			Class.forName("com.mysql.cj.jdbc.Driver");   // this is the code which will navigate us to the mysql database
// Class --> one of the  inbuilt class of java 
//forName -->static function of that class
// if we want to connect to oracle database change from mysql-->Oracle
//forName is taking the database to mysql database using a connector jar file jdbc

//			conn = DriverManager.getConnection("jdbc:mysql//localhost:3306" , "root", "root");
//			if(conn != null)
//			{
//				System.out.println("Connected successfully to mysql database.");  // if get connected
//			}
//			
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//			System.out.println("Unable to connect to mysql database");
//		}
//
//	}
// java code will connect to data base only after adding jar files to it
// if jar files didn't added once refresh the project 
	// don't add the jar files again and again
	public static void main(String[] args) {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

	        if (conn != null) {
	            System.out.println("Connected successfully to MySQL database.");
	        } else {
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
