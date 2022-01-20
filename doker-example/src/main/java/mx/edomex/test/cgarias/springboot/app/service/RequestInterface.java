/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edomex.test.cgarias.springboot.app.service;

import mx.edomex.test.cgarias.springboot.app.dto.DTODatosEjemplo;

/**
 * Interface que contiene la firma de los métodos 
 * a implementar en la clase de logica.
 * 
 * @author cgarias
 * @since 17/01/2022
 */
public interface RequestInterface {
    
    /**
     * Definicion de método de para realizar la consulta del servicio
     * para consultar datos al servicio de Actuator.
     * 
     * @param name propiedad que contiene una cadena de caracteres.
     * @return String respuesta de servicio independiente.
     */
    public DTODatosEjemplo requestNameActuator(String name);
}
