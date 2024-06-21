package com.ms.service;

import java.util.List;

import com.ms.entity.Employee;


public interface EmployeeService {
	//Get all data
	List<Employee> getAllEmployees();
	//Save and Update data by Id(when id is not existing then add and if existing then update)
	void saveEmployee(Employee employee);
	//Get Employee By Id
	Employee getEmployeeById(int id);
	//Delete Employee By Id
	void deleteEmployeeById(int id);
}
