package com.java.employee.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employee.entity.Employee;
import com.java.employee.exceptions.EmployeeNotFoundException;
import com.java.employee.repository.EmployeeRepository;
import com.java.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee getEmployeeDetails(Long id) {
		Optional<Employee> findById = repo.findById(id);
		if(null==findById) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		return repo.findById(id).get();
	}
	
	
}
