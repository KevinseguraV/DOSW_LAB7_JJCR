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

## RF-01 — Crear y gestionar un torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-01 |
| **Nombre del requerimiento** | Crear y gestionar un torneo |
| **Descripción** | El sistema debe permitir al organizador crear un torneo con su información básica (fecha inicial, fecha final, cantidad de equipos, costo por equipo y estado), así como iniciarlo y finalizarlo. |
| **Precondiciones** | El organizador debe estar autenticado en el sistema con rol de Organizador. |
| **Actor** | Organizador |
| **Flujo principal** | 1. El organizador accede a la sección de gestión de torneos.<br>2. El organizador diligencia los campos: fecha inicial, fecha final, cantidad de equipos, costo por equipo.<br>3. El sistema valida que los campos obligatorios estén completos y que las fechas sean coherentes.<br>4. El sistema crea el torneo con estado *Borrador*.<br>5. El organizador puede cambiar el estado a *Activo*, *En progreso* o *Finalizado* según el avance del torneo. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el torneo quede registrado en el sistema con un estado definido y sea visible para los demás actores. |

---

## RF-02 — Inscribir equipo a un torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-02 |
| **Nombre del requerimiento** | Inscribir equipo a un torneo |
| **Descripción** | El sistema debe permitir al capitán inscribir su equipo a un torneo activo, siempre que el equipo cumpla con los requisitos mínimos de conformación y el pago haya sido aprobado. |
| **Precondiciones** | El capitán debe estar autenticado. El equipo debe tener mínimo 7 jugadores y más de la mitad deben pertenecer a los programas de Ingeniería de Sistemas, IA, Ciberseguridad o Estadística. El torneo debe estar en estado *Activo*. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán accede a la sección de torneos disponibles.<br>2. El capitán selecciona el torneo al que desea inscribir su equipo.<br>3. El sistema valida que el equipo cumple los requisitos de conformación.<br>4. El sistema registra la solicitud de inscripción con estado *Pendiente*.<br>5. El capitán sube el comprobante de pago.<br>6. El organizador revisa y aprueba o rechaza la inscripción. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el equipo quede inscrito con estado *Aprobado* y habilitado para participar en el torneo. |

---

## RF-03 — Consultar información del torneo y sus partidos

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-03 |
| **Nombre del requerimiento** | Consultar información del torneo y sus partidos |
| **Descripción** | El sistema debe permitir a cualquier usuario autenticado consultar la información general del torneo, incluyendo fechas, reglamento, calendario de partidos y resultados. |
| **Precondiciones** | El usuario debe estar autenticado en el sistema. El torneo debe existir y estar en estado *Activo*, *En progreso* o *Finalizado*. |
| **Actor** | Estudiante, Capitán, Árbitro, Organizador, Administrador |
| **Flujo principal** | 1. El usuario accede a la sección del torneo.<br>2. El sistema muestra la información general: fechas, reglamento, estado del torneo.<br>3. El usuario selecciona la opción de ver partidos.<br>4. El sistema muestra el calendario de partidos con fechas, horarios, canchas y resultados registrados. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el usuario visualice correctamente la información del torneo y sus partidos. |

---

## RF-04 — Registrar pago mediante comprobante

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-04 |
| **Nombre del requerimiento** | Registrar pago mediante comprobante |
| **Descripción** | El sistema debe permitir al capitán subir un comprobante de pago (imagen o PDF) para iniciar el proceso de verificación de inscripción del equipo. |
| **Precondiciones** | El capitán debe estar autenticado. El equipo debe estar creado y cumplir los requisitos de conformación. El torneo debe estar en estado *Activo* y con inscripciones abiertas. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán accede a la sección de inscripción de su equipo.<br>2. El capitán selecciona el archivo del comprobante de pago (NEQUI o efectivo).<br>3. El sistema valida el formato y tamaño del archivo.<br>4. El sistema almacena el comprobante de forma segura y registra el estado del pago como *Pendiente*.<br>5. El sistema notifica al organizador sobre el nuevo comprobante. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el comprobante quede registrado en el sistema con estado *Pendiente* y el organizador sea notificado. |

