# apiearthquakes
Earthquakes Spring boot API for APIUX

API Earthquakes como prueba técnica.

Instrucciones: Para instalar la aplicacion, se debe realizar un git clone de este repositorio https://github.com/abrahamhp/apiearthquakes.git , para descargarlo localmente.

Luego de descargar la carpeta, debe Importar esta como proyecto Maven prefereiblemente en el IDE Spring Tool Suite 4.

Ejecute la API con el endpoint público para la ejecución de los servicios REST http://localhost:9090/swagger-ui.html

La Base de Datos usada es H2 la cual no requiere ser instalada fisicamente en el entorno local, ya que tiene una configuracion para funcionar virtualmente en memoria mientras se ejecuta una sesion de la API, y el esquema se crea de manera virtual y automaticamente cada vez que se inicia el servidor embebido del IDE en cuestion, por lo tanto no debe ejecutar el script schema.sql de manera manual, tampoco debe ser borrado ni quitado de la carpeta resources del proyecto.

Para acceder a la tabla del esquema de la Base de Datos H2 de la API creada automaticamente para verificar los datos manipulados por las operaciones de la API, debe ingresar a la consola de H2 http://localhost:9090/h2-console/ , para consultar los datos de la tabla.

Prerequisites Java 8 Spring tool Suite Dependencias de : -H2 Database - JPA - Web

#Abraham Hernandez


