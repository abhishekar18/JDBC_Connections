package com.training.utils;
import java.sql.*;
/**
 * 
 * @author Abhishek Arora
 * @since 2023
 * 
 *
 */
public class DbConnections {
	/**
	 * The Method obtains the connection to the database using the parameters
	 */
	public static Connection getMySqlConnection() {
		
		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "abhishek");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
//	public static Connection getOracleConnection() {
//		
//		return null;
//	}
	
}
