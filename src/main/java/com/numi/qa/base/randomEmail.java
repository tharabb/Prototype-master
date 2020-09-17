package com.numi.qa.base;

import java.time.LocalDate;
import java.util.Date;



public class randomEmail {
	public static void main(String[] args) {
		generateRandomEmail();
	}
	
	public static String generateRandomEmail() {
	long time = new Date().getTime();
	String email= "qa"+time+"@gmail.com";
	System.out.println("Generate randome Email:"+email);
	return email;
	
	}
	
	public String generatePPEmail() {
		long time = new Date().getTime();
		// type casting long to int
		int inum= (int)time;
		//convert int to string
		String str = String.valueOf(inum);
		//getting only the last 5 digits
		String email= "pp"+str.substring(str.length()-5)+"@ns.com";
		System.out.println("Generate random Email:"+email);
		
		return email;
		
		}
	
	public static String generateFirstName() {
		LocalDate date = LocalDate.now();  
		String firstName = "Antony"+date;
		System.out.println("Expected ProfileName is: "+firstName);
		return firstName;
	}
	
	public String generatePPfn() {
		LocalDate date = LocalDate.now();  
		String firstName = "pp"+date;
		System.out.println("Expected ProfileName is: "+firstName);
		return firstName;
	}


}
