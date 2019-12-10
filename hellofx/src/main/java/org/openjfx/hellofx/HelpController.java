package org.openjfx.hellofx;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelpController {
	
	@FXML
	private Button closeButton;
	
	@FXML
	public void goBackToMain() throws IOException {
		App.setRoot("main");
	}

}
