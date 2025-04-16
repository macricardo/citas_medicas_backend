package com.citas_medicas.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "status_cita")  // Match with the database table.
public class StatusCita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_creado")
    private LocalDateTime fechaCreado;

    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    // Getters and setters (required by JPA).
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDateTime getFechaCreado() { return fechaCreado; }
    public void setFechaCreado(LocalDateTime fechaCreado) { this.fechaCreado = fechaCreado; }

    public LocalDateTime getFechaUpdate() { return fechaUpdate; }
    public void setFechaUpdate(LocalDateTime fechaUpdate) { this.fechaUpdate = fechaUpdate; }
}