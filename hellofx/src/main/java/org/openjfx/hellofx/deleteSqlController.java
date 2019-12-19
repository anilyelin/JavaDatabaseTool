package org.openjfx.hellofx;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * @author anil yelin
 *
 */

public class deleteSqlController {
	
	@FXML
	private Button delSqlButton;
	
	@FXML
	private Button backButton;
	
	@FXML 
	private TextField fnameField;
	
	@FXML 
	private TextField lnameField;
	
	@FXML
	private TextField depidField;
	
	@FXML
	private TextField empidField;
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void goBack() throws IOException {
		App.setRoot("main");
	}
	
	
	public Boolean checkString(String str) {
		boolean result;
		if(str.equals("")) {
			result = false;
			return result;
		}
		else {
			result = true;
			return result;
		}
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void clearInputs() throws IOException {
		fnameField.setText("");
		lnameField.setText("");
		depidField.setText("");
		empidField.setText("");
	}
	/**
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException 
	 */
	public void deleteRecordByParameter() throws SQLException, ClassNotFoundException, IOException {
		DatabaseConnection dbc = new DatabaseConnection();
		String fname = fnameField.getText();
		String lname = lnameField.getText();
		String empid = empidField.getText();
		String depid = depidField.getText();
		
		
		if(checkString(fname).equals(true)) {
			String test = fname;
			dbc.deleteEmployee2(test);
		}
		else if(checkString(lname).equals(true)) {
			System.out.println("this lname");
		}
		else if(checkString(depid).equals(true)) {
			int test = 123;
			dbc.deleteEmployee(test);
		}
		else if(checkString(empid).equals(true)) {
			int test = Integer.parseInt(empid);
			dbc.deleteEmployee(test);
		}
		
		clearInputs();
		
	}
	
	/**
	 * to delete a specific employee, the user have to enter the right combination
	 * of employee id and first name of employee
	 * @throws Exception 
	 */
	public void deleteRecordByParameter1() throws Exception {
		DatabaseConnection dbc = new DatabaseConnection();
		String fname = fnameField.getText();
		String lname = lnameField.getText();
		String empid = empidField.getText();
		String depid = depidField.getText();
		
		//fist step is to check if the user has entered both
		//required fields. empid and first name
		//then we check if the given user exists by 
		//executing a simple query and ResultSet
		if (checkString(fname).equals(true) && checkString(empid).equals(true)) {
			String fnameString = fname;
			String empid1 = empid;
			int emp = Integer.parseInt(empid1);
			ResultSet rs = dbc.checkEmployee(emp, fnameString);
			if (rs.next()) {
				int emp1 = rs.getInt("empID");
				String str = rs.getString("firstName");
				System.out.println(emp1);
				System.out.println(str);
			}
			dbc.deleteEmployee3(fnameString,emp);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("User Information");
			alert.setHeaderText(null);
			alert.setContentText("User successfully deleted");
			alert.showAndWait();
			clearInputs();
			
			
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("User Information");
			alert.setHeaderText(null);
			alert.setContentText("Could not delete record. Check your inputs");
			alert.showAndWait();
			clearInputs();
		}
		
	}

}
