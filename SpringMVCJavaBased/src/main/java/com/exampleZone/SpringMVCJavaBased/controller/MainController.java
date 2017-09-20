package com.exampleZone.SpringMVCJavaBased.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.exampleZone.SpringMVCJavaBased.model.Employee;
import com.exampleZone.SpringMVCJavaBased.service.EmployeeService;

@Controller
@RequestMapping("/")
public class MainController {

	private final Logger LOGGER  = Logger.getLogger(MainController.class.getName());
	
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcomeMessage(ModelMap model)
	{
		model.addAttribute("message", "Project is up and running !!!");
		return "index";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String getAllEmployees(ModelMap modelMap)
	{
		List<Employee> empList = empService.getAllEmployees();
		modelMap.addAttribute("allEmployees", empList);
		return "empdata"; 
	}
	
	@RequestMapping(value="/newemp",method=RequestMethod.GET)
	public String addEmployee(ModelMap modelMap)
	{
		Employee e =  new Employee();
		modelMap.addAttribute("employee", e);
		return "newemp";
	}
	
	@RequestMapping(value="/newemp",method=RequestMethod.POST)
	public String  saveEmployee(@ModelAttribute("employee")Employee employee, ModelMap modelMap, UriComponentsBuilder uriComponentsBuilder)
	{
		Employee newEmp = employee;
		empService.addEmployee(newEmp);
		
		return "redirect:emp";
	}
}