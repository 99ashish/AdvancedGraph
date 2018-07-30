package com.jda.advanced_utility;
import java.util.List;
public class Appointment{
	DoctorInfo doctorName;
	List<PatientInfo> patientName;
	public DoctorInfo getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(DoctorInfo doctorName) {
		this.doctorName = doctorName;
	}
	public List<PatientInfo> getPatientName() {
		return patientName;
	}
	public void setPatientName(List<PatientInfo> patientName) {
		this.patientName = patientName;
	}
}