---

## RF-06 — Definir partidos de fase de grupos

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-06 |
| **Nombre del requerimiento** | Definir partidos de fase de grupos |
| **Descripción** | El sistema debe generar automáticamente los partidos iniciales de la fase de grupos de forma aleatoria, una vez que el torneo sea iniciado por el organizador. |
| **Precondiciones** | El torneo debe estar en estado *Activo*. Todos los equipos participantes deben tener el pago aprobado. Debe existir al menos el número mínimo de equipos definido en el torneo. |
| **Actor** | Organizador |
| **Flujo principal** | 1. El organizador inicia el torneo desde la sección de gestión.<br>2. El sistema cambia el estado del torneo a *En progreso*.<br>3. El sistema toma los equipos inscritos con pago aprobado.<br>4. El sistema genera aleatoriamente los enfrentamientos de fase de grupos.<br>5. El sistema publica el calendario de partidos visible para todos los actores. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que los partidos de fase de grupos queden generados y visibles en el calendario del torneo. |

---

## RF-10 — Consultar información de partidos (Árbitro)

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-10 |
| **Nombre del requerimiento** | Consultar información de partidos asignados |
| **Descripción** | El sistema debe permitir al árbitro consultar la información de los partidos que tiene asignados para arbitrar, incluyendo fecha, hora, cancha y equipos participantes. |
| **Precondiciones** | El árbitro debe estar autenticado con rol de Árbitro. Deben existir partidos asignados al árbitro en el sistema. |
| **Actor** | Árbitro |
| **Flujo principal** | 1. El árbitro accede a la sección de mis partidos.<br>2. El sistema muestra el listado de partidos asignados al árbitro.<br>3. El árbitro selecciona un partido.<br>4. El sistema muestra: fecha, hora, cancha, equipo local y equipo visitante. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el árbitro visualice correctamente la información del partido asignado. |

---

## RF-11 — Restringir cambio de integrantes en torneo activo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-11 |
| **Nombre del requerimiento** | Restringir cambio de integrantes en torneo activo |
| **Descripción** | El sistema debe impedir que se realicen cambios en la nómina de jugadores de un equipo una vez que el torneo haya iniciado. Los 12 jugadores registrados al inicio deben permanecer hasta el final. |
| **Precondiciones** | El torneo debe estar en estado *En progreso*. El equipo debe estar inscrito y aprobado. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán intenta modificar la nómina de su equipo durante el torneo.<br>2. El sistema detecta que el torneo está en estado *En progreso*.<br>3. El sistema bloquea la acción e informa al capitán que no es posible realizar cambios durante el torneo activo. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que la nómina del equipo permanezca sin cambios y el capitán reciba un mensaje informativo sobre la restricción. |

---

## RF-12 — Organizar alineación antes de un partido

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-12 |
| **Nombre del requerimiento** | Organizar alineación antes de un partido |
| **Descripción** | El sistema debe permitir al capitán definir la alineación de su equipo antes de cada partido, seleccionando titulares, reservas, formación y posición visual de cada jugador en la cancha. |
| **Precondiciones** | El capitán debe estar autenticado. El equipo debe estar inscrito y aprobado. Debe existir un partido programado para el equipo. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán accede a la sección de alineaciones de su equipo.<br>2. El capitán selecciona el partido para el cual desea definir la alineación.<br>3. El capitán elige la formación táctica (ej. 2-3-1).<br>4. El capitán asigna los jugadores titulares a cada posición en el campo visual.<br>5. El capitán define los jugadores reservas.<br>6. El sistema guarda la alineación y la hace visible para los demás actores. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que la alineación quede registrada y sea consultable por jugadores y el equipo rival. |

---

