package com.bridgelabz.service;

public interface PatientService {
		void takeAppointment();
		void showPatientDetails();
		void searchPatientByName();
		void searchPatientByMobileNumber();
		void searchPatientById(String patientId);
		void showPopularDoctor();
		void showPopularSpecialisation();
}
