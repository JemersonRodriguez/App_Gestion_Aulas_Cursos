package com.app_siquirres.app_gestion_aulas_cursos_siquirres.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class WebConfig {
    
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
        FilterRegistrationBean<HiddenHttpMethodFilter> filterRegBean = new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
        filterRegBean.setOrder(1); // Asegura que el filtro se ejecute primero
        return filterRegBean;
    }
}