## RF-13 — Validar participación por pago aprobado

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-13 |
| **Nombre del requerimiento** | Validar participación por pago aprobado |
| **Descripción** | El sistema debe garantizar que solo los equipos cuyo pago haya sido aprobado por el organizador puedan participar en los partidos del torneo. |
| **Precondiciones** | El torneo debe estar en estado *En progreso*. El organizador debe haber revisado los comprobantes de pago de los equipos. |
| **Actor** | Organizador, Sistema |
| **Flujo principal** | 1. El organizador inicia el torneo.<br>2. El sistema verifica qué equipos tienen estado de pago *Aprobado*.<br>3. El sistema incluye únicamente esos equipos en la generación de partidos.<br>4. Los equipos con estado *Pendiente*, *En revisión* o *Rechazado* son excluidos automáticamente. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que solo los equipos con pago aprobado aparezcan en el calendario de partidos del torneo. |

---

## RF-14 — Subir comprobante de pago

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-14 |
| **Nombre del requerimiento** | Subir comprobante de pago |
| **Descripción** | El sistema debe permitir al capitán cargar el archivo del comprobante de pago (transferencia NEQUI o recibo de efectivo) para que el organizador pueda verificarlo. |
| **Precondiciones** | El capitán debe estar autenticado. El equipo debe estar creado. El torneo debe tener inscripciones abiertas. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán accede al formulario de inscripción de su equipo.<br>2. El capitán selecciona el archivo del comprobante desde su dispositivo.<br>3. El sistema valida el formato del archivo (imagen o PDF).<br>4. El sistema almacena el archivo de forma segura.<br>5. El sistema registra el estado del pago como *Pendiente* y notifica al organizador. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el comprobante quede almacenado y el estado de pago del equipo sea *Pendiente*. |

---

## RF-15 — Notificar al organizador sobre nuevos comprobantes

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-15 |
| **Nombre del requerimiento** | Notificar al organizador sobre nuevos comprobantes |
| **Descripción** | El sistema debe notificar al organizador cuando un capitán suba un nuevo comprobante de pago, para que pueda revisarlo oportunamente. |
| **Precondiciones** | El capitán debe haber subido un comprobante exitosamente. El organizador debe estar registrado en el sistema con rol de Organizador. |
| **Actor** | Sistema, Organizador |
| **Flujo principal** | 1. El capitán sube el comprobante de pago.<br>2. El sistema registra el comprobante con estado *Pendiente*.<br>3. El sistema genera una notificación dirigida al organizador.<br>4. El organizador recibe la notificación e ingresa a revisar el comprobante.<br>5. El organizador cambia el estado a *En revisión*, luego a *Aprobado* o *Rechazado*. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el organizador sea notificado y pueda acceder al comprobante para su revisión. |

---

## RF-16 — Consultar alineaciones de equipos

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-16 |
| **Nombre del requerimiento** | Consultar alineaciones de equipos |
| **Descripción** | El sistema debe permitir a capitanes y jugadores consultar la alineación de cualquier equipo, incluyendo la del equipo rival antes de un partido. |
| **Precondiciones** | El usuario debe estar autenticado. La alineación del equipo debe haber sido definida por el capitán correspondiente. |
| **Actor** | Capitán, Estudiante |
| **Flujo principal** | 1. El usuario accede a la sección de alineaciones.<br>2. El usuario selecciona el partido o el equipo que desea consultar.<br>3. El sistema muestra la formación táctica con los jugadores titulares posicionados visualmente en la cancha.<br>4. El sistema muestra también el listado de reservas. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el usuario visualice la alineación completa del equipo consultado. |

---

## RF-17 — Buscar jugadores para el equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-17 |
| **Nombre del requerimiento** | Buscar jugadores para el equipo |
| **Descripción** | El sistema debe permitir al capitán buscar jugadores disponibles aplicando filtros por posición, semestre, edad, género, nombre e identificación. |
| **Precondiciones** | El capitán debe estar autenticado. Deben existir jugadores registrados que se hayan marcado como disponibles. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán accede a la sección de búsqueda de jugadores.<br>2. El capitán aplica uno o varios filtros: posición, semestre, edad, género, nombre o identificación.<br>3. El sistema muestra el listado de jugadores disponibles que coincidan con los filtros.<br>4. El capitán selecciona un jugador y le envía una invitación para unirse al equipo. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el capitán visualice jugadores disponibles y pueda enviarles una invitación. |

