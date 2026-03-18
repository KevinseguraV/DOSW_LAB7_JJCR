<div align="center">

# 🏆 TECH-CUP

### Sistema de Gestión de Torneos de Fútbol

---

**Escuela Colombiana de Ingeniería Julio Garavito**  
Ingeniería de Sistemas — Desarrollo de Software (DOSW)

---

![Estado](https://img.shields.io/badge/Estado-En%20Desarrollo-blue?style=flat-square)
![Materia](https://img.shields.io/badge/Materia-DOSW-darkgreen?style=flat-square)
![Universidad](https://img.shields.io/badge/ECI-Julio%20Garavito-red?style=flat-square)
![Tecnología](https://img.shields.io/badge/Backend-Spring%20Boot-brightgreen?style=flat-square)
![Tecnología](https://img.shields.io/badge/Frontend-React%20+-blue?style=flat-square)
![Base de Datos](https://img.shields.io/badge/Database-PostgreSQL-316192?style=flat-square)

</div>

---

## 2. Requerimientos Funcionales

### 2.1 RF-001 — Crear Torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-001 |
| **Nombre** | Crear Torneo |
| **Descripción** | *El sistema debe permitir al organizador crear un nuevo torneo ingresando la información básica del mismo.* |
| **Precondiciones** | *El usuario debe estar autenticado y tener rol de Organizador asignado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al apartado de gestión de torneos.<br>2. El sistema muestra la opción "Crear torneo".<br>3. El organizador selecciona "Crear torneo".<br>4. El sistema despliega el formulario con los campos requeridos.<br>5. El organizador diligencia los datos del torneo y confirma.<br>6. El sistema valida que todos los campos obligatorios estén completos y cumplan las reglas.<br>7. El sistema crea el torneo en estado "Borrador" y muestra mensaje de confirmación. |

---

### 2.2 RF-002 — Iniciar Torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-002 |
| **Nombre** | Iniciar Torneo |
| **Descripción** | *El sistema debe permitir al organizador cambiar el estado de un torneo de "Activo" a "En progreso", dando inicio oficial al torneo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) El torneo debe estar en estado Activo.<br>3) Debe haber al menos 2 equipos inscritos con estado Aprobado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al torneo.<br>2. El organizador selecciona "Iniciar torneo".<br>3. El organizador confirma la acción.<br>4. El sistema cambia el estado del torneo a "En progreso". |

---

### 2.3 RF-003 — Finalizar Torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-003 |
| **Nombre** | Finalizar Torneo |
| **Descripción** | *El sistema debe permitir al organizador cambiar el estado de un torneo de "En progreso" a "Finalizado", cuando termine el torneo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) El torneo debe estar en estado "En progreso".* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al torneo en progreso.<br>2. El organizador selecciona "Finalizar torneo".<br>3. El organizador confirma la acción.<br>4. El sistema cambia el estado del torneo a "Finalizado". |

---

### 2.4 RF-004 — Consultar Torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-004 |
| **Nombre** | Consultar Torneo |
| **Descripción** | *El sistema debe permitir a cualquier usuario autenticado consultar la información de un torneo existente.* |
| **Precondiciones** | *El usuario debe estar autenticado en el sistema.* |
| **Actor** | *Todos los actores* |
| **Flujo principal** | 1. El usuario accede al módulo de torneos.<br>2. El sistema muestra la lista de torneos disponibles.<br>3. El usuario selecciona un torneo para ver su detalle.<br>4. El sistema muestra la información completa del torneo. |

---

### 2.5 RF-005 — Registrarse como Jugador

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-005 |
| **Nombre** | Registrarse como Jugador |
| **Descripción** | *El sistema debe permitir a estudiantes, graduados, profesores, personal administrativo y familiares registrarse en la plataforma como jugadores.* |
| **Precondiciones** | *El usuario no debe tener una cuenta antes en el sistema.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El usuario accede a la página de registro.<br>2. El usuario selecciona su tipo de vinculación.<br>3. El usuario ingresa sus datos personales.<br>4. El usuario confirma el registro.<br>5. El sistema crea la cuenta y notifica al usuario. |

---

### 2.6 RF-006 — Crear Perfil Jugador

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-006 |
| **Nombre** | Crear Perfil Jugador |
| **Descripción** | *El sistema debe permitir a un jugador registrado completar su perfil deportivo indicando sus posiciones de juego, número dorsal y foto.* |
| **Precondiciones** | *El usuario debe estar autenticado y registrado en el sistema (RF-005 completado).* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El jugador accede a su perfil.<br>2. El jugador selecciona "Completar perfil deportivo".<br>3. El jugador ingresa la información deportiva (posiciones de juego, número dorsal y foto).<br>4. El jugador confirma los datos ingresados.<br>5. El sistema guarda y muestra el perfil actualizado. |

---

### 2.7 RF-007 — Activar Disponibilidad

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-007 |
| **Nombre** | Activar Disponibilidad |
| **Descripción** | *El sistema debe permitir a un jugador indicar que está disponible para unirse a un equipo, permitiendo que los capitanes lo encuentren y contacten.* |
| **Precondiciones** | *1) El usuario debe estar autenticado.<br>2) Debe tener su perfil deportivo completo (RF-006).<br>3) No debe pertenecer a un equipo en el torneo activo.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El jugador accede a su perfil.<br>2. El jugador activa la opción de disponibilidad.<br>3. El sistema actualiza el estado del jugador como "Disponible". |

