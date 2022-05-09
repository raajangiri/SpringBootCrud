package com.raajangiri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raajangiri.Entity.Employee;
import com.raajangiri.Entity.EmployeeRepository;

@Service
public class EmpService {
	@Autowired  

	EmployeeRepository empRepo;
	//getting all books record by using the method findaAll() of CrudRepository  
	public List<Employee> getAllEmployee()   
	{  
	List<Employee> employee = new ArrayList<Employee>();  
	empRepo.findAll().forEach(employee1 -> employee.add(employee1));  
	return employee;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Employee getEmployeeById(long id)   
	{  
	return empRepo.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Employee books)   
	{  
	empRepo.save(books);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(long id)   
	{  
	empRepo.deleteById(id);  
	}  
	//updating a record  
	public void update(Employee employee, long id)   
	{  
	empRepo.save(employee);  
	}  
	}  