package org.openjfx.hellofx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * 
 * @author anilyelin
 *
 */

public class sqlWindowController {
	
	/**
	 * this class provided functionality for
	 * the sql window where the user can 
	 * interact with the mysql database 
	 * with sql queries
	 */
	
	@FXML
	private Button execButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	public void goToMainPage() throws IOException {
		App.setRoot("main");
	}
	
	

}