---

### 2.8 RF-008 — Gestionar Invitaciones de Equipos

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-008 |
| **Nombre** | Gestionar Invitaciones de Equipos |
| **Descripción** | *El sistema debe permitir a un jugador visualizar las invitaciones recibidas para unirse a un equipo y aceptarlas o rechazarlas.* |
| **Precondiciones** | *1) El usuario debe estar autenticado.<br>2) Debe tener al menos una invitación pendiente.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El jugador accede a su bandeja de invitaciones.<br>2. El sistema muestra las invitaciones pendientes.<br>3. El jugador selecciona aceptar o rechazar cada invitación.<br>4. El sistema actualiza el estado de la invitación y notifica al capitán. |

---

### 2.9 RF-009 — Crear Equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-009 |
| **Nombre** | Crear Equipo |
| **Descripción** | *El sistema debe permitir a un jugador registrado crear un equipo para participar en un torneo activo, convirtiéndose en capitán del mismo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado y tener perfil deportivo completo.<br>2) Debe existir al menos un torneo en estado "Activo".<br>3) El jugador no debe pertenecer a otro equipo en el mismo torneo.<br>4) El torneo no debe haber alcanzado la cantidad máxima de equipos.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar (asume rol de Capitán)* |
| **Flujo principal** | 1. El jugador accede al torneo activo.<br>2. El jugador selecciona "Crear equipo".<br>3. El jugador diligencia los datos del equipo.<br>4. El jugador confirma la creación.<br>5. El sistema registra al jugador como capitán del equipo. |

---

### 2.10 RF-010 — Invitar Jugadores al Equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-010 |
| **Nombre** | Invitar Jugadores al Equipo |
| **Descripción** | *El sistema debe permitir al capitán de un equipo enviar invitaciones a jugadores disponibles para que se unan a su equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) El equipo no debe haber alcanzado el máximo de 12 jugadores.<br>3) El torneo debe estar en estado "Activo".* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede a la gestión de su equipo.<br>2. El capitán busca jugadores disponibles.<br>3. El capitán selecciona un jugador y le envía una invitación.<br>4. El sistema registra y notifica la invitación al jugador. |

---

### 2.11 RF-011 — Buscar Jugadores

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-011 |
| **Nombre** | Buscar Jugadores |
| **Descripción** | *El sistema debe permitir a los capitanes buscar jugadores disponibles aplicando filtros por diferentes criterios para facilitar la conformación de su equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) Debe existir un torneo en estado "Activo".* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede al módulo de búsqueda de jugadores.<br>2. El capitán aplica los filtros deseados por los criterios disponibles.<br>3. El sistema muestra los resultados que coinciden con los filtros aplicados. |

---

