package org.openjfx.hellofx;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author anil yelin
 * 
 *
 *
 */
public class DatabaseConnection {
	
	/**
	 * provides access to a MYSQL database 
	 * via JDBC driver, everything database
	 * related will happen in this
	 * class
	 */
	
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private final String connectionString = "com.mysql.cj.jdbc.Driver";
	private final String driverStringforLogin = "jdbc:mysql://localhost/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root";
	private final String driverStringforEmployee = "jdbc:mysql://localhost/javaAppDatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root";
	
	
	/**
	 * by default the connection will be javaAppDatabase Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DatabaseConnection() throws SQLException, ClassNotFoundException {
		
		try {
		Class.forName(connectionString);
		connect = DriverManager.getConnection(driverStringforEmployee);
		System.out.println("Connection Successful");
		
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	/**
	 * parametrized constructor for specific database connection
	 * @param specifiedString
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public DatabaseConnection(String specifiedString) throws SQLException, ClassNotFoundException {
		try {
			Class.forName(connectionString);
			connect = DriverManager.getConnection(specifiedString);
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
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("insert into loginAccount values (?,?,?)");
		preparedStatement.setString(1, user);
		preparedStatement.setString(2, pass);
		preparedStatement.setString(3, date);
		preparedStatement.executeUpdate();
	}
	
	/**
	 * prototype function 
	 * 
	 * @param empid
	 * @param firstname
	 * @return
	 * @throws Exception
	 */
	public ResultSet checkEmployee(int empid, String firstname) throws Exception {
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("select empID, firstName from employee where empID = (?) and firstName = (?)");
		preparedStatement.setInt(1, empid);
		preparedStatement.setString(2, firstname);
		ResultSet rs = preparedStatement.executeQuery();
		return rs;	
	}
	
	/**
	 * 
	 * @param username
	 * @param host
	 * @param password
	 */
	public void specificConnection(String username, String host, String password) {
		try {
			Class.forName(connectionString);
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
	 * @throws SQLException 
	 */
	public void empConnection(int id, String fname, String lname, int depid) throws SQLException {
		statement = connect.createStatement();
		preparedStatement = connect.prepareStatement("insert into employee values (?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, fname);
		preparedStatement.setString(3, lname);
		preparedStatement.setInt(4, depid);
		preparedStatement.executeUpdate();
	}
	
	
	/**
	 * getting table meta, testing
	 * @throws SQLException 
	 */
	public void getTableData() throws SQLException {
		DatabaseMetaData data = connect.getMetaData();
		int    majorVersion   = data.getDatabaseMajorVersion();
		System.out.println(majorVersion);	
	}
	
	/**
	 * 
	 * @throws SQLException
	 */
	public void getEmployeeData() throws SQLException {
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

	}
	
	/**
	 * this function will return just the first Name of the 
	 * tables employee 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getFirstNames() throws SQLException {
		try {
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
			statement = connect.prepareStatement("select depID from employee");
			ResultSet rs = statement.executeQuery("select depID from employee");
			return rs;
			
		} catch (Exception ex) {
			System.err.println(ex);
			return null;
		}
	}
	
	public void deleteAll() throws SQLException {
		connect = DriverManager.getConnection(driverStringforEmployee);
		preparedStatement = connect.prepareStatement("delete from employee");
		preparedStatement.executeUpdate();
	}
	
	public void deleteEmployee(int param) throws SQLException {
			preparedStatement = connect.prepareStatement("delete from employee where empID = (?)");
			//preparedStatement.setString(1, id);
			preparedStatement.setInt(1, param);
			preparedStatement.executeUpdate();
	}
		/**
		 * 
		 * @param <E>
		 * @param e
		 * @throws SQLException 
		 */
		<E> void deleteEmployee2(E e) throws SQLException {
			preparedStatement = connect.prepareStatement("delete from employee where firstName = (?)");
			//preparedStatement.setString(1, id);
			preparedStatement.setObject(1, e);
			preparedStatement.executeUpdate();

	}
		/**
		 * 
		 * @param <E>
		 * @param e
		 * @throws SQLException 
		 */
		<E> void deleteEmployee3(E e1, E e2) throws SQLException {
			preparedStatement = connect.prepareStatement("delete from employee where firstName = (?) and empID = (?)");
			preparedStatement.setObject(1, e1);
			preparedStatement.setObject(2, e2);
			preparedStatement.executeUpdate();
		}
		
		/**
		 * 
		 * @return
		 * @throws SQLException
		 */
		public ResultSet checkUsername() throws SQLException {
			

			statement = connect.prepareStatement("select username from loginAccount");
			ResultSet user = statement.executeQuery("select username from loginAccount");
		
			return user;
			
		}
		
		/**
		 * 
		 * @return
		 * @throws SQLException
		 */
		public ResultSet checkPasswd() throws SQLException {
			
			statement = connect.prepareStatement("select password from loginAccount");
			ResultSet passwd = statement.executeQuery("select password from loginAccount");
			
			return passwd;
		}
		
		public void addAccount(String username, String password) throws SQLException {
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("insert into loginAccount values (?,?,?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			preparedStatement.setString(3, timeStamp);
		
			preparedStatement.executeUpdate();
			
		}
	
}