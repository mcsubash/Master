package org.baseClass;

import java.util.ArrayList;


public class SampleClass {
	public static void main(String[] args) {
		
		ArrayList <StudentsPOJO> al = new ArrayList<>();
//		al.add(new StudentsPOJO("123", "Kalai", "12345", "10"));
//		al.add(new StudentsPOJO("234", "Saritha", "12345", "11"));
//		al.add(new StudentsPOJO("456", "Subash", "12345", "12"));
//		al.add(new StudentsPOJO("678", "Sathish", "12345", "13"));
//		al.add(new StudentsPOJO("890", "Kavitha", "12345", "14"));
		
		for(StudentsPOJO s : al)
		{
			if(s.getStudName().equals("Subash"))
			{
				System.out.println("Name: " + s.getStudName());
				System.out.println("ID: " + s.getStdID());
				System.out.println("Phone No: " + s.getMobileNo());
				System.out.println("Rank " + s.getAverage());
			}
		}
	}

}
