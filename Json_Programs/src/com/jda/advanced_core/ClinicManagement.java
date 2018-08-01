package com.jda.advanced_core;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.jda.advanced_utility.ClinicUser;
import com.jda.advanced_utility.Input;
public class ClinicManagement {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Input get =Input.getInputInstance();
		ClinicUser user=null;
		
			while(true)
			{
				System.out.println("1.Add Doctors Details" + "\n" +"2.Add Patient Appointment" +"\n"+"3.Patient menu" +"\n"+"4.Doctor's menu" +"\n"+"5.Quit");
				int opt=get.sc.nextInt();
				if(opt==5)
					break;
		    if(opt==4)
		    	break;
		    switch(opt)
		    {
		    case 1:ClinicUser.addDoctorDetail();break;
		    case 2:if(user==null) user= new ClinicUser();user.addPatientDetail();break;
		    case 3:if(user==null) user= new ClinicUser();user.patientMenu();break;
		    case 4:if(user==null) user= new ClinicUser();user.doctorMenu();break;
			default:System.out.println("Worng entry"); break;
			}
			}
	}
}