### 2.12 RF-012 — Subir Comprobante de Pago

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-012 |
| **Nombre** | Subir Comprobante de Pago |
| **Descripción** | *El sistema debe permitir al capitán de un equipo subir el comprobante de pago de la inscripción al torneo para su posterior verificación por el organizador.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) El equipo debe tener mínimo 7 jugadores.<br>3) Más de la mitad de los miembros deben pertenecer a los programas elegibles.<br>4) El torneo debe estar en estado "Activo".<br>5) El equipo no debe tener un pago ya aprobado.* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede a la gestión de su equipo.<br>2. El capitán selecciona "Subir comprobante de pago".<br>3. El capitán adjunta el archivo del comprobante.<br>4. El capitán confirma la carga del archivo.<br>5. El sistema registra el comprobante en estado "Pendiente" y notifica al organizador. |

---

### 2.13 RF-013 — Verificar Pago

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-013 |
| **Nombre** | Verificar Pago |
| **Descripción** | *El sistema debe permitir al organizador revisar los comprobantes de pago subidos por los capitanes y aprobar o rechazar la inscripción del equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) Debe existir al menos un comprobante en estado "Pendiente".* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al módulo de pagos.<br>2. El sistema muestra los comprobantes pendientes de revisión.<br>3. El organizador revisa cada comprobante.<br>4. El organizador aprueba o rechaza la inscripción del equipo.<br>5. El sistema actualiza el estado del equipo según la decisión tomada. |

---

### 2.14 RF-014 — Configurar Torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-014 |
| **Nombre** | Configurar Torneo |
| **Descripción** | *El sistema debe permitir al organizador definir la configuración detallada del torneo incluyendo reglamento, fechas importantes, horarios, canchas y sanciones.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) El torneo debe existir y estar en estado "Borrador" o "Activo".* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al torneo creado.<br>2. El organizador selecciona "Configurar torneo".<br>3. El organizador diligencia las diferentes secciones de configuración (reglamento, fechas importantes, horarios, canchas y sanciones).<br>4. El sistema guarda la configuración ingresada. |

---

### 2.15 RF-015 — Registrar Resultado de Partido

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-015 |
| **Nombre** | Registrar Resultado de Partido |
| **Descripción** | *El sistema debe permitir al organizador registrar los resultados de un partido incluyendo marcador, goleadores, tarjetas amarillas y tarjetas rojas.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) Debe existir un partido programado que ya se haya disputado.<br>3) El torneo debe estar en estado "En progreso".<br>4) El partido no debe tener un resultado previamente registrado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al partido disputado.<br>2. El organizador selecciona "Registrar resultado".<br>3. El organizador ingresa el marcador del partido.<br>4. El organizador registra los goleadores del partido.<br>5. El organizador registra las tarjetas amarillas y rojas recibidas.<br>6. El organizador confirma el registro.<br>7. El sistema guarda el resultado y actualiza las estadísticas del torneo. |

---

### 2.16 RF-016 — Validar Equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-016 |
| **Nombre** | Validar Equipo |
| **Descripción** | *El sistema debe validar automáticamente que un equipo cumpla con las condiciones mínimas de participación: mínimo 7 jugadores, máximo 12, que ningún jugador pertenezca a dos equipos en el mismo torneo, y que más de la mitad de los integrantes sean de los programas objetivo.* |
| **Precondiciones** | *1) El equipo debe estar registrado en un torneo activo.<br>2) El torneo debe estar en estado "Activo".* |
| **Actor** | *Sistema (automático)* |
| **Flujo principal** | 1. El sistema detecta un evento que requiere validación del equipo (inscripción, carga de comprobante o inicio de torneo).<br>2. El sistema verifica que el equipo tenga entre 7 y 12 jugadores.<br>3. El sistema verifica que ningún jugador esté inscrito en otro equipo del mismo torneo.<br>4. El sistema verifica que más de la mitad de los integrantes pertenezcan a los programas objetivo.<br>5. Si todas las condiciones se cumplen, el sistema permite continuar con la operación.<br>6. Si alguna condición falla, el sistema bloquea la operación y notifica el motivo al capitán. |

---

