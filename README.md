# Proyecto Final del Curso de Desarrollo Basado en Plataformas

## **Nombre del Proyecto** 
**Sistema Acádemico +**

##  **Integrantes** 
| Nombre            | Código de Alumno    |
|-------------------|---------------------|
| Luciano Aguirre   | 202220401           |
| Bihonda Epiquién  | 202110103           |
| Paolo Medrano     | 202210206           |
| Sofía Salazar     | 202110103           |

## **Introducción**
Mediante este proyecto se pretende mejorar el sistema académico de UTEC mediante el desarrollo de un software que pueda gestionar y organizar cursos, secciones, grabaciones de clases, horarios, calificaciones y otros aspectos del proceso académico. Creemos que la experiencia de usuario de la plataforma actual presenta ciertos aspectos que representan parcialmente un problema tanto para estudiantes como profesores. 
Nuestra propuesta es realizar las siguientes mejoras en la plataforma siguiendo estos aspectos:
1. Diseño de Interfaz 
2. Accesibilidad 
3. UI & UX
4. https://conference.utec.edu.pe fusionado con sistema académico en una sola web.
Todo esto con el objetivo de beneficiar a todos los usuarios que usan diariamente la plataforma.


## **Demostración en Vivo**
La demostración en vivo constó de una presentación dividida en 5 partes:
- Introducción al proyecto.
- Entidades solicitadas.
- Diagrama de la base de datos.
- Arquitectura utilizada
- Código Backend con/sin demo security implementado.
- Código Frontend
- [CLICK AQUÍ PARA VER PRESENTACIÓN ](https://www.canva.com/design/DAFyf8ViidQ/mK1aNLCXbcwzwg22xjn1zA/edit?utm_content=DAFyf8ViidQ&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

## **Explicación del Diseño**
### *Backend*
5 entidades mínimas solicitadas : 
- Course 
- Student 
- Section 
- Session 
- Teacher 
#### *Configuración de archivos*
```
Server
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── demo_p  (🌟Alta Importancia🌟)
|   |   |               └── controller
|   |   |               |   └── CourseController.java
|   |   |               |   └── RootController.java
|   |   |               |   └── SectionController.java
|   |   |               |   └── SessionController.java
|   |   |               |   └── StudentCpontroller.java
|   |   |               |   └── TeacherController.java
|   |   |               └── model
|   |   |               |   └── Course.java
|   |   |               |   └── Section.java
|   |   |               |   └── Session.java
|   |   |               |   └── Student.java
|   |   |               |   └── Teacher.java
|   |   |               └── repository
|   |   |               |   └── CourseRepository.java
|   |   |               |   └── SectionRepository.java
|   |   |               |   └── SessionRepository.java
|   |   |               |   └── StudentRepository.java
|   |   |               |   └── TeacherRepository.java
│   │   │               └── service  
|   |   |                   └── course
|   |   |                   |   └── CourseSearchService.java
|   |   |                   |   └── CourseService.java
|   |   |                   |   └── CourseValidationService.java
|   |   |                   └── section
|   |   |                   |   └── SectionService.java
|   |   |                   └── session
|   |   |                   |   └── SessionService.java
|   |   |                   └── student
|   |   |                   |   └── StudentService.java
|   |   |                   |   └── StudentValidationService.java
|   |   |                   └── teacher
|   |   |                         └── TeacherService.java
|   |   |                         └── TeacherValidationService.java
│   │   └── resources
│   │       └── application.properties  (🌟Alta Importancia🌟: Configuraciones de la aplicación)
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── demo
│                       └── DemoApplicationTests.java  (Pruebas unitarias)
```
### **Controllers**
#### CourseController
El archivo `CourseController.java` es un controlador de Spring Boot que facilita la obtención, adición y eliminación de cursos y sus secciones a través del manejo de solicitudes HTTP relacionadas con los cursos. 
A continuación, describimos los métodos y sus respectivas funcionalidades:

- `courses()`: Este método maneja una solicitud GET al endpoint "/course". Recupera y devuelve una lista de todos los cursos utilizando el método `getAllCourses()` de la clase `CourseService`.

- `course_id(Long id)`: Este método maneja una solicitud GET al endpoint "/course/{id}". Recupera y devuelve el curso con el ID especificado utilizando el método `getCourseById(Long id)` de la clase `CourseService`.

- `sections(Long id)`: Este método maneja una solicitud GET al endpoint "/course/section/{id}". Recupera y devuelve una lista de secciones asociadas al curso especificado por su ID, utilizando el método `getSectionsByCourse(Long id)` de la clase `CourseService`.

- `postCourses(Course course)`: Este método maneja una solicitud POST al endpoint "/course". Permite la adición de un nuevo curso invocando el método `postCourse(Course course)` de la clase `CourseService`.

- `deleteCourse_id(Long id)`: Este método maneja una solicitud DELETE al endpoint "/course/{id}". Elimina el curso con el ID especificado utilizando el método `deleteCourse(Long id)` de la clase `CourseService`.


#### Section Controller

El archivo `SectionController.java` es un controlador de Spring Boot que gestiona las solicitudes HTTP relacionadas con las secciones proporciona funcionalidades para recuperar, agregar y eliminar secciones y sus estudiantes. A continuación, se detallan las funcionalidades de los métodos en el archivo `SectionController.java`:

- `sections()`: Este método maneja una solicitud GET al endpoint "/sección" y devuelve una lista de todas las secciones utilizando el método `getAllSections()` de la clase `SectionService`.

- `section(Long id)`: Este método maneja una solicitud GET al endpoint "/section/{id}" y devuelve la sección con el ID especificado utilizando el método `getSectionById(Long id)` de la clase `SectionService`.

- `groups(Long id)`: Este método maneja una solicitud GET al endpoint "/section/students/{id}" y devuelve una lista de estudiantes para la sección con el ID especificado utilizando el método `getStudentsBySection(Long id)` de la clase `SectionService`.

- `Section(Section section)`: Este método maneja una solicitud POST al endpoint "/sección" y agrega una nueva sección utilizando el método `postSection(Section section)` de la clase `SectionService`.

- `deleteSection_id(Long id)`: Este método maneja una solicitud DELETE al endpoint "/section/{id}" y elimina la sección con el ID especificado utilizando el método `deleteSection(Long id)` de la clase `SectionService`.

#### Session Controller
El archivo `SessionController.java` es un controlador de Spring Boot que maneja las solicitudes HTTP para recuperar, agregar y eliminar sesiones, así como sus secciones y profesores asociados. A continuación, se describen las funcionalidades de los métodos en el archivo `SessionController.java`:

- `sessions()`: Este método maneja una solicitud GET al endpoint "/session" y devuelve una lista de todas las sesiones utilizando el método `getAllSessions()` de la clase `SessionService`.

- `session(Long id)`: Este método maneja una solicitud GET al endpoint "/session/{id}" y devuelve la sesión con el ID especificado utilizando el método `getSessionById(Long id)` de la clase `SessionService`.

- `section(Long id)`: Este método maneja una solicitud GET al endpoint "/session/{id}/section/" y devuelve la sección correspondiente a la sesión con el ID especificado utilizando el método `getSectionById(Long id)` de la clase `SessionService`.

- `teacher(Long id)`: Este método maneja una solicitud GET al endpoint "/session/{id}/teacher/" y devuelve el profesor asociado a la sesión con el ID especificado utilizando el método `getTeacherById(Long id)` de la clase `SessionService`.

- `Session(Session session)`: Este método maneja una solicitud POST al endpoint "/session" y agrega una nueva sesión utilizando el método `newSession(Session session)` de la clase `SessionService`.

- `DeleteSession(Long id)`: Este método maneja una solicitud DELETE al endpoint "/session/{id}" y elimina la sesión con el ID especificado utilizando el método `deleteSessionByID(Long id)` de la clase `SessionService`.

#### Student Controller
El archivo `StudentController.java` es un controlador de Spring Boot encargado de gestionar las solicitudes HTTP para recuperar, agregar y eliminar estudiantes, así como para gestionar sus secciones.A continuación, se detallan las funcionalidades de los métodos en el archivo `StudentController.java`:

- `students()`: Este método maneja una solicitud GET al endpoint "/student" y devuelve una lista de todos los estudiantes utilizando el método `getAllStudents()` de la clase `StudentService`.

- `student(Long id)`: Este método maneja una solicitud GET al endpoint "/student/{id}" y devuelve al estudiante con la ID especificada utilizando el método `getStudentById(Long id)` de la clase `StudentService`.

- `studentEmail(String email)`: Este método maneja una solicitud GET al endpoint "/student/email/{email}" y devuelve al estudiante con el correo electrónico especificado utilizando el método `getStudentByEmail(String email)` de la clase `StudentService`.

- `section(Long id)`: Este método maneja una solicitud GET al endpoint "/student/section/{id}" y devuelve una lista de secciones para el estudiante con la ID especificada utilizando el método `getSectionsByStudent(Long id)` de la clase `StudentService`.

- `Student(Student student)`: Este método maneja una solicitud POST al endpoint "/student" y agrega un nuevo estudiante utilizando el método `postStudent(Student student)` de la clase `StudentService`.

- `deleteStudent_id(Long id)`: Este método maneja una solicitud DELETE al endpoint "/student/{id}" y elimina al estudiante con la ID especificada utilizando el método `deleteStudent(Long id)` de la clase `StudentService`.

#### Teacher Controller
El archivo `TeacherController.java` es un controlador de Spring Boot encargado de gestionar las solicitudes HTTP para  recuperar, agregar y eliminar profesores, así como para gestionar las sesiones relacionadas con ellos. A continuación, se describen las funcionalidades de los métodos en el archivo `TeacherController.java`:

- `teachers()`: Este método maneja una solicitud GET al endpoint "/teacher" y devuelve una lista de todos los profesores utilizando el método `getAllTeachers()` de la clase `TeacherService`.

- `teacher(Long id)`: Este método maneja una solicitud GET al endpoint "/teacher/{id}" y devuelve al profesor con la ID especificada utilizando el método `getTeacherById(Long id)` de la clase `TeacherService`.

- `teacherEmail(String email)`: Este método maneja una solicitud GET al endpoint "/teacher/email/{email}" y devuelve al profesor con el correo electrónico especificado utilizando el método `getTeacherByEmail(String email)` de la clase `TeacherService`.

- `sessionsOfTeacher(Long id)`: Este método maneja una solicitud GET al endpoint "/teacher/session/{id}" y devuelve una lista de sesiones para el profesor con el ID especificado utilizando el método `getSessionsByTeacher(Long id)` de la clase `TeacherService`.

- `newTeacher(Teacher teacher)`: Este método maneja una solicitud POST al endpoint "/teacher" y agrega un nuevo profesor utilizando el método `newTeacher(Teacher teacher)` de la clase `TeacherService`.

- `deleteTeacher(Long id)`: Este método maneja una solicitud DELETE al endpoint "/teacher/{id}" y elimina al profesor con la ID especificada utilizando el método `deleteTeacher(Long id)` de la clase `TeacherService`. 
### **Model**

#### Course
El archivo `Course.java` es una clase modelo que define la estructura de la entidad Curso en la aplicación del servidor. Aquí se detallan los atributos de la entidad Curso:

- `id: Long`
- `name: String`
- `sections: List<Section>`
- `area: String`
- `programm: String`

La anotación `@Entity` indica que esta clase es una entidad JPA, y la anotación `@Table(name = "course")` especifica el nombre de la tabla de la base de datos que corresponde a esta entidad. La anotación `@Id` indica que el atributo `id` es la clave primaria de la entidad, y la anotación `@GeneratedValue(strategy = GenerationType.IDENTITY)` especifica que los valores de clave primaria son generados por la base de datos. La anotación `@OneToMany(mappedBy = "course")` especifica que el atributo `sections` establece una relación uno a muchos con la entidad Section, y el atributo `mappedBy` indica que el atributo `course` en la entidad Section es el lado propietario de la relación.
#### Section 
El archivo `Section.java` es una clase de modelo que define la estructura de la entidad Section en la aplicación del servidor, incluyendo sus atributos y relaciones con otras entidades.

Aquí se detallan los atributos de la entidad Section:

- `id: Long`
- `course: Course`
- `students: List<Student>`

La anotación `@Entity` indica que esta clase es una entidad JPA. La anotación `@Table(name = "section")` especifica el nombre de la tabla de la base de datos que corresponde a esta entidad.
La anotación `@Id` indica que el atributo `id` es la clave primaria de la entidad. La anotación `@GeneratedValue(strategy = GenerationType.IDENTITY)` especifica que los valores de clave primaria son generados por la base de datos. La anotación `@ManyToOne` especifica que el atributo `course` establece una relación de muchos a uno con la entidad `Course`. La anotación `@JoinColumn(name = "course_id")` especifica el nombre de la columna de clave foránea en la tabla de la base de datos. La anotación `@ManyToMany` especifica que el atributo `students` establece una relación de muchos a muchos con la entidad `Student`.El atributo `fetch = FetchType.LAZY` especifica que no debe cargarse desde la base de datos hasta que se solicite explícitamente.
#### Session 
El archivo `Session.java`es una clase modelo que define la estructura de la entidad Session en la aplicación del servidor e incluye los siguientes atributos:

- `id`: Long
- `initialHour`: String
- `finalHour`: String
- `modality`: String
- `link`: String
- `classroom`: String
- `state`: String
- `section_code`: Sección Entity
- `teacher_code`: Teacher Entity

La anotación `@Entity` designa esta clase como una entidad JPA. La anotación `@Table(name = "session")` especifica el nombre de la tabla de la base de datos que corresponde a esta entidad.
La anotación `@Id` indica que el atributo `id` es la clave principal de la entidad.La anotación `@GeneratedValue(strategy = GenerationType.AUTO)` especifica que los valores de la clave principal se generan automáticamente. La anotación `@Column` se utiliza para especificar el nombre de la columna de la base de datos que corresponde a cada atributo. La anotación `@ManyToOne` establece relaciones de muchos a uno entre los atributos `section` y `teacher` con las entidades `Sección` y `Profesor`, respectivamente. La anotación `@JoinColumn` especifica el nombre de la columna de clave externa en la tabla de la base de datos.
#### Student 
El archivo Student.java es una clase modelo que define la estructura de la entidad Student en la aplicación del servidor e incluye los siguientes atributos:
- `id`: Long
- `name`: String
- `dni`: String
- `BornDate`: Date
- `email`: String
- `adress`: String
- `phone`: String
- `carreer`: String
- `avatarUrl`: String
- `sections`: List<`Section`>

La anotación `@Entity` indica que esta clase es una entidad JPA, y la anotación `@Table(name = "students")` especifica el nombre de la tabla de la base de datos que corresponde a esta entidad. La anotación `@Id` indica que el atributo `id` es la clave primaria de la entidad, y la anotación `@Column` especifica el nombre de la columna de la base de datos que corresponde al atributo. La anotación `@ManyToMany` especifica que el atributo `sections` es una relación de muchos a muchos con la entidad `Section`, y el atributo `mappedBy` especifica el lado inverso de la relación.
#### Teacher 
El archivo Teacher.java es una clase modelo que define la estructura de la entidad Teacher en la aplicación del servidor e incluye los siguientes atributos:
- `id: Long `
- `name: String`
- `dni: String`
- `email: String`
- `photo: String`
- `sessions: List<Session>`
- `avatarUrl: String`

La anotación `@Entity` indica que esta clase es una entidad JPA, y la anotación `@Table(name = "teacher")` especifica el nombre de la tabla de la base de datos que corresponde a esta entidad. La anotación `@Id` indica que el atributo `id` es la clave primaria de la entidad, y la anotación `@Column` especifica el nombre de la columna de la base de datos que corresponde al atributo. La anotación `@OneToMany` especifica que el atributo `sessions` es una relación de uno a muchos con la entidad `Session`, y el atributo `mappedBy` especifica el lado inverso de la relación.
### **Repository**
#### CourseRepository

El archivo `CourseRepository.java` es una interfaz que extiende la interfaz JpaRepository, proporciona una forma conveniente de interactuar con la entidad Course en la base de datos a través de Spring Data JPA. La interfaz CourseRepository también define métodos para consultar la entidad del curso en función de atributos específicos como área, programa y nombre.
Estos son los métodos definidos en la interfaz CourseRepository:

- `List<Course> findByArea(String area)`: Este método devuelve una lista de cursos que coinciden con el área especificada.
- `List<Course> findByProgramm(String program)`: este método devuelve una lista de cursos que coinciden con el programa especificado.
- `List<Course> findByName(String name)`: este método devuelve una lista de cursos que coinciden con el nombre especificado.
- `int countByName(String name)`: este método devuelve la cantidad de cursos que coinciden con el nombre especificado.
#### SectionRepository
El archivo `SectionRepository.java` es una interfaz que extiende la interfaz JpaRepository, que es una interfaz Spring Data JPA que proporciona una manera conveniente de interactuar con la entidad Sección en la base de datos a través de Spring Data JPA.

Aquí está el método definido en la interfaz SectionRepository:

- ` public interface SectionRepository extends JpaRepository<Section, Long> {}`: Este método extiende la interfaz JpaRepository y especifica la entidad Section y el tipo de su clave principal.
#### SessionRepository
El archivo `SessionRepository.java` es una interfaz que extiende la interfaz JpaRepository, que es una interfaz Spring Data JPA que proporciona una forma conveniente de interactuar con la entidad Session en la base de datos a través de Spring Data JPA.
Aquí está el método definido en la interfaz SessionRepository:
- `public interface SessionRepository extends JpaRepository<Session, Long> {} `: Este método extiende la interfaz JpaRepository y especifica la entidad de sesión y el tipo de su clave principal.
#### StudentRepository
El archivo `StudentRepository.java` es una interfaz que extiende la interfaz JpaRepository, que es una interfaz Spring Data JPA que proporciona una forma conveniente de interactuar con la entidad Student en la base de datos a través de Spring Data JPA.
Aquí está el método definido en la interfaz StudentRepository:
- `Optional<Student> findByEmail(String email)`: Este método se utiliza para encontrar un estudiante por su correo electrónico. Devuelve un objeto que puede contener o no al estudiante con el correo electrónico proporcionado.
#### TeacherRepository
El archivo `TeacherRepository.java` es una interfaz que extiende la interfaz JpaRepository, que es una interfaz Spring Data JPA que proporciona una forma conveniente de interactuar con la entidad Teacher en la base de datos a través de Spring Data JPA.
Aquí está el método definido en la interfaz TeacherRepository:
- `Optional<Teacher> findByEmail(String email)`: Es un método personalizado para encontrar un profesor por correo electrónico.
### **Service**
#### Course
##### CourseSearchService
El archivo `CourseSearchService` facilita la búsqueda de cursos en una aplicación Spring, y otros componentes pueden utilizar sus métodos para acceder a los datos de cursos de manera eficiente.

- La anotación `@Service` indica que esta clase es un servicio manejado por Spring.

- La anotación `@Autowired` se utiliza para inyectar una instancia de `CourseRepository`, que se utiliza para acceder a la base de datos.

- `CourseRepository` es una interfaz que define métodos para interactuar con los datos de cursos en la base de datos.

- `searchCoursesByName(String name)`: Este método busca cursos por nombre y devuelve una lista de cursos con ese nombre.

- `searchCoursesByArea(String area)`:Este método busca cursos por área y devuelve una lista de cursos en esa área.

- ` searchCoursesByProgram(String program)`:Este método busca cursos por programa y devuelve una lista de cursos en ese programa.
##### CourseValidationService
El archivo `CourseValidationService` proporciona una forma sencilla de validar los datos de los cursos antes de que se guarden en la base de datos. Ayuda a garantizar que los nombres de los cursos sean únicos y cumplan con ciertos requisitos, como comenzar con dos letras mayúsculas. Esto contribuye a mantener la integridad de los datos en la base de datos. Utiliza la interfaz `CourseRepository` para llevar a cabo operaciones en la base de datos.

- `@Service` marca la clase como un servicio Spring, lo que permite que Spring la detecte y la instancie automáticamente.

- `@Autowired` se utiliza para inyectar la instancia de `CourseRepository` en la clase. Esto permite que la clase realice operaciones en la base de datos.
- `isCourseNameUnique(String name)` verifica si un nombre de curso es único contando el número de cursos con el mismo nombre en la base de datos.
- `isCourseNameValid(String name)` comprueba si un nombre de curso es válido. Para ser válido, el nombre debe comenzar con dos letras mayúsculas y también debe ser único en la base de datos. Si el nombre no es válido, el método devuelve `false`.

##### CourseService
El archivo `CourseService` proporciona métodos para gestionar cursos en una aplicación Spring, incluyendo la recuperación, creación y eliminación de cursos, y valida los datos de los cursos antes de operar en la base de datos.

- `@Service` marca la clase como un servicio Spring, lo que permite que Spring la detecte y la instancie automáticamente.
- `@Autowired` se utiliza para inyectar las instancias de `CourseRepository` y `CourseValidationService` en la clase. Esto permite que la clase realice operaciones en la base de datos y valide los datos de los cursos.
- `getAllCourses()` recupera todos los cursos de la base de datos y los devuelve en una lista contenida en un objeto `ResponseEntity`.
- `getCourseById(@PathVariable Long id)` recupera un curso de la base de datos por su ID y lo devuelve en un objeto `ResponseEntity`.
- `getSectionsByCourse(@PathVariable Long id)` recupera todas las secciones asociadas a un curso por su ID y las devuelve en una lista contenida en un objeto `ResponseEntity`.
- El método `postCourse(@RequestBody Course course)` crea un nuevo curso en la base de datos y devuelve un objeto `ResponseEntity` con un código de estado y un mensaje que indica si la operación fue exitosa o no.
- El método `deleteCourse(@PathVariable Long id)` elimina un curso de la base de datos por su ID y devuelve un objeto `ResponseEntity` con un código de estado y un mensaje que indica si la operación fue exitosa o no.

#### Section
##### SectionService
El archivo `SectionService` proporciona una implementación básica de un servicio para gestionar secciones y estudiantes, con métodos para recuperar, crear y eliminar secciones, así como para recuperar estudiantes en una sección

- `SectionRepository` y `StudentRepository` son inyectados en el servicio utilizando `@Autowired`.

- `getAllSections()` recupera todas las secciones desde el repositorio y las devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK).

