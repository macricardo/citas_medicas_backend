package com.citas_medicas.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")  // Match with the database table.
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paciente_nombre", nullable = false)
    private String nombre;

    @Column(name = "paciente_email", unique = true)
    private String email;

    @Column(name = "paciente_password")
    private String password;

    @Column(name = "paciente_telefono")
    private String telefono;

    @Column(name = "paciente_rfc", unique = true)
    private String rfc;

    @Column(name = "paciente_direccion")
    private String direccion;

    @Column(name = "paciente_status_id")
    private Integer statusId;

    @Column(name = "fecha_creado")
    private LocalDateTime fechaCreado;

    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    // Getters and setters (required by JPA).
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getStatusId() { return statusId; }
    public void setStatusId(Integer statusId) { this.statusId = statusId; }

    public LocalDateTime getFechaCreado() { return fechaCreado; }
    public void setFechaCreado(LocalDateTime fechaCreado) { this.fechaCreado = fechaCreado; }

    public LocalDateTime getFechaUpdate() { return fechaUpdate; }
    public void setFechaUpdate(LocalDateTime fechaUpdate) { this.fechaUpdate = fechaUpdate; }
}