---

## RF-18 — Registrarse como jugador

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-18 |
| **Nombre del requerimiento** | Registrarse como jugador |
| **Descripción** | El sistema debe permitir a estudiantes, graduados, profesores, personal administrativo y familiares registrarse como jugadores, creando un perfil deportivo con posición, número dorsal y foto. |
| **Precondiciones** | El usuario debe contar con un correo institucional (@escuelaing.edu.co) o correo personal de Gmail (para familiares). El usuario no debe tener un perfil de jugador previamente creado. |
| **Actor** | Estudiante, Graduado, Profesor, Personal Administrativo, Familiar |
| **Flujo principal** | 1. El usuario accede al formulario de registro.<br>2. El usuario ingresa sus datos personales y su correo según su tipo (institucional o Gmail).<br>3. El sistema verifica el dominio del correo.<br>4. El usuario completa su perfil deportivo: posición de juego, número dorsal y foto.<br>5. El usuario indica si está disponible para ser contactado por capitanes.<br>6. El sistema crea el perfil y lo registra en el sistema. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el usuario quede registrado como jugador con perfil deportivo completo y visible para los capitanes si está disponible. |

---

## RF-19 — Registrarse como capitán

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-19 |
| **Nombre del requerimiento** | Registrarse como capitán |
| **Descripción** | El sistema debe permitir a un jugador ya registrado asumir el rol de capitán para poder crear y administrar un equipo. |
| **Precondiciones** | El usuario debe estar registrado como jugador en el sistema. El usuario no debe ser ya capitán de otro equipo activo. |
| **Actor** | Estudiante, Graduado, Profesor, Personal Administrativo, Familiar |
| **Flujo principal** | 1. El jugador accede a la opción de crear un equipo.<br>2. El sistema verifica que el jugador no sea capitán de otro equipo activo.<br>3. El sistema asigna el rol de Capitán al jugador.<br>4. El jugador puede comenzar a crear y administrar su equipo. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el jugador tenga el rol de Capitán asignado y pueda acceder a las funcionalidades de gestión de equipo. |

---

## RF-20 — Iniciar y finalizar un torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-20 |
| **Nombre del requerimiento** | Iniciar y finalizar un torneo |
| **Descripción** | El sistema debe permitir al organizador cambiar el estado del torneo a *En progreso* para iniciarlo y a *Finalizado* para cerrarlo oficialmente. |
| **Precondiciones** | Para iniciar: el torneo debe estar en estado *Activo* y debe tener equipos inscritos con pago aprobado. Para finalizar: el torneo debe estar en estado *En progreso* y todos los partidos deben estar registrados. |
| **Actor** | Organizador |
| **Flujo principal** | 1. El organizador accede a la gestión del torneo.<br>2. El organizador selecciona la opción *Iniciar torneo*.<br>3. El sistema valida que haya equipos suficientes con pago aprobado.<br>4. El sistema cambia el estado a *En progreso* y genera los partidos de fase de grupos.<br>5. Al concluir el torneo, el organizador selecciona *Finalizar torneo*.<br>6. El sistema cambia el estado a *Finalizado* y congela la información. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el torneo cambie de estado correctamente y se activen o cierren las funcionalidades correspondientes. |

---

## RF-21 — Configurar parámetros del torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-21 |
| **Nombre del requerimiento** | Configurar parámetros del torneo |
| **Descripción** | El sistema debe permitir al organizador definir el reglamento, fechas importantes, cierre de inscripciones, horarios de partidos, canchas disponibles y sanciones aplicables. |
| **Precondiciones** | El organizador debe estar autenticado. El torneo debe existir y estar en estado *Borrador* o *Activo*. |
| **Actor** | Organizador |
| **Flujo principal** | 1. El organizador accede a la configuración del torneo.<br>2. El organizador ingresa o actualiza el reglamento del torneo.<br>3. El organizador define las fechas importantes y el cierre de inscripciones.<br>4. El organizador registra las canchas disponibles y los horarios de partidos.<br>5. El organizador define las sanciones aplicables (tarjetas, suspensiones, etc.).<br>6. El sistema guarda la configuración y la publica para los demás actores. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que la configuración del torneo quede guardada y sea visible para todos los actores del sistema. |