- `getSectionById()` recupera una sección por su ID desde el repositorio y la devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

- `getStudentsBySection()` recupera todos los estudiantes en una sección por su ID desde el repositorio y los devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si la sección existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

- `postSection()` crea una nueva sección con la información proporcionada en la solicitud y asigna estudiantes existentes a la sección. Devuelve un objeto `ResponseEntity` con un estado HTTP de 200 (OK) y un mensaje de éxito si la sección se crea con éxito, o un objeto `ResponseEntity` con un estado HTTP de 400 (BAD REQUEST) y un mensaje de error si alguno de los estudiantes solicitados no existe.

- El método `deleteSection()` elimina una sección por su ID desde el repositorio y devuelve un objeto `ResponseEntity` con un estado HTTP de 200 (OK) y un mensaje de éxito si la sección se elimina con éxito, o un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

#### Session
##### SessionService
 El archivo `SessionService` proporciona una implementación básica de un servicio para gestionar sesiones, con métodos para recuperar, crear y eliminar sesiones, así como para recuperar la sección y el profesor asociados a una sesión.

-  `getAllSessions()` recupera todas las sesiones desde el repositorio y las devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK).

-  `getSessionById()` recupera una sesión por su ID desde el repositorio y la devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

-  `getSectionById()` recupera la sección asociada a una sesión por su ID desde el repositorio y la devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si la sesión existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

