package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openjfx.hellofx.App;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CsvReader  {
	
	
	Stage stage;
	
	/**
	 * 
	 * @throws IOException
	 */
	public void start() throws IOException {
		
		try {
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Open File");
	    chooser.getExtensionFilters().addAll(
	    	     new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
	    File file = chooser.showOpenDialog(new Stage());
		 
	    BufferedReader csvReader = new BufferedReader(new FileReader(file));
	    String row = "";
		while ((row = csvReader.readLine()) != null) {
	    	String[] data= row.split(",");
	    	//System.out.println(data[0].toString());
	    	//System.out.println(data[1].toString());
	    	//System.out.println(data[2].toString());
	    	//System.out.println(data[3].toString());
	    }
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Import successfull");
		alert.showAndWait();
		
		App.setRoot("importData");
		
		} catch (FileNotFoundException ex) {
			//System.err.println(ex);
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("No file selected");
			alert.showAndWait();
		}
	    
	}
	
}
