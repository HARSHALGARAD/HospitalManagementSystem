package com.management.hospital.HospitalManagement.serviceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class something {

    public something(){
        System.err.println("Something loaded");
    }
    @Bean
    public  String getSomethig(){
        System.err.println("get somethig executed");
        return "somethig";
    }
}
