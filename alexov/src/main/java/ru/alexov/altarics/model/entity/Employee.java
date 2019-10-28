package ru.alexov.altarics.model.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

enum Position {manager, boss, developer, yardman}
@Entity
@Table(name="Employee")

public class Employee {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false)
	private long id;
	
	
	@Column(name="name")
	private String name;
	@Column
	private String surname;
	@Column
	private String patronymic=null;
	@Column
	private char sex;
	@Column
	private Calendar dataOfBirthday;
	@Column
	private String tel;
	@Column
	private String email;
	@Column
	private Calendar datestartjob;
	@Column
	private Calendar dateofgetout=null;
	@Column
	private Position position;
	@Column
	private Double salary;
	@Column
	private boolean bossdep;
	@ManyToOne(optional=false,cascade=CascadeType.ALL)
	private Department dep;
		
	public Employee() {}
	
	
	public Employee(long id, String name, String surname, String patronymic, char sex, Calendar dataOfBirthday,
			String tel, String email, Calendar datestartjob, Calendar dateofgetout, Position position, Double salary,
			boolean bossdep) {
	
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.sex = sex;
		this.dataOfBirthday = dataOfBirthday;
		this.tel = tel;
		this.email = email;
		this.datestartjob = datestartjob;
		this.dateofgetout = dateofgetout;
		this.position = position;
		this.salary = salary;
		this.bossdep = bossdep;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
