package mx.edomex.test.cgarias.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque de aplicacion de Spring boot.
 *
 * @author cgarias
 * @since 17/01/2022
 */
@SpringBootApplication
public class DokerExampleApplication {
    /***
     * Método Main de aplicación.
     * @param args propiedad arreglo que puede contner valore de manera string para arrancar el aplicativo.
     */
    public static void main(String[] args) {
        SpringApplication.run(DokerExampleApplication.class, args);
    }
}
