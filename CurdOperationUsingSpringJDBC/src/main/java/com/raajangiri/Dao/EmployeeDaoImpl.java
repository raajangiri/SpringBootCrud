package com.raajangiri.Dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raajangiri.Entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {


	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> findAll()
	{
	return jdbcTemplate.query("SELECT * FROM tbl_employees", new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	

	@Override
	public int deleteById(long id) {
		return jdbcTemplate.update("DELETE FROM tbl_employees WHERE id=?", id);
	}

	@Override
	public int save(Employee employee) {
		return jdbcTemplate.update("insert into tbl_employees(name,location ,departmant) values(?,?,?)", new Object[]{employee.getName(),employee.getLocation(),employee.getDepartment()});
		
	}
	
	@Override
	public int update(Employee employee,long id) {
		return jdbcTemplate.update("UPDATE tbl_employees SET name = ?, location = ?, department = ? WHERE id = ?", new Object[]{employee.getName(),employee.getLocation(),employee.getDepartment()},id);
		
	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM tbl_employees WHERE id=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}
	


}
