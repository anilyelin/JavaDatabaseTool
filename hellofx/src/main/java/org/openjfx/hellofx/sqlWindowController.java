package org.openjfx.hellofx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class sqlWindowController {
	
	@FXML
	private Button execButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	public void goToMainPage() throws IOException {
		App.setRoot("main");
	}
	

}
