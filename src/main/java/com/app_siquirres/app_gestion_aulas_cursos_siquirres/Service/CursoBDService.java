package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.Curso;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.CursoRepository;

@Service
public class CursoBDService {

    private final CursoRepository cursoRepository;

    public CursoBDService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public void eliminar(String sigla) {
        cursoRepository.deleteById(sigla);
    }

    public Optional<Curso> buscar(String sigla) {
        return cursoRepository.findById(sigla);
    }

    public Curso actualizar(Curso curso) {
        if(cursoRepository.existsById(curso.getSigla())) {
            return cursoRepository.save(curso);
        }
        else{
            throw new RuntimeException("Sigla de Curso no encontrado con ID: " + curso.getSigla());
        }
    }

}
