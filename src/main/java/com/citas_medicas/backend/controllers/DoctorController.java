package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.Doctor;
import com.citas_medicas.backend.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // Endpoint to list all doctors
    @GetMapping
    public List<Doctor> getAllDoctores() {
        return doctorRepository.findAll();
    }
}