### 2.17 RF-017 — Definir Alineación y Formación Táctica

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-017 |
| **Nombre** | Definir Alineación y Formación Táctica |
| **Descripción** | *El sistema debe permitir al capitán definir los jugadores titulares, reservas y la formación táctica del equipo antes de cada partido, con ubicación visual de los jugadores en la cancha.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) El torneo debe estar en estado "En progreso".<br>3) El equipo debe tener al menos 7 jugadores aprobados.* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede a la gestión de su equipo.<br>2. El capitán selecciona el partido para el cual desea definir la alineación.<br>3. El sistema muestra la interfaz visual de la cancha con los jugadores disponibles.<br>4. El capitán asigna los jugadores titulares y los ubica en su posición dentro de la cancha.<br>5. El capitán asigna los jugadores reservas.<br>6. El capitán selecciona la formación táctica del equipo.<br>7. El capitán confirma la alineación.<br>8. El sistema guarda la configuración para el partido. |

---

### 2.18 RF-018 — Registrar Resultado de Partido

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-018 |
| **Nombre** | Registrar Resultado de Partido |
| **Descripción** | *El sistema debe permitir al organizador registrar los resultados de un partido incluyendo marcador, goleadores, tarjetas amarillas y tarjetas rojas.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) Debe existir un partido programado que ya se haya disputado.<br>3) El torneo debe estar en estado "En progreso".<br>4) El partido no debe tener un resultado previamente registrado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al partido disputado.<br>2. El organizador selecciona "Registrar resultado".<br>3. El organizador ingresa el marcador del partido.<br>4. El organizador registra los goleadores del partido.<br>5. El organizador registra las tarjetas amarillas y rojas recibidas.<br>6. El organizador confirma el registro.<br>7. El sistema guarda el resultado y actualiza las estadísticas del torneo. |

---

### 2.19 RF-019 — Consultar Partidos Asignados

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-019 |
| **Nombre** | Consultar Partidos Asignados |
| **Descripción** | *El sistema debe permitir al árbitro consultar la información de los partidos que tiene asignados, incluyendo fecha, hora, cancha y equipos participantes.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Árbitro.<br>2) Debe tener al menos un partido asignado.* |
| **Actor** | *Árbitro* |
| **Flujo principal** | 1. El árbitro accede al módulo de sus partidos asignados.<br>2. El sistema muestra la lista de partidos asignados al árbitro.<br>3. El árbitro selecciona un partido para ver su detalle.<br>4. El sistema muestra la fecha, hora, cancha y equipos participantes del partido. |

---

### 2.20 RF-020 — Tabla de Posiciones

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-020 |
| **Nombre** | Tabla de Posiciones |
| **Descripción** | *El sistema debe calcular automáticamente la tabla de posiciones del torneo, incluyendo partidos jugados, ganados, empatados y perdidos, goles a favor, goles en contra, diferencia de gol y puntos de cada equipo.* |
| **Precondiciones** | *1) El torneo debe estar en estado "En progreso".<br>2) Debe existir al menos un resultado de partido registrado.* |
| **Actor** | *Sistema (automático)* |
| **Flujo principal** | 1. El sistema detecta el registro de un nuevo resultado de partido.<br>2. El sistema actualiza los partidos jugados, ganados, empatados y perdidos de cada equipo.<br>3. El sistema recalcula los goles a favor, goles en contra y diferencia de gol.<br>4. El sistema actualiza los puntos de cada equipo según el resultado.<br>5. El sistema reordena la tabla de posiciones según los criterios de clasificación.<br>6. La tabla actualizada queda disponible para consulta de todos los usuarios. |

---

### 2.21 RF-021 — Generar Llaves Eliminatorias

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-021 |
| **Nombre** | Generar Llaves Eliminatorias |
| **Descripción** | *El sistema debe generar automáticamente las llaves eliminatorias (cuartos de final, semifinal y final) una vez concluida la fase de grupos del torneo.* |
| **Precondiciones** | *1) El torneo debe estar en estado "En progreso".<br>2) La fase de grupos debe haber concluido con todos los resultados registrados.<br>3) Deben existir suficientes equipos clasificados para conformar las llaves.* |
| **Actor** | *Sistema (automático)* |
| **Flujo principal** | 1. El sistema detecta la finalización de la fase de grupos.<br>2. El sistema determina los equipos clasificados según la tabla de posiciones.<br>3. El sistema genera los enfrentamientos de cuartos de final según el orden de clasificación.<br>4. El sistema programa los partidos de semifinal en espera de los resultados de cuartos.<br>5. El sistema programa el partido de final en espera de los resultados de semifinal.<br>6. El sistema publica las llaves generadas y las deja disponibles para consulta de todos los usuarios. |

