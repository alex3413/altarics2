package ru.alexov.altarics.model.services;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRep;

	@Override
	public Department add(Department dep) {
		return departmentRep.saveAndFlush(dep);
		

	}

	@Override
	public Collection<Department> getAll() {
		
		return departmentRep.findAll();
	}

	@Override
	public Optional<Department> getById(long id) {
		
		return departmentRep.findById(id);
	}

	@Override
	public void update(Department dep) {
		departmentRep.saveAndFlush(dep);

	}

	@Override
	public void delete(long id) {
		departmentRep.deleteById(id);

	}

}
