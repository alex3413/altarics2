package ru.alexov.altarics.model.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ru.alexov.altarics.model.entity.Department;
import ru.alexov.altarics.model.entity.Employee;
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
	public Department getById(long id) {
		Department dep =departmentRep.findById(id).get();
		System.out.println(dep.getName());
		return dep;
	}

	@Override
	public void update(Department dep) {
		departmentRep.saveAndFlush(dep);

	}

	@Override
	public void delete(long id) {
		departmentRep.deleteById(id);

	}

	@Override
	public void rename(String name, String newname) {
		Department dep= getByName(name);
		List<Department> list= (List<Department>) getAll();
		Iterator<Department> itr = list.iterator();
		boolean flag=false;
		while(itr.hasNext()) {
			flag=itr.next().getName().equals(newname);
			if(flag)
				break;
		}		
		if(flag)
			System.out.println("nfrjt bvz e;t tcnm");
		else
			dep.setName(newname);
		
	}

	@Override
	public List<Department> getsubDep(long idDep) {
		return departmentRep.getsubDep(idDep);
		
	}
	private List<Department> queryGetSubDep(Long idDep) {
		List<Department> listdep= (List<Department>) getsubDep(idDep);
		if(!listdep.isEmpty()) {
			List<Department> lst=new ArrayList<Department>();
			for(Department d: listdep) {
				lst.addAll(queryGetSubDep(d.getId()));
			}
			lst.addAll(listdep);
			return lst;
		}
		return listdep;
	}
	@Override
	public Collection<Department> getsubDepAll(long idDep) {
		return  queryGetSubDep( idDep);
	}
	private List<Department> getPaDe(List<Department> list) {
		Department dep=null;
		for(Department d: list)
			dep=d;
		Long index =dep.getParentdepId();
		if(index!=null) {
			Department depParent =departmentRep.findById(index).get();
			list.add(depParent);
			return getPaDe(list);
		}
		return list;
	}
	@Override
	public Collection<Department> getParentDep(long idDep) {
		List <Department> list = new LinkedList<Department>();
		Long index =departmentRep.findById(idDep).get().getParentdepId();
		if(index!=null) {
			Department depParent =departmentRep.findById(index).get();
			list.add(depParent);
			return getPaDe(list);
		}
		return null;
	}

	@Override
	public Department getByName(String name) {
		return departmentRep.findByName(name);
	}

	@Override
	public Double totalSalaryDep(Department dep) {
		dep.setTotalSalary();
		departmentRep.saveAndFlush(dep);		 
		return dep.getTotalSalary();
	}

	
}
