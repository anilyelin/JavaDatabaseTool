package org.openjfx.hellofx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author anil yelin
 *
 */
public class LoginController {
	
	@FXML
	private Button loginButton;
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button quitButton;
	
	@FXML
	private Button createAccountButton;
	
	@FXML
	public void AccountCreator() throws IOException {
		App.setRoot("account");
	}
	
	public void getAccounts() throws IOException {
		System.out.println("");
	}
	
	@FXML
	public void quitApp() throws IOException {
		System.exit(0);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void login() throws Exception {
		String username;
		String password;
		String hashedPassword;
		username = usernameField.getText().toString();
		password = passwordField.getText().toString();
	
		// at this point we check if the corresponding field
		// such as username and/or password are not entered 
		// by the user
		if (usernameField.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login Information");
			alert.setHeaderText(null);
			alert.setContentText("No username given!, try again");
			alert.showAndWait(); 
			App.setRoot("login");
			return;
			
		}
		if (passwordField.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login Information");
			alert.setHeaderText(null);
			alert.setContentText("No password provided, try again!");
			alert.showAndWait();
			App.setRoot("login");
			return;
		}
		// if the login fails the user will be redirected
		// to a new login page otherwise the 
		hashedPassword = hashPassword(password);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		writeIntoDatebase(username, hashedPassword, timeStamp);
		App.setRoot("main");
	}
	/**
	 * 
	 * @param base
	 * @return
	 */
	public String hashPassword(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();
			
			for (int i=0;i<hash.length;i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				hexString.append(hex);
			}
			
			return hexString.toString();
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	/**
	 * 
	 * @param user
	 * @param pass
	 * @param date
	 * @throws Exception
	 */
	public void writeIntoDatebase(String user, String pass, String date) throws Exception {
		
		final String str = "jdbc:mysql://localhost/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=root&password=root";

		DatabaseConnection dbc = new DatabaseConnection(str);
		dbc.testData(user, pass, date);
	}

}