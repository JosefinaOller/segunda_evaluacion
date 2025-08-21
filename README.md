# 🏥 Gestión de Turnos Médicos

## 📌 Descripción del Proyecto

Este proyecto es una **aplicación Spring Boot** para la **gestión de turnos médicos**.
Permite:

* Registrar **pacientes** y **profesionales**.
* Crear, consultar y eliminar **turnos médicos**.
* Exponer funcionalidades a través de una **API RESTful**.

---

## ⚙️ Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3.5.4
* **Persistencia:** Spring Data JPA
* **Base de Datos:** H2 (en memoria con persistencia en archivo)
* **Build Tool:** Apache Maven

---

## ▶️ Cómo ejecutar la aplicación

### Requisitos previos

* JDK 17
* Maven

### Pasos

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/JosefinaOller/segunda_evaluacion.git
   cd evaluacion
   ```
2. Ejecutar la aplicación con Maven:

   ```bash
   mvn spring-boot:run
   ```
3. La aplicación se iniciará en el puerto **8080**.

---

## 🗄️ Acceso a la base de datos H2 Console

La aplicación utiliza **H2 Database** persistida en archivo.

1. Asegúrate de que la aplicación esté en ejecución.
2. Accede en tu navegador a:
   👉 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
3. Configura los siguientes datos:

   * **JDBC URL:** `jdbc:h2:file:./data/evaluaciondb`
   * **User Name:** `user`
   * **Password:** *(dejar en blanco)*

---
## 📝 Nota Final

Este proyecto fue desarrollado con el objetivo de poner en práctica mis conocimientos en
**Java, Spring Boot, JPA y el desarrollo de APIs RESTful**.

Dentro del desarrollo se aplicaron los siguientes conceptos:

* Arquitectura **MVC** en Spring Boot
* **Controladores REST** y endpoints HTTP
* **Manejo de rutas** y parámetros
* **Inyección de dependencias** con `@Autowired`
* **Manejo de errores** y validaciones
* Buenas prácticas de **estructuración de proyectos**

Forma parte de mi camino de aprendizaje y mejora continua como **Java Backend Developer**.
