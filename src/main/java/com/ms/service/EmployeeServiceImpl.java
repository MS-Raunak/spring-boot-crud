package com.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.Employee;
import com.ms.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> getAllEmployees() {
		 List<Employee> employees = (List<Employee>) employeeRepository.findAll();
	
		 return employees;
	}


	@Override
	public void saveEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		
		Employee employee;
	
		if(optional.isPresent()){
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee Not Found: " + id);
		}
		return employee;
	}


	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
	}

}
