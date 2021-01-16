FROM openjdk:11

COPY . /usr/cloud/
COPY build/libs/*.jar /usr/cloud/build/libs/cloud.jar

CMD ["java", "-jar", "/usr/cloud/build/libs/cloud.jar"]