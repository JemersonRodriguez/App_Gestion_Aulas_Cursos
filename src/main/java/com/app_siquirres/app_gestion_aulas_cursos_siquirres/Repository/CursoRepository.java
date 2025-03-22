package com.app_siquirres.app_gestion_aulas_cursos_siquirres.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app_siquirres.app_gestion_aulas_cursos_siquirres.Model.CursoModel;

public interface CursoRepository extends JpaRepository<CursoModel,String> {
    //Se heredan todas las consultas CRUD con las que se podra interactual con la infraestrucutura en este caso Mysql
}
