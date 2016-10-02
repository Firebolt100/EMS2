package com.flp.ems.view;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

public class UserInteraction {
	static int id;
	EmployeeServiceImpl empService = new EmployeeServiceImpl();
	Scanner input = new Scanner(System.in);
	
	public void AddEmployee(){
		
		boolean[] f = new boolean[8];
		for(boolean temp : f)
		{ temp = false; }
		
		String name = null,phoneNo = null,address= null,dob,doj,deptId= null,projectId= null,roleId = null, kinId = null, emailId= null;
		
		HashMap <String , String > employeedetails = new HashMap <String , String >();
		
		id++;
		
		System.out.println("Enter Employee Details .....");
		System.out.println("Name :");
		while(f[0]== false){
			name = input.nextLine();
			f[0] = Validate.validateName(name);
			if(f[0] == false)
				System.out.println("Invalid  . Enter valid Name ");
		}
		
		System.out.println("Phone Number :");
		
		while(f[1] == false){
			phoneNo = input.next();
			f[1] = Validate.validatePhoneNo(phoneNo);
			if(f[1] == false)
				System.out.println("Invalid  . Enter valid Phone Number ");
		}
	
		System.out.println("Address :");
		String garb = input.nextLine(); // so dat address doesn't giv invalid d first time it runs
		while(f[2] == false){
			address = input.nextLine();
			f[2] = Validate.validateAddress(address);
			if(f[2] == false)
				System.out.println("Invalid  . Enter valid Address ");
		}
		System.out.println("Date of Birth (dd/mm/yyyy) :");
		dob = input.next();
		System.out.println("Date of joining (dd/mm/yyyy) :");
		doj = input.next();
		
		System.out.println("Enter Department Code Number :");
		System.out.println("1. Aviator");
		System.out.println("2. Velocity");
		System.out.println("3. Discover");
		
		while(f[5] == false){
			deptId = input.next();
			f[5] = Validate.validateDeptId(deptId);
			if(f[5] == false)
				System.out.println("Invalid  . Enter Department ID number code ");
		}
		
		
		System.out.println("Enter Project Code Number :");
		System.out.println("1. Tokyo");
		System.out.println("2. Sydney");
		System.out.println("3. California");
		
		while(f[6] == false){
			projectId = input.next();
			f[6] = Validate.validateProjectId(projectId);
			if(f[6] == false)
				System.out.println("Invalid  . Enter Project ID number code ");
		}
		
		System.out.println("Enter Role  Code Number :");
		System.out.println("1. Developer");
		System.out.println("2. Tester");
		
		while(f[7] == false){
			roleId = input.next();
			f[7] = Validate.validateRoleId(roleId);
			if(f[7] == false)
				System.out.println("Invalid  . Enter Role ID number code ");
		}
		
		kinId = ""+ id + "_fs";
		emailId= kinId+"@barclays.com";
		
		employeedetails.put("name", name);
		employeedetails.put("phoneNo", phoneNo);
		employeedetails.put("address", address);
		employeedetails.put("dob", dob);
		employeedetails.put("doj", doj);
		employeedetails.put("deptId", deptId);
		employeedetails.put("projectId", projectId);
		employeedetails.put("roleId", roleId);
		employeedetails.put("kinId", kinId);
		employeedetails.put("emailId", emailId);
				
		//input.close();
		
		empService.AddEmployee(employeedetails);
		
		
		
		
	}
	public void ModifyEmployee(){
		
		boolean[] f = new boolean[8];
		for(boolean temp : f)
		{ temp = false; }
		
		String name = null,phoneNo = null,address= null,dob,doj;
		
		System.out.println(" Select Option :\n");
		System.out.println("1.  Search Employee record to modify");
		System.out.println("2.  View all Employees");
		
		String in = input.next();
		boolean fl = false;
		
		while(!fl)
		{
			if(in.equals("1"))
			{	SearchEmployee();
					fl=true;
				}
			
			else if(in.equals("2"))
				{getAllEmployee();
				fl=true;
				}
			else
				System.out.println("Invalid option . Select 1 or 2 ");
							
		}
		
		HashMap<String , String> m = new HashMap<String , String>();
		String z= "0";
		
		System.out.println("Enter KinID of employee, whose info is to be Modified");
		String kinId=input.next();
		System.out.println("Enter the values you wish to modify (for fields you don't wish to modify enter 0 )");
		System.out.println("Name :");
		while(f[0]== false){
			name = input.nextLine();
			if(!name.equals("0"))
			{  f[0] = Validate.validateName(name);
			   if(f[0] == false)
				   System.out.println("Invalid  . Enter valid Name ");
			}  
		}
		
		System.out.println("Phone No :");
		while(f[1] == false){
			phoneNo = input.next();
			if(!phoneNo.equals("0")){
				f[1] = Validate.validatePhoneNo(phoneNo);
				if(f[1] == false)
					System.out.println("Invalid  . Enter valid Phone Number ");
			}
		}
		System.out.println("DOB :");
		dob = input.next();
		System.out.println("DOJ :");
		doj = input.next();
		
		System.out.println("Address :");
		String garb = input.nextLine();
		while(f[2] == false){
			address = input.nextLine();
			if(!address.equals("0")){
				f[2] = Validate.validateAddress(address);
				if(f[2] == false)
					System.out.println("Invalid  . Enter valid Address ");
			}
		}
		
		/*to add capability after adding mapping of dept ,proj , role id to their names
		 * 
		 * System.out.println("Department  :");
		String name = input.next();
		System.out.println("Name :");
		String name = input.next();
		System.out.println("Name :");
		String name = input.next();*/
		
		m.put("kinId", kinId);
		if(!name.equals("0"))
			m.put("name", name);
		if(!phoneNo.equals("0"))
			m.put("phoneNo", phoneNo);
		if(!dob.equals("0"))
			m.put("dob", dob);
		if(!doj.equals("0"))
			m.put("doj", doj);
		if(!address.equals("0"))
			m.put("address", address);
		
		
		
		
		empService.ModifyEmployee(m);
		
		
	}
	public void RemoveEmployee(){
		
		System.out.println(" Select Option :\n");
		System.out.println("1.  Search Employee record to modify");
		System.out.println("2.  View all Employees");
		
		String in = input.next();
		boolean fl = false;
		
		while(!fl)
		{
			if(in.equals("1"))
			{	SearchEmployee();
					fl=true;
				}
			
			else if(in.equals("2"))
				{getAllEmployee();
				fl=true;
				}
			else
				System.out.println("Invalid option . Select 1 or 2 ");
							
		}
		
		System.out.println("Enter KinID of employee, whose info is to be Modified");
		String kinId=input.next();
		
		HashMap <String,String> h = new HashMap<String,String>();
		h.put("kinId", kinId);
		empService.RemoveEmployee(h);
		
	}
	public void SearchEmployee(){
		
		boolean[] f=new boolean[3];
		for(boolean temp : f)
		{ temp = false; }
		HashMap<String , String > searching = new HashMap<String , String >();
		
		System.out.println("Search by    ( Enter 0 if you don't want to search by that field ) ");
		
		System.out.println("KinID ");
		String kinId=input.next();
		f[0]=Validate.validateNonEmpty(kinId);
		if(f[0] != false)
			searching.put("kinId",kinId);
		
		System.out.println("Name ");
		String name=input.next();
		f[1]=Validate.validateNonEmpty(name);
		if(f[1] != false)
			searching.put("name",name);
		
		System.out.println("EmailID");
		String emailId=input.next();
		f[2]=Validate.validateNonEmpty(emailId);
		if(f[2] != false)
			searching.put("emailId",emailId);
		
		Set set = searching.entrySet();
		System.out.println("key value pair in hashmap in VIEW" + set);
		
		
		HashMap<String , String> hashMap=new HashMap<String , String>();
		hashMap= empService.SearchEmployee(searching);
		System.out.println("The Employee Searched for  :\n");
		System.out.println(hashMap.get("kinId")+" : "+hashMap.get("name")+" : "+hashMap.get("emailId")+" : "+hashMap.get("phoneNo")+" : "+hashMap.get("deptId")+" : "+hashMap.get("projectId")+" : "+hashMap.get("roleId"));

	}
	public void getAllEmployee(){
		
		HashMap<String , String >[] h = empService.getAllEmployee();
		System.out.println(h.toString());
		System.out.println("No of Employees  : "+ h.length+"\n");
		System.out.println("KinID   Name  emailID     PhoneNo  DeptID   ProjectID  RoleID \n");
		
		for (HashMap<String, String> hashMap : h) {
			//System.out.println("in loop");
			System.out.println(hashMap.get("kinId")+" : "+hashMap.get("name")+" : "+hashMap.get("emailId")+" : "+hashMap.get("phoneNo")+" : "+hashMap.get("deptId")+" : "+hashMap.get("projectId")+" : "+hashMap.get("roleId"));
		}	
					
	}
}


