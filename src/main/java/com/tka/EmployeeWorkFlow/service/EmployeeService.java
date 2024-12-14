package com.tka.OrganizationWorkFlow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationWorkFlow.dao.EmployeeDao;
import com.tka.OrganizationWorkFlow.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao<?, ?> dao;

	public String addRecord(Employee employee) {
		String msg = dao.addRecord(employee);

		if (Objects.isNull(msg)) {
			msg = "Employee is Not added...";
		}

		return msg;
		
	}

	public String updateRecord(Employee employee, int id) {
		String msg = dao.updateRecord(employee,id);

		if (Objects.isNull(msg)) {
			msg = "Employee is Not Updated...";
		}

		return msg;
	}

	public String deleteRecord(int id) {
		String msg = dao.deleteRecord(id);

		if (Objects.isNull(msg)) {
			msg = "Employee is Not Deleted...";
		}

		return msg;
	}

	public List<Employee> getAllRecord() {
		List<Employee> list= dao.getAllRecord();
		return list;
	}

	public Employee getById(int id) {
		Employee employee= dao.getById(id);
		return employee;
	}

	public Map<String, Object> userLogin(Employee employee) {
		Employee obj = dao.userLogin(employee);
		Map<String, Object> map =new HashMap<String, Object>();
		

		if (Objects.isNull(obj)) {
			map.put("msg", "Invalid user");
			map.put("user", obj);
			
			
		} else {
			map.put("msg", "Valid user");
			map.put("user", obj);
		}

		return map;
		
	}

	public List<Employee> getBySalaryRange(double salary1, double salary2) {
		List<Employee> list= dao.getBySalaryRange(salary1,salary2);
		return list;
	}

	public List<Employee> getByStatus(String status) {
		List<Employee> list= dao.getByStatus(status);
		return list;
	}

	
	public String updateByStatus(int id) {
		
		
		Employee emp = dao.updateByStatus(id);
		
		
		String currentStatus= emp.getStatus();
		
		if (currentStatus.equals("active")) {
			
            return "Status changed successfully";
            
		} else if (currentStatus.equals("inactive")){
			
            return "Status changed successfully";
			
		} else if (currentStatus.equals("suspend")) {
			
            return "Suspended employee does not change status..!";
		}else {
			return "Unknown status";
		}
	


		
	}

}
