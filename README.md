# Proyecto que contiene el lebantamiento de un ambiente completo integrado con 2 servicios de ejemplo.

Este proyecto contiene las siguientes tecnologías. 

*- Docker-compose*
*- Docker*
*- Java*
*- Maven*
*- Spring-boot*
*- Spring-Cloud*
*- Eureka-server*
*- Histrix*
*- Turbine*

Comandos utilizados para realizar el lebantamiento del ejemplo:

-> git clone https://github.com/ChristopherAriasC/docker-compose-spring-eureka-hystrix.git

-> cd docker-compose-spring-eureka-hystrix

-> docker compose up -d

Con esto se levantan los servicios sobre docker y podemos acceder a ellos mediante las siguientes URLs:

# Servicio uno ejemplo:

http://localhost:5000/api-example/

http://localhost:5000/api-example/hola/MI-NOMBRE

http://localhost:5000/api-example/comunicacion-falback/miNombre


# Servicio dos ejemplo:

http://localhost:5001/api-actuator/hola/MI-NOMBRE

http://localhost:5001/api-actuator/

# Eureka Server

http://localhost:8761/

# Hystrix:

http://localhost:9000/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A9000%2Fturbine.stream%3Fcluster%3Ddefault&title=cluster


# Referencias

Proyecto integracion hystrix dashboard y turbine: https://stackabuse.com/spring-cloud-turbine/

Doctcumentación compatibilidad entre Spring cloud y spring boot:  https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-Hoxton-Release-Notes



