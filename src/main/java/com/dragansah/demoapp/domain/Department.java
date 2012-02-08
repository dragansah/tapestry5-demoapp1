package com.dragansah.demoapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department
{
	private String code;
	private String name;

	public Department()
	{

	}

	public Department(String code, String name)
	{
		super();
		this.code = code;
		this.name = name;
	}

	@Id
	@Column
	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	@Column
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
