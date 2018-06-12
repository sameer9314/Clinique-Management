package com.bridgelabz.serviceimplementation;

import com.bridgeLabz.model.*;
import com.bridgelabz.controller.CliniqueManager;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.utility.Utility;

/**
 * Purpose : To implement all the behaviours provided for the Manager Service .
 * @author Sameer Saurabh
 * @since  12/06/2018
 * @version 1.0
 */
public class ManagerServiceImpl implements ManagerService{
	public static Patient p;
	
	 /**
	 * Method is written to add Patients to the list. 
	 */
	public  void addPatient() {
		 p=new Patient();
		 System.out.println(" Enter the patient Name");
		 ManagerServiceImpl.p.setPatientName(Utility.getString());
		 boolean patientIdAllotted=false;
		 String patientId=null;
		 while(patientIdAllotted==false) {
			 System.out.println(" Enter the patient Id");
			 patientId =Utility.getString();
			if(Patient.patientList.size()!=0) {
			 for(int i=0;i<Patient.patientList.size();i++) {
				 if(patientId.equals(Patient.patientList.get(i).getPatientId()))
				 {
					 System.out.println(" Id Allready Alloted To Patient ");
					 System.out.println(" Enter 0 to Enter Id Again");
					 System.out.println(" Enter 1 to Open Patient with Id : "+patientId);
					 int choice=Utility.getInt();
					 if(choice==0) {
					 patientId =Utility.getString();
					 }else if(choice==1){
						 CliniqueManager.patientService.searchPatientById(patientId);
						 return;
					 }
				 }
				 else {
					 patientIdAllotted=true;
				 }
			 }
			}else if(Patient.patientList.size()==0){
				patientIdAllotted=true;}
		 }
		 ManagerServiceImpl.p.setPatientId(patientId);
		 System.out.println("Enter the patient Phone Number");
		 ManagerServiceImpl.p.setPatientMobileNumber(Utility.getString());
		 System.out.println("Enter the patient Age");
		 ManagerServiceImpl.p.setPatientAge(Utility.getString());
		 Patient.patientList.add(p);
		 Utility.printAllPatientDetails();
	 }
	
	 /**
	  * Method is written to Update Patients details in the list. 
	  */
	 public  void updatePatientDetail() {
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
		 System.out.println("Enter the patient Phone Number");
		 Patient.patientList.get(index).setPatientMobileNumber(Utility.getString());
		 System.out.println("Enter the patient Age");
		 Patient.patientList.get(index).setPatientAge(Utility.getString());
	 }
	 
	 /**
	  * Method is written to delete Patients from the list. 
	  */
	 public void deletePatient() {
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
}
