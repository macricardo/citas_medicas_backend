package com.citas_medicas.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "doctor_paciente",
    uniqueConstraints = @UniqueConstraint(columnNames = {"doctor_id", "paciente_id"})
)
public class DoctorPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;

    @Column(name = "fecha_termino")
    private LocalDateTime fechaTermino;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "fecha_creado")
    private LocalDateTime fechaCreado;

    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }

    public LocalDateTime getFechaTermino() { return fechaTermino; }
    public void setFechaTermino(LocalDateTime fechaTermino) { this.fechaTermino = fechaTermino; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalDateTime getFechaCreado() { return fechaCreado; }
    public void setFechaCreado(LocalDateTime fechaCreado) { this.fechaCreado = fechaCreado; }

    public LocalDateTime getFechaUpdate() { return fechaUpdate; }
    public void setFechaUpdate(LocalDateTime fechaUpdate) { this.fechaUpdate = fechaUpdate; }
}