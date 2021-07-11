package com.mapping.mappingproject.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@Column(name="employeeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name="empName")
	private String empName;
	
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId",referencedColumnName = "employeeId")
	private EmployeeContact employeeContact;




	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId",referencedColumnName = "employeeId")
	private List<EmployeeCourses> employeeCourses;


	public List<EmployeeCourses> getEmployeeCourses() {
		return employeeCourses;
	}



	public void setEmployeeCourses(List<EmployeeCourses> employeeCourses) {
		this.employeeCourses = employeeCourses;
	}



	public Integer getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public EmployeeContact getEmployeeContact() {
		return employeeContact;
	}



	public void setEmployeeContact(EmployeeContact employeeContact) {
		this.employeeContact = employeeContact;
	}

	

}
	
	


