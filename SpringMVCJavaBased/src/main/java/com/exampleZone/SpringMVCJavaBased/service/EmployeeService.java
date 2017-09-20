package com.exampleZone.SpringMVCJavaBased.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.exampleZone.SpringMVCJavaBased.model.Employee;


@Service
public class EmployeeService {

	private final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());
	
	private static final AtomicLong counter = new AtomicLong();

	private static List<Employee> eList;

	static {
		eList = getDummyEmployees();
	}

	public List<Employee> getAllEmployees() {
		return eList;
	}

	public Employee getEmployeeById(long id) {
		for (Employee e : eList) {
			if (e.getE_id() == id) {
				return e;
			}
		}
		LOGGER.warning("No such Employee found with Id  : "+id);
		return null;
	}

	public boolean checkEmployeeExist(Employee e) {
		if(getEmployeeById(e.getE_id()) !=null )
		{
			LOGGER.info("Employee with Id : "+e.getE_id()+" exist ");
			return true;
		}
		LOGGER.warning("Employee with Id : "+e.getE_id()+" does not exist");
		return false;
	}

	public void addEmployee(Employee e) {
		e.setE_id(counter.incrementAndGet());
		eList.add(e);
		LOGGER.info("employee "+e.getE_name()+" was added successfully");
	}

	public void deleteEmpoyeeById(long id) {
		for (Iterator<Employee> iterator = eList.iterator(); iterator.hasNext();) {
			Employee e = iterator.next();
			if (e.getE_id() == id) {
				iterator.remove();
				LOGGER.info("employee with Id : "+e.getE_id()+" was removed successfully");
			}
		}
	}

	private static List<Employee> getDummyEmployees() {
		List<Employee> dummyEmp = new ArrayList<>();
		dummyEmp.add(new Employee(counter.incrementAndGet(), "Mike", "Developer", "mike@company.com", 1234566777,
				"mike address 1"));
		dummyEmp.add(new Employee(counter.incrementAndGet(), "Jenny", "Tester", "jenny@company.com", 2112212,
				"jenny address 1"));
		dummyEmp.add(new Employee(counter.incrementAndGet(), "Rachel", "Developer", "rachel@company.com", 3223233,
				"rachel address 1"));

		return dummyEmp;
	}
}
