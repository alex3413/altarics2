package ru.alexov.altarics.DAO;

import java.util.Set;

import ru.alexov.altarics.model.entity.Department;



public interface DaoDepartment {
	public void add(Department dep);
	public Set<Department> getAll();
	public Department getById(int id);
	public void update(Department dep);
	public void remove(Department dep);
}

