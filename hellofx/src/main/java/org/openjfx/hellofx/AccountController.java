package org.openjfx.hellofx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.*;

/**
 * 
 * @author anil yelin
 *
 */
public class AccountController {
	/**
	 * This class controls everything inside the 
	 * FXML layout account.fxml
	 * the user can create an account in this view
	 */
	
	@FXML
	private Button exitButton;
	
	@FXML
	private Button accountCreateButton;
	
	@FXML
	private Button goBackButton;
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private PasswordField pass1Field;
	
	@FXML
	private PasswordField pass2Field;
	
	@FXML
	public void getBack() throws IOException {
		App.setRoot("login");
	}
	
	public ArrayList<Account> accounts;
	
	/**
	 * 
	 * @throws IOException
	 * creating an account. The user needs to enter an username
	 * one password with requirements described below 
	 * if everything is fine, then the account information
	 * will be stored in a mysql database
	 * the passwords will be hashed in SHA 256 using 
	 * the java security libary
	 */
	@FXML
	public void createAccount() throws IOException {
		
		String username = userNameField.getText().toString();
		String password1 = pass1Field.getText().toString();
		String password2 = pass2Field.getText().toString();
		if (!checkPasswords(password1,password2)) {
			App.setRoot("account");
		}
		if (!checkPasswordRequirements(password1)) {
			App.setRoot("account");
		}
		Account account = new Account(username,password1,password2);
		System.out.println("Account successfully created");
		System.out.println();
		System.out.println(account.getUsername());
		System.out.println(account.getPassword1());
		System.out.println(account.getPassword2());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Account successfully created");
		alert.showAndWait();
		userNameField.setText("");
		pass1Field.setText("");
		pass2Field.setText("");
		accounts = new ArrayList<Account>();
		accounts.add(account);
		
	}
	/**
	 * 
	 * @throws IOException
	 * Exciting the application
	 */
	@FXML
	public void exitApp() throws IOException {
		System.exit(0);
	}
	
	/**
	 * 
	 * @param password1
	 * @param password2
	 * @return
	 * @throws IOException
	 */
	
	public boolean checkPasswords(String password1, String password2) throws IOException {
		boolean same;
		if (password1.equals(password2)) {
			same = true; 
			return same;
			}
		
		else {
			same = false;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Password Information");
			alert.setHeaderText(null);
			alert.setContentText("Password 1 and Password 2 doesn't match, try again");
			alert.showAndWait(); 
			return same;}
	}
	
	/**
	 * 
	 * @param password1
	 * @return
	 * @throws IOException
	 * 
	 * Password Requirements are: At least one capital letter
	 * At least one number and at least one symbol e.g. .,(),+ etc.
	 * the password length should be at least 8 character long
	 * 
	 */
	public boolean checkPasswordRequirements(String password1) throws IOException {
		boolean check;
		if (password1.length()==8)  {
			check=true;
			return check;
			}
		
		else {
			
			check = false;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Password Information");
			alert.setHeaderText(null);
			alert.setContentText("Password doesn't fullfill requirments, try again");
			alert.showAndWait(); 
			return check;
		}
	}

}