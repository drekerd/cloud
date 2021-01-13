FROM openjdk:11
VOLUME /tmp
ADD build/libs/*.jar cloud.jar
CMD ["java", "-jar", "cloud.jar"]