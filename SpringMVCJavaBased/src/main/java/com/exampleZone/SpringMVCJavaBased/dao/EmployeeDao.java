package com.exampleZone.SpringMVCJavaBased.dao;

import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

import com.exampleZone.SpringMVCJavaBased.model.Employee;

@Repository("employeeDao")
public class EmployeeDao extends RootDao<Long, Employee> {

	private static final Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
	
	public Employee findEmployeeById(long id)
	{
		Employee e  = getById(id);
		if(e == null)
		{
			LOGGER.warning("No Employee found in DB with id  : "+id);
		}
		return e;
	}
	
	public void saveEmployee(Employee e)
	{
		persist(e);
	}
	
	public void deleteEmployee(long id)
	{
		Employee e  = findEmployeeById(id);
		if(e == null)
		{
			LOGGER.warning("Could not delete Empoyee as no such found with id  :  "+id);
		}
		delete(e);
	}
	
	
}
