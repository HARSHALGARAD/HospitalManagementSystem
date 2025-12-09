package com.management.hospital.HospitalManagement.controller;

import com.management.hospital.HospitalManagement.entity.Patient;
import com.management.hospital.HospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        Patient savePatient= patientService.savePatient(patient);
        return new ResponseEntity<>(savePatient , HttpStatus.CREATED);

    }

    @GetMapping("/get-all-patients")
    public ResponseEntity<List<Patient>> getAllPatientList(){
        List<Patient> allPatientList = patientService.getAllPatientList();
        return  new ResponseEntity<>(allPatientList,HttpStatus.FOUND);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity <Patient> getPatientByID(@PathVariable("id")int id){
        Patient patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient,HttpStatus.FOUND);



    }

    @DeleteMapping("delete-by-id/{id}")
    private ResponseEntity<String> deletePatientById(@PathVariable("id")int id){
        String msg = patientService.deletePatientById(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);


    }

    @PutMapping("/update/{id}")
    public  ResponseEntity <Patient> updatePatient(@PathVariable("id")int id , @RequestBody Patient patient){
       Patient updatePatient =  patientService.updatePatient(id, patient);
       return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }
}
