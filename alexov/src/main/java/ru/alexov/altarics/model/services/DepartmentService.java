package ru.alexov.altarics.model.services;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import ru.alexov.altarics.model.entity.Department;

public interface DepartmentService {
	public Department add(Department dep);
	public Collection<Department> getAll();
	public Optional<Department> getById(long id);
	public void update(Department dep);
	public void delete(long id);

}
