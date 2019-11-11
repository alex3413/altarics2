package ru.alexov.altarics.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ru.alexov.altarics.model.entity.Department;

public class DepSalarys implements Runnable {
	@Autowired
	private DepartmentService department;
	
	public DepSalarys() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		List<Department> lst = (List<Department>) department.getAll();
		for(Department d: lst)
			department.totalSalaryDep(d);
		long timeout = 5*60*1000;
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			System.err.print("Error time out thread");
			e.printStackTrace();
		}
		

	}

}
