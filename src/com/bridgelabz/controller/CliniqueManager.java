package com.bridgelabz.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeLabz.model.Appointment;
import com.bridgeLabz.model.Doctor;
import com.bridgeLabz.model.Patient;
import com.bridgelabz.serviceimplementation.DoctorServiceImpl;
import com.bridgelabz.serviceimplementation.ManagerServiceImpl;
import com.bridgelabz.serviceimplementation.PatientServiceImpl;
import com.bridgelabz.utility.Utility;

/**
 * Purpose : To manage All the operations for the Clinique.
 * @author Sameer Saurabh
 * @since  12/06/2018
 * @version 1.0
 */
public class CliniqueManager {
	public static ManagerServiceImpl manager=new ManagerServiceImpl();
	public static PatientServiceImpl patientService=new PatientServiceImpl();
	public static DoctorServiceImpl doctorService=new DoctorServiceImpl();
	public static Utility obj=new Utility();
	public static void main(String[] args) {
		System.out.println(" Opening Clinique...");
		System.out.println(" Retrieving available doctors details...");
		doctorService.addDoctor();
		System.out.println(" Retrieving Appointment Details...");
		Utility.retrievingAppointmentDetails();
		System.out.println(" Retrieving  Patient details...");
		Utility.retrievingPatientDetails();
		System.out.println("                         _______________________");
		System.out.println("                           WELCOME TO CLINIQUE  ");
		System.out.println("                         _______________________\n");
		boolean cliniqueManagerPresent=true;	
		while(cliniqueManagerPresent==true) {
			System.out.println(" _____________________");
			System.out.println(" Main Counter :   ");
			System.out.println(" _____________________");
			System.out.println(" Select Your Choice :   ");
			System.out.println(" _____________________\n");
			System.out.println(" Enter 1 To Add New Patient Or To Update Or Delete In The List :");
			System.out.println(" Enter 2 To Set Appointment Or To Access Patient Details :");
			System.out.println(" Enter 3 To Access Doctors Details :");
			System.out.println(" Enter 0 to Close  Clinique :");
			
			int choice=Utility.getInt();
			switch(choice) {
			case 1 : CliniqueManager.managerServiceManager();
			break;
			case 2 : CliniqueManager.patientServiceManager();
			break;
			case 3 : CliniqueManager.doctorServiceManager();
			break;
			case 0 : CliniqueManager.savingAppointmentDetails();
					 CliniqueManager.savingPatientDetails();
					 CliniqueManager.savingDoctorDetails();
					 cliniqueManagerPresent=false;
			break;		 
			default : System.out.println(" Wrong Choice ");
			}
		}
	}
	
	/**
	 * Method is written to manage all the services provided For the Patients.
	 */
	static void patientServiceManager(){
		boolean patientServiceManager=true;
		while(patientServiceManager==true) {
		System.out.println(" _____________________");
		System.out.println(" Select Your Choice :   ");
		System.out.println(" _____________________\n");
		System.out.println(" Enter 1 To Set Appointment :");
		System.out.println(" Enter 2 To Show All Patient Details :");
		System.out.println(" Enter 3 To Search Patient By Name :");
		System.out.println(" Enter 4 To Search Patient By Mobile Number :");
		System.out.println(" Enter 5 To Search Patient By Id :");
		System.out.println(" Enter 6 To Show Popular Doctor :");
		System.out.println(" Enter 7 To Show Popular Specialisation :");
		System.out.println(" Enter 0 To Exit Patient Service ");
		int choice =Utility.getInt();
		switch(choice) {
		case 1 : patientService.takeAppointment();
		break;
		case 2 : patientService.showPatientDetails();
		break;
		case 3 : patientService.searchPatientByName();
		break;
		case 4 : patientService.searchPatientByMobileNumber();
		break;
		case 5 : patientService.searchPatientById(null);
		break;
		case 6 : patientService.showPopularDoctor();
		break;
		case 7 : patientService.showPopularSpecialisation();
		break;
		case 0 : patientServiceManager=false;
		break;
		default : System.out.println(" Wrong Choice");
		}}
	}
	
	/**
	 * Method is written to manage all the services provided For the Manager.
	 */
	static void managerServiceManager() {
		boolean managerServiceManager=true;
		while(managerServiceManager==true) {
		System.out.println(" _____________________");
		System.out.println(" Select Your Choice :   ");
		System.out.println(" _____________________\n");
		System.out.println(" Enter 1 To Add New Patient ");
		System.out.println(" Enter 2 To Update Patient Information ");
		System.out.println(" Enter 3 To Delete Patient From The List ");
		System.out.println(" Enter 0 To Exit Manager Service ");
		int choice=Utility.getInt();
		switch(choice) {
		case 1 : manager.addPatient();
		break;
		case 2 : manager.updatePatientDetail();
		break;
		case 3 : manager.deletePatient();
		break;
		case 0 : managerServiceManager=false;
		break;
		default : System.out.println(" Wrong choice ");
		}}
	}
	
