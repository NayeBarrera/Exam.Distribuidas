# Define la imagen base de Java
FROM openjdk:latest

# Crea un directorio para la aplicación
WORKDIR /app

# Copia los archivos Java al contenedor
COPY . /app

# Compila los archivos Java
RUN javac ConversorRemoto.java ConversorRemotoImpl.java ServidorRMI.java ClienteRMI.java

# Expone el puerto utilizado por RMI
EXPOSE 1099

# Inicia el servidor RMI al ejecutar el contenedor
CMD ["java", "ServidorRMI"]