package com.learning.spring.z.jpatutorial.controller.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.boot.support.exceptions.UserNotFoundException;
import com.learning.spring.z.jpatutorial.model.beans.Employee;
import com.learning.spring.z.jpatutorial.model.dao.EmployeeCustomRepository;
import com.learning.spring.z.jpatutorial.model.dao.EmployeeRepository;

@RestController
public class EmployeeResource {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	EmployeeCustomRepository customEmployeeRepository;

	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee retrieveEmployee(@PathVariable int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent()) {
			throw new UserNotFoundException("Employee With Id :" + id + "Not Found");
		}
		return employee.get();
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		employeeRepository.deleteById(id);
	}

	@GetMapping("/employees/custom")
	public List<String> retrieveEmployeeEmailBySurnameAndLocation(@RequestParam("location") String location,
			@RequestParam("surname") String surname) {
		return customEmployeeRepository.findEmployeeBySurnameAndLocation(location, surname);
	}
}
