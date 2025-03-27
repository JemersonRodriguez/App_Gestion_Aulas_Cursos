package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

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

    @Column(name = "cantidadestudiantes", nullable = false)
    private int cantidadestudiantes;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<AsignarModel> asignaciones;

    // Constructor vacío requerido por Hibernate
    public CursoModel() {
    }

    // Constructor completo
    public CursoModel(String sigla, String nombre, String profesor, int cantidadestudiantes) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.profesor = profesor;
        this.cantidadestudiantes = cantidadestudiantes;
    }

    // Getters y setters
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCantidadestudiantes() {
        return cantidadestudiantes;
    }

    public void setCantidadestudiantes(int cantidadestudiantes) {
        this.cantidadestudiantes = cantidadestudiantes;
    }

    public List<AsignarModel> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<AsignarModel> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        return "CursoModel{" +
                "sigla='" + sigla + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor='" + profesor + '\'' +
                ", cantidad_estudiantes=" + cantidadestudiantes +
                '}';
    }
}
