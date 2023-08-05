package org.department;
import java.util.*;

import org.college.College;  

public class Department extends College{
	
	
//deptName()
	 ArrayList<String> list=new ArrayList<String>();//Creating arraylist    
	 
	 public  ArrayList<String> deptName() {
		 ArrayList<String> list=new ArrayList<String>();
		
		list.add("CSC");
		list.add("EEE");
		list.add("ECE");
		list.add("MECH");
		list.add("CIVIL");
		
		
return list;
		
	}
	 
	 public static void main(String[] args) {
		 
		 Department d=new Department();
		 d.deptName();
		
	}
}
