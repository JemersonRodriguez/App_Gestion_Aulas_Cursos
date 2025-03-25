package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class CursoModel {
    @Id
    @Column(name = "sigla")
    private String sigla;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "profesor", nullable = false)
    private String profesor;

    @Column(name = "cantidad_estudiantes", nullable = false)
    private int cantidad_estudiantes;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<AsignarModel> asignaciones;

    public CursoModel() {
    } // Necesario por defecto por Hibernate

    public CursoModel(String sigla, String nombre, String profesor, int cantidad_estudiantes) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.profesor = profesor;
        this.cantidad_estudiantes = cantidad_estudiantes;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public int cantidad_estudiantes() {
        return cantidad_estudiantes;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void cantidad_estudiantes(int cantidad_estudiantes) {
        this.cantidad_estudiantes = cantidad_estudiantes;
    }

    @Override
    public String toString() {
        return "CursoModel{" +
                "sigla='" + sigla + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor='" + profesor + '\'' +
                ", cantidad_estudiantes=" + cantidad_estudiantes +
                '}';
    } //Quitar las impresiones correspondientes a otras tablas
}
