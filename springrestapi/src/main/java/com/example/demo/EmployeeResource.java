package com.example.demo;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeResource {

	EmployeeRepository er=new EmployeeRepository();
	@GetMapping("employees")
	public List<Employee> getallemployees()
	{
		//List<Employee> employees= new ArrayList<>();
		//Employee e= new Employee();
		//e.setId(101);
		//e.setName("Rajat");
		//e.setAge(22);
		//employees.add(e);
		return er.getemployees();
	}
	
	@GetMapping("employee/{id}")
	public Employee getemployee(@PathVariable("id") int id) {
		
		return er.getemployee(id);
	}
	
	@PostMapping("employee/add")
	public void createEmployee(@RequestBody Employee e1) {
		er.create(e1);
	}
	
	@PutMapping("employee/{id}")
	public void updateEmployee(@RequestBody Employee e1,@PathVariable("id") int id) {
		er.update(e1,id);
	}
	
	@DeleteMapping("employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		er.delete(id);
	}
	
	}
