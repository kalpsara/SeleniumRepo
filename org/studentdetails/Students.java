package org.studentdetails;

public class Students {

	
	public void getStudentInfo(int id) {
		
		System.out.println("Student id:"+id);
	}
	
	public void getStudentInfo(int id,String name) {

		System.out.println("Student id:"+id+" Student name:"+name);
		
	}
	
	public void getStudentInfo(String email,long phoneNumber) {
		System.out.println("Student email:"+email+" Student name:"+phoneNumber);
	}
	
	
	
	
	
	public static void main(String[] args) {
		Students s=new Students();
		s.getStudentInfo(123);
		s.getStudentInfo(1234, "Saravana");
		s.getStudentInfo("sarench@gmail.com", 95001200000l);

	}

}
