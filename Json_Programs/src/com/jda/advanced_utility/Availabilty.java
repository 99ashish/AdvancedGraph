package com.jda.advanced_utility;
import java.util.ArrayList;
import java.util.List;
class Timing{
	String day;
	String time;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
public class Availabilty {
	List<Timing> schedule= new ArrayList();

	public List<Timing> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Timing> schedule) {
		this.schedule = schedule;
	} 
    
}
