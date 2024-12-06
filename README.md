# Consultorio Médico - Proyecto de Prueba Técnica

Este proyecto es una implementación de una aplicación de gestión de citas médicas, creada como parte de una prueba técnica para el puesto de **Java Backend Developer**. La aplicación está desarrollada usando **Spring Boot**, **JPA**, **Thymeleaf**, y **H2 Database**.

## Descripción

La aplicación permite gestionar las citas médicas de un consultorio, lo que incluye las siguientes funcionalidades:

- Creación, consulta de **Citas**.
- Validaciones para garantizar que las citas no se superpongan para un doctor o un consultorio.
- Interfaz de usuario básica para la creación y visualización de citas usando **Thymeleaf**.

## Tecnologías Utilizadas

- **Spring Boot** 3.x
- **Spring Data JPA** con **H2 Database**
- **Thymeleaf** para la renderización de la interfaz de usuario
- **MapStruct** para la conversión de objetos (DTOs a entidades y viceversa)
- **H2 Database** en memoria para pruebas (configurable para persistencia en disco)
- **Maven** como herramienta de construcción

## Requisitos

- **Java 17+**
- **Maven 3.8+**

## Instalación y Ejecución

### 1. Clona el repositorio

git clone https://github.com/AldairMontano/ConsultorioMedico.git
cd consultorio-medico

#### 2. Construye el proyecto

mvn clean install

### 3. Ejecuta la aplicación

mvn spring-boot:run
La aplicación se ejecutará en http://localhost:8080.

### 4. Accede a la Consola H2 (opcional)

http://localhost:8080/h2-console
Configura la conexión con los siguientes datos:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (vacío)

### 5. Interfaz de usuario
Accede a la interfaz de creación de citas en http://localhost:8080/citas/crear.
Visualiza las citas existentes en http://localhost:8080/citas/lista.
