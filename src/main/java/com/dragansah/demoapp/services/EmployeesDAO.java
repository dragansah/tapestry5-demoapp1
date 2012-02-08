package com.dragansah.demoapp.services;

import java.util.List;

import com.dragansah.demoapp.domain.Department;
import com.dragansah.demoapp.domain.Employee;

public interface EmployeesDAO
{
	Employee findById(Integer id);
	
	Department findById(String code);
	
	List<Department> findAllDepartments();
	
	List<Employee> findAll();
	
	List<Employee> findAll(Department department);
	
	void save(Employee employee);
}
