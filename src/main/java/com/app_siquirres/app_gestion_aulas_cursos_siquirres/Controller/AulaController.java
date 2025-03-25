package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam; || Para parametros opcionales
import org.springframework.web.bind.annotation.RestController;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service.AulaService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;


;

@Controller
@RequestMapping("/aula")
public class AulaController {
    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @PostMapping("/")
    public String crear(@ModelAttribute AulaModel aula) {
        aulaService.guardar(aula);
        return "redirect:/view/aulas";
    }

    @DeleteMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Integer codigo) {
        //System.out.println("Codigo para elminar" + codigo);
        aulaService.eliminar(codigo);
        return "redirect:/view/aulas";
    }

    @GetMapping("/")
    public String listar() {
        aulaService.listar();
        return "redirect:/view/aulas";
    }

    @PutMapping("/{codigo}")
    public AulaModel actualizar(@PathVariable Integer codigo, @RequestBody AulaModel aula) {
       aula.setCodigo(codigo);
       return aulaService.actualizar(aula);
    }

    @GetMapping("/{codigo}")
    public AulaModel buscar(@PathVariable Integer codigo) {
        return aulaService.buscar(codigo);
    }
}
