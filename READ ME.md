Inventario de Medicamentos (DSWII) - Spring Boot + JWT
API REST para:

Registro de sedes/hospitales
Registro de medicamentos
Control de lotes y caducidad
Inventario por sede (stock actual + stock mínimo)
Alertas: bajo stock y por caducar
Reportes simples (endpoints)
Requisitos
JDK 17
Maven 3.9+
MySQL 8 (o compatible)
Configuración BD
Edita src/main/resources/application.yml:

spring.datasource.url
spring.datasource.username
spring.datasource.password
Por defecto crea las tablas automáticamente con ddl-auto: update.

Ejecutar
mvn spring-boot:run
Swagger
http://localhost:8080/swagger-ui/index.html
Usuarios iniciales (se crean al iniciar)
admin / admin123 (ROLE_ADMIN)
user / user123 (ROLE_USER)
Autenticación
Login: POST /api/auth/login
{"username":"admin","password":"admin123"}
Header: Authorization: Bearer <TOKEN>
