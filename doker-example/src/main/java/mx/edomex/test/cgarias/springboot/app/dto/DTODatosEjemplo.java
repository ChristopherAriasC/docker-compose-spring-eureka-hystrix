/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edomex.test.cgarias.springboot.app.dto;

import org.springframework.stereotype.Component;

/**
 * Clase que contiene un mapeo de propiedades que 
 * pudiera llegar a tener un objeto.
 * 
 * @author cgarias
 * @since 17/01/2022
 */
@Component
public class DTODatosEjemplo {
    
    /**
     * Construuctor principal de la clase.
     */
    public DTODatosEjemplo(){};
    
    /**
     * Constructor secudario que puede llegar a tener una clase.
     * @param hello propiedad que contiene el objeto.
     */
    public DTODatosEjemplo(String hello){
        this.hello = hello;
    };
    /**
     * propiedad que define un saludo.
     */
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }   
}
