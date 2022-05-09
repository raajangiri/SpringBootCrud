package com.raajangiri.service;

import java.util.List;

import com.raajangiri.Entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(long id);
	public Employee postEmployee(Employee emp);
	public Employee deleteEmployee(long id);
	public Employee updataEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	
	

}
