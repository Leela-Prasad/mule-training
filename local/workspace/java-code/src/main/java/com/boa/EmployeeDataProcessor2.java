package com.boa;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class EmployeeDataProcessor2 implements Callable {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		MuleMessage message = eventContext.getMessage();
		Map<String,String> queryParams = (Map<String,String>)message.getInboundProperty("http.query.params");
		String data = queryParams.get("data");
		
		HashMap<String,String> employee = processData(data);
		message.setPayload(employee);
		
		message.setSessionProperty("employee", employee);
		message.setOutboundProperty("employee", employee);
		message.setInvocationProperty("employee", employee);
		
		return message;
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

	

}
