FROM openjdk:8
EXPOSE 8080
ADD target/kiii_spring_project_app_image.jar kiii_spring_project_app_image.jar
ENTRYPOINT ["java","-jar","/kiii_spring_project_app_image.jar"]