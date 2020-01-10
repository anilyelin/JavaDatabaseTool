package org.openjfx.hellofx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openjfx.hellofx.App;
//import org.openjfx.hellofx.DatabaseConnection;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CsvReader {
	
	
	Stage stage;
	
	/**
	 * 
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void start() throws IOException, ClassNotFoundException, SQLException {
		
		try {
		//creating a database connection to submit the csv
		// data to the mysql database
		DatabaseConnection dbc = new DatabaseConnection();
		//ArrayList<String> test = new ArrayList<>();
		
		FileChooser chooser = new FileChooser();
	    chooser.setTitle("Open File");
	    chooser.getExtensionFilters().addAll(
	    	     new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
	    File file = chooser.showOpenDialog(new Stage());
		 
	    BufferedReader csvReader = new BufferedReader(new FileReader(file));
	    String row = "";
	    
		while ((row = csvReader.readLine()) != null) {
	    	String[] data= row.split(",");
	    	
	    	Integer empid = Integer.parseInt(data[0]);
	    	Integer depid = Integer.parseInt(data[3]);
	    	dbc.empConnection(empid, data[1], data[2], depid);
	    	System.out.println();
	    	System.out.println("The emp ids are: "+data[0]);
	    	System.out.println("The firstnames are: "+data[1]);
	    	System.out.println("The last names are: "+data[2]);
	    	System.out.println("The dep ids are: "+data[3]);
	    	System.out.println();
	    	//for (String elem : data) {
	    	//	System.out.println(elem);
	    		//test.add(elem);
	    		
	    	//}
	    }
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Import successfull");
		alert.showAndWait();
		
		//Iterator itr = test.iterator();
		//while (itr.hasNext()) {
		//	System.out.println(itr.next());
		//}
		
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
