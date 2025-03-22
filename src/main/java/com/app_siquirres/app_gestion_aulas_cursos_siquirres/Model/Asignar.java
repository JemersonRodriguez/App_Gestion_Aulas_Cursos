package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion_aula_curso")
public class Asignar {
    @Id
    private int id;
    @Column(name = "curso", nullable = false)
    private String curso;
    @Column(name = "aula_id", nullable = false)
    private int aula_id;
    @Column(name = "dia", nullable = false)
    private String dia;
    @Column(name = "hora", nullable = false)
    private String hora;
    @Column(name = "duracion", nullable = false)
    private int duracion;

    public Asignar (int id , String curso , int aula_id , String dia , String hora , int duracion) {
        this.id = id;
        this.curso = curso;
        this.aula_id = aula_id;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }
    public String getCurso() {
        return curso;
    }
    public int getAula_id() {
        return aula_id;
    }
    public String getDia() {
        return dia;
    }
    public String getHora() {
        return hora;
    }
    public int getDuracion() {
        return duracion;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setAula_id(int aula_id) {
        this.aula_id = aula_id;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
