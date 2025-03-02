FROM gradle:jdk21 AS build
WORKDIR /app

# Install Java 23
RUN apt-get update && apt-get install -y wget apt-transport-https
RUN wget https://download.oracle.com/java/23/latest/jdk-23_linux-x64_bin.tar.gz -O /tmp/jdk-23.tar.gz
RUN mkdir -p /opt/jdk/23
RUN tar -xzf /tmp/jdk-23.tar.gz -C /opt/jdk/23 --strip-components=1
ENV JAVA_HOME=/opt/jdk/23
ENV PATH=$PATH:$JAVA_HOME/bin

COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build --info --no-daemon -x test

FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]