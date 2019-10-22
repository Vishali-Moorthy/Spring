package com.visha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visha.model.Employee;
import com.visha.service.EmployeeService;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping ("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = empService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping ("/add")
	public ResponseEntity<String> addEmployee(@RequestBody String empStr) {
		return new ResponseEntity<String>(empService.addEmployee(empStr), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping ("/addAll")
	public ResponseEntity<String> addEmployees(@RequestBody String empStr) {
		
		return new ResponseEntity<String>(empService.addEmployees(empStr),new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		return new ResponseEntity<String>(empService.deleteEmployee(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/deleteEmployees")
	public ResponseEntity<String> deleteEmployees(@RequestBody String empStr) {
		return new ResponseEntity<String>(empService.deleteEmployees(empStr), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody String empStr) {
		return new ResponseEntity<String>(empService.updateEmployee(empStr), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/updateEmployees")
	public ResponseEntity<String> updateEmployees(@RequestBody String empStr) {
		return new ResponseEntity<String>(empService.updateEmployees(empStr), new HttpHeaders(), HttpStatus.OK);
	}

}
