package ru.alexov.altarics.model.services;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import ru.alexov.altarics.model.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee dep);
	public Collection<Employee> getAll();
	public Optional<Employee> getById(long id);
	public void update(Employee dep);
	public void delete(long id);

}
