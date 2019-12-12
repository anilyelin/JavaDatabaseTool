package org.openjfx.hellofx;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author anil yelin
 *
 */
public class DatabaseConnection {
	
	/**
	 * provides access to a MYSQL database 
	 * via JDBC driver, everything database
	 * related will happen in this
	 * class
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
	
	/**
	 * 
	 * @param id
	 * @param fname
	 * @param lname
	 * @param depid
	 */
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
	
	
	/**
	 * getting table meta, testing
	 */
	public void getTableData() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
			System.out.println("Connection Successful");
			DatabaseMetaData data = connect.getMetaData();
			int    majorVersion   = data.getDatabaseMajorVersion();
			System.out.println(majorVersion);
			
		}catch(Exception ex) {
			System.err.print(ex);
		}
		
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	public void getEmployeeData() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
			System.out.println("Connection Successful");
			statement = connect.prepareStatement("select * from employees");
			ResultSet rs = statement.executeQuery("select * from employee");
			
			while (rs.next()) {
				String firstName  = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int empID = rs.getInt("empID");
				int depID = rs.getInt("depID");
				System.out.println(firstName);
				System.out.println(lastName);
				System.out.println(empID);
				System.out.println(depID);
			}
			
			
		} catch (Exception ex) {
			System.err.print(ex);
		}
	}
	
	/**
	 * this function will return just the first Name of the 
	 * tables employee 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getFirstNames() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
			
			statement = connect.prepareStatement("select firstName from employees");
			ResultSet rs = statement.executeQuery("select firstName from employee");
			return rs;
		} catch (Exception ex) {
			System.err.println(ex);
			return null;
		}
	}
	
	/**
	 * returning all last names from the employee database
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getLastNames() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");
			statement = connect.prepareStatement("select lastName from employee");
			ResultSet rs = statement.executeQuery("select lastName from employee");
			return rs;
		} catch (Exception ex) {
			System.err.println(ex);
			return null;
		}
	}
	/**
	 * 
	 * @return all empIDs 
	 * @throws SQLException
	 */
	public ResultSet getEmployeeIDs() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");

			statement = connect.prepareStatement("select empID from employee");
			ResultSet rs = statement.executeQuery("select empID from employee");
			return rs;
			
		} catch (Exception ex) {
			System.err.println(ex);
			return null;
		}
	}
	/**
	 * 
	 * @return all department IDS from the table employees
	 * @throws SQLException
	 */
	public ResultSet getDepartmentIDs() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");

			statement = connect.prepareStatement("select depID from employee");
			ResultSet rs = statement.executeQuery("select depID from employee");
			return rs;
			
		} catch (Exception ex) {
			System.err.println(ex);
			return null;
		}
	}
	
	public void deleteAll() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root");

			preparedStatement = connect.prepareStatement("delete from employee");
			
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception ex) {
			System.err.println(ex);
			
		}
		
	}
	
}