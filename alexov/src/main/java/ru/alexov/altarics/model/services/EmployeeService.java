package ru.alexov.altarics.model.services;

import java.util.Set;

import ru.alexov.altarics.model.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee dep);
	public Set<Employee> getAll();
	public Employee getById(long id);
	public void update(Employee dep);
	public void delete(long id);

}
