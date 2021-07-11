package com.mapping.mappingproject;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.mapping.mappingproject.Model.Employee;
import com.mapping.mappingproject.Model.EmployeeContact;
import com.mapping.mappingproject.Model.EmployeeCourses;
import com.mapping.mappingproject.Repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingprojectApplication.class, args);
	}

@Autowired
EmployeeRepo erepo;
@PostConstruct
public void init(){
	Employee E= new Employee();
	E.setEmpName("mupaatha");
	EmployeeContact ec= new EmployeeContact();
	ec.setAddress("ther adi theruvuu papanayakanpalayam koyambathuru");
	E.setEmployeeContact(ec);
	EmployeeCourses ecs= new EmployeeCourses();
	ecs.setCourseName("Java");
	E.setEmployeeCourses(Arrays.asList(ecs));
	erepo.save(E);
}
}
