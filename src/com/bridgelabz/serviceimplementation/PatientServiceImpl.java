package com.bridgelabz.serviceimplementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bridgeLabz.model.*;
import com.bridgelabz.service.PatientService;
import com.bridgelabz.utility.Utility;

/**
 * Purpose : To implement all the behaviours provided for the Patient Service .
 * @author Sameer Saurabh
 * @since  12/06/2018
 * @version 1.0
 */
public class PatientServiceImpl implements PatientService{
	public static Appointment appointment;

	/**
	 * Method is written to Take Appointments. 
	 */
	public void  takeAppointment() {
		 Utility.doctorSpecifications();
		 System.out.println("Enter the id of the patient to get the appointment");
		 String patientId=Utility.getString();
		 int index=0;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientId())) {
				 index=i;
			 }
		 }
		 if(index==0) {
			 System.out.println(" Id not found ");
			 return;
			 }
		 System.out.println(" Enter the Doctor Specialisation To Get The Doctor Appointment ");
		 String specialisation=Utility.getString();
		 for(int i=0;i<Doctor.doctorList.size();i++) {
			 if(specialisation.equalsIgnoreCase(Doctor.doctorList.get(i).getSpecialisation())) {
				 if(Doctor.doctorList.get(i).isAvailability()>0 ){
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					 LocalDateTime now = LocalDateTime.now();
				//	System.out.println(dtf.format(now));	
				 System.out.println(" Appointing doctors to the Patients");
				 appointment=new Appointment();
				 PatientServiceImpl.appointment.setPatientName(Patient.patientList.get(index).getPatientName());
				 PatientServiceImpl.appointment.setPatientId(Patient.patientList.get(index).getPatientId());
				 PatientServiceImpl.appointment.setDoctorName(Doctor.doctorList.get(i).getDoctorName());
				 PatientServiceImpl.appointment.setDoctorId(Doctor.doctorList.get(i).getDoctorId());
				 PatientServiceImpl.appointment.setTimeStamp(dtf.format(now));
				 Doctor.doctorList.get(i).setAvailability(Doctor.doctorList.get(i).isAvailability()-1);
				 Doctor.doctorList.get(i).setCountOfPeople(Doctor.doctorList.get(i).getCountOfPeople()+1);
				
				 System.out.println("Adding appointments to the list ");
				 Appointment.appointmentList.add(appointment);
				 Utility.appointmentDetails();
				 return;
				 }
			 }
		 }
		System.out.println("Doctor Not Available");
	 }
	
	/**
	 * Method is written to show all Patients details to the list. 
	 */
	public void showPatientDetails() {
		Utility.printAllPatientDetails();
	}
	
	/**
	 * Method is written search patients by Name.
	 */
	public void searchPatientByName() {
		System.out.println(" Enter the Name of the patient to print the patient details");
		 String patientId=Utility.getString();
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientName())) {
				 Utility.printOnePatientDetails(i);
				 return;
			 }
		 }
		 System.out.println(" Name Not Found ");
	}
	
	/**
	 * Method is written search patients by Mobile Number.
	 */
	public void searchPatientByMobileNumber() {
		System.out.println("Enter the Phone Number of the patient to print the patient details");
		 String patientId=Utility.getString();
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientMobileNumber())) {
				 Utility.printOnePatientDetails(i);
				 return;
			 }
		 }
		 System.out.println(" Mobile Number Not Found");
	}
	
	/**
	 * Method is written search patients by Id.
	 * @param patientId
	 */
	public void searchPatientById(String patientId) {
		System.out.println(" Enter the id of the patient to print the patient details");
		if(patientId==null) patientId=Utility.getString();
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientId())) {
				 Utility.printOnePatientDetails(i);
				 return;
			 }
		 }
		 System.out.println(" Id Not Found");
	}
	
	/**
	 * Method is written to Display Popular Doctor details in the Clinique.
	 */
	public void showPopularDoctor() {
		int index=0;
		int max=0;
		for(int i=0;i<Doctor.doctorList.size();i++) {
			if(Doctor.doctorList.get(i).getCountOfPeople()>max) {
				max=Doctor.doctorList.get(i).getCountOfPeople();
				index=i;
			}
		}
		Utility.printOneEntries(index);
	}
	
	/**
	 * Method is written to Display Popular Specialisation of the Clinique.
	 */
	public void showPopularSpecialisation() {
		int index=0;
		int max=0;
		for(int i=0;i<Doctor.doctorList.size();i++) {
			if(Doctor.doctorList.get(i).getCountOfPeople()>max) {
				max=Doctor.doctorList.get(i).getCountOfPeople();
				index=i;
			}
		}
		System.out.println(" ________________________________________");
		System.out.println(" Popular Specialisation in Clinique is :");
		System.out.println(" ________________________________________\n");
		System.out.println(" "+Doctor.doctorList.get(index).getSpecialisation()+"\n");
	}
}
