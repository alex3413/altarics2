package ru.alexov.altarics.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.alexov.altarics.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
