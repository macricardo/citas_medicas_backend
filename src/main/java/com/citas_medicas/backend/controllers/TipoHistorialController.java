package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.models.TipoHistorial;
import com.citas_medicas.backend.repositories.TipoHistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-historial")
public class TipoHistorialController {

    @Autowired
    private TipoHistorialRepository tipoHistorialRepository;

    @GetMapping
    public List<TipoHistorial> getAllTipos() {
        return tipoHistorialRepository.findAll();
    }
}