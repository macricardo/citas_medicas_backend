package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.dto.PacienteDoctorRequest;
import com.citas_medicas.backend.models.Doctor;
import com.citas_medicas.backend.models.DoctorPaciente;
import com.citas_medicas.backend.models.Paciente;
import com.citas_medicas.backend.repositories.DoctorPacienteRepository;
import com.citas_medicas.backend.repositories.DoctorRepository;
import com.citas_medicas.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorPacienteRepository doctorPacienteRepository;

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

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody PacienteDoctorRequest request) {
        // Create Paciente
        Paciente paciente = new Paciente();
        paciente.setNombre(request.getNombre());
        paciente.setEmail(request.getEmail());
        paciente.setPassword(request.getPassword());
        paciente.setTelefono(request.getTelefono());
        paciente.setRfc(request.getRfc());
        paciente.setDireccion(request.getDireccion());
        paciente.setStatusId(1);
        paciente.setFechaCreado(LocalDateTime.now());
        paciente.setFechaUpdate(LocalDateTime.now());
        Paciente savedPaciente = pacienteRepository.save(paciente);

        // Link to Doctor
        Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElse(null);
        if (doctor != null) {
            DoctorPaciente dp = new DoctorPaciente();
            dp.setDoctor(doctor);
            dp.setPaciente(savedPaciente);
            dp.setActivo(true);
            dp.setFechaAsignacion(LocalDateTime.now());
            dp.setFechaCreado(LocalDateTime.now());
            dp.setFechaUpdate(LocalDateTime.now());
            doctorPacienteRepository.save(dp);
        }

        return ResponseEntity.ok(savedPaciente);
    }
}