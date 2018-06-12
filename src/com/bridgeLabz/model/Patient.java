package com.bridgeLabz.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Purpose : To get the Patients Details And store to the list.
 * @author Sameer Saurabh
 * @since  12/06/2018
 * @version 1.0
 */
public class Patient {
String patientName;
String patientId;
String patientMobileNumber;
String patientAge;
public static List<Patient> patientList=new <Patient>LinkedList();
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
}
public String getPatientMobileNumber() {
	return patientMobileNumber;
}
public void setPatientMobileNumber(String patientMobileNumber) {
	this.patientMobileNumber = patientMobileNumber;
}
public String getPatientAge() {
	return patientAge;
}
public void setPatientAge(String patientAge) {
	this.patientAge = patientAge;
}
}
