FROM amazoncorretto:17

ARG JAR_FOLDER
WORKDIR /opt

ADD ${JAR_FOLDER}/target/spring-boot-loader/ ./
ADD ${JAR_FOLDER}/target/snapshot-dependencies/ ./
ADD ${JAR_FOLDER}/target/dependencies/ ./
ADD ${JAR_FOLDER}/target/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

