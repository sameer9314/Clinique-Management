package com.bridgelabz.serviceimplementation;


import com.bridgeLabz.model.Doctor;
import com.bridgelabz.service.DoctorService;
import com.bridgelabz.utility.Utility;

/**
 * Purpose : To implement all the behaviours provided for the Doctors .
 * @author Sameer Saurabh
 * @since  12/06/2018
 * @version 1.0
 */
public class DoctorServiceImpl implements DoctorService{
	/**
	 * Method is written to retrieve all the details of Doctors from the Database.
	 */
	public void addDoctor() {
		Utility.recoveringDoctorData();
	}
	
	/**
	 * Method is written to print all doctor details present in clinique.
	 */
	public void showDoctorDetails() {
		Utility.printAllEntries();
	}
	
	/**
	 * Method is written to search doctor details present in clinique by Name.
	 */
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
	
	/**
	 * Method is written to search doctor details present in clinique by Id.
	 */
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
	
	/**
	 * Method is written to search doctor details present in clinique by Specialisation.
	 */
	public void searchDoctorBySpecialisation() {
		Utility.doctorSpecifications();
		System.out.println("Enter the Specialisation of Doctor to search");
		String specialisation=Utility.getString();
		for(int i=0;i<Doctor.doctorList.size();i++) {
			if((specialisation).equalsIgnoreCase((Doctor.doctorList.get(i).getSpecialisation()))) {
				Utility.printOneEntries(i);
				return;
			}
		}
	}
	
	/**
	 * Method is written to search doctor details present in clinique by Availability.
	 */
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
