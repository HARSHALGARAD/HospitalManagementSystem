package com.management.hospital.HospitalManagement.schedulars;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PatientCountSchedular {

    @Scheduled(cron = "*/10  * * * * *")
    public void getCount(){
        System.err.println("Number of Patient in hospital is :20 ");
    }

}

