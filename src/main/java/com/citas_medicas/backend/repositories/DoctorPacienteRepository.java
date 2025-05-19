package com.citas_medicas.backend.repositories;

import com.citas_medicas.backend.models.DoctorPaciente;
import com.citas_medicas.backend.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorPacienteRepository extends JpaRepository<DoctorPaciente, Long> {
    @Query("SELECT dp.paciente FROM DoctorPaciente dp WHERE dp.doctor.id = :doctorId AND (dp.activo = true OR dp.activo IS NULL)")
    List<Paciente> findPacientesByDoctorId(@Param("doctorId") Long doctorId);
}