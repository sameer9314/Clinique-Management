package com.bridgelabz.utility;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgeLabz.model.*;
import com.bridgelabz.serviceimplementation.ManagerServiceImpl;
import com.bridgelabz.serviceimplementation.PatientServiceImpl;


public class Utility {
	private static Scanner scnObj = null;

	public Utility() {
		scnObj = new Scanner(System.in);
	}
/*********************************************** Doctors implements starts **********************************************************************************/	
	public static void recoveringDoctorData(){
		JSONParser parser=new JSONParser();
			try {
				JSONArray a=(JSONArray) parser.parse(new FileReader("/home/administrator/eclipse-workspace/CliniqueManagement/src/com/bridgelabz/files/doctor.json"));
				for(int j=0;j<a.size();j++) {
					Doctor d=new Doctor();
					JSONObject ob=	(JSONObject) a.get(j);
					d.setDoctorName(ob.get("doctorName").toString());
					d.setDoctorId(ob.get("doctorId").toString());
					d.setSpecialisation(ob.get("specialisation").toString());
					d.setAvailability(Integer.parseInt(ob.get("availability").toString()) );
					d.setCountOfPeople(Integer.parseInt(ob.get("countOfPateints").toString()) );
					
					Doctor.doctorList.add(d);
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	/*****************************************************************************************************/
	 public static void printAllEntries () {
		 for(int i=0;i<Doctor.doctorList.size();i++) {
		 System.out.println(Doctor.doctorList.get(i).getDoctorName());
		 System.out.println(Doctor.doctorList.get(i).getDoctorId());
		 System.out.println(Doctor.doctorList.get(i).getSpecialisation());
		 System.out.println(Doctor.doctorList.get(i).isAvailability());
		 System.out.println(Doctor.doctorList.get(i).getCountOfPeople());
		 
		 System.out.println();
		}
	}
	 
	 /*****************************************************************************************************/
	 public static void printOneEntries (int index) {
	//	 for(int i=0;i<Doctor.doctorList.size();i++) {
		 System.out.println(Doctor.doctorList.get(index).getDoctorName());
		 System.out.println(Doctor.doctorList.get(index).getDoctorId());
		 System.out.println(Doctor.doctorList.get(index).getSpecialisation());
		 System.out.println(Doctor.doctorList.get(index).isAvailability());
		 System.out.println(Doctor.doctorList.get(index).getCountOfPeople());
		 
		 System.out.println();
		//}
	}
	 
/*********************************************** Doctors implementation ends ************************************************************************************/	 

	 
/*********************************************** Manager implements starts **********************************************************************************/
	 
	 public static void setPersonDetails() {
		 System.out.println("Enter the patient Name");
		 ManagerServiceImpl.p.setPatientName(Utility.getString());
		 System.out.println("Enter the patient Id");
		 ManagerServiceImpl.p.setPatientId(Utility.getString());
		 System.out.println("Enter the patient Phone Number");
		 ManagerServiceImpl.p.setPatientMobileNumber(Utility.getString());
		 System.out.println("Enter the patient Age");
		 ManagerServiceImpl.p.setPatientAge(Utility.getString());
		 
	 }
	 
	 public static void updatePatientDetail() {
		 System.out.println("Enter Patient Id to update the information");
		 String patientId=Utility.getString();
		 int index=0;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientId())) {
				 index=i;
			 }
		 }
		 System.out.println("Enter the patient Name");
		 Patient.patientList.get(index).setPatientName(Utility.getString());
		 System.out.println("Enter the patient Id");
		 Patient.patientList.get(index).setPatientId(Utility.getString());
		 System.out.println("Enter the patient Phone Number");
		 Patient.patientList.get(index).setPatientMobileNumber(Utility.getString());
		 System.out.println("Enter the patient Age");
		 Patient.patientList.get(index).setPatientAge(Utility.getString());
	 }
	 
	 public static void deletePatient() {
		 System.out.println("Enter Patient Id to update the information");
		 String patientId=Utility.getString();
		 int index=0;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientId())) {
				 index=i;
			 }
		 }
		 Patient.patientList.remove(index);
	 }
/*********************************************** Manager implements ends **********************************************************************************/	

	 
/*********************************************** Patient implementation starts **********************************************************************************/	
	 public static void  takeAppointment() {
		 System.out.println("Enter the id of the patient to get the appointment");
		 String patientId=null;
		 for(int i=0;i<Patient.patientList.size();i++) {
			 if(patientId.equalsIgnoreCase(Patient.patientList.get(i).getPatientId())) {
				 Utility.printOnePatientDetails(i);
			 }
		 }
	 }
	 
	 public static void printOnePatientDetails(int index) {
		 
			 System.out.println(Patient.patientList.get(index).getPatientName());
			 System.out.println(Patient.patientList.get(index).getPatientId());
			 System.out.println(Patient.patientList.get(index).getPatientMobileNumber());
			 System.out.println(Patient.patientList.get(index).getPatientAge());
			 
			 System.out.println();
	 }
	 
	 public static void printAllPatientDetails () {
		 for(int i=0;i<Patient.patientList.size();i++) {
		 System.out.println(Patient.patientList.get(i).getPatientName());
		 System.out.println(Patient.patientList.get(i).getPatientId());
		 System.out.println(Patient.patientList.get(i).getPatientMobileNumber());
		 System.out.println(Patient.patientList.get(i).getPatientAge());
		 
		 System.out.println();
		}
	}
	 
/*********************************************** Patient implements ends **********************************************************************************/	

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
