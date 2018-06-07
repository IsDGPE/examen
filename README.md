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

Si corriò el contenedor anteior detengalo

 docker stop 766a8a94c1a8

Correr los siguientes comandos con variable de ambiente:

docker run -d -p 9191:8080 -e PBA=hola1 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9192:8080 -e PBA=hola2 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9193:8080 -e PBA=hola3 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

Iniciar haproxy

sudo service haproxy start


