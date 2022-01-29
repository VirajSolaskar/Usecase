package com.java.employee.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.java.employee.entity.Employee;
import com.java.employee.service.EmployeeService;
@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {
	@Mock
	private EmployeeService service;
	@InjectMocks
	private EmployeeController controller;
	@BeforeEach
	void setUp() {
		controller=new EmployeeController();
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void getEmployeeByIdTest() {
		Long id=1L;
		Employee emp=new Employee();
		Mockito.when(service.getEmployeeDetails(id)).thenReturn(emp);
		Employee employee=controller.getEmployeeById(id);
		Assertions.assertNotNull(employee);
	}
	
}
