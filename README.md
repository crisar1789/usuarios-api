# Usuarios-api

Se utlizó Strping Boot 2.3.1.RELEASE y Sprin Framework 5.2.7.RELEASE
para los servicios. 
 
La api se puede utilziar solo con servicios rest a través de cualquier herramienta
para consumo y prueba de servicios rest, además a través de las páginas html
expuestas dentro de la api.

Para el funcionamiento de la api a través de las páginas html, se utilizó Spring MVC, 
donde hay un controller encargado de los procesos backend.

Se utiliza patrpóon Facade y Singleton dento de la api.

Se utilizó una base de datos H2, en la cual se crea la tabla expuesta en el 
folder resources en el archivo ddl.sql.

La api corre dentro del servidor local por el puerto 9012 (http://localhost:9012).

Se realizó documentación completa de la api con Swagger, la cuál se puede acceder 
a través de la url http://localhost:9012/swagger-ui.html#/, luego de corre la api.

