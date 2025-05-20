package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.Paciente;
import com.citas_medicas.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Endpoint to "delete" a paciente by setting statusId to 2
    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDeletePaciente(@PathVariable Long id) {
        return pacienteRepository.findById(id)
            .map(paciente -> {
                paciente.setStatusId(2);
                pacienteRepository.save(paciente);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}