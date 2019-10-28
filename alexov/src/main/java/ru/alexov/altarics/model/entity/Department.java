package ru.alexov.altarics.model.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false)
	private long id;
	
	@Column(name= "nameofDep")
	private String name;
	@Column
	private Long parentdepId;
	@Column
	@OneToMany(mappedBy="dep", fetch= FetchType.EAGER)
	private List<Employee> empList;

	
	
	public Long getParentdepId() {
		return parentdepId;
	}

	public void setParentdepId(Long parentdepId) {
		this.parentdepId = parentdepId;
	}

	public Department() {}
	
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
