package org.openjfx.hellofx;


import org.openjfx.hellofx.Test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
	
	@FXML
	private MenuItem deleteEmployeeItem;
	
	@FXML
	private Button csvExportButton;
	
	@FXML
	private Button quitAppButton;

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
		Iterator<Person> it = personData.iterator();
		while (it.hasNext()) {
			Person name = it.next();
			System.out.println(name.getFirstName());
		}
		return personData;
	}
	
	/**
	 * 
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * this function will fill the TableView on the main page 
	 * by using obersable lists from javafx
	 */
	@FXML 
	public void putDataIntoTable() throws IOException, ClassNotFoundException, SQLException {
		
		DatabaseConnection dbc = new DatabaseConnection();
		ResultSet fNameResultSet = dbc.getFirstNames();
		ResultSet lNameResultSet = dbc.getLastNames();
		ResultSet empIdResultSet = dbc.getEmployeeIDs();
		ResultSet depIdResultSet = dbc.getDepartmentIDs();
	
		while (fNameResultSet.next() && lNameResultSet.next() && empIdResultSet.next() && depIdResultSet.next()) {
			String fName = fNameResultSet.getString("firstName");
			String lName = lNameResultSet.getString("lastName");
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
	 * redirects the user to the help page
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
	 * this action will lead to the deletion of all entries
	 * this action can't be revoked
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
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void goToMongoDbPage() throws IOException {
		App.setRoot("mongoDbPage");
	}
	/**
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@FXML
	public void deleteEmployeeByParameter() throws SQLException, ClassNotFoundException {
		DatabaseConnection dbc = new DatabaseConnection();
		Integer var = 122;
		String id = var.toString();
		dbc.deleteEmployee(var);
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void directToDelPage() throws IOException {
		App.setRoot("delSQL");
	}
	
	/**
	 * 
	 * @throws IOException
	 * this function will allow to export the whole data
	 * in the mysql database into a csv file
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@FXML
	public void exportCSV() throws IOException, ClassNotFoundException, SQLException {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(
	    	     new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
		File file = fc.showSaveDialog(new Stage());
		PrintWriter out = null;
		StringBuffer sb = new StringBuffer("");
		try {
			out = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.err.print(e);
		}
		//for (int i=0;i<3;i++) {
		//	out.println("Anil"+i);
		//}
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.getEmployeeData();
		ResultSet rs1 = dbc.getEmployeeIDs();
		ResultSet rs2 = dbc.getFirstNames();
		ResultSet rs3 = dbc.getLastNames();
		ResultSet rs4 = dbc.getDepartmentIDs();
		while (rs1.next()&& rs2.next() && rs3.next() && rs4.next()) {
			//sb.append(rs1.getString(0));
			//sb.append(rs2.getString(1));
			sb.append(rs1.getInt("empID"));
			sb.append(",");
			sb.append(rs2.getString("firstName"));
			sb.append(",");
			sb.append(rs3.getString("lastName"));
			sb.append(",");
			sb.append(rs4.getInt("depID"));
			//sb.append(rs4.getString(3));
			sb.append("\n");
		}
		out.write(sb.toString());
		
		out.close();
		
	}
	
	@FXML
	public void quitAppAction() throws IOException {
		System.exit(0);
	}
	

}