- `getTeacherById()` recupera el profesor asociado a una sesión por su ID desde el repositorio y lo devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si la sesión existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

- `newSession()` crea una nueva sesión con la información proporcionada en la solicitud y la guarda en el repositorio. Devuelve un objeto `ResponseEntity` con un estado HTTP de 201 (CREATED) y un mensaje de éxito.

- `deleteSessionByID()` elimina una sesión por su ID desde el repositorio y devuelve un objeto `ResponseEntity` con un estado HTTP de 200 (OK) y un mensaje de éxito si la sesión se elimina con éxito, o un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

#### Student
##### StudentService
El archivo `StudentService`es un componente de servicio de Spring que proporciona una implementación básica de un servicio para gestionar estudiantes, con métodos para recuperar, crear y eliminar estudiantes, así como para recuperar las secciones a las que un estudiante está asignado. Además, se incluye validación de datos para garantizar la integridad de los datos del estudiante.

- Se realiza la inyección de `StudentRepository` en el servicio para permitir el acceso a las operaciones del repositorio relacionadas con estudiantes.

- También se realiza la inyección de `StudentValidationService` en el servicio para validar los datos de los estudiantes.
- `getAllStudents()` recupera todos los estudiantes desde el repositorio y los devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK).
-  `getStudentsById()` recupera un estudiante por su ID desde el repositorio y lo devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.
- `getStudentsByEmail()` recupera un estudiante por su correo electrónico desde el repositorio y lo devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.
-  `getSectionsByStudents()` recupera todas las secciones a las que un estudiante está asignado por su ID desde el repositorio y las devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si el estudiante existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.
-  `postStudent()` crea un nuevo estudiante con la información proporcionada en la solicitud y lo guarda en el repositorio. Devuelve un objeto `ResponseEntity` con un estado HTTP de 201 (CREATED) y un mensaje de éxito si el estudiante se crea con éxito, o un objeto `ResponseEntity` con un estado HTTP de 400 (BAD REQUEST) y un mensaje de error si alguno de los datos del estudiante es inválido.
- `deleteStudent()` elimina un estudiante por su ID desde el repositorio y devuelve un objeto `ResponseEntity` con un estado HTTP de 200 (OK) y un mensaje de éxito si el estudiante se elimina con éxito, o un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

