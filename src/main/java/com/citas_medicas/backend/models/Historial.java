package com.citas_medicas.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historiales")  // Match with the database table.
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Paciente paciente;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", columnDefinition = "LONGTEXT")
    private String descripcion;

    @Column(name = "tipo_historial_id")
    private Integer tipoHistorialId;

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

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getTipoHistorialId() { return tipoHistorialId; }
    public void setTipoHistorialId(Integer tipoHistorialId) { this.tipoHistorialId = tipoHistorialId; }

    public LocalDateTime getFechaCreado() { return fechaCreado; }
    public void setFechaCreado(LocalDateTime fechaCreado) { this.fechaCreado = fechaCreado; }

    public LocalDateTime getFechaUpdate() { return fechaUpdate; }
    public void setFechaUpdate(LocalDateTime fechaUpdate) { this.fechaUpdate = fechaUpdate; }
}