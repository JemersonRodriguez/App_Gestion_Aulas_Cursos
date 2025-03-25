package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AsignarModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service.AsignarService;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.DTO.AsignacionDTO;

@RestController
@RequestMapping("/asignaciones")
public class AsignarController {

    private final AsignarService asignarService;

    // Constructor con inyección de dependencia del servicio
    public AsignarController(AsignarService asignarService) {
        this.asignarService = asignarService;
    }

    // Endpoint para crear una nueva asignación
    @PostMapping
    public ResponseEntity<AsignarModel> crearAsignacion(@RequestBody AsignacionDTO asignar) {
        System.out.println("Entre al controller");
        AsignarModel asignacionGuardada = asignarService.guardar(asignar);
        if (asignacionGuardada == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         } else {
            return new ResponseEntity<>(asignacionGuardada, HttpStatus.CREATED);
        }
    }

    // Endpoint para obtener todas las asignaciones
    @GetMapping
    public ResponseEntity<List<AsignarModel>> listarAsignaciones() {
        return new ResponseEntity<>(asignarService.listar(), HttpStatus.OK);
    }

    // Endpoint para obtener una asignación por ID
    @GetMapping("/{id}")
    public ResponseEntity<AsignarModel> obtenerAsignacion(@PathVariable Integer id) {
        return asignarService.buscar(id)
                .map(asignar -> new ResponseEntity<>(asignar, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para eliminar una asignación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Integer id) {
        asignarService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