---

## RF-22 — Cambiar estado de un pago

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-22 |
| **Nombre del requerimiento** | Cambiar estado de un pago |
| **Descripción** | El sistema debe permitir al organizador revisar el comprobante de pago de un equipo y actualizar su estado a *En revisión*, *Aprobado* o *Rechazado*. |
| **Precondiciones** | El organizador debe estar autenticado. El capitán debe haber subido un comprobante de pago. El estado actual del pago debe ser *Pendiente* o *En revisión*. |
| **Actor** | Organizador |
| **Flujo principal** | 1. El organizador recibe la notificación de un nuevo comprobante.<br>2. El organizador accede a la sección de pagos pendientes.<br>3. El organizador visualiza el comprobante subido por el capitán.<br>4. El organizador cambia el estado a *En revisión* mientras lo analiza.<br>5. El organizador aprueba o rechaza el pago.<br>6. El sistema actualiza el estado, registra la acción con marca de tiempo y notifica al capitán. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el estado del pago quede actualizado y el capitán sea notificado del resultado. |

---

## RF-23 — Registrar resultado de un partido

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-23 |
| **Nombre del requerimiento** | Registrar resultado de un partido |
| **Descripción** | El sistema debe permitir al organizador registrar el marcador final, los goleadores, las tarjetas amarillas y las tarjetas rojas de cada partido disputado. |
| **Precondiciones** | El organizador debe estar autenticado. El partido debe existir en el calendario del torneo. El torneo debe estar en estado *En progreso*. |
| **Actor** | Organizador |
| **Flujo principal** | 1. El organizador accede a la sección de gestión de partidos.<br>2. El organizador selecciona el partido a registrar.<br>3. El organizador ingresa el marcador final (goles por equipo).<br>4. El organizador registra los goleadores indicando jugador y minuto.<br>5. El organizador registra las tarjetas amarillas y rojas con el jugador correspondiente.<br>6. El sistema guarda el resultado y actualiza automáticamente la tabla de posiciones y estadísticas. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el resultado quede registrado y la tabla de posiciones y estadísticas sean actualizadas automáticamente. |

---

## RF-24 — Generar llaves eliminatorias

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-24 |
| **Nombre del requerimiento** | Generar llaves eliminatorias |
| **Descripción** | El sistema debe generar automáticamente las llaves eliminatorias (cuartos de final, semifinal y final) con base en los resultados de la fase de grupos, una vez que esta haya concluido. |
| **Precondiciones** | El torneo debe estar en estado *En progreso*. Todos los partidos de la fase de grupos deben tener resultado registrado. |
| **Actor** | Organizador, Sistema |
| **Flujo principal** | 1. El organizador indica que la fase de grupos ha concluido.<br>2. El sistema toma la tabla de posiciones final de la fase de grupos.<br>3. El sistema clasifica los equipos según su posición.<br>4. El sistema genera automáticamente los enfrentamientos de cuartos de final.<br>5. A medida que se registran resultados, el sistema avanza las llaves a semifinal y final.<br>6. El sistema publica las llaves visibles para todos los actores. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que las llaves eliminatorias queden generadas y sean visibles para todos los actores del sistema. |

---

## RF-25 — Mostrar tabla de posiciones

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-25 |
| **Nombre del requerimiento** | Mostrar tabla de posiciones |
| **Descripción** | El sistema debe mostrar la tabla de posiciones actualizada automáticamente con los siguientes datos por equipo: partidos jugados, ganados, empatados, perdidos, goles a favor, goles en contra, diferencia de gol y puntos totales. |
| **Precondiciones** | El torneo debe estar en estado *En progreso*. Debe haber al menos un partido con resultado registrado. |
| **Actor** | Estudiante, Capitán, Árbitro, Organizador, Administrador |
| **Flujo principal** | 1. El usuario accede a la sección de tabla de posiciones del torneo.<br>2. El sistema consulta todos los resultados registrados.<br>3. El sistema calcula para cada equipo: PJ, PG, PE, PP, GF, GC, DG y puntos.<br>4. El sistema muestra la tabla ordenada por puntos de mayor a menor.<br>5. En caso de empate en puntos, el sistema aplica los criterios de desempate definidos en el reglamento. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el usuario visualice la tabla de posiciones actualizada con todos los datos estadísticos por equipo. |

