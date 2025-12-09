package com.management.hospital.HospitalManagement.seviceImpl;

import com.management.hospital.HospitalManagement.entity.Patient;
import com.management.hospital.HospitalManagement.repository.PatientRepository;
import com.management.hospital.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient savePatient(Patient patient) {

        Patient newPatient = patientRepository.save(patient);
        System.out.println("Patient Save Successfully");
        return newPatient;
    }

    @Override
    public List<Patient> getAllPatientList() {
        List<Patient> patientList =  patientRepository.findAll();
        return patientList;
    }

    @Override
    public Patient getPatientById(int id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () ->  new IllegalArgumentException());
        return patient;
    }

    @Override
    public String deletePatientById(int id) {
        patientRepository.deleteById(id);
        String msg = "Patient Delete with id"+id;
        return msg;
    }

    @Override
    public Patient updatePatient(int id, Patient patient) {
        //get object form db which need to be upadte [get by id]
        Patient patientFromDb=patientRepository.findById(id).orElseThrow(()->new IllegalArgumentException());

        //update patinetFromDb with new values
        patientFromDb.setPatientName(patient.getPatientName());
        patientFromDb.setAddress(patient.getAddress());
        patientFromDb.setAge(patient.getAge());
        patientFromDb.setMobileNumber(patient.getMobileNumber());
        //save date fromm db
        Patient updatedPatient = patientRepository.save(patientFromDb);
        return updatedPatient;
    }


}
