package ru.alexov.altarics.model.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false)
	private long id;

	@Column(name = "NAME")
	private String name; 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
