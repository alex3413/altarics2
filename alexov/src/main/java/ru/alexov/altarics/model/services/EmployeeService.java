package ru.alexov.altarics.model.services;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee empl);
	public List<Employee> getAll(long idDep); 
	public Employee getById(long id);
	public void update(Employee dep); 
	public void delete(long id);
	public void getOutEmpl(Calendar date);
	public void transferDepEmpl(Department dep);
	public void transerDepEmplAll(Department dep);
	public Employee getBossofEmpl(Employee emp);
	public Employee getByNameAndEmail(String name,String email);
	List<Employee> getAll();
	
	
	

}
