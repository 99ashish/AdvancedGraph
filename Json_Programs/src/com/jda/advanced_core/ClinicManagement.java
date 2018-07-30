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
				System.out.println("1.Add Doctors Details" + "\n" +"2.Create User Account" +"\n"+"3.Log into existing account" +"\n" +"4.Quit");
				int opt=get.sc.nextInt();
		    if(opt==4)
		    	break;
		    switch(opt)
		    {
		    case 1:ClinicUser.addDoctorDetail();break;
		    //case 2:if(user==null) user= new ClinicUser();user.createUserAccount();break;
		    //case 3:if(user==null) user= new ClinicUser();user.openUserAccount();break;
		    //case 4:StockBook.showStockName();break;
			default:System.out.println("Worng entry"); break;
			}
			}
	}
}
