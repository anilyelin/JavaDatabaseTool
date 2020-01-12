package org.openjfx.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * 
 * @author anilyelin
 *
 */

public class PersonOverview {
	
	/**
	 * provids the functionality to fill the javafx table
	 * with the employee data
	 */
	
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

	private PersonDataTable pdt;
	
	public PersonOverview() {

	}

	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

	
	public void setMainApp(PersonDataTable pdt) {
		this.pdt = pdt;
		initialize();
		personTable.setItems(pdt.getPersonData());
	}
	

}
