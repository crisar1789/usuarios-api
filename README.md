# Usuarios-api

Se utliz� Strping Boot 2.3.1.RELEASE y Sprin Framework 5.2.7.RELEASE
para los servicios. 
 
La api se puede utilziar solo con servicios rest a trav�s de cualquier herramienta
para consumo y prueba de servicios rest, adem�s a trav�s de las p�ginas html
expuestas dentro de la api.

Para el funcionamiento de la api a trav�s de las p�ginas html, se utiliz� Spring MVC, 
donde hay un controller encargado de los procesos backend.

Se utiliza patrp�on Facade y Singleton dento de la api.

Se utiliz� una base de datos H2, en la cual se crea la tabla expuesta en el 
folder resources en el archivo ddl.sql.

La api corre dentro del servidor local por el puerto 9012 (http://localhost:9012).

Se realiz� documentaci�n completa de la api con Swagger, la cu�l se puede acceder 
a trav�s de la url http://localhost:9012/swagger-ui.html#/, luego de corre la api.

