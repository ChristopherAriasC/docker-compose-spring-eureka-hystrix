/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edomex.test.cgarias.springboot.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mx.edomex.test.cgarias.springboot.app.dto.DTODatosEjemplo;
import mx.edomex.test.cgarias.springboot.app.service.RequestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase que contiene los ruteos rest para el consumo
 * de la api con contexto api-example.
 * 
 * @author cgarias
 * @since 17/01/2022
 */
@EnableHystrix
@RestController
@EnableSwagger2
@EnableCircuitBreaker
@RequestMapping("/api-example")
public class ControllerMapDE {
    
    /**
     * Inyeccion de dependencia para utilizar la clase service por medio del Qualifier
     */
    @Autowired
    @Qualifier("request")	
    private RequestInterface request;
    
    /**
     * Método de acceso principal a la api de /api-example contexto "/"
     * @return String cadena que contiene texto de caracteres (saludo).
     */
    @HystrixCommand
    @RequestMapping("/")
    public String homeDockerExample() {
      return "Hello from sprign on docker-example";
    }
    
    /**
     * Método definido como GET para
     * retornar un objeto Json como string
     * 
     * @param nombre Parametro que contiene una cadena de caracteres.
     * @return String cadena respuesta en este caso es un Json.
     */
    @HystrixCommand
    @RequestMapping(
            name = "GET-HOLA_NOMBRE",
            value = "/hola/{nombre}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public DTODatosEjemplo holaDockerExample(@PathVariable("nombre") String nombre) {
        return new DTODatosEjemplo(nombre+" from srping on docker-example");
    }
    
    /**
     * Método definido como POST para
     * retornar un objeto Json como string 
     * 
     * @param nombre Parametro que contiene una cadena de caracteres.
     * @param body Objecto que se recibe en el body, de un llamado post
     * @return String responde una cadena de caractes.
     */
    @HystrixCommand
    @RequestMapping(
            name = "POST-HOLA_NOMBRE",
            value = "/hola/{nombre}", 
            method = RequestMethod.POST
    )
    public String holaDockerExamplePost(@PathVariable("nombre") String nombre, @RequestBody String body) {
      return "Hello from sprign on docker-example body: "+body;
    }
    
    /**
     * Método que recibe un parameto por medio de GET y 
     * lo reenvia a otro servicio para su consumo, contiene
     * definido una respuesta estatica en caso de errro de 
     * comunicacion y realiza un corto de circuito por default
     * 6 segundo.
     * 
     * @param name parametro que contiene una cadena de caracteres.
     * @return DTODatosEjemplo objeto que contiene una 
     */
    @HystrixCommand(fallbackMethod = "fallBackRequesToOtherService")
    @RequestMapping(
            name = "COMUNICACION_NOMBRE",
            value = "/comunicacion-falback/{name}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public DTODatosEjemplo comunicacionFalback(@PathVariable("name") String name){        
        return request.requestNameActuator(name);
    }
    /**
     * Método definido para el caso de que el servicio al que se manda a llamar falle.
     * 
     * @param nombre parametro que contiene una cadena de caracteres.
     * @return DTODatosEjemplo objeto de respuesta para el cliente.
     */
    public DTODatosEjemplo fallBackRequesToOtherService(@PathVariable("nombre") String nombre){
        return new DTODatosEjemplo("THIS IS A FALLBACK RESPONSE");
    }
}
