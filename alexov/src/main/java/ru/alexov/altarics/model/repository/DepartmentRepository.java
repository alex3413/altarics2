package ru.alexov.altarics.model.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.alexov.altarics.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	@Query("select u from Department u where u.parentdepId=:idDep")
	List<Department> getsubDep(@Param("idDep") Long idDep);
	Department findByName(String name);
	//Collection<Department> getsubDepAll(Long idDep);
	//Collection<Department> getParentDep(Long idDep);
	//Double totalSalaryDep(Department dep);
	

}
