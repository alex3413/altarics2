package ru.alexov.altarics.model.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Employee> getAll() {
		
		return employeeRep.findAll();
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
		// TODO Auto-generated method stub

	}

}
