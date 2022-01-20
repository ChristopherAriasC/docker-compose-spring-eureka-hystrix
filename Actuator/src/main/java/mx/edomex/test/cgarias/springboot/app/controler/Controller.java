/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edomex.test.cgarias.springboot.app.controler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que contiene las definicion de los accesos REST
 * de la aplicacion, esta pude dividirse por contextos
 * principales agregados  la clase.
 * 
 * @author cgarias
 * @since 17/01/2022
 */
@RestController(value = "api-actuator")
@EnableCircuitBreaker
@RequestMapping("/api-actuator")
public class Controller {

    /**
     * Método que define el contexto principal de la clase "/".
     * 
     * @return SZtring mensage de tipo String
     */
    @HystrixCommand
    @RequestMapping("/")
    public String helloSpringActuator() {
      return "Hello Srping actuator";
    }
    
    @HystrixCommand
    @RequestMapping(
            value = "/hola/{nombre}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public String ellowFromDockerObject(@PathVariable("nombre") String nombre) {
      return "{\"hello\":\""+nombre+" from Docker World\"}";
    }
}
