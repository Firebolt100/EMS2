package com.flp.ems.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService{
	
	EmployeeDaoImplForList empdao = new EmployeeDaoImplForList();
	Scanner input = new Scanner(System.in);
	
	
	//Add Employee
	public void AddEmployee(HashMap<String , String > h){
		
		Employee employee = new Employee();
		
		//to convert the DATE from string to Date format
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date d1=null,d2=null ;
		try {
			 d1= df.parse(h.get("dob"));
		} catch (ParseException e) {
	    
			e.printStackTrace();
		}
		try {
			 d2= df.parse(h.get("doj"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int deptId= Integer.parseInt(h.get("deptId"));
		int projectId= Integer.parseInt(h.get("projectId"));
		int roleId= Integer.parseInt(h.get("roleId"));
		
		employee.setName(h.get("name"));
		employee.setPhoneNo(h.get("phoneNo"));
		employee.setAddress(h.get("address"));
		employee.setDob(d1);
		employee.setDoj(d2);
		employee.setDeptId(deptId);
		employee.setProjectId(projectId);
		employee.setRoleId(roleId);
		employee.setKinId(h.get("kinId"));
		employee.setEmailId(h.get("emailId"));
		
		empdao.AddEmployee(employee);
		
	}
	
	//modify
	
	public void ModifyEmployee(HashMap<String , String > h){
		
		Employee emp = new Employee();
		
		emp.setKinId(h.get("kinId"));
		
		//to convert the DATE from string to Date format
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date d1=null,d2=null ;
		
		try {
			if(h.containsKey("dob"))
			 d1= df.parse(h.get("dob"));
			else
				emp.setDob(null);
		} catch (ParseException e) {
	    			e.printStackTrace();
		  }
		
		try {
			if(h.containsKey("doj"))
			   d2= df.parse(h.get("doj"));
			else
				emp.setDoj(null);
		} catch (ParseException e) {
			e.printStackTrace();
		  }
		
		
		if(h.containsKey("name")){
			emp.setName(h.get("name"));
		}
		else
			emp.setName(null);
		
		if(h.containsKey("phoneNo")){
			emp.setPhoneNo(h.get("phoneNo") );
		}
		else
			emp.setPhoneNo(null);
		
		if(d1!=null){
			emp.setDob(d1) ;
		}
		
		if(d2!=null){
			emp.setDoj(d2);
		}
		if(h.containsKey("address")){
			emp.setAddress(h.get("address"));
		}
		else
			emp.setAddress(null);
		
		empdao.ModifyEmployee(emp);
	}
	
	//remove
	
	public void RemoveEmployee(HashMap<String , String > h){
		
		Employee e = new Employee();
		e.setKinId(h.get("kinId"));
		e.setAddress(null);
		e.setDeptId(0);
		e.setDob(null);
		e.setDoj(null);
		e.setEmailId(null);
		e.setName(null);
		e.setPhoneNo(null);
		e.setProjectId(0);
		e.setRoleId(0);
		
		System.out.println("Do you want to really Delete this Entry");
		String reply = input.next();
		String stan = "yes";
		if(reply.equalsIgnoreCase(stan))
			{System.out.println("deleting ....");
			empdao.RemoveEmployee(e);
			}
		else{
			System.out.println("Returning from service to view ....");
			return;
		}
	}
	
	//search
	
	public HashMap<String,String>  SearchEmployee(HashMap<String , String > h){
		
		Employee e =empdao.SearchEmployee(h);
		
		HashMap<String , String > s = new HashMap<String , String >();
		
		String di ="" +e.getDeptId();
		String pi ="" +e.getProjectId();
		String ri ="" +e.getRoleId();
		
		s.put("kinId",e.getKinId());
		s.put("name",e.getName());
		s.put("emailId",e.getEmailId());
		s.put("phoneNo",e.getPhoneNo());
		s.put("deptId",di);
		s.put("projectId",pi);
		s.put("roleId", ri);
		
		return s;
		
	}
	
	public HashMap<String,String>[] getAllEmployee(){
		List<Employee> l = empdao.getAllEmployee();
		
		HashMap<String , String> row[] = new HashMap[l.size()];
		
		int i=0;

		System.out.println("in service");
		while(i<l.size()){
			System.out.println("Putting to hashmap");
			String di="" +l.get(i).getDeptId();
			String pi ="" +l.get(i).getProjectId();
			String ri =	"" +	l.get(i).getRoleId();
			
			row[i]=new HashMap<String , String>();
			row[i].put("kinId",l.get(i).getKinId());
			row[i].put("name",l.get(i).getName());
			row[i].put("emailId",l.get(i).getEmailId());
			row[i].put("phoneNo",l.get(i).getPhoneNo());
			row[i].put("deptId",di);
			row[i].put("projectId",pi);
			row[i].put("roleId", ri);
			
			i++;
					
		}
		
		
		return row;
	}

}
