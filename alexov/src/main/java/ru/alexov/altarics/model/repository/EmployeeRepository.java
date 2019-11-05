package ru.alexov.altarics.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT * FROM EMPLOYEE u WHERE u.id_dep=: idDep", nativeQuery= true)
	List<Employee> findAllByIdDep(@Param("idDep") long idDep);
	Employee findByDepAndBossdep(Department dep , boolean boss);
	Employee findByNameAndEmail(String name, String email);
}
