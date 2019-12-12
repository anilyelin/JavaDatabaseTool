package org.openjfx.hellofx;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MongoDbPageController {
	
	@FXML
	private Button backToMainPageNewButton;
	
	@FXML
	private TextField mongoEmpIDField;
	
	@FXML
	private TextField mongofNameField;
	
	@FXML
	private TextField mongolNameField;
	
	@FXML
	private TextField mongodepIDField;
	
	@FXML
	private Button mongoDbSubmitButton;
	
	@FXML
	private TextArea mongoPageTextArea;
	
	@FXML
	private Button clearInputsButton;
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void getJsonFromInput() throws IOException {
		
		
		String empID = mongoEmpIDField.getText();
		if(empID.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Information");
			alert.setHeaderText(null);
			alert.setContentText("No employee provided, try again!");
			alert.showAndWait();
			App.setRoot("mongoDbPage");
		}
		String fName = mongofNameField.getText();
		if(fName.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Information");
			alert.setHeaderText(null);
			alert.setContentText("No first name provided, try again!");
			alert.showAndWait();
			App.setRoot("mongoDbPage");
		}
		String lName = mongolNameField.getText();
		if(lName.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Information");
			alert.setHeaderText(null);
			alert.setContentText("No last name provided, try again!");
			alert.showAndWait();
			App.setRoot("mongoDbPage");
		}
		String depID = mongodepIDField.getText();
		if(depID.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Input Information");
			alert.setHeaderText(null);
			alert.setContentText("No department id provided, try again!");
			alert.showAndWait();
			App.setRoot("mongoDbPage");
		}
		Person person = new Person(empID,fName,lName,depID);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(person).toString();
		mongoPageTextArea.setText(json);
		
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void clearInputFields() throws IOException {
		mongoEmpIDField.setText("");
		mongofNameField.setText("");
		mongolNameField.setText("");
		mongodepIDField.setText("");
		mongoPageTextArea.setText("");
		
	}
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void dummyFunction() throws IOException {
		String empid = mongoEmpIDField.getText();
		String firstName = mongofNameField.getText();
		String lastName = mongolNameField.getText();
		String depid = mongodepIDField.getText();
		
		System.out.println(empid);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(depid);
		
		mongoEmpIDField.setText("");
		mongofNameField.setText("");
		mongolNameField.setText("");
		mongodepIDField.setText("");
		
	}
	/**
	 * 
	 * @throws IOException
	 */
	@FXML
	public void goToMainPageNew() throws IOException {
		App.setRoot("main");
	}

}
