package com.raajangiri.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raajangiri.Entity.Employee;
import com.raajangiri.Service.MyService;

@RestController
public class MyController {
	
	@Autowired
	private MyService service;

	@GetMapping("/findAll")
	public List<Employee> findAll() throws ClassNotFoundException {
		 return service.findAll();
	}

	@GetMapping("/findAll/{id}")
	public List<Employee>  findById(@PathVariable long id) throws ClassNotFoundException {
		 return service.findById(id);
	}

	@PostMapping("/save")
	public String save(@RequestBody Employee employee) {
	 return service.save(employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
	return service.deleteById(id);
	}

	@PutMapping("/save/{id}")
	public String update(@RequestBody Employee employee, @PathVariable long id) {
	 return service.update(employee, id);
	}

}