---

## RF-26 — Crear equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-26 |
| **Nombre del requerimiento** | Crear equipo |
| **Descripción** | El sistema debe permitir al capitán crear un equipo asignándole nombre, escudo y colores de uniforme. |
| **Precondiciones** | El usuario debe estar registrado como jugador y tener rol de Capitán. El capitán no debe ser ya responsable de otro equipo activo. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán accede a la sección de creación de equipo.<br>2. El capitán ingresa el nombre del equipo.<br>3. El capitán sube la imagen del escudo del equipo.<br>4. El capitán define los colores del uniforme.<br>5. El sistema valida que el nombre no esté en uso.<br>6. El sistema crea el equipo y lo asocia al capitán. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el equipo quede creado en el sistema con su información básica y asociado al capitán. |

---

## RF-27 — Invitar jugadores al equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-27 |
| **Nombre del requerimiento** | Invitar jugadores al equipo |
| **Descripción** | El sistema debe permitir al capitán enviar invitaciones a jugadores disponibles para que se unan a su equipo, respetando el límite máximo de 12 jugadores. |
| **Precondiciones** | El capitán debe estar autenticado con rol de Capitán. El equipo debe estar creado. El jugador a invitar debe estar registrado y marcado como disponible. El equipo no debe haber alcanzado el máximo de 12 jugadores. |
| **Actor** | Capitán |
| **Flujo principal** | 1. El capitán busca un jugador en la sección de búsqueda.<br>2. El capitán selecciona al jugador y elige la opción de invitar.<br>3. El sistema verifica que el jugador no pertenezca ya a otro equipo.<br>4. El sistema verifica que el equipo no haya alcanzado el máximo de 12 jugadores.<br>5. El sistema envía la invitación al jugador.<br>6. El jugador recibe la invitación y puede aceptarla o rechazarla. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que la invitación quede registrada y el jugador sea notificado para que tome una decisión. |

---

## RF-28 — Aceptar o rechazar invitación a un equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-28 |
| **Nombre del requerimiento** | Aceptar o rechazar invitación a un equipo |
| **Descripción** | El sistema debe permitir al jugador aceptar o rechazar las invitaciones recibidas de capitanes para unirse a un equipo. |
| **Precondiciones** | El jugador debe estar autenticado. El jugador debe haber recibido al menos una invitación pendiente. El jugador no debe pertenecer ya a otro equipo. |
| **Actor** | Estudiante, Graduado, Profesor, Personal Administrativo, Familiar |
| **Flujo principal** | 1. El jugador accede a la sección de invitaciones recibidas.<br>2. El sistema muestra las invitaciones pendientes con información del equipo y el capitán.<br>3. El jugador selecciona una invitación y elige aceptar o rechazar.<br>4. Si acepta: el sistema agrega al jugador al equipo y actualiza el roster.<br>5. Si rechaza: el sistema descarta la invitación y notifica al capitán.<br>6. El sistema valida que el jugador no pertenezca a dos equipos simultáneamente. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el jugador quede vinculado al equipo si aceptó, o que la invitación quede descartada si rechazó. |

---

