package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.AsignarRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.Asignar;


@Service
public class AsignarBDService {

    private final AsignarRepository asignarRepository;
    // Constructor con inyección de dependencia del repositorio
    public AsignarBDService(AsignarRepository asignarRepository) {
        this.asignarRepository = asignarRepository;
    }

    public Asignar guardar(Asignar asignar) {
        return asignarRepository.save(asignar);
    }

    public List<Asignar> listar() {
        return asignarRepository.findAll();
    }

    public void eliminar(Integer id) {
        asignarRepository.deleteById(id);
    }

    public Optional<Asignar> buscar(Integer id) {
        return asignarRepository.findById(id);
    }

    public Asignar actualizar(Asignar asignar) {
        if (asignarRepository.existsById(asignar.getId())) {
            return asignarRepository.save(asignar);
        } else {
            throw new RuntimeException("Id de asignacion no encontrado con ID: " + asignar.getId());
        }
    }

}

