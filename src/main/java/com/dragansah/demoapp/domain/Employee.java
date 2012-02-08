package com.dragansah.demoapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee
{
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer salary;

	private Department department;

	public Employee()
	{

	}

	public Employee(String firstName, String lastName, Integer salary)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Employee(String firstName, String lastName, Integer salary, Department department)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Column
	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Column
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Column
	public Integer getSalary()
	{
		return salary;
	}

	public void setSalary(Integer salary)
	{
		this.salary = salary;
	}

	@ManyToOne
	@JoinColumn
	public Department getDepartment()
	{
		return department;
	}

	public void setDepartment(Department department)
	{
		this.department = department;
	}

}
