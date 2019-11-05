package ru.alexov.altarics.model.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import ru.alexov.altarics.model.entity.Department;

public interface DepartmentService {
	public Department add(Department dep);
	public Collection<Department> getAll();
	public Department getById(long id); 
	public void update(Department dep);
	public void delete(long id); 
	public List<Department> getsubDep(long idDep); 
	public Collection<Department> getsubDepAll(long idDep); 
	public Collection<Department> getParentDep(long idDep);
	public Department getByName(String name);
	public Double totalSalaryDep(Department dep);
	public void rename(String name, String newname);

}