##### StudentValidationService
El archivo  `StudentValidationService` proporciona una implementación básica de un servicio para validar datos de estudiantes. Los métodos de la clase se utilizan para validar el formato del correo electrónico, DNI, número de teléfono y nombre de un estudiante. Estas validaciones pueden ser útiles para garantizar que los datos del estudiante cumplan con ciertos estándares antes de ser almacenados o procesados en una aplicación.

- `StudentValidationService` está anotada con `@Service`, lo que indica que es un componente de servicio de Spring y puede ser gestionado por el contenedor de Spring.

- `isStudentEmailValid()` valida el formato del correo electrónico de un estudiante utilizando una expresión regular y devuelve un valor booleano que indica si el correo electrónico es válido o no.

-  `isStudentDNIValid()` valida el formato del DNI de un estudiante utilizando una expresión regular y devuelve un valor booleano que indica si el DNI es válido o no.

-  `isStudentPhoneValid()` valida el formato del número de teléfono de un estudiante utilizando una expresión regular y devuelve un valor booleano que indica si el número de teléfono es válido o no.
-  `isStudentNameValid()` valida el formato del nombre de un estudiante utilizando una expresión regular y devuelve un valor booleano que indica si el nombre es válido o no.

#### Teacher
##### TeacherService
 El archivo `TeacherService` proporciona una implementación básica de un servicio para gestionar profesores, con métodos para recuperar, crear y eliminar profesores, así como para validar los datos de los profesores, incluyendo el formato del correo electrónico, DNI y nombre. Está anotada con `@Service`, lo que indica que es un componente de servicio de Spring y puede ser gestionado por el contenedor de Spring.

