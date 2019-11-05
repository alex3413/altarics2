package ru.alexov.altarics.model.entity;

import java.io.Serializable;
import java.util.Calendar;

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



enum Position {manager, boss, developer, yardman}
@Entity
@Table(name="Employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Employee implements Serializable {

	
	
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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name ="dep_id")
	@JsonIgnore
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


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPatronymic() {
		return patronymic;
	}


	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}


	public char getSex() {
		return sex;
	}


	public void setSex(char sex) {
		this.sex = sex;
	}


	public Calendar getDataOfBirthday() {
		return dataOfBirthday;
	}


	public void setDataOfBirthday(Calendar dataOfBirthday) {
		this.dataOfBirthday = dataOfBirthday;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Calendar getDatestartjob() {
		return datestartjob;
	}


	public void setDatestartjob(Calendar datestartjob) {
		this.datestartjob = datestartjob;
	}


	public Calendar getDateofgetout() {
		return dateofgetout;
	}


	public void setDateofgetout(Calendar dateofgetout) {
		this.dateofgetout = dateofgetout;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public boolean isBossdep() {
		return bossdep;
	}


	public void setBossdep(boolean bossdep) {
		this.bossdep = bossdep;
	}


	public Department getDep() {
		return dep;
	}


	public void setDep(Department dep) {
		this.dep = dep;
	}


	
}
