package ru.alexov.altarics.model.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import ru.alexov.altarics.model.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee dep);
	public List<Employee> getAll();
	public Employee getById(long id);
	public void update(Employee dep);
	public void delete(long id);

}
