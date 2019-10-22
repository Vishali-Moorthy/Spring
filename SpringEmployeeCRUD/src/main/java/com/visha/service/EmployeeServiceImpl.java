package com.visha.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.visha.model.Employee;
import com.visha.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> listEmployee = (List<Employee>) empRepository.findAll();
		if (listEmployee.size() > 0) {
			return listEmployee;
		} else {
			return new ArrayList<Employee>();
		}

	}

	@Override
	public String addEmployee(String empStr) {

		JSONArray jsonArray = (JSONArray) JSONValue.parse(empStr);
		Employee emp = new Employee();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = (JSONObject) jsonArray.get(i);
			long id = (long) obj.get("id");
			emp.setId((int) id);
			double salary = (double) obj.get("salary");
			emp.setSalary(salary);
			String name = (String) obj.get("name");
			emp.setName(name);
		}
		Employee tempEmp = empRepository.save(emp);
		if (tempEmp != null) {
			return "Employee Created Successfully";
		} else {
			return "Employee Not Created";
		}

	}

	@Override
	public String addEmployees(String empStr) {
		JSONArray jsonArray = (JSONArray) JSONValue.parse(empStr);
		List<Employee> employeeList = new ArrayList<Employee>();

		for (int i = 0; i < jsonArray.size(); i++) {
			Employee emp = new Employee();
			JSONObject obj = (JSONObject) jsonArray.get(i);
			long id = (long) obj.get("id");
			emp.setId((int) id);
			double salary = (double) obj.get("salary");
			emp.setSalary(salary);
			String name = (String) obj.get("name");
			emp.setName(name);
			employeeList.add(emp);

		}
		List<Employee> tempEmp = (List<Employee>) empRepository.saveAll(employeeList);
		if (tempEmp != null) {
			return "Employee Created Successfully";
		} else {
			return "Employee Not Created";
		}

	}

	@Override
	public String deleteEmployee(int id) {
		empRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public String deleteEmployees(String empStr) {
		JSONArray jsonArray = (JSONArray) JSONValue.parse(empStr);
		List<Employee> employeeList = new ArrayList<Employee>();

		for (int i = 0; i < jsonArray.size(); i++) {
			Employee emp = new Employee();
			JSONObject obj = (JSONObject) jsonArray.get(i);
			long id = (long) obj.get("id");
			emp.setId((int) id);
			double salary = (double) obj.get("salary");
			emp.setSalary(salary);
			String name = (String) obj.get("name");
			emp.setName(name);
			employeeList.add(emp);

		}
		empRepository.deleteAll(employeeList);
		return "Deleted Successfully";
	}

	@Override
	public String updateEmployee(String empStr) {
		JSONArray jsonArray = (JSONArray) JSONValue.parse(empStr);
		Employee emp = new Employee();
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = (JSONObject) jsonArray.get(i);
			long id = (long) obj.get("id");
			emp.setId((int) id);
			double salary = (double) obj.get("salary");
			emp.setSalary(salary);
			String name = (String) obj.get("name");
			emp.setName(name);
		}
		empRepository.save(emp);
		return "Updated Successfully";
	}

	@Override
	public String updateEmployees(String empStr) {
		
		JSONArray jsonArray = (JSONArray) JSONValue.parse(empStr);
		List<Employee> employeeList = new ArrayList<Employee>();

		for (int i = 0; i < jsonArray.size(); i++) {
			Employee emp = new Employee();
			JSONObject obj = (JSONObject) jsonArray.get(i);
			long id = (long) obj.get("id");
			emp.setId((int) id);
			double salary = (double) obj.get("salary");
			emp.setSalary(salary);
			String name = (String) obj.get("name");
			emp.setName(name);
			employeeList.add(emp);

		}
		empRepository.saveAll(employeeList);
		return "Employees Updated";

	}

		
	

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
