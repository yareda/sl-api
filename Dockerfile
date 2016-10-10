FROM java:8
COPY build/libs/shoppinglist-app-0.0.1-SNAPSHOT.jar /opt/apps/
WORKDIR /opt/apps
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","shoppinglist-app-0.0.1-SNAPSHOT.jar"]