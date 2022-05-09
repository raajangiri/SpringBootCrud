package com.raajangiri.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raajangiri.Entity.Employee;
import com.raajangiri.Repository.MyRepository;

@Service
public class MyService {
	@Autowired
	 MyRepository myrepo;

	public List<Employee>  findById(long id) throws ClassNotFoundException {
		return myrepo.findById(id);
		
	}

	public List<Employee> findAll() throws ClassNotFoundException {
		return myrepo.findAll();
		
		
	}

	public String save(Employee employee) {
		return myrepo.save(employee);
		
	}

	public String deleteById(long id) {
		// TODO Auto-generated method stub
		return myrepo.deleteById(id);
		
	}

	public String update(Employee employee, long id) {
		return myrepo.update(employee, id);
		
	}

	
}
