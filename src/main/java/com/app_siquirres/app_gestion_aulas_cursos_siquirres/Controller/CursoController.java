package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.CursoModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service.CursoService;

//import jakarta.websocket.server.PathParam;

import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/") //Se usa ModelAtributte por que es informacion de un form y esta no vija de la mmisma forma como un JSON que se recibiria normalmente con un @RequestBody
    public String crear(@ModelAttribute CursoModel curso) {
         cursoService.guardar(curso);
         return "redirect:/view/aulas";
    }

    @GetMapping("/")
    public List<CursoModel> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{sigla}")
    public CursoModel buscar(@PathVariable String sigla) {
        return cursoService.buscar(sigla);
    }

    @PutMapping("/{sigla}")
    public CursoModel actualizar(@RequestBody CursoModel curso , @PathVariable String sigla) {
        curso.setSigla(sigla);
        return cursoService.actualizar(curso);
    }

    @DeleteMapping("/{sigla}")
    public void eliminar(@PathVariable String sigla) {
        cursoService.eliminar(sigla);
    }
}
