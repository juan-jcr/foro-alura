<h1 align="center">Challenge ONE | Back End | Foro Alura </h1>
<img align="right" alt="Coding" width="450" src="https://www.servicetonic.com/wp-content/uploads/2020/10/API-Interface-Servicetonic.png">

>
<p align="left">
 DESCRIPCIÓN
  
 ✅ Desafio del programa ONE-ORACLE NEXT EDUCATION  - Desarrollo de una API REST con Java y Spring Boot 3.0.

 ✅ El foro alura es un lugar donde todos los alumnos de la plataforma alura pueden colocar sus preguntas sobre determinados cursos, este mágico lugar está lleno de mucho aprendizaje y de colaboración entre alumnos, profesores y moderadores..

✅ Ese es nuestro desafío, vamos a replicar a nivel de back end este proceso, y para eso crearemos una API REST usando Spring Boot.

✅ Realizaremos CRUD (CREATE, READ, UPDATE, DELETE) y usaremos un framework de Java Spring Framework por ende diseñaremos con  
  ### arquitectura hexagonal

#### 📃Visita la página del Desafío [¡Haciendo clic aquí!](https://www.aluracursos.com/challenges/oracle-one-back-end/aluraforo) 


<p/>
<br>
<h2>Instalación📌</h2>
<br>
<h2>Funcionalidad 🔎</h2>
## Sample Valid JSON Request Bodys

##### <a id="signup">Sign Up -> /auth/sign-up</a>
```json
{
    "name":"Juan  Castañeda",
    "email":"prueba@gmail.com",
    "password":"password"
}
```

##### <a id="signin">Log In -> /auth/log-in</a>
```json
{
    "email":"prueba@gmail.com",
    "password":"password"
}
```
##### <a id="topicCreate">Create Topic -> /api/v1/topics/add</a>
```json
{
    "title": "Titulo Uno",
    "message": "Mensaje Uno",
    "course": "Curso Uno"
}
```
```json
//Response when creating topic
{
    "id": 1,
    "title": "Titulo Uno",
    "message": "Mensaje Uno",
    "dateOfCreation": "2024-11-16",
    "topicalStatus": true,
    "author": {
        "id": 1,
        "name": "Juan  Castañeda",
        "email": "prueba@gmail.com"
    },
    "course": "Curso Uno"
}
```
##### <a id="topicUpdate">Update Topic -> /api/v1/topics/update/1</a>

```json
{
    "title": "Titulo  Actualizado",
    "message": "Mensaje Uno",
    "course": "Curso Uno"
}
```
```json
//Response when updating topic
{
    "id": 1,
    "title": "Titulo Actualizado",
    "message": "Mensaje Uno",
    "dateOfCreation": "2024-11-16",
    "topicalStatus": true,
    "author": {
        "id": 1,
        "name": "Juan  Castañeda",
        "email": "prueba@gmail.com"
    },
    "course": "Curso Uno"
}
```



