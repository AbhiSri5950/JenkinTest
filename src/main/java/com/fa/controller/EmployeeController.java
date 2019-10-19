package com.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fa.bean.Employee;
import com.fa.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService=null;
	
	
	//@PostMapping()
	//@RequestMapping(value = "/getemployee/{id}")
	public String findById(@PathVariable("id") int id,Model model) {
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setEmpName("abhi");
		model.addAttribute("employee",emp);
	    
		return "employee";
	}
	
	
	@PostMapping()
	@RequestMapping(value = "/getemployee/{id}")
	public String getEmployee(Model model) {
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setEmpName("abhi");
		model.addAttribute("employee",emp);
		System.out.println(employeeService.m1("abhi"));
		return "employee";
	}

	/*@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String postEmployee() {
		Employee emp = new Employee();
		emp.setEmpId(postEmployee.getEmpId());
		emp.setEmpName(postEmployee.getEmpName());
		hello
		String str=employeeService.m1("abhi");
		System.out.println(str);
		return emp;
	}*/
	
}
