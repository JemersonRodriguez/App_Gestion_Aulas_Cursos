package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Controller;

//import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;
//import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service.AulaService;

import org.springframework.ui.Model;



@Controller
@RequestMapping("view")
public class ViewController {

    private final AulaService aulaService;
    //Controller que retornara las vistas HTML

    public ViewController(AulaService aulaService) {
        this.aulaService = aulaService;
    }
    @GetMapping("/")
    public String rootView() {
        return "Inicio";
    }

    @GetMapping("/aulas")
    public String aulasView(Model model) {
        model.addAttribute("aula", new AulaModel());
        model.addAttribute("aulas", aulaService.listar());
        return "GestionAulas";
    }

    @GetMapping("/cursos")
    public String cursosView() {
        return "GestionCursos";
    }

    @GetMapping("/asignaciones")
    public String asignacionesView() {
        return "Asignaciones";
    }
    
    
}
