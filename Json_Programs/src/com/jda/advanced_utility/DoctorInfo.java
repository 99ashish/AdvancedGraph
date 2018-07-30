package com.jda.advanced_utility;

public class DoctorInfo {
	private String name;
	private long mobileNumber;
	private long Id;
	private String specialization;
	private Availabilty availability;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Availabilty getAvailability() {
		return availability;
	}
	public void setAvailability(Availabilty availability) {
		this.availability = availability;
	}
	

}
