package com.citas_medicas.backend;

import com.citas_medicas.backend.entity.Doctor;
import com.citas_medicas.backend.repository.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDatabaseConnection(DoctorRepository doctorRepo) {
        return args -> {
            System.out.println("Testing database connection...");
            
            // Save a test record
            Doctor doctor = new Doctor();
            doctor.setNombre("Dr. Test");
            doctorRepo.save(doctor);
            
            // Query the record
            Doctor savedDoctor = doctorRepo.findById(doctor.getId()).orElseThrow();
            System.out.println("Saved doctor: " + savedDoctor.getNombre());
        };
    }
}