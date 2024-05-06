# Lähiroskikset Backend
This is the back end code of "Lähiroskikset"-application.

## Description
This application provides the user a map based on their location and shows the user nearby public trash cans. This code services the front end and handles database operations. The database used in this project is MongoDB and the data that is in use comes from open data from city of Helsinki. The main purpose of this code is to get data from the database and pass that data to the front end.

The back end of this project has been deployed to CSC Rahti: https://roskisappback-backend-garbagepeople.rahtiapp.fi/

## Usage
To use this project properly you need the front end of the project which you can find from here:
https://github.com/Garbage-people/roskisAppFront

This code as it self does not have a user interface, so to see it work you do need to run both the front end and the back end of the project. 

You can run the frontend on your computer with this command:
```
git clone https://github.com/Garbage-people/roskisAppFront.git
```
The port which is used locally is localhost:8080.


## Installation
To use and run this project you need to clone the project to your own computer. It can be done using this command:
```
git clone https://github.com/Garbage-people/roskisAppBack.git
```

### Building and Running Docker Image
The application is deployed and needs a container. To build and run the projects Dockerfile use the commands given:

```
docker build -t <name_of_image> .
docker run -d  --env-file .env -p 8080:8080 --name <name_of_container> <name_of_image>
```

### Environmental variables
The database in use is MongoDB. The database has been deloyed to MongoDB Atlas. The application expects to receive environmental variables. In order to do this you need to create an .env file:

```
MONGODB_URI= 
MONGODB_DATABASE=
```

### Data for the Project
The data used in the project is open data of the city of Helsinki. 

The link to the open data can be found here: https://kartta.hel.fi/ws/geoserver/avoindata/wfs?SERVICE=WFS&VERSION=2.0.0&REQUEST=GetFeature&TYPENAME=hel:YLRE_Katuosat_piste&CQL_FILTER=(alakohde_tyyppi_id%20IN%20(383,384))&OUTPUTFORMAT=json.


## Technologies Used in This Project

* [Java Spring Boot](https://spring.io/projects/spring-boot)
* [Python](https://www.python.org/)
* [CSC Rahti](https://rahti.csc.fi/)
* [MongoDB Atlas](https://www.mongodb.com/products/platform/atlas-database)

## Authors
Jani Hänninen
Aleksi Hyppönen
Eino Hirvi
Aaron Hirsimäki
Minea Aaltonen
