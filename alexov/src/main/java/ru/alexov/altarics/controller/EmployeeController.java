package ru.alexov.altarics.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.alexov.altarics.DAO.DaoEmployee;
import ru.alexov.altarics.model.entity.Employee;
import ru.alexov.altarics.model.services.EmployeeService;

@RestController
//@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employee;
	
	@GetMapping(value ="welcome", produces ="application/json")
		public String welcome() {
		
		return"Hello rest app";
	}
	@RequestMapping(value ="employees", method = RequestMethod.GET, produces ="application/json")
	@ResponseBody
	public List<Employee> getall(){
		return employee.getAll();
	}
	@RequestMapping(value ="{id}", method = RequestMethod.GET, produces ="application/json")
	@ResponseBody
	public Employee getByid(@PathVariable("id") long id) {
		return employee.getById(id);
	} 
	@RequestMapping(value ="/employee/{id}", method = RequestMethod.PUT, produces ="applicatinn/json")
	public void updateEmp(@PathVariable("id") long id, @RequestBody Employee name) {
			Employee emp =employee.getById(id);
			emp.setName(name.getName());
		employee.update(emp);
	}
	@RequestMapping(value ="/employee", method = RequestMethod.POST, produces ="applicatinn/json")
	public void addEmployee(@RequestBody Employee emp) {
		employee.addEmployee(emp);
	}
	

}
