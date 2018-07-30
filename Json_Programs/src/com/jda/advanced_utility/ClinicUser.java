package com.jda.advanced_utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class ClinicUser {
	static Input get =Input.getInputInstance();
	private static String path = "C:\\Users\\1022784\\Desktop\\gitProgram\\StakeHolder\\";
	public void createUserAccount() {
		// TODO Auto-generated method stub
		
	}

	public void openUserAccount() {
		// TODO Auto-generated method stub
		
	}

	public static void addDoctorDetail() throws JsonGenerationException, JsonMappingException, IOException {
		File fileName=new File(path+"DoctorInfo" +".json");
		List<DoctorInfo> drInfo= new ArrayList<>();
		System.out.println("Number of doctor");
		int drNumber=get.sc.nextInt();
		for(int i=0;i<drNumber;i++)
		{
		DoctorInfo doctor= new DoctorInfo();
		get.sc.nextLine();
		System.out.println("Doctor Name");
		doctor.setName(get.sc.nextLine());
		System.out.println("Unique Id");
		doctor.setId(get.sc.nextLong());
		System.out.println("Mobile Number");
		doctor.setMobileNumber(get.sc.nextLong());
		System.out.println("Specialization");
		doctor.setSpecialization(get.sc.nextLine());
		Availabilty availabilty=new Availabilty();
		System.out.println("Number of availablity in days");
		int days=get.sc.nextInt();
		get.sc.nextLine();
		for(int j=0;j<days;j++)
		{
		Timing schedule=new Timing();
		System.out.println("Day");
		schedule.setDay(get.sc.nextLine());
		System.out.println("Timimg");
		schedule.setTime(get.sc.nextLine());
		availabilty.schedule.add(schedule);
		}
		doctor.setAvailability(availabilty);
		drInfo.add(doctor);
	}
		StockPortfolio.writeToFile(fileName, drInfo);
  }


}
