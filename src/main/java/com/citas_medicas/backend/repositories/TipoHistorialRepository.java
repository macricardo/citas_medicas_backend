package com.citas_medicas.backend.repositories;

import com.citas_medicas.backend.models.TipoHistorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoHistorialRepository extends JpaRepository<TipoHistorial, Long> {
}