package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.DTO.AsignacionDTO;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AsignarModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.CursoModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.AsignarRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.AulaRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AsignarService {

    private final AsignarRepository asignarRepository;
    private final AulaRepository aulaRepository;
    private final CursoRepository cursoRepository;

    // Constructor con inyección de dependencias
    public AsignarService(AsignarRepository asignarRepository, AulaRepository aulaRepository,
            CursoRepository cursoRepository) {
        this.asignarRepository = asignarRepository;
        this.aulaRepository = aulaRepository;
        this.cursoRepository = cursoRepository;
    }

    public AsignarModel guardar(AsignacionDTO asignar) {
        // Verificar si el Aula existe por su código
        AulaModel aula = aulaRepository.findById(asignar.getCodigoAula()).orElse(null);
        //System.out.println(aula != null ? aula.toString() : "Aula no encontrada");

        // Verificar si el Curso existe por su sigla
        CursoModel curso = cursoRepository.findById(asignar.getSiglaCurso()).orElse(null);
        //System.out.println(curso != null ? curso.toString() : "Curso no encontrado");

        // Validación si cualquiera de los dos es null
        if (curso == null || aula == null) {
            return null; // Si alguno de los dos es null, no se puede crear la asignación
        } else {
            // Crear el objeto de asignación
            AsignarModel asignacion = new AsignarModel( curso, aula, asignar.getDia(),
                    asignar.getHora(), asignar.getDuracion());

            // Guardar la asignación en la base de datos
            return asignarRepository.save(asignacion);
        }
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
            // Verificar si el Aula existe
            Optional<AulaModel> aula = aulaRepository.findById(asignar.getAula().getCodigo());
            if (!aula.isPresent()) {
                throw new RuntimeException("Aula no encontrada con el código: " + asignar.getAula().getCodigo());
            }

            // Verificar si el Curso existe
            Optional<CursoModel> curso = cursoRepository.findById(asignar.getCurso().getSigla());
            if (!curso.isPresent()) {
                throw new RuntimeException("Curso no encontrado con el ID: " + asignar.getCurso().getSigla());
            }

            // Establecer las entidades encontradas en el AsignarModel
            asignar.setAula(aula.get());
            asignar.setCurso(curso.get());

            return asignarRepository.save(asignar);
        } else {
            throw new RuntimeException("Id de asignación no encontrado con ID: " + asignar.getId());
        }
    }
}
