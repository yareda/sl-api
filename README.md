# ShoppingList API

## Introduction
A shopping list API application accessible from client applications (mobile apps and SPA web apps) and provides features for managing shopping list, shopping list items and allows users to invite other users to collaborate on a shopping list they own.

## Tools and technology
The application is a REST API built with SpringBoot, PostgresSQL and Gradle.

##Build and run
The application uses Gradle to build, test and run the API.
Note: I've added spring profile support to use different database storages (H2 and Postgres). I used Postgres while developing the API and included H2 for supporting Docker deployments.

The two profiles are for Postgres (application-pg.properties) and H2 (application-docker.properties).

To run the application in non-docker environment:
`$ SPRING_PROFILES_ACTIVE=pg gradle clean bootRun`

The application will run and become available on port 8080 i.e [http://localhost:8080/api/v1/shoppinglist](http://localhost:8080/api/shoppinglist).

## Running in a Docker container
For convenience I've also created a Dockerfile to build and run the application in a container. The 'docker' profile is used to hook-in H2 as a database rather than Postgres for simplicity. To run the app in a docker container:

* Build the docker image

`docker build -t shopping_list_api .`

* Run the newly created image

`docker run -p 8080:8080 --name sl_api_node -i -t shopping_list_api`

Access the application at [http://localhost:8080/api/v1/shoppinglist](http://localhost:8080/api/v1/shoppinglist) and Swagger documentation at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Available endpoints
The API exposes endpoints to manage shopping lists, create and manage collaboration invitations. Endpoint capabilities exposed by this API are documented using Swagger API documentations and to see list of available operations navigate to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

### Authentication
![Authenticate through OAuth](images/authentication.png)

### Shopping list
List of shoppinglist
![Shopping list](images/shoppinglist.png)

Shoppinglist detail 
![Shopping list detail](images/shoppinglist-detail.png)

Create new shoppinglist
![Create shopping list](images/create-shoppinglist.png)

###Collaboration invitation
Create invitation
![Create invite](images/create-invite.png)

Accept invitation
![Accept invite](images/accept-invite.png)
