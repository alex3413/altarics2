package ru.alexov.altarics.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ru.alexov.altarics.exception.IllegalDateEntytyException;
import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.entity.Employee;
import ru.alexov.altarics.model.services.EmployeeService;

@RestController
@RequestMapping("employee")
@Api(value = "Контроллер работников", description ="контроллер обработки запросов работников")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employee;
	
	@GetMapping(value ="welcome")
	public String welcome() {
		return"Hello rest app";
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllbyidDep(@RequestBody long idDep){
		return employee.getAllbydep(idDep);
	}
	@RequestMapping(value ="{id}", method = RequestMethod.GET)
	public Employee getByid(@PathVariable("id") long id) {
		return employee.getById(id);
	} 
	@RequestMapping(value ="{id}", method = RequestMethod.PUT, produces ="applicatinn/json")
	public void updateEmp(@PathVariable("id") long id, @Valid@RequestBody Employee emp) {
		emp.setId(id);
		
		employee.update(emp);
	}
	@RequestMapping(method = RequestMethod.POST, produces ="applicatinn/json")
	public void addEmployee(@Valid@RequestBody Employee emp) {
		employee.addEmployee(emp);
	}
	@PutMapping(value= "getout/{id}")
	public void getOutEmpl(@PathVariable("id") long emp, Calendar date) {
		Employee e = employee.getById(emp);
		if((date.compareTo(e.getDatestartjob())>0))
				throw new IllegalDateEntytyException();
			
		employee.getOutEmpl(employee.getById(emp), date);
	}
	@ApiOperation(value= "Метод перевода сотрудника", notes= "переводим одного сотрудника в др. департамент")
	@PutMapping(value= "transfer/{id}", produces ="applicatinn/json")
	public void transferDepEmpl(@PathVariable("id") long id, @RequestBody Department dep) {
		employee.transferDepEmpl(employee.getById(id), dep);
	}
	@ApiOperation(value= "Метод перевода всех сотрудников", notes= "переводим всех сотрудников в др. департамент")
	@PutMapping(value= "transferall/{idDep}")
	public void transerDepEmplAll(@PathVariable("idDep") long idDep, @RequestBody Department newdep) {
		employee.transerDepEmplAll(idDep, newdep);
	}
	@GetMapping (value = "boss")
	public Employee getBossofEmpl(@RequestBody Employee emp) {
		return employee.getBossofEmpl(emp);
		
	}
	@GetMapping (value = "nameandemail")
	public Employee getByNameAndEmail(@RequestBody Map <String, String>  nameAndEmail) {
		return employee.getByNameAndEmail(nameAndEmail.get("name"), nameAndEmail.get("email"));
		
	}
	

}