## RF-29 — Crear perfil deportivo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-29 |
| **Nombre del requerimiento** | Crear perfil deportivo |
| **Descripción** | El sistema debe permitir al jugador registrado completar su perfil deportivo indicando su posición de juego preferida, número dorsal y foto. |
| **Precondiciones** | El usuario debe estar registrado en el sistema. El perfil deportivo no debe haber sido creado previamente. |
| **Actor** | Estudiante, Graduado, Profesor, Personal Administrativo, Familiar |
| **Flujo principal** | 1. El usuario accede a la sección de perfil deportivo.<br>2. El usuario selecciona su posición de juego: portero, defensa, volante o delantero.<br>3. El usuario elige su número dorsal.<br>4. El usuario sube su foto de perfil.<br>5. El sistema guarda el perfil deportivo y lo asocia al usuario. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el perfil deportivo del jugador quede completo y sea visible para los capitanes en la búsqueda de jugadores. |

---

## RF-30 — Marcarse como disponible para un equipo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-30 |
| **Nombre del requerimiento** | Marcarse como disponible para un equipo |
| **Descripción** | El sistema debe permitir al jugador indicar si está disponible para ser contactado por capitanes que busquen jugadores para sus equipos. |
| **Precondiciones** | El jugador debe estar registrado y tener su perfil deportivo creado. El jugador no debe pertenecer ya a un equipo activo. |
| **Actor** | Estudiante, Graduado, Profesor, Personal Administrativo, Familiar |
| **Flujo principal** | 1. El jugador accede a su perfil deportivo.<br>2. El jugador activa la opción de *disponible para equipo*.<br>3. El sistema actualiza el estado de disponibilidad del jugador.<br>4. El perfil del jugador ahora aparece en los resultados de búsqueda de capitanes. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el jugador aparezca en el listado de jugadores disponibles y pueda recibir invitaciones de capitanes. |

---

## RF-31 — Consultar estadísticas del torneo

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-31 |
| **Nombre del requerimiento** | Consultar estadísticas del torneo |
| **Descripción** | El sistema debe permitir a cualquier usuario autenticado consultar las estadísticas del torneo, incluyendo el ranking de máximos goleadores, historial de partidos y resultados por equipo. |
| **Precondiciones** | El usuario debe estar autenticado. El torneo debe estar en estado *En progreso* o *Finalizado*. Deben existir partidos con resultados registrados. |
| **Actor** | Estudiante, Capitán, Árbitro, Organizador, Administrador |
| **Flujo principal** | 1. El usuario accede a la sección de estadísticas del torneo.<br>2. El sistema muestra el ranking de máximos goleadores con nombre, equipo y cantidad de goles.<br>3. El usuario puede consultar el historial de partidos con fechas y resultados.<br>4. El usuario puede filtrar los resultados por equipo para ver su desempeño histórico. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el usuario visualice las estadísticas actualizadas del torneo según los resultados registrados. |

---

## RF-32 — Administración total del sistema

| Campo | Descripción |
|-------|-------------|
| **ID** | RF-32 |
| **Nombre del requerimiento** | Administración total del sistema |
| **Descripción** | El sistema debe otorgar al administrador acceso completo a todas las funcionalidades, incluyendo la gestión de usuarios, torneos, equipos, pagos y configuraciones globales. |
| **Precondiciones** | El usuario debe estar autenticado con rol de Administrador. |
| **Actor** | Administrador |
| **Flujo principal** | 1. El administrador accede al panel de administración del sistema.<br>2. El administrador puede consultar, crear, editar o eliminar cualquier entidad del sistema: usuarios, torneos, equipos, pagos, partidos.<br>3. El administrador puede asignar o revocar roles a cualquier usuario.<br>4. El administrador puede consultar los registros de auditoría del sistema.<br>5. El sistema registra todas las acciones del administrador en el log de auditoría. |
| **Diagrama de caso de uso** | *Por definir* |
| **Poscondiciones** | Se espera como resultado que el administrador pueda gestionar cualquier aspecto del sistema sin restricciones, y que todas sus acciones queden registradas. |

---

## 3. Requerimientos No Funcionales

