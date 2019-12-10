package org.openjfx.hellofx;

public class Employee {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private int departmentID;
	
	/**
	 * 
	 * @param employeeID
	 * @param firstName
	 * @param lastName
	 * @param departmentID
	 */
	
	public Employee(int employeeID, String firstName, String lastName, int departmentID) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentID = departmentID;
	}
	/**
	 * 
	 * @return
	 */
	public int getEmployeeID() {
		return employeeID;
	}
	/**
	 * 
	 * @return
	 */
	
	public int getDepartmentID() {
		return departmentID;
	}
	/**
	 * 
	 * @return
	 */
	
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @return
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setEmployeeID(int id) {
		employeeID = id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setDepartmentID(int id) {
		departmentID = id;
	}
	/**
	 * 
	 * @param fName
	 */
	public void setFirstName(String fName) {
		firstName = fName;
	}
	/**
	 * 
	 * @param lName
	 */
	public void setLastName(String lName) {
		lastName = lName;
	}
	
	
	
	
	

}