- Inyecta `TeacherRepository`, lo que permite el acceso a las operaciones del repositorio relacionadas con profesores.

- Inyecta `TeacherValidationService` para validar los datos de los profesores.

-  `getAllTeachers()` recupera todos los profesores desde el repositorio y los devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK).

- `getTeacherById()` recupera un profesor por su ID desde el repositorio y lo devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

- `getTeachersByEmail()` recupera un profesor por su correo electrónico desde el repositorio y lo devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.
- `getSessionsByTeacher()` recupera todas las sesiones de un profesor por su ID desde el repositorio y las devuelve como un objeto `ResponseEntity` con un estado HTTP de 200 (OK) si el profesor existe, o como un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.

-  `newTeacher()` crea un nuevo profesor con la información proporcionada en la solicitud y lo guarda en el repositorio. Devuelve un objeto `ResponseEntity` con un estado HTTP de 201 (CREATED) y un mensaje de éxito si el profesor se crea con éxito, o un objeto `ResponseEntity` con un estado HTTP de 400 (BAD REQUEST) y un mensaje de error si alguno de los datos del profesor es inválido.

- `deleteTeacher()` elimina un profesor por su ID desde el repositorio y devuelve un objeto `ResponseEntity` con un estado HTTP de 200 (OK) y un mensaje de éxito si el profesor se elimina con éxito, o un objeto `ResponseEntity` con un estado HTTP de 404 (NOT FOUND) si no existe.


