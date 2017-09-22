package com.exampleZone.SpringMVCJavaBased.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.exampleZone.SpringMVCJavaBased.model.Employee;
import com.exampleZone.SpringMVCJavaBased.service.EmployeeService;

/**
 * @author chinmay
 *
 */
@Controller
@RequestMapping("/")
public class MainController {

	private final Logger LOGGER  = Logger.getLogger(MainController.class.getName());
	
	
	@Autowired
	private EmployeeService empService;
	
	
	/**
	 * @param model
	 * @return 
	 */
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
		modelMap.addAttribute("edit", false);
		return "newemp";
	}
	
	@RequestMapping(value="/newemp",method=RequestMethod.POST)
	public String  saveEmployee(@ModelAttribute("employee")Employee employee, ModelMap modelMap)
	{
		Employee newEmp = employee;
		empService.addEmployee(newEmp);
		return "redirect:emp";
	}
	
	@RequestMapping(value="/emp/update/{id}", method=RequestMethod.GET)
	public String editEmployee(@PathVariable long id, ModelMap modelMap)
	{
		Employee e  = empService.getEmployeeById(id);
		if(e == null)
		{
			modelMap.addAttribute("error", "No Employee found with id : "+id);
			return "empdata";
		}
		
		modelMap.addAttribute("employee", e);
		modelMap.addAttribute("edit",true);
		return "newemp";
	}
	
	// path variable : id wasted here look another way to implement method
	
	@RequestMapping(value="/emp/update/{id}",method=RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee")Employee employee, ModelMap modelMap )
	{
		// need a new property to have distinct employees (ex: emp_no,etc)
//		Employee updatedEmp = employee;
//		empService.updateEmployee(updatedEmp);
//		return "redirect:emp";
		
		return "siteupdatepage";
	}
	
	@RequestMapping(value="/emp/delete/{id}",method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable long id)
	{
		
		empService.deleteEmpoyeeById(id);
		return "redirect:/emp";
	}
}