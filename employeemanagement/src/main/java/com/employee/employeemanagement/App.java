package com.employee.employeemanagement;

import com.employeemanagementdao.EmployeeDao;
import com.employeemanagementdao.EmployeeDetailDao;
import com.employeemanagemententity.Employee;
import com.employeemanagemententity.EmployeeDetail;

// kindly uncomment line for execution purpose only.........

public class App {
	public static void main(String[] args) {
		// Save two employee
		Employee employee = new Employee("mitul", "krishna", 32);
		EmployeeDetail employeeDetail = new EmployeeDetail("Mumbai", "www.pyro2k@gmail.com", 165000);
		employee.setEmployeeFirstName("Pyro");
		employeeDetail.setEmployee(employee);
		employee.setEmployeeDetail(employeeDetail);

		Employee employee1 = new Employee("crow", "sinister", 26);
		EmployeeDetail employeeDetail1 = new EmployeeDetail("Mumbai", "www.sinister@gmail.com", 165000);
		// employee1.setEmployeeFirstName("Sindhu");
		employeeDetail1.setEmployee(employee1);
		employee1.setEmployeeDetail(employeeDetail1);

		EmployeeDao emplo = new EmployeeDao();

		// for save data
		// emplo.saveEmployee(employee);
		// emplo.saveEmployee(employee1);
		Employee e1 = emplo.getEmployee(3);

		System.out.println(e1.getEmployeeFirstName());
		// e1.setEmployeeFirstName("Sixense");
		emplo.deleteEmployee(4);

		EmployeeDetailDao emp = new EmployeeDetailDao();
		// emp.incrementEmployeeSalary(2, 30);
		emp.deleteEmployeeDetail(4);

	}
}
