package org.openjfx.hellofx;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author anil yelin
 *
 */


public class EmployeeController {
	
	@FXML
	private Button backButton;
	
	@FXML
	private TextField empIDField;
	
	@FXML
	private TextField fnameField;
	
	@FXML 
	private TextField lnameField;
	
	@FXML
	private TextField depIDField;
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void getToMain() throws IOException {
		App.setRoot("main");
	}
	
	/**
	 * 
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@FXML
	public void getEmpData() throws IOException, ClassNotFoundException, SQLException {
		String empId;
		String firstName;
		String lastName;
		String depID;
		
		
		empId = empIDField.getText();
		firstName = fnameField.getText();
		lastName = lnameField.getText();
		depID = depIDField.getText();
		try {
		int finalEmpID = Integer.parseInt(empId);
		int finalDepID = Integer.parseInt(depID);
		System.out.println(empId);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(depID);
		
		DatabaseConnection dbc = new DatabaseConnection();
		dbc.empConnection(finalEmpID, firstName, lastName, finalDepID);
		} catch(Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Password Information");
			alert.setHeaderText(null);
			alert.setContentText("There is an error with your input. ID's have to be digits");
			alert.showAndWait(); 
		}
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void resetFieldValues() throws IOException {
		empIDField.setText("");
		fnameField.setText("");
		lnameField.setText("");
		depIDField.setText("");
	}
	

}
