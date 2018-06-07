# Examen Calculadora VERTX

Instrucciones para inicializar el proyecto

Parte 1

Asegúrese de tener instalado Docker

Se pone por ejemplo que tiene instalada una imagen en el siguiente directorio: 

/home/gustavo/development/examen

Para correr el VERTX utilice el siguiente comando de docker 

docker run -d -p 9191:8080 -e PBA=hola1 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/sample-1.0-SNAPSHOT-fat.jar


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

Parte 3. 

Balancear 6 contenedores

editar el siguiente archivo:

/etc/haproxy/haproxy.cfg

frontend www
    bind localhost:9090
    default_backend site-backend


backend site-backend
    mode http
    stats enable
    stats uri /haproxy?stats
    balance roundrobin
    server lamp1 localhost:9191 check
    server lamp2 localhost:9192 check
    server lamp3 localhost:9193 check
    server lamp4 localhost:9191 check
    server lamp5 localhost:9192 check
    server lamp6 localhost:9193 check

Correr los siguientes comandos con variable de ambiente:

docker run -d -p 9191:8080 -e PBA=hola1 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9192:8080 -e PBA=hola2 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9193:8080 -e PBA=hola3 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9194:8080 -e PBA=hola4 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9195:8080 -e PBA=hola5 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

docker run -d -p 9196:8080 -e PBA=hola6 -v /home/gustavo/development/examen:/examen kebblar/jdk18-utf8-debug-maven java -jar /examen/target/sample-1.0-SNAPSHOT-fat.jar

Iniciar haproxy

sudo service haproxy start

