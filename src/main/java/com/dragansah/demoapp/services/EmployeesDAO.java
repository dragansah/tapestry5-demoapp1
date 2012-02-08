// Copyright 2012 Dragan Sahpaski
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