---

### 2.22 RF-022 — Consultar Estadísticas

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-022 |
| **Nombre** | Consultar Estadísticas |
| **Descripción** | *El sistema debe permitir consultar las estadísticas del torneo, incluyendo máximos goleadores, historial de partidos y resultados por equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado.<br>2) El torneo debe tener al menos un resultado de partido registrado.* |
| **Actor** | *Todos los actores* |
| **Flujo principal** | 1. El usuario accede al módulo de estadísticas del torneo.<br>2. El sistema muestra las opciones de consulta disponibles.<br>3. El usuario selecciona el tipo de estadística que desea consultar (máximos goleadores, historial de partidos o resultados por equipo).<br>4. El sistema recupera y muestra la información solicitada actualizada. |

---

### 2.23 RF-023 — Control de Roles

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-023 |
| **Nombre** | Control de Roles |
| **Descripción** | *El sistema debe implementar control de acceso basado en roles, garantizando que cada usuario solo pueda acceder y ejecutar las funcionalidades correspondientes a su rol asignado: Administrador, Organizador, Capitán, Jugador y Árbitro.* |
| **Precondiciones** | *1) El usuario debe estar autenticado en el sistema.<br>2) El usuario debe tener al menos un rol asignado.* |
| **Actor** | *Sistema (automático)* |
| **Flujo principal** | 1. El usuario se autentica en el sistema.<br>2. El sistema identifica el rol asignado al usuario.<br>3. El sistema habilita únicamente las funcionalidades y módulos correspondientes a dicho rol.<br>4. El usuario accede solo a las opciones permitidas según su rol.<br>5. El sistema bloquea y deniega cualquier intento de acceso a funcionalidades fuera del rol asignado. |

---

### 2.24 RF-024 — Auditoría

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-024 |
| **Nombre** | Auditoría |
| **Descripción** | *El sistema debe registrar automáticamente un log de las acciones relevantes realizadas por cada usuario, permitiendo trazabilidad y control sobre las operaciones ejecutadas en la plataforma.* |
| **Precondiciones** | *1) El usuario debe estar autenticado en el sistema.<br>2) El módulo de auditoría debe estar activo.* |
| **Actor** | *Sistema (automático)* |
| **Flujo principal** | 1. El usuario ejecuta una acción relevante dentro del sistema.<br>2. El sistema intercepta la acción realizada.<br>3. El sistema registra en el log: el usuario, el rol, la acción ejecutada, la fecha, la hora y el resultado de la operación.<br>4. El registro queda almacenado y disponible para consulta por parte del Administrador. |

---

## 3. Requerimientos No Funcionales

| Código | Nombre |    Categoría    | Descripción |
|--------|--------|:---------------:|-------------|
| **RNF-001** | Autenticación con correo institucional |    Seguridad    | El sistema debe autenticar a estudiantes, graduados, profesores y personal administrativo mediante correo institucional (@escuelaing.edu.co). |
| **RNF-002** | Autenticación con correo Gmail |    Seguridad    | El sistema debe permitir la autenticación de familiares mediante correo personal de Gmail. |
| **RNF-003** | Backend Spring Boot por capas | ️ Arquitectura  | El backend debe desarrollarse con Spring Boot separado por capas: controladores, adaptadores, lógica y datos. |
| **RNF-004** | API REST |  Arquitectura   | El sistema debe exponer sus funcionalidades mediante una API REST desarrollada con Spring Boot. |
| **RNF-005** | Frontend React con TypeScript | ️ Arquitectura  | El frontend debe desarrollarse como una aplicación web utilizando React con TypeScript. |
| **RNF-006** | Base de datos PostgreSQL | ️ Arquitectura  | El sistema debe utilizar PostgreSQL como motor de base de datos. |
| **RNF-007** | Diseño responsive |   Usabilidad  | La interfaz web debe ser responsive y adaptarse a dispositivos móviles para facilitar el acceso desde cualquier dispositivo. |