##### TeacherValidationService

El archivo `TeacherValidationService` proporciona una implementación básica de un servicio para validar datos de profesores. Los métodos de la clase se utilizan para validar el formato del correo electrónico, DNI y nombre de un profesor.

- `isTeacherEmailValid()` valida el formato del correo electrónico de un profesor utilizando una expresión regular y devuelve un valor booleano que indica si el correo electrónico es válido o no.

-  `isTeacherDNIValid()` valida el formato del DNI de un profesor utilizando una expresión regular y devuelve un valor booleano que indica si el DNI es válido o no.

- `isTeacherNameValid()` valida el formato del nombre de un profesor utilizando una expresión regular y devuelve un valor booleano que indica si el nombre es válido o no.
## Frontend
## *LoginComponent*
### Implementación de Seguridad con Google OAuth 2.0
Para la implementación de seguridad se ha utilizado el protocolo **OAuth 2.0**, un estándar de autenticación y autorización que permite a las aplicaciones obtener acceso a recursos protegidos en servidores. Mediante la restricción del acceso a la página de inicio de sesión a usuarios con un dominio de correo electrónico específico  y factor de autenticación para renderizar las rutas protegidas. 
### Loginpage.jsx
En el archivo llamado `Loginpage.jsx` se implementa la seguridad restringiendo el acceso a la página de inicio de sesión a usuarios con un dominio de correo electrónico específico. Para lograr esto, se utiliza la biblioteca `jwt-decode` para decodificar el JSON Web Token (JWT) devuelto por Google después de un inicio de sesión exitoso. Si el dominio no es 'utec.edu.pe', se muestra un mensaje emergente pidiendo al usuario que inicie sesión con una cuenta válida. Si el dominio es válido, el usuario es redirigido a la página '/oauth/login' utilizando el gancho `useNavigate` de la biblioteca `react-router-dom`.
### AuthRoutes.jsx
En el archivo llamado `AuthRoutes.jsx` se implementa la seguridad verificando si el usuario está autenticado antes de renderizar las rutas protegidas. Para lograr esto, se utiliza el gancho `useLocation` de la biblioteca `react-router-dom` para acceder al objeto de ubicación actual. El gancho `useState` se utiliza para administrar el estado de las credenciales del usuario. El gancho `useEffect` se utiliza para actualizar el estado de las credenciales del usuario cuando cambia el objeto de ubicación. El componente `AuthRoutes` verifica si existe el estado de las credenciales del usuario. Si no existe, el componente redirige al usuario a la página de inicio de sesión. Si existe, el componente renderiza las rutas protegidas utilizando el componente `Outlet` de `react-router-dom`.



#### *Configuración de archivos*
```
Client
├── src
│   ├── assets
|   |    └── dashboard-header.png
|   |    └── login-background.webp
|   |    └── mock-calendar.png
|   |    └── mock-payments.png
|   |    └── utec-logo.png
|   |    └── uteclogohorizontal.java
│   ├── components
|   |    ├── auth
|   |    |     └── AuthRoutes.jsx
|   |    └── dashboard
|   |         └── Header.jsx
|   |         └── Sidebar.jsx
|   |         └── SidebarButton.jsx
|   |         └── SidebarIcon.jsx
|   |         └── UserPanel.jsx
│   │       
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── demo
│                       └── DemoApplicationTests.java  (Pruebas unitarias)
```
## **Conclusiones y Aprendizajes**
Enumeración de las conclusiones más importantes y su relación con los conceptos del curso

## **Preguntas**
Respuestas a las posibles preguntas del jurado sobre el proyecto y su desarrollo
