package org.openjfx.hellofx;

import java.io.IOException;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ThreeController {
	
	@FXML
	private Button testButton;
	
	@FXML
	private Button quitButton;
	
	
	@FXML
	private TextField t1Field;
	
	@FXML
	public void clickMe() throws IOException {
		System.out.println("Hallo Welsdfsdsft");
	}
	
	@FXML
	public String getData() throws IOException {
		
		return t1Field.getText();
		
	}
	
	@FXML
	public void checkData() throws IOException {
		
		String input;
		input = getData().toString();
		System.out.println(input);
		String res = "123";
		//App.setRoot("secondary");
		if (input.equals(res)) {
			System.out.println("Access granted");
			App.setRoot("main");
		}
		else
		{
			System.out.println("Wrong password, try again");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Wrong password, try again");
			t1Field.setText("");
			alert.showAndWait();
			
			
		}
	}
	
	@FXML
	public void quitApp() throws IOException {
		System.exit(0);
	}
	

}