FROM openjdk:17
COPY "./target/ProyectoKarentDeportes-1.jar" "app.jar"
EXPOSE 8067
ENTRYPOINT ["java", "-jar", "app.jar"]