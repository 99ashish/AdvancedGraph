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
class Search<T>
{
	public void searchId(List<T> dataList,int id,Class className)
	{
		for(int i=0;i<dataList.size();i++)
		{
			if( ((className)dataList.get(i)).getId().compareTo(id)==0)
			{
				System.out.println(dataList.get(i));
			}
		}
		
	}
	public void searchByName(List<T> dataList,String name)
	{
			for(int i=0;i<dataList.size();i++)
			{
				if( ((PatientInfo)(dataList.get(i))).getPatientName().compareTo(name)==0)
				{
					System.out.println(dataList.get(i));
				}
			}
	}
	public void searchByMobNum(List<T> dataList,long mobileNumber)
	{
		for(int i=0;i<dataList.size();i++)
		{
			if( dataList.get(i).getMobileNumber().compareTo(mobileNumber)==0)
			{
				System.out.println(dataList.get(i));
			}
		}
	}
}
public class ClinicUser<T> {
	private static final Class DoctorInfo = null;
	static Input get =Input.getInputInstance();
	private static String path ="C:\\Users\\1022784\\Desktop\\gitProgram\\StakeHolder\\";
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
			System.out.println((i+1)+".\t\t\t" +"                    Id:    "+ drInfo.get(i).getId()
					                    +"\n\t\t\t" +"Doctor Name:    " +drInfo.get(i).getName()
					                    +"\n\t\t\t\t" + "Availability: ");
			for(int j=0; j< drInfo.get(i).getAvailability().getSchedule().size();j++)
			{
				System.out.println("\t\t\t\t\t" +drInfo.get(i).getAvailability().getSchedule().get(j).getDay()+"  "+drInfo.get(i).getAvailability().getSchedule().get(j).getTime() );
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
			get.sc.nextLine();
			PatientInfo pr=new PatientInfo();
			System.out.println("Patient Name");
			pr.setPatientName(get.sc.nextLine());
			System.out.println("Unique Id");
			pr.setId(get.sc.nextLong());
			System.out.println("Mobile Number");
			pr.setMobileNumber(get.sc.nextLong());
			System.out.println("Age");
			pr.setAge(get.sc.nextInt());
			patient.add(pr);
			StockPortfolio.writeToFile(fileName, patientInfo);
			while(true)
			{
			System.out.println("Enter a valid serial number of doctor to get appointment........");
			int opt=get.sc.nextInt();
			if(opt>drInfo.size()+1)
			{
				System.out.println("Not a valid option");
				continue;
			}
           Appointment apt=new Appointment();
           apt.doctorName=drInfo.get(opt-1);
           List<Appointment> aptDetail =new ArrayList<>();
           File file=new File(path+"Appointment"+".json");
           readFromFile(file,(List<T>) aptDetail,Appointment.class);
           if(have(aptDetail,apt.doctorName))
           {
        	   //System.out.println("hi");
        	   int idx=getIdx(aptDetail,drInfo.get(opt-1));
        	   if(aptDetail.get(idx).patientName.size()==5)
        	   {
        		   System.out.println("Doctor is not availble select other one");
        		   continue;
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
        	   File fileName1=new File("/home/bridgelabz/Desktop/JavaCode/StakeHolder/Appointment.json");
        	   writeToFile(fileName1,(List<T>) aptDetail,Appointment.class);
        	   break;
           }
		}

	int getIdx(List<Appointment> list , DoctorInfo doctorName)
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
		case 1:searchPatientByName(  patientInfo);break;
		case 2:searchPatientById(patientInfo);break;
		case 3:searchPatientBYMobNum(patientInfo);break;
		default:
			System.out.println("worng entry");
		}
		
	}
	private void searchPatientById(List<PatientInfo>  patientInfo)
	{
		System.out.println("Enter the Id");
		int val= get.sc.nextInt();
		Search<PatientInfo> genericSearch= new Search<PatientInfo>();
		genericSearch.searchId(patientInfo,val);
	}
	private void searchPatientBYMobNum(List<PatientInfo>  patientInfo)
	{
		System.out.println("Enter the Mobile Number");
		long val= get.sc.nextLong();
		Search<PatientInfo> genericSearch= new Search<>();
		genericSearch.searchByMobNum(patientInfo,val);
	}
	private void searchPatientByName(List<PatientInfo>  patientInfo)
	{
		System.out.println("Enter the name");
		String val= get.sc.nextLine();
		Search<PatientInfo> genericSearch= new Search<>();
		genericSearch.searchByName(patientInfo,val);
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
		//case 1:searchDoctorByName(drInfo);break;
		//case 2:searchById();System.out.println("Enter the id");searchFunction((List<T>)patientInfo, (T)get.sc.nextLine());break;
		//case 3:searchBYMobNum();System.out.println("Enter the Mobile number");searchFunction((List<T>)patientInfo,(T)get.sc.nextLine());break;
		default:
			System.out.println("worng entry");
		}
	
		// TODO Auto-generated method stub
		
	}
}
