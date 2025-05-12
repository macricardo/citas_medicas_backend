// filepath: /home/fermat/Documents/Semestre8/APIs/proyecto_final/springboot/backend/src/main/java/com/citas_medicas/backend/repositories/PacienteRepository.java
package com.citas_medicas.backend.repositories;

import com.citas_medicas.backend.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}