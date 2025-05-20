package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.Historial;
import com.citas_medicas.backend.models.Doctor;
import com.citas_medicas.backend.models.Paciente;
import com.citas_medicas.backend.repositories.HistorialRepository;
import com.citas_medicas.backend.repositories.DoctorRepository;
import com.citas_medicas.backend.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/historiales")
public class HistorialController {

    @Autowired
    private HistorialRepository historialRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/paciente/{pacienteId}")
    public List<Historial> getHistorialByPacienteId(@PathVariable Long pacienteId) {
        return historialRepository.findByPacienteId(pacienteId);
    }

    @PostMapping
    public ResponseEntity<Historial> createHistorial(@RequestBody Historial historial) {
        // Set fecha_creado and fecha_update to now
        historial.setFechaCreado(LocalDateTime.now());
        historial.setFechaUpdate(LocalDateTime.now());

        // Optionally, ensure doctor and paciente exist
        if (historial.getDoctor() != null && historial.getDoctor().getId() != null) {
            Doctor doctor = doctorRepository.findById(historial.getDoctor().getId()).orElse(null);
            historial.setDoctor(doctor);
        }
        if (historial.getPaciente() != null && historial.getPaciente().getId() != null) {
            Paciente paciente = pacienteRepository.findById(historial.getPaciente().getId()).orElse(null);
            historial.setPaciente(paciente);
        }

        Historial saved = historialRepository.save(historial);
        return ResponseEntity.ok(saved);
    }
}