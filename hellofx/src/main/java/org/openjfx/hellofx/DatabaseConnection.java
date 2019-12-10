package org.openjfx.hellofx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 * @author anilyelin
 *
 */
public class DatabaseConnection {
	
	/**
	 * provides access to a MYSQL database 
	 * via JDBC driver
	 */
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	/**
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DatabaseConnection() throws SQLException, ClassNotFoundException {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
		System.out.println("Connection Successful");
		
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	/**
	 * 
	 * @param user
	 * @param pass
	 * @param date
	 * @throws Exception
	 */
	public void testData(String user, String pass, String date) throws Exception{
		String res = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
			System.out.println("Connection Successful");
			
			statement = connect.createStatement();
			
			preparedStatement = connect.prepareStatement("insert into loginAccount values (?,?,?)");
			
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, date);
			preparedStatement.executeUpdate();
		}
		catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param username
	 * @param host
	 * @param password
	 */
	public void specificConnection(String username, String host, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://"+host+"/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user="+username+"&password="+password+"");
			System.out.println("Connection Successful");
			
			
			
		} catch(Exception ex) {
			System.err.print(ex);
		}
	}
	
	public void empConnection(int id, String fname, String lname, int depid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
			System.out.println("Connection Successful");
			statement = connect.createStatement();
			
			preparedStatement = connect.prepareStatement("insert into employee values (?,?,?,?)");
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, fname);
			preparedStatement.setString(3, lname);
			preparedStatement.setInt(4, depid);
			preparedStatement.executeUpdate();
			
		}catch(Exception ex) {
			System.err.print(ex);
		}
	}
	
	
	
}