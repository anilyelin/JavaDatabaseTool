package org.openjfx.hellofx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * @author anil yelin
 *
 */

public class Person {
	/**
	 * this class represents an employee with 
	 * all his information such as various id's
	 */
	
	private final StringProperty employeeID;
	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty departmentID;
	private App app;
	
	/**
	 * 
	 * @param employeeID
	 * @param firstName
	 * @param lastName
	 * @param departmentID
	 */
	public Person(String employeeID, String firstName, String lastName, String departmentID) {
		this.employeeID = new SimpleStringProperty(employeeID);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.departmentID = new SimpleStringProperty(departmentID);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmpID() {
		return this.employeeID.get();
	}
	/**
	 * 
	 * @return
	 */
	public String getDepID() {
		return this.departmentID.get();
	}
	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return this.firstName.get();
	}
	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return this.lastName.get();
	}
	/**
	 * 
	 * @return
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}
	/**
	 * 
	 * @return
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}
	/**
	 * 
	 * @return
	 */
	public StringProperty empIdProperty() {
		return employeeID;
	}
	/**
	 * 
	 * @return
	 */
	public StringProperty depIdProperty() {
		return departmentID;
	}
	/**
	 * 
	 * @param lname
	 */
	public void setLastName(String lname) {
		this.lastName.set(lname);
	}
	/**
	 * 
	 * @param fname
	 */
	public void setFirstName(String fname) {
		this.firstName.set(fname);
	}
	/**
	 * 
	 * @param depid
	 */
	public void setDepartmentID(String depid) {
		this.departmentID.set(depid);
	}
	/**
	 * 
	 * @param empid
	 */
	public void setEmployeeID(String empid) {
		this.employeeID.set(empid);
	}
	

}
