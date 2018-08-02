package com.jda.advanced_utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
public class ClinicUser<T> {
	private static final Class DoctorInfo = null;
	static Input get =Input.getInputInstance();
	private static String path ="C:\\Users\\1022784\\Desktop\\JavaPrograms\\StakeHolder\\";
	public  void  readFromFile(File fileName,List<T> patientInfo,Class className) 
	{
		try {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(fileName);
        for(JsonNode obj:node)
        {
        	T list = (T)mapper.treeToValue(obj,className);
        	patientInfo.add(list);
        }
		}
		catch(Exception e)
		{
			System.out.println("Empty File");
		}

	}
	public List<T>  showDoctorDetail()
	{
		File fileName=new File(path+"DoctorInfo" +".json");
		List<DoctorInfo> drInfo= new ArrayList<>();
		readFromFile(fileName, (List<T>) drInfo,DoctorInfo.class);
		
		for(int i=0;i<drInfo.size();i++)
		{
			System.out.println("********************************************************************************");
			System.out.println((i+1)+".\t\t\t" +     "               Id:    "+ drInfo.get(i).getId()
					                    +"\n\t\t\t" +"      Doctor Name:    " +drInfo.get(i).getName()
					                    +"\n\t\t\t" +"      Availability:   ");
			for(int j=0; j< drInfo.get(i).getAvailability().getSchedule().size();j++)
			{
				System.out.println("\t\t\t\t\t\t" +drInfo.get(i).getAvailability().getSchedule().get(j).getDay()+"  "+drInfo.get(i).getAvailability().getSchedule().get(j).getTime() );
			}
		}
		return (List<T>) drInfo;
	}

	public void addPatientDetail() throws JsonGenerationException, JsonMappingException, IOException 
	{
		   List<DoctorInfo> drInfo=(List<com.jda.advanced_utility.DoctorInfo>) showDoctorDetail();
			File fileName=new File(path+"PatientInfo" +".json");
			List<PatientInfo> patientInfo= new ArrayList<>();
			readFromFile(fileName,(List<T>) patientInfo,PatientInfo.class);
			List<PatientInfo> patient= new ArrayList<>();
			boolean exist=false;
			get.sc.nextLine();
			PatientInfo pr=new PatientInfo();
			System.out.println("Patient Name");
			pr.setPatientName(get.sc.nextLine());
			System.out.println("Mobile Number");
			pr.setMobileNumber(get.sc.nextLong());
			int idx1=searchInPatient(patientInfo, pr.getPatientName(), "ByName",false);
			if(idx1>=0 &&(patientInfo.get(idx1).getMobileNumber()-pr.getMobileNumber())==0)
			{
				System.out.println("Your data already exist in our system");
				exist=true;
			}
			else
			{
			System.out.println("Unique Id");
			pr.setId(get.sc.nextLong());
			System.out.println("Age");
			pr.setAge(get.sc.nextInt());
			patient.add(pr);
			StockPortfolio.writeToFile(fileName, patientInfo);
			}
			while(true)
			{
			System.out.println("Enter a valid serial number of doctor to get appointment........");
			int opt=get.sc.nextInt();
			if(opt>drInfo.size()+1)
			{
				System.out.println("Not a valid option");
				continue;
			}
			if(exist)
				pr=patientInfo.get(idx1);
			addAppointment(pr,drInfo.get(opt-1));
         }
	}
	private void addAppointment(PatientInfo pr,DoctorInfo doctorName)
	{
		Appointment apt=new Appointment();
        apt.doctorName=doctorName;
        List<Appointment> aptDetail =new ArrayList<>();
        File file=new File(path+"Appointment"+".json");
        readFromFile(file,(List<T>) aptDetail,Appointment.class);
        if(have(aptDetail,apt.doctorName))
        {
     	   int idx=getIdx(aptDetail,doctorName);
     	   if(aptDetail.get(idx).patientName.size()==5)
     	   {
     		   System.out.println("Doctor is not availble select other one");
     		   return;
     	   }
     	   aptDetail.get(idx).patientName.add(pr);
        }
     	else
     	   {
     		  Appointment patientApt= new Appointment();
     		  List<PatientInfo> ptr=new ArrayList<>();
     		  ptr.add(pr);
     		  patientApt.setDoctorName(apt.doctorName);
     		  patientApt.setPatientName(ptr);
     		  aptDetail.add(patientApt);
     		  
     	   }
     	   File fileName1=new File("C:\\Users\\1022784\\Desktop\\JavaPrograms\\StakeHolder\\Appointment.json");
     	   try {
			writeToFile(fileName1,(List<T>) aptDetail,Appointment.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	private int getIdx(List<Appointment> list , DoctorInfo doctorName)
	{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).doctorName.getId()==doctorName.getId())
				return i;
		}
		return -1;
	}
	boolean have(List<Appointment> aptDetail,DoctorInfo doctorName)
	{
		for(int i=0;i<aptDetail.size();i++)
		{
			if(aptDetail.get(i).doctorName.getId()==doctorName.getId())
				return true;
		}
		return false;
	}
	public void openUserAccount() {
		// TODO Auto-generated method stub
		
	}
	public void writeToFile(File fileName,List<T> patientList,Class className) throws JsonGenerationException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer();
			writer.writeValue(fileName,
					patientList);
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
	public  void patientMenu() {
		File fileName=new File(path+"PatientInfo" +".json");
		List<PatientInfo> patientInfo= new ArrayList<>();
		readFromFile(fileName, (List<T>) patientInfo,PatientInfo.class);
		System.out.println("1.Search by name"+"\n2."+ "Search by Id" +"\n3.Search By Mobile number");
		int opt=get.sc.nextInt();
		get.sc.nextLine();
		switch(opt)
		{
		case 1:searchPatientByName(patientInfo);break;
		case 2:searchPatientById(patientInfo);break;
		case 3:searchPatientBYMobNum(patientInfo);break;
		default:
			System.out.println("worng entry");
		}
		
	}
	private int searchInPatient(List<PatientInfo> patientInfo, String val, String string,boolean print) {
		boolean found=false; 
		int i;
		for( i=0;i<patientInfo.size();i++)
		{
			if(string.equals("ById")&&(patientInfo.get(i).getId()-Long.valueOf(val))==0)
			{found=true;break;}
			if(string.equals("ByMobNum")&&(patientInfo.get(i).getMobileNumber()-Long.valueOf(val))==0)
			{found=true;break;}
			if(string.equals("ByName")&&(patientInfo.get(i).getPatientName().equals(val)))
			{found=true;break;}
	}
		if(found)
		{
			if(print)
			{
			System.out.println("Data Found for Patient............................................................");
			System.out.println("Patient Name                            :"+ patientInfo.get(i).getPatientName()
					               +"\n" +"Patient Id                                  :" + patientInfo.get(i).getId()
					               +"\n" +"Patient Mobile Number          :" + patientInfo.get(i).getMobileNumber());
			}
			return i;
		}
		if(print && !found)
			System.out.println("data not found");
		return -1;
	}
	private void searchInDoctor(List<DoctorInfo> doctorInfo, String val, String string) {
		boolean found=false;
		int i;
		for(i=0;i<doctorInfo.size();i++)
		{
			if(string.equals("ById")&&(doctorInfo.get(i).getId()-Long.valueOf(val))==0)
			{found=true;break;}
			if(string.equals("ByMobNum")&&(doctorInfo.get(i).getMobileNumber()-Long.valueOf(val))==0)
			{found=true;break;}
			if(string.equals("ByName")&&(doctorInfo.get(i).getName().equals(val)))
			{found=true;break;}
		}	
		if(found)
		{
			System.out.println("Data Found for Doctor............................................................");
			System.out.println("Doctor Name                            :"+ doctorInfo.get(i).getName()
					               +"\n" +"Doctor Id                                  :" + doctorInfo.get(i).getId()
					               +"\n" +"Doctor Mobile Number          :" + doctorInfo.get(i).getMobileNumber());
		}
		else
			System.out.println("data not found");
	}
	private void searchPatientById(List<PatientInfo>  patientInfo)
	{
		System.out.println("Enter the Id");
		String val= get.sc.nextLine();
	    searchInPatient(patientInfo,val,"ById",true);
	}
	private void searchPatientBYMobNum(List<PatientInfo>  patientInfo)
	{
		System.out.println("Enter the Mobile Number");
		String val= get.sc.nextLine();
	    searchInPatient(patientInfo,val,"ByMobNum",true);
	}
	private void searchPatientByName(List<PatientInfo>  patientInfo)
	{
		System.out.println("Enter the name");
		String val= get.sc.nextLine();
	    searchInPatient(patientInfo,val,"ByName",true);
	}
	
