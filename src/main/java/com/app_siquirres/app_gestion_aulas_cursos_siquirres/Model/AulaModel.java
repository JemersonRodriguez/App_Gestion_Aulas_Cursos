package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aula")
public class AulaModel {
    @Id
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "aire_acondicionado", nullable = false)
    private boolean aire_acondicionado;

    @OneToMany(mappedBy = "aula", cascade = CascadeType.ALL)
    private List<AsignarModel> asignaciones;

    public AulaModel() {
    } // Necesario por defecto por Hibernate

    public AulaModel(int codigo, int capacidad, String nombre, String ubicacion, boolean aire_acondicionado) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.aire_acondicionado = aire_acondicionado;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean getAire_acondicionado() {
        return aire_acondicionado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setAire_acondicionado(boolean aire_acondicionado) {
        this.aire_acondicionado = aire_acondicionado;
    }

    @Override
    public String toString() {
        return "AulaModel{" +
                "codigo=" + codigo +
                ", capacidad=" + capacidad +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", aire_acondicionado=" + aire_acondicionado +
                ", asignaciones=" + asignaciones +
                '}';
    } //Quitar las impresiones correspondientes a otras tablas
}
