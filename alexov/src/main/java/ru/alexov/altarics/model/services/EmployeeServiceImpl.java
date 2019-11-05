package ru.alexov.altarics.model.services;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.entity.Employee;
import ru.alexov.altarics.model.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRep;
	
	@Override
	public void addEmployee(Employee empl) {
		employeeRep.saveAndFlush(empl);

	}

	@Override
	public List<Employee> getAllbydep( long idDep) {
		
		return employeeRep.findAllByIdDep(idDep);
	}

	@Override
	public Employee getById(long id) {
		
		 Optional<Employee> opempl = employeeRep.findById(id);
		 Employee emp = opempl.get();
		 return emp;
		 
	}

	@Override
	public void update(Employee dep) {
		employeeRep.saveAndFlush(dep);

	}

	@Override
	public void delete(long id) {
	employeeRep.deleteById(id);

	}
	
	@Override
	public void getOutEmpl(Employee emp, Calendar date) {
		emp.setDateofgetout(date);
		employeeRep.saveAndFlush(emp);
		
	}

	@Override
	public void transferDepEmpl(Employee emp, Department dep) {
		emp.setDep(dep);
		employeeRep.saveAndFlush(emp);
		
	}

	@Override
	public void transerDepEmplAll(Long dep, Department newdep) {
		List<Employee> list = getAllbydep(dep);
		for(Employee e: list)
			e.setDep(newdep);
		
	}

	@Override
	public Employee getBossofEmpl(Employee emp) {
		return employeeRep.findByDepAndBossdep(emp.getDep(), true);
		
	}

	@Override
	public Employee getByNameAndEmail(String name, String email) {
		
		return employeeRep.findByNameAndEmail(name, email);
	}

}
