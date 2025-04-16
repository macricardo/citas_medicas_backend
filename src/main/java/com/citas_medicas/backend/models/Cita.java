package com.citas_medicas.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")  // Match with the database table.
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @Column(name = "cita_fecha", nullable = false)
    private LocalDateTime citaFecha;

    @Column(name = "status_cita_id")
    private Integer statusCitaId;

    @Column(name = "fecha_creado")
    private LocalDateTime fechaCreado;

    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    // Getters and setters (required by JPA).
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDateTime getCitaFecha() { return citaFecha; }
    public void setCitaFecha(LocalDateTime citaFecha) { this.citaFecha = citaFecha; }

    public Integer getStatusCitaId() { return statusCitaId; }
    public void setStatusCitaId(Integer statusCitaId) { this.statusCitaId = statusCitaId; }

    public LocalDateTime getFechaCreado() { return fechaCreado; }
    public void setFechaCreado(LocalDateTime fechaCreado) { this.fechaCreado = fechaCreado; }

    public LocalDateTime getFechaUpdate() { return fechaUpdate; }
    public void setFechaUpdate(LocalDateTime fechaUpdate) { this.fechaUpdate = fechaUpdate; }
}