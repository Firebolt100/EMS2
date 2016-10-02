package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao {
	
	static List<Employee> list = new ArrayList<Employee>();

	public void AddEmployee(Employee employee){
		
		list.add(employee);
		for(Employee temp : list)
			System.out.println(temp);
	}
	public void ModifyEmployee(Employee employee){
		
		
		Employee e1= null;
		int i=0;
		
		while(i< list.size()){
			if(  (list.get(i).getKinId()).equals(employee.getKinId()) )
			{	try {
					e1 = (Employee) list.get(i).clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
			else
			   i++;
		}
		
		if(employee.getName()!=null)
			e1.setName(employee.getName());
		if(employee.getPhoneNo()!=null)
			e1.setPhoneNo(employee.getPhoneNo());
		if(employee.getAddress()!=null)
			e1.setAddress(employee.getAddress());
		if(employee.getDob()!=null)
			e1.setDob(employee.getDob());
		if(employee.getDoj()!=null)
			e1.setDoj(employee.getDoj());
		
		list.add(e1);
		list.remove(list.get(i));
		
		for(Employee temp : list)
			System.out.println(temp);

	}
	public void RemoveEmployee(Employee employee){
		int i=0;
		
		while(i<list.size()){
			if(employee.getKinId().equals(list.get(i).getKinId()))
			{	list.remove(list.get(i));
				break;
			}
		}
		
		for(Employee temp : list)
			System.out.println(temp);
		
		
	}
	public Employee SearchEmployee(HashMap<String , String> h){
		
		Employee holder = null;
		//System.out.println("size of list  :"+list.size());
		
		int i=0;
		while(i<list.size())
		{
			System.out.println("Searching at element :"+ i );
			
			
			if(h.containsKey("kinId")){
				if(h.get("kinId").equals(list.get(i).getKinId()))
					{ holder=list.get(i); 
						//System.out.println(list.get(i));
						break; 
					}
			}
			
		
			if(h.containsKey("emailId")){
				if(h.get("emailId").equals(list.get(i).getEmailId()))
					{  holder=list.get(i); 
					//System.out.println(list.get(i));
						break ; 
					}
			}
			
			if(h.containsKey("name")){
				if(h.get("name").equals(list.get(i).getName()))
					{  holder=list.get(i);
					//System.out.println(list.get(i));
						break;
					}
			}	
			
			i++;
		}
		/*System.out.println("in dao , out of loop");
		System.out.println(holder);*/
		
		return holder;
		
		
	}
	public List<Employee> getAllEmployee(){
		System.out.println("in dao");
		for(Employee temp : this.list){
			System.out.println(temp);	
			
		}
		System.out.println("out of dao");
		return list;
	}
}