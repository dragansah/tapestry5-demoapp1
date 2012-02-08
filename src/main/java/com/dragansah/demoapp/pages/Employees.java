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

package com.dragansah.demoapp.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.apache.tapestry5.util.AbstractSelectModel;

import com.dragansah.demoapp.domain.Department;
import com.dragansah.demoapp.domain.Employee;
import com.dragansah.demoapp.services.EmployeesDAO;

public class Employees
{
	@Inject
	private EmployeesDAO employeesDAO;

	@Property
	private Employee employee;

	public List<Employee> getEmployees()
	{
		if (department == null)
			return employeesDAO.findAll();

		return employeesDAO.findAll(department);
	}

	@PageActivationContext
	@Property
	private Department department;

	@Inject
	private Block editBlock;

	public Object onEdit(Employee employee)
	{
		editingEmployee = employee;
		return editBlock;
	}

	@Persist
	@Property
	private Employee editingEmployee;

	@InjectComponent
	private Zone editZone;

	@InjectComponent
	private Zone mainZone;

	@InjectComponent
	private Zone salaryZone;
	
	@Inject
	private AjaxResponseRenderer ajaxResponseRenderer;

	@CommitAfter
	Object onSuccessFromEditEmployee()
	{
		employeesDAO.save(editingEmployee);
		ajaxResponseRenderer.addRender(mainZone);
		return editZone;
	}

	@Log
	@CommitAfter
	Object onSlide(Employee employee, Integer salary)
	{
		this.employee = employee;
		employee.setSalary(salary);
		return salaryZone.getBody();
	}

	public String getSalaryZoneId()
	{
		return "salary-zone-" + employee.getId();
	}

	public SelectModel getDepartmentModel()
	{
		return new AbstractSelectModel()
		{

			@Override
			public List<OptionModel> getOptions()
			{
				List<OptionModel> options = new ArrayList<OptionModel>();
				for (final Department d : employeesDAO.findAllDepartments())
					options.add(new OptionModel()
					{

						@Override
						public boolean isDisabled()
						{
							// TODO Auto-generated method stub
							return false;
						}

						@Override
						public Object getValue()
						{
							return d;
						}

						@Override
						public String getLabel()
						{
							return d.getName();
						}

						@Override
						public Map<String, String> getAttributes()
						{
							// TODO Auto-generated method stub
							return null;
						}
					});

				return options;
			}

			@Override
			public List<OptionGroupModel> getOptionGroups()
			{
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public ValueEncoder<Department> getDepartmentEncoder()
	{
		return new ValueEncoder<Department>()
		{

			@Override
			public String toClient(Department value)
			{
				return value.getCode();
			}

			@Override
			public Department toValue(String clientValue)
			{
				return employeesDAO.findById(clientValue);
			}
		};
	}
}
