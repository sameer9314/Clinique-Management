package com.bridgelabz.serviceimplementation;

import com.bridgeLabz.model.*;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.utility.Utility;

public class PatientServiceImpl implements PatientService{
	public static Appointment a;
	public void takeAppointment() {
		a=new Appointment();
		Utility.takeAppointment();
		Appointment.appointmentList.add(a);
	}
	
	public void showPatientDetails() {
		Utility.printAllPatientDetails();
	}
	public void searchPatientByName() {
		System.out.println("Enter the id of the patient to print the patient details");
		 String patientId=null;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientName())) {
				 Utility.printOnePatientDetails(i);
			 }
		 }
	}
	public void searchPatientByMobileNumber() {
		System.out.println("Enter the id of the patient to print the patient details");
		 String patientId=null;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientMobileNumber())) {
				 Utility.printOnePatientDetails(i);
			 }
		 }
	}
	public void searchPatientById() {
		System.out.println("Enter the id of the patient to print the patient details");
		 String patientId=null;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientId())) {
				 Utility.printOnePatientDetails(i);
			 }
		 }
	}
	public void showPopularDoctor() {
		
	} 
	public void showPopularSpecialisation() {
		
	}
}
