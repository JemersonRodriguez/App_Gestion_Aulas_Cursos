package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion_aula_curso")
public class AsignarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "curso", nullable = false)
    private CursoModel curso;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private AulaModel aula;

    @Column(name = "dia", nullable = false)
    private String dia;

    @Column(name = "hora", nullable = false)
    private String hora;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    // Constructor necesario por Hibernate
    public AsignarModel() {
    }

    public AsignarModel(CursoModel curso, AulaModel aula, String dia, String hora, int duracion) {
        this.curso = curso;
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public AulaModel getAula() {
        return aula;
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

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public void setAula(AulaModel aula_id) {
        this.aula = aula_id;
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

    @Override
    public String toString() {
        return "AsignarModel{" +
                "id=" + id +
                ", curso=" + curso +
                ", aula=" + aula +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", duracion=" + duracion +
                '}';
    }

}
