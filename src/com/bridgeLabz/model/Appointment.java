package com.bridgeLabz.model;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Purpose : To get the appointment and store it to the list.
 * @author Sameer Saurabh
 * @since  12/06/2018
 * @version 1.0
 */
public class Appointment {
String patientName;
String patientId;
String doctorName;
String doctorId;
String timeStamp;

public static List<Appointment> appointmentList=new <Appointment>LinkedList();
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
public String getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
}
}
