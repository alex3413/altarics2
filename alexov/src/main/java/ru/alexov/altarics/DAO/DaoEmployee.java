package ru.alexov.altarics.DAO;

import java.util.Set;

import ru.alexov.altarics.model.entity.Employee;


public interface DaoEmployee {

	public void add(Employee dep);
	public Set<Employee> getAll();
	public Employee getById(long id);
	public void update(Employee dep);
	public void remove(Employee dep);
}