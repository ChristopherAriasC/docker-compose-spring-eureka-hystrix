/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edomex.test.cgarias.springboot.app.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mx.edomex.test.cgarias.springboot.app.dto.DTODatosEjemplo;
import mx.edomex.test.cgarias.springboot.app.service.RequestInterface;
import static mx.edomex.test.cgarias.springboot.app.config.Config.URL_SERVICE_ACTUATOR;

/**
 * Clase que contiene la implementacion de los 
 * métodos de RequestInterface para su funcionalidad
 * 
 * @author cgarias
 * @since 17/01/2022
 */
@Scope("prototype")
@Service("request")
public class Request implements RequestInterface{
    private static final String METHOD_ACTUATOR_HOLA = URL_SERVICE_ACTUATOR+"/api-actuator/hola/";
    
    /**
     * Inyeccion de dependencia para hacer uso de un bean de configuracion que inicializa el RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Método que realiza el llamado al servicio 
     * externo al otro servicio por medio del resttemplate.
     * 
     * @param name propiedad que contiene una cadena de caracteres.
     * @return DTODatosEjemplo objeto que contiene el mapero del objeto respuesta del servicio a consumir.
     */
    @Override
    public DTODatosEjemplo requestNameActuator(String name) {
        return restTemplate.getForObject(METHOD_ACTUATOR_HOLA+name, DTODatosEjemplo.class);
    }
}
