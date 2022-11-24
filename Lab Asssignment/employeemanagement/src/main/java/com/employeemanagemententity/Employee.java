package com.employeemanagemententity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")

//pojo class
public class Employee {

	// creating instances and making database table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id") // it will be displayed in database
	private int id;

	@Column(name = "Employee_First_Name")
	private String employeeFirstName;

	@Column(name = "Employee_Last_Name")
	private String employeeLastName;

	@Column(name = "Employee_age")
	private int employeeAge;

	// giving relation between tables
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_info_id")
	private EmployeeDetail employeeDetail;

	// Default constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized contructor
	public Employee(String employeeFirstName, String employeeLastName, int employeeAge) {
		super();
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeAge = employeeAge;
	}

	// Generating getter setter
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	// generating To String method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeAge=" + employeeAge + ", employeeDetail=" + employeeDetail + "]";
	}

}
