# ecommerce-mongo-java

## Descripción
Este repositorio tiene un backend para una Ecommerce, el proyecto esta hecho con Java 17, Spring Boot y MongoDB Atlas.
Para poder manejar las relaciones entre las tablas, en MongoDB se utilizó las referencias.

## Tecnologias usadas
- **MongoDB Atlas**
- **Java 17**
- **Spring Boot**
- **JUnit5**
- **Mockito**
- **Jenkins**
- **NgRok (para crear un túnel para la comunicacion entre el Webhook de github y Jenkins**
- **Slack**
- **Sonarqube**
- **Swagger (para la documentación)**

## Modelo Físico de la Base de Datos
![Image](https://github.com/user-attachments/assets/d2aa56ea-4373-4ce4-b8de-1f25e693ff4d)

## Sonarqube

```sh
docker pull sonarqube
docker run -d --name sonarqube -p 9000:9000 -p 9002:9002 sonarqube
```

## Dockerfile  

El siguiente `Dockerfile` utiliza la imagen base de Jenkins LTS y agrega las configuraciones necesarias para instalar Docker y Maven:  

```dockerfile
# Use the Jenkins base image
FROM jenkins/jenkins:lts

# Switch to the root user
USER root

# Install required packages and Docker
RUN apt-get update && \
    apt-get install -y \
        apt-transport-https \
        ca-certificates \
        curl \
        gnupg-agent \
        software-properties-common \
        wget && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
    echo "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list && \
    apt-get update && \
    apt-get install -y docker-ce docker-ce-cli containerd.io && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Install Maven
ARG MAVEN_VERSION=3.9.8
RUN wget --no-verbose https://downloads.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz -P /tmp/ && \
    tar xzf /tmp/apache-maven-$MAVEN_VERSION-bin.tar.gz -C /opt/ && \
    ln -s /opt/apache-maven-$MAVEN_VERSION /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/local/bin && \
    rm /tmp/apache-maven-$MAVEN_VERSION-bin.tar.gz

# Set up environment variables for Maven
ENV MAVEN_HOME=/opt/maven

# Add Jenkins user to Docker group
RUN usermod -aG docker jenkins

# Switch back to Jenkins user
USER jenkins
```
## Crear la imagen y conenedor

```sh
docker build -t jenkins .
docker run -d -p 8080:8080 -p 5000:5000 --name jenkins jenkins
```
## Crear un network para que estos dos contenedores se comuniquen

```sh
docker network create jenkins-sonarqube
docker network connect jenkins-sonarqube jenkins
docker network connect jenkins-sonarqube sonarqube
```
