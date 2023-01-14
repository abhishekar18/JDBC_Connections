package com.training.utils;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
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
			Properties prop = new Properties();
			InputStream inStream =DbConnections.class.getClassLoader().getResourceAsStream("application.properties");
			prop.load(inStream);
			con = DriverManager.getConnection(prop.getProperty("datasource.mysql.url"),
					prop.getProperty("datasource.mysql.username"),
					prop.getProperty("datasource.mysql.password"));
			
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
