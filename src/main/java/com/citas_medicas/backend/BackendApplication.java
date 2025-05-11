// ./mvn spring-boot:run

package com.citas_medicas.backend;

import com.citas_medicas.backend.repositories.DoctorRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDatabaseConnection(DoctorRepository doctorRepo) {
        return args -> {
            System.out.println("Testing database connection...");
            
            // Test database connection by querying the count of doctors
            long doctorCount = doctorRepo.count();
            System.out.println("Number of doctors in the database: " + doctorCount);
        };
    }
}