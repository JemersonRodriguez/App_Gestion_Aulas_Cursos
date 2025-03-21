package com.app_siquirres.app_gestion_aulas_cursos_siquirres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;;

@SpringBootApplication
public class AppGestionAulasCursosSiquirresApplication {

	public void saludo() {
		System.out.println("Hola desde el Server en Spring Boot");
	}

	public static void main(String[] args) {
		ApplicationContext contexto = SpringApplication.run(AppGestionAulasCursosSiquirresApplication.class, args);
		AppGestionAulasCursosSiquirresApplication app = contexto.getBean(AppGestionAulasCursosSiquirresApplication.class);
		app.saludo();
	}
}
