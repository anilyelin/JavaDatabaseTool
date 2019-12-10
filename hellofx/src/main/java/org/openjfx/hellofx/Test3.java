package org.openjfx.hellofx;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Test3 {
	
	
	
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public Test3() {
		
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}
	
	
	

}
