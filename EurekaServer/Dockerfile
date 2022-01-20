# Fase de construcción
FROM maven:3.6.0-jdk-8 AS build

# Copiar código fuente y manifiesto pom.xml
WORKDIR /code
COPY src ./src
COPY pom.xml .

# Construir paquete
RUN mvn package;

# Fase de ejecución
FROM openjdk:8-alpine

ENV JAR_FILE_NAME EurekaServer-0.0.1-SNAPSHOT
ENV JAR_FILE $JAR_FILE_NAME.jar

USER root
RUN echo "America/Mexico_City" > /etc/timezone

COPY --from=build /code/target/$JAR_FILE .

EXPOSE 8761

# Se usa "sh -c" para sortear esta limitante: https://github.com/docker/docker/issues/5509 - variable not expanded
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar $JAR_FILE -id $JAR_FILE_NAME --redirect -output"]

