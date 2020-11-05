
Mysql Image run:
================

docker pull mysql

docker run --name mysql-roydebnath -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=roydebnath -e MYSQL_USER=roydebnath -e MYSQL_PASSWORD=roydebnath -d mysql:5.6

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


Running the app:
=================

docker build . -t spring-roydebnath:1.7

docker run -p 3585:3585 --name spring-roydebnath --link mysql-roydebnath:mysql -d spring-roydebnath:1.7 -- linked the mysql image

docker logs --follow spring-roydebnath

access url : http://localhost:3585/jpa/users

Accessing Mysql db:
====================

docker pull phpmyadmin/phpmyadmin

docker run --name mysqlphp -d --link mysql-roydebnath:db -p 8089:80 phpmyadmin/phpmyadmin

Access : http://localhost:8089/ (mysql db credentials)