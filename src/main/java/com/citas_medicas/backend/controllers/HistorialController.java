package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.Historial;
import com.citas_medicas.backend.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historiales")
public class HistorialController {

    @Autowired
    private HistorialRepository historialRepository;

    @GetMapping("/paciente/{pacienteId}")
    public List<Historial> getHistorialByPacienteId(@PathVariable Long pacienteId) {
        return historialRepository.findByPacienteId(pacienteId);
    }
}