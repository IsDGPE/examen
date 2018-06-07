# Examen Calculadora VERTX

Instrucciones para inicializar el proyecto

Parte 1

Asegúrese de tener instalado Docker

Se pone por ejemplo que tiene instalada una imagen en el siguiente directorio: 

/home/gustavo/development/examen

Para correr el VERTX utilice el siguiente comando de docker 

docker run -it -p 9191:8080 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven bash

Utilizando el siguiente comando puede verificar que el repositorio este arriba

docker ps

Parte 2 
Correr en haproxy



