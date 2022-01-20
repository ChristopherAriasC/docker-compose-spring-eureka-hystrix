package mx.edomex.test.cgarias.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Clase principal de arranque de aplicacion de Spring boot.
 *
 * @author cgarias
 * @since 17/01/2022
 */
//@EnableHystrixDashboard
//@EnableEurekaClient // no se requiere decalrar ya que el registro se realiza por medio de la config de Hystrix.
@SpringBootApplication
@EnableHystrix
public class ActuatorApplication {
    /***
     * Método Main de aplicación.
     * @param args propiedad arreglo que puede contner valore de manera string para arrancar el aplicativo.
     */
    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }
}
