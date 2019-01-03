package com.fa.service;

import org.springframework.stereotype.Service;


public class EmployeeService {

	public EmployeeService() {
		System.out.println("Hello Service");
	}

	public String m1(String arg) {
		System.out.println(10/0);
		System.out.println("m1");
		System.out.println(arg);
		return "abhi";
	}
	
}
