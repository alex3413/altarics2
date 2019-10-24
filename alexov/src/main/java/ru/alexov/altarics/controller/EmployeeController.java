package ru.alexov.altarics.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.alexov.altarics.DAO.DaoEmployee;
import ru.alexov.altarics.model.entity.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private DaoEmployee employee;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to rest employee";
	}
	@RequestMapping(value ="/employees", method = RequestMethod.GET, produces ="applicatinn/json")
	@ResponseBody
	public Set<Employee> getall(){
		return employee.getAll();
	}
	@RequestMapping(value ="/employee/{id}", method = RequestMethod.GET, produces ="applicatinn/json")
	@ResponseBody
	public Employee getByid(@PathVariable("id") long id) {
		return employee.getById(id);
	} 
	@RequestMapping(value ="/employee/{id}", method = RequestMethod.PUT, produces ="applicatinn/json")
	@ResponseBody
	public void updateEmp(@PathVariable("id") long id) {
		employee.update(employee.getById(id));
	}
	

}
