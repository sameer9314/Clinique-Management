package com.bridgelabz.serviceimplementation;

import com.bridgeLabz.model.*;
import com.bridgelabz.service.ManagerService;
import com.bridgelabz.utility.Utility;

public class ManagerServiceImpl implements ManagerService{
	public static Patient p;
	public void addPatient() {
		 p=new Patient();
		Utility.setPersonDetails();
		Patient.patientList.add(p);
	}
	public void updatePatientDetail() {
		Utility.updatePatientDetail();
	}
	public void deletePatient() {
		Utility.deletePatient();
	}
}
