package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.AsignarRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AsignarModel;


@Service
public class AsignarService {

    private final AsignarRepository asignarRepository;
    // Constructor con inyección de dependencia del repositorio
    public AsignarService(AsignarRepository asignarRepository) {
        this.asignarRepository = asignarRepository;
    }

    public AsignarModel guardar(AsignarModel asignar) {
        return asignarRepository.save(asignar);
    }

    public List<AsignarModel> listar() {
        return asignarRepository.findAll();
    }

    public void eliminar(Integer id) {
        asignarRepository.deleteById(id);
    }

    public Optional<AsignarModel> buscar(Integer id) {
        return asignarRepository.findById(id);
    }

    public AsignarModel actualizar(AsignarModel asignar) {
        if (asignarRepository.existsById(asignar.getId())) {
            return asignarRepository.save(asignar);
        } else {
            throw new RuntimeException("Id de asignacion no encontrado con ID: " + asignar.getId());
        }
    }

}

