### 2.X Requerimiento Funcional RF-001

| Campo | Descripción |
|------|-------------|
| **ID** | RF-001 |
| **Nombre del requerimiento** | Crear Torneo |
| **Descripción** | *El sistema debe permitir al organizador crear un nuevo torneo ingresando la información básica del mismo.* |
| **Precondiciones** | *El usuario debe estar autenticado y tener rol de Organizador asignado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al apartado de gestión de torneos.<br>2. El sistema muestra la opción "Crear torneo".<br>3. El organizador selecciona "Crear torneo".<br>4. El sistema despliega el formulario con los campos requeridos.<br>5. El organizador diligencia los datos del torneo y confirma.<br>6. El sistema valida que todos los campos obligatorios estén completos y cumplan las reglas.<br>7. El sistema crea el torneo en estado "Borrador" y muestra mensaje de confirmación. |

---
### 2.X Requerimiento Funcional RF-002

| Campo | Descripción |
|------|-------------|
| **ID** | RF-002 |
| **Nombre del requerimiento** | Iniciar Torneo |
| **Descripción** | *El sistema debe permitir al organizador cambiar el estado de un torneo de "Activo" a "En progreso", dando inicio oficial al torneo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) El torneo debe estar en estado Activo.<br>3) Debe haber al menos 2 equipos inscritos con estado Aprobado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al torneo.<br>2. El organizador selecciona "Iniciar torneo".<br>3. El organizador confirma la acción. |
---
### 2.X Requerimiento Funcional RF-003

| Campo | Descripción |
|------|-------------|
| **ID** | RF-003 |
| **Nombre del requerimiento** | Finalizar Torneo |
| **Descripción** | *El sistema debe permitir al organizador cambiar el estado de un torneo de "En progreso" a "Finalizado", cuando termine el torneo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) El torneo debe estar en estado "En progreso".* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al torneo en progreso.<br>2. El organizador selecciona "Finalizar torneo".<br>3. El organizador confirma la acción. |
---
### 2.X Requerimiento Funcional RF-004

| Campo | Descripción |
|------|-------------|
| **ID** | RF-004 |
| **Nombre del requerimiento** | Consultar Torneo |
| **Descripción** | *El sistema debe permitir a cualquier usuario autenticado consultar la información de un torneo existente.* |
| **Precondiciones** | *El usuario debe estar autenticado en el sistema.* |
| **Actor** | *Todos los actores* |
| **Flujo principal** | 1. El usuario accede al módulo de torneos.<br>2. El sistema muestra la lista de torneos disponibles.<br>3. El usuario selecciona un torneo para ver su detalle. |
---
### 2.X Requerimiento Funcional RF-005

| Campo | Descripción |
|------|-------------|
| **ID** | RF-005 |
| **Nombre del requerimiento** | Registrarse como Jugador |
| **Descripción** | *El sistema debe permitir a estudiantes, graduados, profesores, personal administrativo y familiares registrarse en la plataforma como jugadores.* |
| **Precondiciones** | *El usuario no debe tener una cuenta antes en el sistema.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El usuario accede a la página de registro.<br>2. El usuario selecciona su tipo de vinculación.<br>3. El usuario ingresa sus datos personales.<br>4. El usuario confirma el registro. |
---
### 2.X Requerimiento Funcional RF-006

| Campo | Descripción |
|------|-------------|
| **ID** | RF-006 |
| **Nombre del requerimiento** | Crear Perfil Jugador |
| **Descripción** | *El sistema debe permitir a un jugador registrado completar su perfil deportivo indicando sus posiciones de juego, número dorsal y foto.* |
| **Precondiciones** | *El usuario debe estar autenticado y registrado en el sistema (RF-005 completado).* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El jugador accede a su perfil.<br>2. El jugador selecciona "Completar perfil deportivo".<br>3. El jugador ingresa la información deportiva (posiciones de juego, número dorsal y foto).<br>4. El jugador confirma los datos ingresados. |
---
### 2.X Requerimiento Funcional RF-007

| Campo | Descripción |
|------|-------------|
| **ID** | RF-007 |
| **Nombre del requerimiento** | Activar Disponibilidad |
| **Descripción** | *El sistema debe permitir a un jugador indicar que está disponible para unirse a un equipo, permitiendo que los capitanes lo encuentren y contacten.* |
| **Precondiciones** | *1) El usuario debe estar autenticado.<br>2) Debe tener su perfil deportivo completo (RF-006).<br>3) No debe pertenecer a un equipo en el torneo activo.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El jugador accede a su perfil.<br>2. El jugador activa la opción de disponibilidad. |
---
### 2.X Requerimiento Funcional RF-008

| Campo | Descripción |
|------|-------------|
| **ID** | RF-008 |
| **Nombre del requerimiento** | Gestionar Invitaciones de Equipos |
| **Descripción** | *El sistema debe permitir a un jugador visualizar las invitaciones recibidas para unirse a un equipo y aceptarlas o rechazarlas.* |
| **Precondiciones** | *1) El usuario debe estar autenticado.<br>2) Debe tener al menos una invitación pendiente.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar* |
| **Flujo principal** | 1. El jugador accede a su bandeja de invitaciones.<br>2. El sistema muestra las invitaciones pendientes.<br>3. El jugador selecciona aceptar o rechazar cada invitación. |
---
### 2.X Requerimiento Funcional RF-009

