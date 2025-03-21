package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class View {
    //Controller que retornara las vistas HTML
    @GetMapping("/")
    public String endpoint_root() {
        return "Inicio";
    }
    
}
