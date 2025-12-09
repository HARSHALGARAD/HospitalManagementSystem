package com.management.hospital.HospitalManagement.repository;

import com.management.hospital.HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

    @Query(value = "value= select * from patient",nativeQuery = true)
    List<Patient> getAllPatient();
}
