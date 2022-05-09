package com.raajangiri.Dao;

import java.util.List;

import com.raajangiri.Entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();
	public int deleteById(long id);
	public Employee findById(long id);
	public int save(Employee employee);
	public int update(Employee employee,long id);
}
