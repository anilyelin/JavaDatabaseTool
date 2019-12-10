package org.openjfx.hellofx;


import org.openjfx.hellofx.Test3;

import java.io.IOException;

import java.sql.SQLException;

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
	 */
	@FXML 
	public void testtest() throws IOException {
		// dummy data
        personData.add(new Person("2","sda","sfad","3"));
        personData.add(new Person("2","dsad","asda","12"));
        personData.add(new Person("3","adsad","asd","13"));
        personData.add(new Person("4","dasa","asda","15"));
        personData.add(new Person("5","Hadsadns","sda","16"));
        personData.add(new Person("6","asda","asdasd","17"));
        personData.add(new Person("7","dasdas","dads","18"));
        personData.add(new Person("8","dsasd","asdas","19"));
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        empIdColumn.setCellValueFactory(cellData -> cellData.getValue().empIdProperty());
        depIdColumn.setCellValueFactory(cellData -> cellData.getValue().depIdProperty());
        System.out.println("allo");
        personTable.setItems(getPersonData());
  
       
	}
	
	@FXML
	public void goToHelp() throws IOException {
		App.setRoot("help");
	}
	
	
	
	

}