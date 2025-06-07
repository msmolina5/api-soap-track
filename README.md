# api-soap-track

# Seguimiento de Paquetes

Este proyecto implementa un servicio web SOAP usando Spring Boot y Apache CXF para realizar seguimiento de paquetes con almacenamiento en PostgreSQL.

---

## ⚙️ Requisitos

- Java 21 o superior  
- PostgreSQL instalado y corriendo  

---

## 🔧 Configuración de la Base de Datos

1. Crear una base de datos en PostgreSQL llamada: seguimiento (o puede crear otra y cambiarel codigo en el archivo application.properties)
2. Verificar que el usuario tenga permisos suficientes. Ejemplo de configuración usada:

- Usuario: `postgres`
- Contraseña: `admin`

3. Editar el archivo:

`src/main/resources/application.properties`

##Ejecucion
Puede comprobar en la base de datos que se crearon las tablas sin ningun problema


Probar luego en el navegador o en soapUi
http://localhost:8080/ws/TrackingService?wsdl

