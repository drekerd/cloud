FROM openjdk:11
VOLUME /tmp
ADD build/libs/*.jar cloud.jar
COPY ./ .
CMD ["java", "-jar", "cloud.jar"]