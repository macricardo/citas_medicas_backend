package com.citas_medicas.backend.controllers;

import com.citas_medicas.backend.dto.LoginRequest;
import com.citas_medicas.backend.models.Doctor;
import com.citas_medicas.backend.repositories.DoctorRepository;
import com.citas_medicas.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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
                String token = JwtUtil.generateToken(doctor.getEmail());
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("doctor", Map.of(
                    "id", doctor.getId(),
                    "nombre", doctor.getNombre(),
                    "email", doctor.getEmail()
                ));
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }
}