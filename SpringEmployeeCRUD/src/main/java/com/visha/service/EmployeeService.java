package com.visha.service;

import java.util.List;

import com.visha.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public String addEmployee(String empStr);
	
	public String addEmployees(String empStr);
	
	public String deleteEmployee(int id);
	
	public String deleteEmployees(String empStr);
	
	public String updateEmployee(String empStr);
	
	public String updateEmployees(String empStr);
	
	public Employee getEmployee(int id);
	
	public String getEmployeeByName(String name);
		
	

}