	/**
	 * Method is written to manage all the services provided For the Doctors.
	 */
	static void doctorServiceManager() {
		boolean doctorServiceManager=true;
		while(doctorServiceManager==true) {
		System.out.println(" _____________________");
		System.out.println(" Select Your Choice :   ");
		System.out.println(" _____________________\n");
		System.out.println(" Enter 1 To Show All Doctors Details ");
		System.out.println(" Enter 2 To Search Doctor By name ");
		System.out.println(" Enter 3 To Search Doctor By id ");
		System.out.println(" Enter 4 To Search Doctor By Its Specialisation ");
		System.out.println(" Enter 5 To Search Doctor By Availability ");
		System.out.println(" Enter 0 To Exit Doctor Service ");
		//System.out.println(" Enter 3 To Search Doctor By id ");
		int choice=Utility.getInt();
		switch(choice) {
		case 1 : doctorService.showDoctorDetails();
		break;
		case 2 : doctorService.searchDoctorByName();
		break;
		case 3 : doctorService.searchDoctorById();
		break;
		case 4 : doctorService.searchDoctorBySpecialisation();
		break;
		case 5 : doctorService.searchDoctorByAvailability();
		break;
		case 0 : doctorServiceManager=false;
		break;
		default : System.out.println(" Wrong choice ");
		}
		}
	}
	
	/**************************** Save Appointment Details In File*****************************************************************/
	/**
	 * Method is written to save Appointments Details to the Database using JSON.
	 */
	@SuppressWarnings("unchecked")
	static void savingAppointmentDetails() {
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<Appointment.appointmentList.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("patientName", Appointment.appointmentList.get(i).getPatientName());
			jsonObject.put("patientId",Appointment.appointmentList.get(i).getPatientId());
			jsonObject.put("doctorName", Appointment.appointmentList.get(i).getDoctorName());
			jsonObject.put("doctorId", Appointment.appointmentList.get(i).getDoctorId());
			jsonObject.put("timeStamp", Appointment.appointmentList.get(i).getTimeStamp());
		
			jsonArray.add(jsonObject);
		}
		System.out.println("Saving Appointments...");
		File f = new File("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/appointment.json");
		try {
			System.out.println(f.createNewFile());
			BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(f));
			bufferedwriter.write(jsonArray.toString());
			bufferedwriter.close();
			System.out.println("File updated succesfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}

	/**************************** Save Patient Details In File*****************************************************************/
	
	/**
	 * Method is written to save Patients Details to the Database using JSON.
	 */
	@SuppressWarnings("unchecked")
	static void savingPatientDetails() {
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<Appointment.appointmentList.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("patientName",Patient.patientList.get(i).getPatientName());
			jsonObject.put("patientId",Patient.patientList.get(i).getPatientId());
			jsonObject.put("patientMobileNumber", Patient.patientList.get(i).getPatientMobileNumber());
			jsonObject.put("patientAge", Patient.patientList.get(i).getPatientAge());
		
			jsonArray.add(jsonObject);
		}
		System.out.println("Saving Patient Details...");
		File f = new File("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/patient.json");
		try {
			System.out.println(f.createNewFile());
			BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(f));
			bufferedwriter.write(jsonArray.toString());
			bufferedwriter.close();
			System.out.println("Patient File updated succesfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	
	/**************************** Save Doctors Details In File*****************************************************************/
	
	/**
	 * Method is written to save Doctors Details to the Database using JSON.
	 */
	@SuppressWarnings("unchecked")
	static void savingDoctorDetails() {
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<Doctor.doctorList.size();i++) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("doctorName",Doctor.doctorList.get(i).getDoctorName());
			jsonObject.put("doctorId",Doctor.doctorList.get(i).getDoctorId());
			jsonObject.put("specialisation", Doctor.doctorList.get(i).getSpecialisation());
			jsonObject.put("availability", Doctor.doctorList.get(i).isAvailability());
			jsonObject.put("countOfPateints", Doctor.doctorList.get(i).getCountOfPeople());
			jsonArray.add(jsonObject);
		}
		System.out.println("Saving Doctors Details...");
		File f = new File("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/doctor.json");
		try {
			System.out.println(f.createNewFile());
			BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(f));
			bufferedwriter.write(jsonArray.toString());
			bufferedwriter.close();
			System.out.println("Doctor File updated succesfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}
