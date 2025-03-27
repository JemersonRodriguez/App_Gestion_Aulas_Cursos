package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.CursoModel;
//import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.AulaModel;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service.AulaService;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Service.CursoService;

import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view")
public class ViewController {
    
    private final AulaService aulaService;
    private final CursoService cursoService;
    //Controller que retornara las vistas HTML
    public ViewController(AulaService aulaService , CursoService cursoService) {
        this.aulaService = aulaService;
        this.cursoService = cursoService;
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
    public String cursosView(Model model) {
        model.addAttribute("curso", new CursoModel());
        model.addAttribute("cursos", cursoService.listar());
        return "GestionCursos";
    }

    @GetMapping("/asignaciones")
    public String asignacionesView() {
        return "Asignaciones";
    }
    
    @GetMapping("/contacto")
    public String contactoView() {
        return "Contacto";
    }
}
