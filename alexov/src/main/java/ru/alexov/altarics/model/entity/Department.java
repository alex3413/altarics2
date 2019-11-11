package ru.alexov.altarics.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="Department")
@SecondaryTables({
	@SecondaryTable(name="salarys", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="id_dep",referencedColumnName = "dep_id")
	})
})
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dep_id",nullable=false)
	private long id;
	
	@Column(name= "nameofDep")
	private String name;
	@Column(name = "parent_id")
	private Long parentdepId;
	@Column	
	@OneToMany(mappedBy="dep",fetch =FetchType.EAGER)
	//@JsonIgnore
	
	@JsonManagedReference
	private List<Employee> empList;
	@Column(table = "salarys")
	private Double totalSalary;

	public Department() {}
	
	public Department(long id, String name, Long parentdepId, List<Employee> empList) {
		super();
		this.id = id;
		this.name = name;
		this.parentdepId = parentdepId;
		this.empList = empList;
	}

	public Double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary() {
		double total=0;
		for(Employee e: empList)
			total+=e.getSalary();
		this.totalSalary = total;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public Long getParentdepId() {
		return parentdepId;
	}

	public void setParentdepId(Long parentdepId) {
		this.parentdepId = parentdepId;
	}

		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
