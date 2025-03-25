package com.app_siquirres.app_gestion_aulas_cursos_siquirres.DTO;

public class AsignacionDTO {
    private String siglaCurso;
    private int codigoAula;
    private String dia;
    private String hora;
    private int duracion;

    public AsignacionDTO () {}

    public AsignacionDTO (String siglaCurso, int codigoAula, String dia, String hora, int duracion) {
        this.siglaCurso = siglaCurso;
        this.codigoAula = codigoAula;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    public String getSiglaCurso() {
        return siglaCurso;
    }
    public int getCodigoAula() {
        return codigoAula;
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

    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }
    public void setCodigoAula(int codigoAula) {
        this.codigoAula = codigoAula;
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