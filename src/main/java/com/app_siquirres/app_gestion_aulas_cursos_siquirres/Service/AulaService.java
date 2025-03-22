package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.AulaRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;


@Service
public class AulaService {

    private final AulaRepository aula_repository;

    public AulaService (AulaRepository aula_repository) {
        this.aula_repository = aula_repository;
    }

    public AulaModel guardar (AulaModel aula) {
        return aula_repository.save(aula);
    }

    public List<AulaModel> listar() {
        return aula_repository.findAll();
    }

    public AulaModel buscar(Integer codigo) {
        return aula_repository.findById(codigo).orElse(null) ;
    }

    public void eliminar(Integer codigo) {
        aula_repository.deleteById(codigo);
    }

    public AulaModel actualizar(AulaModel aula) {
        if(aula_repository.existsById(aula.getCodigo())) {
            return aula_repository.save(aula);
        }
        else{
            throw new RuntimeException("Codigo de Aula no encontrado con ID: " + aula.getCodigo());
        }
    }
}
