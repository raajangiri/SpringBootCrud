package com.raajangiri.controller;

import java.util.ArrayList;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.raajangiri.Entity.Employee;
import com.raajangiri.Entity.EmployeeRepository;
import com.raajangiri.service.EmpService;
@RestController
public class MyController {

	
	@Autowired(required=true)
	private EmpService empService;
	
	@GetMapping("/employee")  
	private List<Employee> getAllEmployee()   
	{  
	return empService.getAllEmployee(); 
	}  
	
	@GetMapping("/employee/{employeeid}")  
	private Employee getEmployee(@PathVariable("employeeid") long id)   
	{  
	return empService.getEmployeeById(id);  
	} 
	
	@PostMapping("/employees")  
	private Employee saveEmployee(@RequestBody Employee employee)   
	{  
	empService.saveOrUpdate(employee);  
	return employee;
	}  
	@PutMapping("/update")  
	private Employee update(@RequestBody Employee employee)   
	{  
	empService.saveOrUpdate(employee);  
	return employee;  
	}  
	
	@DeleteMapping("/delete/{employeeid}")  
	private void deleteBook(@PathVariable("employeeid") int employeeid)   
	{  
	empService.delete(employeeid);  
	}  
	
	

}
