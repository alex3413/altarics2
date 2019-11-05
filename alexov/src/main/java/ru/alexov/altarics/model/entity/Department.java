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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="Department")
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
	@OneToMany(mappedBy="dep",fetch =FetchType.LAZY,cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<Employee> empList;

	public Department() {}
	
	public Department(long id, String name, Long parentdepId, List<Employee> empList) {
		super();
		this.id = id;
		this.name = name;
		this.parentdepId = parentdepId;
		this.empList = empList;
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
