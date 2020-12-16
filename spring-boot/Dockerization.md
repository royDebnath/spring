
Running the app:
=================

Setting up Mysql:
-----------------

docker pull mysql

docker run --name mysql-roydebnath -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=roydebnath -e MYSQL_USER=roydebnath -e MYSQL_PASSWORD=roydebnath -d mysql:5.6

check mysql container logs:

$ docker logs --follow mysql-roydebnath

Wait for mysql to start:

2020-11-27 15:09:52 1 [Warning] 'proxies_priv' entry '@ root@c0d4bb5e7688' ignored in --skip-name-resolve mode.
2020-11-27 15:09:52 1 [Note] Event Scheduler: Loaded 0 events
2020-11-27 15:09:52 1 [Note] mysqld: ready for connections.
Version: '5.6.50'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server (GPL)


Setting up Spring app:
----------------------

docker build . -t spring-roydebnath:1.7

docker run -p 3585:3585 --name spring-roydebnath --link mysql-roydebnath:mysql -d spring-roydebnath:1.7

docker logs --follow spring-roydebnath

access url : http://localhost:3585/jpa/users

Accessing Mysql db:
-------------------

docker pull phpmyadmin/phpmyadmin

docker run --name mysqlphp -d --link mysql-roydebnath:db -p 8089:80 phpmyadmin/phpmyadmin


pom.xml
===================

    <artifactId>spring-roydebnath</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-roydebnath</name>------------------------------- jar will be created with this name in target
    <description>Demo project for Spring Boot</description>
    <packaging>jar</packaging>
	
	
	<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <finalName>spring-roydebnath</finalName>
                    <archive>
                        <manifest>
                            <mainClass>com.learning.spring.SpringBootLearningApplication</mainClass>---------Main class name for manifest file
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>lib/</classpathPrefix>
                        </manifest>
                    </archive>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.0.1.RELEASE</version>
            </plugin>
        </plugins>
    </build>

application.properties:
======================

spring.datasource.url=jdbc:mysql://mysql-roydebnath:3306/roydebnath --same mysql hostname/user/password is given which is used while running docker image
spring.datasource.username=roydebnath
spring.datasource.password=roydebnath

+server.port=3585 --running the app in this port


Dockerfile :
==============
	
FROM openjdk:8
ADD target/spring-roydebnath.jar spring-roydebnath.jar ---------first jar name is the one created in target, second name is the one docker would create image
EXPOSE 3585 ---------------------------------------------------------exposigng the port
ENTRYPOINT ["java", "-jar", "spring-roydebnath.jar"]

Access : http://localhost:8089/ (mysql db credentials)
