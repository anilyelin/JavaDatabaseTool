package org.openjfx.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverview {
	
	@FXML
	private TableView<Person> personTable;
	
	@FXML
	private TableColumn<Person, Integer> empIdColumn;
	
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	
	@FXML
	private TableColumn<Person, Integer> depIdColumn;

	private App app;

	private Test3 test3;
	
	public PersonOverview() {

	}

	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

	
	public void setMainApp(Test3 test3) {
		this.test3 = test3;
		initialize();
		personTable.setItems(test3.getPersonData());
	}
	

}
