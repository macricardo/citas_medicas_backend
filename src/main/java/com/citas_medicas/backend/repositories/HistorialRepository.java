package com.citas_medicas.backend.repositories;

import com.citas_medicas.backend.models.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialRepository extends JpaRepository<Historial, Long> {
    List<Historial> findByPacienteId(Long pacienteId);
}