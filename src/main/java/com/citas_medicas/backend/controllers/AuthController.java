package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.dto.LoginRequest;
import com.citas_medicas.backend.models.Doctor;
import com.citas_medicas.backend.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<Doctor> doctorOpt = doctorRepository.findByEmail(loginRequest.getEmail());
        if (doctorOpt.isPresent()) {
            Doctor doctor = doctorOpt.get();
            if (doctor.getPassword().equals(loginRequest.getPassword())) {
                // Puedes devolver solo el nombre, id, email, etc. (no la contraseña)
                return ResponseEntity.ok(doctor);
            }
        }
        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }
}