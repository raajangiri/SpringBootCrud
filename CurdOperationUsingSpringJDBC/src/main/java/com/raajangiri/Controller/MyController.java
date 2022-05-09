package com.raajangiri.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raajangiri.Dao.EmployeeDao;
import com.raajangiri.Entity.Employee;

@RestController
public class MyController {
	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@GetMapping("/findById/{id}")
	public Employee findById(@PathVariable int id) {
		return employeeDao.findById(id);
	}

	@PostMapping("/save")
	public String save(@RequestBody Employee employee) {
		return employeeDao.save(employee) + " Employees addes sucessfully";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		return employeeDao.deleteById(id) + " Employee(s) delete from the database";
	}

	@PutMapping("/save/{id}")
	public String update(@RequestBody Employee e, @PathVariable int id) {
		return employeeDao.update(e, id) + " Employee(s) updated successfully";
	}

}
