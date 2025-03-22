package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.CursoModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public CursoModel guardar(CursoModel curso) {
        return cursoRepository.save(curso);
    }

    public List<CursoModel> listar() {
        return cursoRepository.findAll();
    }

    public void eliminar(String sigla) {
        cursoRepository.deleteById(sigla);
    }

    public Optional<CursoModel> buscar(String sigla) {
        return cursoRepository.findById(sigla);
    }

    public CursoModel actualizar(CursoModel curso) {
        if(cursoRepository.existsById(curso.getSigla())) {
            return cursoRepository.save(curso);
        }
        else{
            throw new RuntimeException("Sigla de Curso no encontrado con ID: " + curso.getSigla());
        }
    }

}
