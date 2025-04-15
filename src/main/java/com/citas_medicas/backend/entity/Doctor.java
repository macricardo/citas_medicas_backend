package com.citas_medicas.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctores")  // Match your MySQL table name
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_nombre")  // Match column name
    private String nombre;

    // Getters and setters (required by JPA)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}