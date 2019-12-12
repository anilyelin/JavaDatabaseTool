package org.openjfx.hellofx;


import org.openjfx.hellofx.Test3;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;

/**
 * 
 * @author anil yelin
 *
 */
public class MainController {
	
	/**
	 *  this class controls everything inside
	 *  the FXML file called main.fxml
	 *  
	 */
	
	@FXML 
	private Button testButton;
	
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Person> personTable;
	
	@FXML
	private TableColumn<Person, String> empIdColumn;
	
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	
	@FXML
	private TableColumn<Person, String> depIdColumn;

	
	@FXML
	private MenuItem createEMPItem;
	
	@FXML
	private MenuItem closeItem;
	
	@FXML
	private MenuItem endSessionItem;
	
	@FXML
	private MenuItem NewWindowItem;
	
	@FXML
	private TextField sqlUsernameField;
	
	@FXML
	private TextField sqlHostField;
	
	@FXML
	private PasswordField sqlPasswordField;
	
	@FXML
	private Button sqlConnectButton;
	
	@FXML
	private Button sqlDisconnectButton;
	
	@FXML
	private MenuItem aboutItem;
	
	@FXML
	private MenuItem metaDataItem;
	
	@FXML
	private MenuItem deleteAllItem;
	
	@FXML
	private MenuItem execSqlStatementItem;
	
	@FXML
	private MenuItem mongoDbItem;

	private App app;
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void closeApp() throws IOException {
		System.exit(0);
	}
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void createNewWindow() throws IOException {
		App.setRoot("main");
	}
	/**
	 * 
	 * @throws IOException
	 */
	
	@FXML
	public void backToLogin() throws IOException {
		App.setRoot("login");
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	
	@FXML
	public void getData() throws IOException {
		String username;
		String host;
		String password;
		username = sqlUsernameField.getText();
		host = sqlHostField.getText();
		password = sqlPasswordField.getText();
		System.out.println(username);
		System.out.println(host);
		System.out.println(password);
		
	}
	
	/**
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void createConnection() throws IOException, ClassNotFoundException, SQLException {
		String username, host, password;
		username = sqlUsernameField.getText();
		host = sqlHostField.getText();
		password = sqlPasswordField.getText();
		System.out.println(username);
		System.out.println(host);
		System.out.println(password);
		
		if(sqlUsernameField.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("SQL Login Information");
			alert.setHeaderText(null);
			alert.setContentText("There is an error with your input. No username provided, try again");
			alert.showAndWait();
			App.setRoot("main");
			return;
		}
		
		if(sqlHostField.getText().contentEquals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("SQL Login Information");
			alert.setHeaderText(null);
			alert.setContentText("There is an error with your input. No host provided, try again!");
			alert.showAndWait();
			App.setRoot("main");
			return;
		}
		
		if (sqlPasswordField.getText().contentEquals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("SQL Login Information");
			alert.setContentText("There is an error with your input. No password provided, try again");
			alert.setHeaderText(null);
			alert.showAndWait();
			App.setRoot("main");
			return;
		}
		
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.specificConnection(username, host, password);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Password Information");
		alert.setHeaderText(null);
		alert.setContentText("Connection to database successful");
		alert.showAndWait(); 

		sqlUsernameField.setText("");
		sqlHostField.setText("");
		sqlPasswordField.setText("");
	}
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void createEmployee() throws IOException {
		App.setRoot("employee");
	}
	/**
	 * 
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
	/**
	 * 
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@FXML 
	public void testtest() throws IOException, ClassNotFoundException, SQLException {
		// dummy data
		
		DatabaseConnection dbc = new DatabaseConnection();
		ResultSet fNameResultSet = dbc.getFirstNames();
		ResultSet lNameResultSet = dbc.getLastNames();
		ResultSet empIdResultSet = dbc.getEmployeeIDs();
		ResultSet depIdResultSet = dbc.getDepartmentIDs();
	
		while (fNameResultSet.next() && lNameResultSet.next() && empIdResultSet.next() && depIdResultSet.next()) {
			String fName = fNameResultSet.getString("firstName");
			System.out.println(fName);
			String lName = lNameResultSet.getString("lastName");
			System.out.println(lName);
			Integer employeeID = empIdResultSet.getInt("empID");
			String empID = employeeID.toString();
			Integer departmentID = depIdResultSet.getInt("depID");
			String depID = departmentID.toString();
			
			personData.add(new Person(empID,fName,lName,depID));
			
		}
      
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().empIdProperty());
        depIdColumn.setCellValueFactory(cellData -> cellData.getValue().depIdProperty());
        personTable.setItems(getPersonData());
  
       
	}
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void goToHelp() throws IOException {
		App.setRoot("help");
	}
	/**
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public void showMetaData() throws IOException, ClassNotFoundException, SQLException {
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.getTableData();
	}
	
	/**
	 * 
	 * @throws IOException
	 * @throws SQLException
	 */
	public void deleteAllEntries() throws IOException, SQLException {
		try {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Database Information");
			alert.setHeaderText(null);
			alert.setContentText("All entries will be deleted, are you sure?");
			alert.showAndWait(); 
			DatabaseConnection dbc = new DatabaseConnection();
			dbc.deleteAll();
			
		} catch(Exception ex) {
			System.err.println(ex);
		}
	}
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void goToSqlPage() throws IOException {
		App.setRoot("sqlWindow");
	}
	
	@FXML
	public void goToMongoDbPage() throws IOException {
		App.setRoot("mongoDbPage");
	}
	
	
	
	

}