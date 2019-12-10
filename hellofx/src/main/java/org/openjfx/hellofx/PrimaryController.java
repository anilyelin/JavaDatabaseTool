package org.openjfx.hellofx;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void nextTest() throws IOException {
    	App.setRoot("three");
    	System.out.println("Hallo Welt");
    }
}