| Código | Nombre | Categoría | Descripción |
|--------|--------|-----------|-------------|
| RNF-001 | Restricción de acceso por dominio | Seguridad | El sistema debe garantizar que solo usuarios con correo verificado (@escuelaing.edu.co o @gmail.com) puedan acceder. Ninguna sesión puede iniciarse sin verificación del dominio del correo. |
| RNF-002 | Tokens de sesión seguros | Seguridad | El sistema debe gestionar sesiones mediante tokens firmados (JWT), con expiración configurable. Las sesiones deben invalidarse al cerrar sesión o al detectar inactividad prolongada. |
| RNF-003 | Control de roles y permisos (RBAC) | Seguridad | El sistema debe implementar control de acceso basado en roles (RBAC) para restringir las funcionalidades según el tipo de usuario: Estudiante, Capitán, Organizador, Árbitro y Administrador. |
| RNF-004 | Registro de acciones (Auditoría) | Seguridad | El sistema debe registrar las acciones relevantes realizadas por los usuarios (quién, qué, cuándo) para fines de auditoría y trazabilidad. Los registros no pueden ser modificados ni eliminados por usuarios regulares. |
| RNF-005 | Backend Spring Boot por capas | Arquitectura | El backend debe desarrollarse con Spring Boot separado por capas: controladores, adaptadores, lógica y datos. |
| RNF-006 | API REST | Arquitectura | El sistema debe exponer sus funcionalidades mediante una API REST desarrollada con Spring Boot, siguiendo convenciones estándar de verbos HTTP y códigos de respuesta. |
| RNF-007 | Frontend React con TypeScript | Arquitectura | El frontend debe desarrollarse como una aplicación web utilizando React con TypeScript. |
| RNF-008 | Base de datos PostgreSQL | Arquitectura | El sistema debe utilizar PostgreSQL como motor de base de datos relacional. |
| RNF-009 | Diseño responsive | Usabilidad | La interfaz web debe ser responsive y adaptarse a dispositivos móviles para facilitar el acceso desde cualquier dispositivo. |
| RNF-010 | Actualización automática de estadísticas | Rendimiento | La tabla de posiciones y las estadísticas deben recalcularse automáticamente al registrar un resultado, sin intervención manual del organizador. |
| RNF-011 | Despliegue en contenedores Docker | Portabilidad | El sistema debe estar completamente dockerizado, con contenedores independientes para el backend, frontend y base de datos, orquestados mediante Docker Compose para facilitar su despliegue en cualquier entorno. |
| RNF-012 | Tiempo de respuesta de la API | Rendimiento | Los endpoints de consulta frecuente (tabla de posiciones, lista de partidos, búsqueda de jugadores) deben responder en menos de 2 segundos bajo condiciones normales de uso. |
| RNF-013 | Validación de integridad de datos | Arquitectura | El sistema debe aplicar validaciones en capa de negocio y en base de datos para garantizar la integridad referencial: un jugador no puede pertenecer a dos equipos simultáneamente, el número de jugadores por equipo debe estar entre 7 y 12, y más de la mitad deben pertenecer a los programas definidos. |
| RNF-014 | Gestión segura de comprobantes | Seguridad | Los archivos de comprobante de pago subidos por los capitanes deben almacenarse de forma segura, accesibles únicamente por el organizador y el Administrador. No deben ser públicamente accesibles mediante URL directa. |
| RNF-015 | Mantenibilidad del código | Mantenibilidad | El código debe seguir los patrones de diseño definidos por el equipo, estar documentado en sus componentes principales y estructurado con Maven, facilitando la incorporación de nuevos integrantes al proyecto. |
| RNF-016 | Disponibilidad durante periodo activo | Disponibilidad | El sistema debe estar disponible durante todo el periodo activo del torneo (estado "En progreso"). Las caídas no planificadas deben ser recuperables sin pérdida de datos. |
| RNF-017 | Generación automática de llaves | Rendimiento | La generación de llaves eliminatorias (cuartos, semifinal, final) debe ejecutarse de forma automática e inmediata al activar la fase eliminatoria, sin tiempos de espera perceptibles por el organizador. |
| RNF-018 | Trazabilidad del estado de inscripción | Seguridad | Cada cambio de estado de un pago (Pendiente → En revisión → Aprobado / Rechazado) debe quedar registrado con marca de tiempo y el usuario que realizó la acción, garantizando trazabilidad completa del proceso. |