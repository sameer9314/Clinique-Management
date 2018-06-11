package com.bridgelabz.serviceimplementation;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgeLabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.Utility;

public class DoctorServiceImpl implements DoctorService{
	public void addDoctor() {
		Utility.recoveringDoctorData();
	}
	public void showDoctorDetails() {
		Utility.printAllEntries();
	}
	public void searchDoctorByName() {
		System.out.println("Enter the name of Doctor to search");
		String doctorName=Utility.getString();
		for(int i=0;i<Doctor.doctorList.size();i++) {
			if((doctorName).equalsIgnoreCase((Doctor.doctorList.get(i).getDoctorName()))) {
				Utility.printOneEntries(i);
				return;
			}
		}
	}
	public void searchDoctorById() {
		System.out.println("Enter the id of Doctor to search");
		String doctorId=Utility.getString();
		for(int i=0;i<Doctor.doctorList.size();i++) {
			if((doctorId).equalsIgnoreCase((Doctor.doctorList.get(i).getDoctorId()))) {
				Utility.printOneEntries(i);
				return;
			}
		}
	}
	public void searchDoctorBySpecialisation() {
		System.out.println("Enter the Specialisation of Doctor to search");
		String specialisation=Utility.getString();
		for(int i=0;i<Doctor.doctorList.size();i++) {
			if((specialisation).equalsIgnoreCase((Doctor.doctorList.get(i).getSpecialisation()))) {
				Utility.printOneEntries(i);
				return;
			}
		}
	}
	public 	void searchDoctorByAvailability() {
			int max=0;
			int index=0;
			for(int i=0;i<Doctor.doctorList.size();i++) {
			if(Doctor.doctorList.get(i).isAvailability()>max) {
				max=Doctor.doctorList.get(i).isAvailability();
				index=i;
			}
			}
			Utility.printOneEntries(index);
	}
	
}
