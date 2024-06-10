# Define la imagen base de Java
FROM openjdk:latest
# Copia los archivos al contenedor
COPY ConversorRemoto.java .
COPY ConversorRemotoImpl.java .
COPY ServidorRMI.java .
COPY ClienteRMI.java .
# Compila los archivos Java
RUN javac *.java
# Expone el puerto utilizado por RMI
EXPOSE 3000
# Inicia el registro RMI y el servidor RMI al ejecutar el contenedor
CMD ["java", "ServidorRMI"]