| Campo | Descripción |
|------|-------------|
| **ID** | RF-009 |
| **Nombre del requerimiento** | Crear Equipo |
| **Descripción** | *El sistema debe permitir a un jugador registrado crear un equipo para participar en un torneo activo, convirtiéndose en capitán del mismo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado y tener perfil deportivo completo.<br>2) Debe existir al menos un torneo en estado "Activo".<br>3) El jugador no debe pertenecer a otro equipo en el mismo torneo.<br>4) El torneo no debe haber alcanzado la cantidad máxima de equipos.* |
| **Actor** | *Estudiante, Graduado, Profesor, Personal Administrativo, Familiar (asume rol de Capitán)* |
| **Flujo principal** | 1. El jugador accede al torneo activo.<br>2. El jugador selecciona "Crear equipo".<br>3. El jugador diligencia los datos del equipo.<br>4. El jugador confirma la creación.<br>5. El sistema registra al jugador como capitán del equipo. |
---
### 2.X Requerimiento Funcional RF-010

| Campo | Descripción |
|------|-------------|
| **ID** | RF-010 |
| **Nombre del requerimiento** | Invitar Jugadores al Equipo |
| **Descripción** | *El sistema debe permitir al capitán de un equipo enviar invitaciones a jugadores disponibles para que se unan a su equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) El equipo no debe haber alcanzado el máximo de 12 jugadores.<br>3) El torneo debe estar en estado "Activo".* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede a la gestión de su equipo.<br>2. El capitán busca jugadores disponibles.<br>3. El capitán selecciona un jugador y le envía una invitación.<br>4. El sistema registra y notifica la invitación al jugador. |
---
### 2.X Requerimiento Funcional RF-011

| Campo | Descripción |
|------|-------------|
| **ID** | RF-011 |
| **Nombre del requerimiento** | Buscar Jugadores |
| **Descripción** | *El sistema debe permitir a los capitanes buscar jugadores disponibles aplicando filtros por diferentes criterios para facilitar la conformación de su equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) Debe existir un torneo en estado "Activo".* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede al módulo de búsqueda de jugadores.<br>2. El capitán aplica los filtros deseados por los criterios disponibles.<br>3. El sistema muestra los resultados que coinciden con los filtros aplicados. |
---
### 2.X Requerimiento Funcional RF-012

| Campo | Descripción |
|------|-------------|
| **ID** | RF-012 |
| **Nombre del requerimiento** | Subir Comprobante de Pago |
| **Descripción** | *El sistema debe permitir al capitán de un equipo subir el comprobante de pago de la inscripción al torneo para su posterior verificación por el organizador.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Capitán.<br>2) El equipo debe tener mínimo 7 jugadores.<br>3) Más de la mitad de los miembros deben pertenecer a los programas elegibles.<br>4) El torneo debe estar en estado "Activo".<br>5) El equipo no debe tener un pago ya aprobado.* |
| **Actor** | *Capitán* |
| **Flujo principal** | 1. El capitán accede a la gestión de su equipo.<br>2. El capitán selecciona "Subir comprobante de pago".<br>3. El capitán adjunta el archivo del comprobante.<br>4. El capitán confirma la carga del archivo.<br>5. El sistema registra el comprobante y lo pone en espera de verificación por el organizador. |
---
### 2.X Requerimiento Funcional RF-013

| Campo | Descripción |
|------|-------------|
| **ID** | RF-013 |
| **Nombre del requerimiento** | Verificar Pago |
| **Descripción** | *El sistema debe permitir al organizador revisar los comprobantes de pago subidos por los capitanes y aprobar o rechazar la inscripción del equipo.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) Debe existir al menos un comprobante en estado "Pendiente".* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al módulo de pagos.<br>2. El sistema muestra los comprobantes pendientes de revisión.<br>3. El organizador revisa cada comprobante.<br>4. El organizador aprueba o rechaza la inscripción del equipo.<br>5. El sistema actualiza el estado del equipo según la decisión tomada. |
---
### 2.X Requerimiento Funcional RF-014

| Campo | Descripción |
|------|-------------|
| **ID** | RF-014 |
| **Nombre del requerimiento** | Configurar Torneo |
| **Descripción** | *El sistema debe permitir al organizador definir la configuración detallada del torneo incluyendo reglamento, fechas importantes, horarios, canchas y sanciones.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) El torneo debe existir y estar en estado "Borrador" o "Activo".* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al torneo creado.<br>2. El organizador selecciona "Configurar torneo".<br>3. El organizador diligencia las diferentes secciones de configuración (reglamento, fechas importantes, horarios, canchas y sanciones).<br>4. El sistema guarda la configuración ingresada. |
---
### 2.X Requerimiento Funcional RF-015

| Campo | Descripción |
|------|-------------|
| **ID** | RF-017 |
| **Nombre del requerimiento** | Registrar Resultado de Partido |
| **Descripción** | *El sistema debe permitir al organizador registrar los resultados de un partido incluyendo marcador, goleadores, tarjetas amarillas y tarjetas rojas.* |
| **Precondiciones** | *1) El usuario debe estar autenticado con rol de Organizador.<br>2) Debe existir un partido programado que ya se haya disputado.<br>3) El torneo debe estar en estado "En progreso".<br>4) El partido no debe tener un resultado previamente registrado.* |
| **Actor** | *Organizador* |
| **Flujo principal** | 1. El organizador accede al partido disputado.<br>2. El organizador selecciona "Registrar resultado".<br>3. El organizador ingresa el marcador del partido.<br>4. El organizador registra los goleadores del partido.<br>5. El organizador registra las tarjetas amarillas y rojas recibidas.<br>6. El organizador confirma el registro.<br>7. El sistema guarda
---