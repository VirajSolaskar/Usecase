package com.java.employee.service.impl;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.java.employee.entity.Employee;
import com.java.employee.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {
	@Mock
	private EmployeeRepository repo;
	@InjectMocks
	private EmployeeServiceImpl service;
	@Before
	void setUp() {
		service=new EmployeeServiceImpl();
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void getEmployeeDetails() {
		Long id=1L;
		Employee emp=new Employee();
		
		Optional<Employee> optinal=Optional.of(emp);
		Mockito.when(repo.findById(id)).thenReturn(optinal);
		Employee result=service.getEmployeeDetails(id);
		Assertions.assertNotNull(result);
	}
}
