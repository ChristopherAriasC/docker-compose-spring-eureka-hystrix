/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edomex.test.cgarias.springboot.app.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuración que contiene de manera declarativa
 * los métodos de configuracion que requiere el aplicativo
 * su funcionamineto correcto.
 * 
 * @author cgarias
 * @since 17/01/2022
 */
@Configuration
public class Config {
    
    public static final String URL_SERVICE_ACTUATOR = System.getenv("URL_SERVICE_ACTUATOR") != null ? System.getenv("URL_SERVICE_ACTUATOR"): "http://192.168.1.67:5001";
    
     /**
     * Propiedad que contiene la definicion del endpoint para exponer las metris para el dashboar de hystrix.
     */
    private static final String PATH_SERVLET_ACTUATOR_HYSTRIX = "/actuator/hystrix.stream";
    
    /**
     * Propieda que contiene el nombre del servlet ocupado para la esposicion de métricas para el dashboard hystrix.
     */
    private static final String NAME_SERVLET_HYSTRIX_STREM = "HystrixMetricsStreamServlet";
    
    /***
     * Definición de método de contexto configuración 
     * para exponer el Servlet de stadisticas hystrix.
     * 
     * @return ServletRegistrationBean Objeto registro de contexto en el proyecto "path"
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings(PATH_SERVLET_ACTUATOR_HYSTRIX);
        registrationBean.setName(NAME_SERVLET_HYSTRIX_STREM);
        return registrationBean;
    }
    
    /**
     * Método de configuracion para la creacion 
     * del objeto de RestTemlate
     * 
     * @return RestTemplate resttemplate.
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