	private void searchDoctorById(List<DoctorInfo>  doctorInfo)
	{
		System.out.println("Enter the Id");
		String val= get.sc.nextLine();
	    searchInDoctor(doctorInfo,val,"ById");
	}
	private void searchDoctorBYMobNum(List<DoctorInfo>  doctorInfo)
	{
		System.out.println("Enter the Mobile Number");
		String val= get.sc.nextLine();
	    searchInDoctor(doctorInfo,val,"ByMobNum");
	}
	private void searchDoctorByName(List<DoctorInfo>  doctorInfo)
	{
		System.out.println("Enter the name");
		String val= get.sc.nextLine();
	    searchInDoctor(doctorInfo,val,"ByName");
	}
	
	public void doctorMenu() {
		File fileName=new File(path+"DoctorInfo" +".json");
		List<DoctorInfo> drInfo= new ArrayList<>();
		readFromFile(fileName, (List<T>) drInfo,DoctorInfo.class);
		System.out.println("1.Search by name"+"\n2."+ "Search by Id" +"\n3.Search By Mobile number");
		int opt=get.sc.nextInt();
		get.sc.nextLine();
		switch(opt)
		{
		case 1:searchDoctorByName(drInfo);break;
		case 2:searchDoctorById(drInfo);break;
		case 3:searchDoctorBYMobNum(drInfo);break;
		default:
			System.out.println("worng entry");
		}
	
		// TODO Auto-generated method stub
		
	}
	/*public static void addEntry() {
		System.out.println("1.Add entry for doctor " + "\n" +"2.Add entry for patient");
		int opt=get.sc.nextInt();
		try {
		switch(opt)
		{
		case 1:addDoctorDetail();break;
		case 2:addPatientDetailIntoFile();break;
		default:System.out.println("Wrong entry.............");return;
		}
		// TODO Auto-generated method stub
		
	}
		catch(Exception e)
		{
			System.out.println("Unable to add entry");
		}
}*/
	private static void addPatientDetailIntoFile() {
		// TODO Auto-generated method stub
		
	}
}
