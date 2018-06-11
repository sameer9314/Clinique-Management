package com.bridgelabz.utility;

import java.io.FileReader;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgeLabz.model.*;
//import com.bridgelabz.serviceimplementation.ManagerServiceImpl;
//import com.bridgelabz.serviceimplementation.PatientServiceImpl;


public class Utility {
	private static Scanner scnObj = null;

	public Utility() {
		scnObj = new Scanner(System.in);
	}
/*********************************************** Doctors implements starts **********************************************************************************/	
	public static void recoveringDoctorData(){
		JSONParser parser=new JSONParser();
			try {
				JSONArray jsonArray=(JSONArray) parser.parse(new FileReader("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/doctor.json"));
				//System.out.println("JSONArray of doctor "+jsonArray);
				for(int j=0;j<jsonArray.size();j++) {
					Doctor doctorObject=new Doctor();
					JSONObject jsonObject=	(JSONObject) jsonArray.get(j);
					doctorObject.setDoctorName(jsonObject.get("doctorName").toString());
					doctorObject.setDoctorId(jsonObject.get("doctorId").toString());
					doctorObject.setSpecialisation(jsonObject.get("specialisation").toString());
					doctorObject.setAvailability(Integer.parseInt(jsonObject.get("availability").toString()));
					doctorObject.setCountOfPeople(Integer.parseInt(jsonObject.get("countOfPateints").toString()) );
					Doctor.doctorList.add(doctorObject);
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void printAllEntries () {
		 for(int i=0;i<Doctor.doctorList.size();i++) {
			 System.out.println("_______________________________");
			 System.out.println("Printing Details of Doctor "+(i+1));
			 System.out.println("_______________________________");
		 System.out.println(" Doctor Name : "+Doctor.doctorList.get(i).getDoctorName());
		 System.out.println(" Doctor Id : "+Doctor.doctorList.get(i).getDoctorId());
		 System.out.println(" Doctor Specialisation : "+Doctor.doctorList.get(i).getSpecialisation());
		 System.out.println(" Doctor Availability : "+Doctor.doctorList.get(i).isAvailability());
		 System.out.println(" Count of People : "+Doctor.doctorList.get(i).getCountOfPeople());
		 
		 System.out.println();
		}
	}
	 
	 public static void printOneEntries (int index) {
	//	 for(int i=0;i<Doctor.doctorList.size();i++) {
		 System.out.println(" Doctor Name : "+Doctor.doctorList.get(index).getDoctorName());
		 System.out.println(" Doctor Id : "+Doctor.doctorList.get(index).getDoctorId());
		 System.out.println(" Doctor Specialisation : "+Doctor.doctorList.get(index).getSpecialisation());
		 System.out.println(" Doctor Availability : "+Doctor.doctorList.get(index).isAvailability());
		 System.out.println(" Count of People : "+Doctor.doctorList.get(index).getCountOfPeople());
		 
		 System.out.println();
		//}
	}
	 
	 public static void doctorSpecifications() {
		 System.out.println(" Available Departments In Clinic");
		 for(int i=0;i<Doctor.doctorList.size();i++){
			 System.out.println((i+1)+". "+Doctor.doctorList.get(i).getSpecialisation());
		 }
	 }
	 
/*********************************************** Doctors implementation ends ************************************************************************************/	 

	 
/*********************************************** Manager implements starts **********************************************************************************/
	 

/*********************************************** Manager implements ends **********************************************************************************/	

	 
/*********************************************** Patient implementation starts **********************************************************************************/	

	 
	 public static void printOnePatientDetails(int index) {
		 	 
			 System.out.println("Patient Name : "+Patient.patientList.get(index).getPatientName());
			 System.out.println("Patient Id : "+Patient.patientList.get(index).getPatientId());
			 System.out.println("Patient Mobile Number : "+Patient.patientList.get(index).getPatientMobileNumber());
			 System.out.println("Patient Age : "+Patient.patientList.get(index).getPatientAge());
			 
			 System.out.println();
	 }
	 
	 public static void printAllPatientDetails () {
		 System.out.println("Patient list size is :"+Patient.patientList.size());
		 for(int i=0;i<Patient.patientList.size();i++) {
		 System.out.println("_______________________________");
		 System.out.println("Patient "+(i+1)+" details ");
		 System.out.println("_______________________________");
		 System.out.println("Patient Name : "+Patient.patientList.get(i).getPatientName());
		 System.out.println("Patient Id : "+Patient.patientList.get(i).getPatientId());
		 System.out.println("Patient Mobile Number : "+Patient.patientList.get(i).getPatientMobileNumber());
		 System.out.println("Patient Age : "+Patient.patientList.get(i).getPatientAge());
		 
		 System.out.println();
		}
	}
	 
	 public static void retrievingPatientDetails(){
			JSONParser parser=new JSONParser();
				try {
					JSONArray jsonArray=(JSONArray) parser.parse(new FileReader("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/patient.json"));
					//System.out.println("JSONArray of Patient "+jsonArray);
					for(int j=0;j<jsonArray.size();j++) {
						Patient patientObject=new Patient();
						JSONObject jsonObject=	(JSONObject) jsonArray.get(j);
						patientObject.setPatientName(jsonObject.get("patientName").toString());
						patientObject.setPatientId(jsonObject.get("patientId").toString());
						patientObject.setPatientMobileNumber(jsonObject.get("patientMobileNumber").toString());
						patientObject.setPatientAge((jsonObject.get("patientAge").toString()));
						Patient.patientList.add(patientObject);
						}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
/*********************************************** Patient implements ends **********************************************************************************/	

/************************************************ Appointment implements starts*****************************************************************************/
	public static void appointmentDetails() {
		 System.out.println(" Printing appointment Details");
		 System.out.println("Appointment List size is : "+Appointment.appointmentList.size());
		 for(int i=0;i<Appointment.appointmentList.size();i++) {
			 System.out.println("_______________________________");
			 System.out.println("Printing "+(i+1)+" Appointment");
			 System.out.println("_______________________________");
			 System.out.println(" Patient Name : "+Appointment.appointmentList.get(i).getPatientName());
			 System.out.println(" Patient Id : "+Appointment.appointmentList.get(i).getPatientId());
			 System.out.println(" Doctor Name : "+Appointment.appointmentList.get(i).getDoctorName());
			 System.out.println(" Doctor Id : "+Appointment.appointmentList.get(i).getDoctorId());
			 System.out.println(" Time Stamp : "+Appointment.appointmentList.get(i).getTimeStamp());
		 }
	 }
	
	public static void retrievingAppointmentDetails(){
		JSONParser parser=new JSONParser();
			try {
				JSONArray jsonArray=(JSONArray) parser.parse(new FileReader("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/appointment.json"));
				//System.out.println("JSONArray of Appointment "+jsonArray);
				for(int j=0;j<jsonArray.size();j++) {
					Appointment appointmentObject=new Appointment();
					JSONObject jsonObject=	(JSONObject) jsonArray.get(j);
					appointmentObject.setPatientName(jsonObject.get("patientName").toString());
					appointmentObject.setPatientId(jsonObject.get("patientId").toString());
					appointmentObject.setDoctorName(jsonObject.get("doctorName").toString());
					appointmentObject.setDoctorId(jsonObject.get("doctorId").toString());
					appointmentObject.setTimeStamp(jsonObject.get("timeStamp").toString());
					Appointment.appointmentList.add(appointmentObject);
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	 
/*************************************************Appointment implements ends*******************************************************************************/	 

	 /*****************************************
		 * Generate one Integer
		 *****************************************/
		/**
		 * Function is written to generate one integer number.
		 */
		public static int getInt() {
			try {
				int number = scnObj.nextInt();
				return number;
			}catch(Exception e) {
				scnObj.nextLine();
				System.out.println("Invalid type of Input, must be integer Please try again... ");
				return getInt();
			}
			
		}

		/****************************************
		 * Generate one String
		 ****************************************/
		/**
		 * Function is written to generate one String.
		 */
		public static String getString() {
			return scnObj.next();
		}
		
		/**
		 * Function is written to generate one String Line.
		 */
		public static String getStringLine() {
			return scnObj.nextLine();
		}
}
