package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.Paciente;
import com.citas_medicas.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Endpoint to list all pacientes
    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }
}