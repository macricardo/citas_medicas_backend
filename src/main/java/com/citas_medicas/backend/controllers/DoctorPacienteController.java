package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.Paciente;
import com.citas_medicas.backend.repositories.DoctorPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor-pacientes")
public class DoctorPacienteController {

    @Autowired
    private DoctorPacienteRepository doctorPacienteRepository;

    @GetMapping("/doctor/{doctorId}/pacientes")
    public List<Paciente> getPacientesByDoctorId(@PathVariable Long doctorId) {
        return doctorPacienteRepository.findPacientesByDoctorId(doctorId);
    }
}