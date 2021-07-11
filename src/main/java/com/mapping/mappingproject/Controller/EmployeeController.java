package com.mapping.mappingproject.Controller;

import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.mappingproject.Model.Employee;
import com.mapping.mappingproject.Repository.EmployeeRepo;

@RestController
public class EmployeeController {

	
	 @Autowired()
	EmployeeRepo employeerepo;
	
	@GetMapping("/Employee/{id}")
	//@PreAuthorize("hasRole('admin)")
	public JSONObject getEmployeeById(@PathVariable Integer id) {
		JSONObject j= new JSONObject();
		Employee e=employeerepo.findById(id).orElse(null);

		j.put("status","passed");
		j.put("message",e);
		// if(e!=null){
		// j.put("EmployeeName",e.getEmpName());
		// j.put("EmployeeId",e.getEmployeeId());
		// }
		// else{
		// j.put("status","failed");
		// j.put("message","Employee not found");
		// }
		return j;
	}
	@GetMapping("/Employee/")
	@PreAuthorize("hasRole('user')")
	public JSONArray getEmployee() {
		
		JSONArray ja= new JSONArray();
		
		List<Employee> le= new ArrayList<Employee>();
		le=employeerepo.findAll();
		if(le != null){
			for(int i=0;i<le.size();i++){
				JSONObject j= new JSONObject();
				j.put("Employee",le.get(i).getEmpName());
				j.put("Employee",le.get(i).getEmployeeContact());

				ja.add(j);
			}
		}
		
		return ja;
	}

	@PostMapping("/Employee")
	public void postEmployee(@RequestBody Employee e){
		 employeerepo.save(e);
	}

	@DeleteMapping("/Employee/{id}")
	public void deleteMapping(@PathVariable Integer id){
		employeerepo.deleteById(id);
	}
}
