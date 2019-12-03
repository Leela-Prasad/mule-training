package com.boa;

import java.util.HashMap;

public class EmployeeDataProcessor {

	public EmployeeDataProcessor() {
		System.out.println("constructor");
	}
	
	public HashMap<String,String> processData(String data) {
		System.out.println("processData");
		String[] elements = data.split(";");
		
		HashMap<String,String> employee = new HashMap<>();
		
		employee.put("id", elements[0]);
		employee.put("name", elements[1]);
		employee.put("salary", elements[2]);
		employee.put("enabled", elements[3]);
		
		return employee;
	}
	
	
	public HashMap<String,String> processData2(String data, Integer age) {
		String[] elements = data.split(";");
		
		HashMap<String,String> employee = new HashMap<>();
		
		employee.put("id", elements[0]);
		employee.put("name", elements[1]);
		employee.put("salary", elements[2]);
		employee.put("enabled", elements[3]);
		employee.put("age", age + "");
		
		return employee;
	}

}
