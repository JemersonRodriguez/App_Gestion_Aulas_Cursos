package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.AulaRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.Aula;


@Service
public class AulaBDService {

    private final AulaRepository aula_repository;

    public AulaBDService (AulaRepository aula_repository) {
        this.aula_repository = aula_repository;
    }

    public Aula guardar (Aula aula) {
        return aula_repository.save(aula);
    }

    public List<Aula> listar() {
        return aula_repository.findAll();
    }

    public Optional<Aula> buscar(Integer codigo) {
        return aula_repository.findById(codigo);
    }

    public void eliminar(Integer codigo) {
        aula_repository.deleteById(codigo);
    }

    public Aula actualizar(Aula aula) {
        if(aula_repository.existsById(aula.getCodigo())) {
            return aula_repository.save(aula);
        }
        else{
            throw new RuntimeException("Codigo de Aula no encontrado con ID: " + aula.getCodigo());
        }
    }
}
