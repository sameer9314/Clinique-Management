package com.bridgeLabz.model;

import java.util.LinkedList;

public class Doctor {
String doctorName;
String doctorId;
String specialisation;
int availability;
int countOfPateints;

public static LinkedList<Doctor> doctorList=new <Doctor> LinkedList();
public String getDoctorName() {
	return doctorName;
}

public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}

public String getDoctorId() {
	return doctorId;
}

public void setDoctorId(String doctorId) {
	this.doctorId = doctorId;
}

public String getSpecialisation() {
	return specialisation;
}

public void setSpecialisation(String specialisation) {
	this.specialisation = specialisation;
}

public int isAvailability() {
	return availability;
}

public void setAvailability(int availability) {
	this.availability = availability;
}

public int getCountOfPeople() {
	return countOfPateints;
}

public void setCountOfPeople(int countOfPateints) {
	this.countOfPateints = countOfPateints;
}

}
