package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.entity.Employee;
import com.ms.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("employeeList", empService.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showAddEmpform")
	public String showAddEmpForm(Model model) {
		Employee employee  = new Employee();
		model.addAttribute("empobj", employee);
		return "addEmpForm";
	}
	
	@PostMapping("/saveEmp")
	public String postMethodName(@ModelAttribute("employee") Employee employee) {
		empService.saveEmployee(employee);
		
		return "redirect:/";
	}
	
	@GetMapping("/showUpdateForm/{id}")
	public String updateEmpById(@PathVariable(value = "id") int id, Model model) {
		Employee employee = empService.getEmployeeById(id);
		model.addAttribute("empobj", employee);
		return "updateEmpForm";
	}
	
	
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmpById(@PathVariable(value = "id") int id) {
		empService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
	

}
