# DOSW_LAB7_JJKCR

# 3. PREGUNTAS

## Estructura de Paquetes en Spring Boot

---

### 1. ¿Para qué sirve el paquete `Controller` en la estructura Spring Boot?

El paquete **Controller** es la capa de presentación o capa web de la aplicación. Su función principal es recibir las solicitudes HTTP entrantes (GET, POST, PUT, DELETE, etc.) desde el cliente, procesarlas y devolver una respuesta adecuada.

En Spring Boot, las clases dentro de este paquete se anotan con `@RestController` o `@Controller`. Son responsables de:

- Mapear las rutas URL a métodos específicos mediante anotaciones como `@GetMapping`, `@PostMapping`, `@PutMapping` y `@DeleteMapping`.
- Recibir parámetros de la petición (`@RequestParam`, `@PathVariable`, `@RequestBody`).
- Delegar la lógica de negocio a la capa de servicio.
- Retornar respuestas al cliente, generalmente en formato JSON o XML.

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }
}
```

---

### 2. ¿Para qué sirve el paquete `Service` en la estructura Spring Boot?

El paquete **Service** contiene la lógica de negocio de la aplicación. Actúa como intermediario entre la capa Controller y la capa Repository, garantizando la separación de responsabilidades.

Las clases en este paquete se anotan con `@Service` y son responsables de:

- Implementar las reglas de negocio de la aplicación.
- Coordinar las operaciones entre uno o más repositorios.
- Realizar validaciones, transformaciones y cálculos necesarios.
- Gestionar transacciones mediante `@Transactional`.
- Convertir entidades a DTOs y viceversa.

```java
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        return new UsuarioDTO(usuario);
    }
}
```

---

### 3. ¿Para qué sirve el paquete `Repository` en la estructura Spring Boot?

El paquete **Repository** es la capa de acceso a datos (DAL - Data Access Layer). Su responsabilidad es interactuar directamente con la base de datos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

En Spring Boot, las interfaces en este paquete generalmente extienden `JpaRepository`, `CrudRepository` o `PagingAndSortingRepository`, y se anotan con `@Repository`. Son responsables de:

- Proveer métodos predefinidos para operaciones básicas con la base de datos.
- Permitir la creación de consultas personalizadas mediante `@Query` o convenciones de nombres de métodos.
- Abstraer la lógica de persistencia del resto de la aplicación.
- Integrarse con JPA/Hibernate para el mapeo objeto-relacional.

```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.activo = true")
    List<Usuario> findAllActivos();
}
```

---

### 4. ¿Para qué sirve el paquete `Controller` en la estructura Spring Boot?

> *Nota: Esta pregunta es una repetición de la pregunta 1. Se amplía con información adicional sobre los tipos de controladores.*

Adicionalmente a lo mencionado, es importante diferenciar los dos tipos principales de controladores en Spring Boot:

- **`@Controller`**: Se utiliza en aplicaciones MVC tradicionales donde se retornan vistas (HTML, Thymeleaf, JSP). Requiere `@ResponseBody` en los métodos para retornar datos en lugar de vistas.

- **`@RestController`**: Es una combinación de `@Controller` y `@ResponseBody`. Se usa en APIs RESTful y retorna datos directamente en el cuerpo de la respuesta (generalmente JSON).

El paquete Controller también puede contener clases de manejo de excepciones globales usando `@ControllerAdvice` o `@RestControllerAdvice`, que capturan errores de toda la aplicación y devuelven respuestas coherentes al cliente.

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(ex.getMessage()));
    }
}
```

---

### 5. ¿Para qué sirve el paquete `Entity` en la estructura Spring Boot?

El paquete **Entity** (también llamado `model` o `domain`) contiene las clases que representan las tablas de la base de datos. Cada clase entidad se mapea directamente a una tabla en la base de datos relacional mediante JPA (Java Persistence API).

Las clases en este paquete se anotan con `@Entity` y son responsables de:

- Definir la estructura de los datos persistidos en la base de datos.
- Establecer relaciones entre tablas (`@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@OneToOne`).
- Configurar restricciones y validaciones a nivel de columna.
- Definir claves primarias (`@Id`) y estrategias de generación (`@GeneratedValue`).

```java
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nombre;

    private boolean activo;

    // Getters y Setters
}
```

---

### 6. ¿Para qué sirve el paquete `DTO` en la estructura Spring Boot?

El paquete **DTO** (Data Transfer Object) contiene clases que actúan como objetos de transferencia de datos entre las capas de la aplicación o entre el servidor y el cliente. Su propósito es desacoplar la representación interna de los datos (entidades) de la representación expuesta al exterior.

Las clases DTO son responsables de:

- Exponer únicamente los campos necesarios para cada operación, evitando exponer información sensible de las entidades.
- Reducir el número de llamadas remotas agrupando datos de múltiples fuentes.
- Adaptar la estructura de datos según las necesidades del cliente o de cada caso de uso.
- Prevenir problemas de serialización circular en relaciones bidireccionales entre entidades.

```java
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
    // No se incluye la contraseña ni datos sensibles

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.email = usuario.getEmail();
    }

    // Getters y Setters
}
```

---

### 7. ¿Para qué sirve el paquete `Exception` en la estructura Spring Boot?

El paquete **Exception** centraliza la definición y el manejo de excepciones personalizadas de la aplicación. Permite implementar un manejo de errores consistente y significativo a lo largo de todo el proyecto.

Las clases en este paquete son responsables de:

- Definir excepciones personalizadas que representan errores específicos del dominio de negocio.
- Proporcionar mensajes de error claros y códigos de estado HTTP apropiados.
- Centralizar el manejo de errores evitando la duplicación de código en los servicios y controladores.
- Facilitar el mantenimiento y la legibilidad del código relacionado con el manejo de errores.

```java
// Excepción personalizada
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

// Respuesta de error estandarizada
public class ErrorResponse {

    private String mensaje;
    private int codigo;
    private LocalDateTime timestamp;

    public ErrorResponse(String mensaje) {
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

    // Getters y Setters
}
```

---

## Bibliografía

Walls, C. (2022). *Spring Boot in action* (2nd ed.). Manning Publications.

Johnson, R., Hoeller, J., Donald, K., Sampaleanu, C., Harrop, R., Risberg, T., Arendsen, A., Davies, D., Kopylenko, D., Pollack, M., Templier, T., Vervaet, E., Tung, P., Hale, B., Colyer, A., Lewis, J., Leau, C., Fisher, M., Brannen, S., ... Webb, P. (2023). *Spring Framework documentation* (6.x). VMware Tanzu. https://docs.spring.io/spring-framework/docs/current/reference/html/

Pivotal Software. (2023). *Spring Boot reference documentation* (3.x). VMware Tanzu. https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/

Fowler, M. (2002). *Patterns of enterprise application architecture*. Addison-Wesley Professional.

Gamma, E., Helm, R., Johnson, R., & Vlissides, J. (1994). *Design patterns: Elements of reusable object-oriented software*. Addison-Wesley Professional.

Ambler, S. W. (2003). *Agile database techniques: Effective strategies for the agile software developer*. John Wiley & Sons.

Oracle Corporation. (2023). *Jakarta Persistence 3.1 specification*. Jakarta EE. https://jakarta.ee/specifications/persistence/3.1/
