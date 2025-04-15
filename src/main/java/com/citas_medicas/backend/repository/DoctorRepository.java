package com.citas_medicas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citas_medicas.backend.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}