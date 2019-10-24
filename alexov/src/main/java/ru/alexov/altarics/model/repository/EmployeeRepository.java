package ru.alexov.altarics.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.alexov.altarics.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
