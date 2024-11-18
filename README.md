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
<h2>Configuración 📌</h2>

Sí no tiene Java 21 instalado y evitar configuraciones como requisito debe tener instalado 
Docker en la máquena local y seguir los siguientes pasos.

**1. Clonar la aplicación**

```bash
git clone https://github.com/juan-jcr/foro-alura.git
```

**2. Construir los servicios**
```bash
docker-compose build
```
**2. Iniciar los servicios**
````bash
docker-compose up
````


**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

<br>

<h2>Funcionalidad 🔎</h2>
 ## Explore Rest APIs

The app defines following CRUD APIs.

### Auth

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /auth/log-in     | Log in | [JSON](#signin) |
| POST   | /auth/sign-up    | Sign up| [JSON](#signup) |

### Tópicos

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/v1/topics/all | Get all topics | |
| GET    | /api/v1/topics/find/{id} | Get topic by id | |
| POST   | /api/v1/topics/add | Create new topic (By logged in user) | [JSON](#topicCreate) |
| PUT    | /api/v1/topics/update/{id} | Update topic by id| [JSON](#topicUpdate) |
| DELETE | /api/v1/topics/delete/{id} | Delete topic | |


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
### Response when creating topic
```json
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
    "title": "Titulo Actualizado",
    "message": "Mensaje Uno",
    "course": "Curso Uno"
}
```




