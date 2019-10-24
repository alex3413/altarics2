package ru.alexov.altarics.model.services;

import java.util.Collection;
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
	public Collection<Employee> getAll() {
		
		return employeeRep.findAll();
	}

	@Override
	public Optional<Employee> getById(long id) {
		
		 Optional<Employee> opempl = employeeRep.findById(id);
		 Employee emp = opempl.get();
		 return opempl;
		 
	}

	@Override
	public void update(Employee dep) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
