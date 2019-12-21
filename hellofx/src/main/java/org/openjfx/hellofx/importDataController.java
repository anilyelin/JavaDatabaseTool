package org.openjfx.hellofx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class importDataController {
	
	@FXML
	private Button goBackButton;
	
	@FXML
	private TextField dataTextField;
	
	
	@FXML
	private void goBackAction() throws IOException {
		App.setRoot("employee");
	}

}
