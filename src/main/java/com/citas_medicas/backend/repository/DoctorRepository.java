package com.citas_medicas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.citas_medicas.backend.models.Doctor;

import java.util.Optional;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
    // Find a doctor by email
    Optional<Doctor> findByName(String nombre);

    // Find doctors by status ID
    List<Doctor> findByStatusId(Integer statusId);

    // Custom query to find doctors by consultorio ID
    @Query("SELECT d FROM Doctor d WHERE d.consultorioId = :consultorioId")
    List<Doctor> findDoctorsByConsultorioId(@Param("consultorioId") Integer consultorioId);

    // Check if a doctor exists by RFC
    boolean existsByRfc(String rfc);
}