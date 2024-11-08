package com.tka.DatabaseDemo2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.DatabaseDemo2.entity.Employee;
import com.tka.DatabaseDemo2.service.EmployeeService;

@RestController
@RequestMapping("employeeApi")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("addrecord")
	public ResponseEntity<String> addRecord(@RequestBody Employee employee) {
		
		
		String msg =employeeService.addRecord(employee);
		
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updaterecord/{id}")
	public ResponseEntity<String> updateRecord(@RequestBody Employee employee,@PathVariable int id) {
		
		
		String msg =employeeService.updateRecord(employee,id);
		
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleterecord/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable int id) {
		
		
		String msg =employeeService.deleteRecord(id);
		
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllRecord() {
		
		
		List<Employee> list =employeeService.getAllRecord();
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id) {
		
		
		Employee employee =employeeService.getById(id);
		
		return ResponseEntity.ok(employee);
	}
	
	
	@PostMapping("userlogin")
	public ResponseEntity<Map> userLogin(@RequestBody Employee employee) {
		
		Map map = employeeService.userLogin(employee);
		
		return ResponseEntity.ok(map);
		
	}
	
	@GetMapping("getBySalary/{salary1}/{salary2}")
	public ResponseEntity<List<Employee>> getBySalaryRange(@PathVariable double salary1,@PathVariable double salary2) {
		
		List<Employee> list= employeeService.getBySalaryRange(salary1,salary2);
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("getBystatus/{status}")
	public ResponseEntity<List<Employee>> getByStatus(@PathVariable String status) {
		
		List<Employee> list= employeeService.getByStatus(status);
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("updateBystatus/{id}")
	public ResponseEntity<String> updateByStatus(@PathVariable int id) {
		
		
		String msg =employeeService.updateByStatus(id);
		
		return ResponseEntity.ok(msg);
	}

}
