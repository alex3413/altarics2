package ru.alexov.altarics.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.services.DepartmentService;
import ru.alexov.altarics.model.services.EmployeeService;


@RestController
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentService department;
	
	@GetMapping(value ="welcome", produces ="application/json")
	public String welcome() {
	
	return"Hello rest app dep";
	}
	
	@PostMapping(value ="add", produces ="applicatinn/json")
	public Department add(@RequestBody Department dep) {
		department.add(dep);
		return dep;
		
	}
	@GetMapping(value ="all")
	@ResponseBody
	public Collection<Department> getAll(){
		return department.getAll();
		
	}
	@GetMapping(value ="{id}")
	
	public Department getById(@PathVariable("id") Long id){ 
		return department.getById(id);
	}
	@PutMapping(value ="{id}", produces ="applicatinn/json")
	public void update(@RequestBody Department dep) {
		department.update(dep);		
	}
	@DeleteMapping(value ="{id}")
	public void delete(long id) throws Exception {
		if(department.getById(id).getEmpList().isEmpty())
			throw new IllegalArgumentException();
		department.delete(id); 
		
	}
	@PutMapping(value ="{name}", produces ="applicatinn/json")
	public void rename(@PathVariable("name") String name, @RequestBody String newname) {
		department.rename(name, newname);
	}
	@GetMapping(value ="sub/{id}")
	public Collection<Department> getsubDep(@PathVariable("id") long idDep){
	
		return department.getsubDep(idDep);
	}
	@GetMapping(value ="suball/{id}")
	public Collection<Department> getsubDepAll(@PathVariable("id") long idDep){
	
		return department.getsubDepAll(idDep);
	}
	@GetMapping(value ="parent/{id}")
	public Collection<Department> getParentDep(@PathVariable("id") long idDep){
		return department.getParentDep(idDep);
		
	}
	@GetMapping(value ="name")
	public Department getByName(@PathVariable("name")String name) {
		
		return department.getByName(name);
	}
	@GetMapping(value ="salary/{id}", produces ="applicatinn/json")
	public Double totalSalaryDep(@PathVariable("id") Long idDep) {
		Department dep=department.getById(idDep);
		return department.totalSalaryDep(dep);
		
	}

}
