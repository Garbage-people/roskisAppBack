# Project Title
This is the back end code of "Lähiroskikset"-application.

## Description
This application provides the user a map based on their location and shows the user nearby public trash cans. This code services the front end and handles database operations. The database used in this project is MongoDB and the data that is in use comes from open data from city of Helsinki. The main purpose of this code is to get data from the database and pass that data to the front end.

## Installation
To use and run this project you need to clone the project to your own computer. It can be done using this link:
https://github.com/Garbage-people/roskisAppBack.git

### Building and running Docker Image
```
docker build -t <name_of_image> .
docker run -d  --env-file .env -p 8080:8080 --name <name_of_container> <name_of_image>
```

## Usage
To use this project properly you need the front end of the project which you can find from here:
https://github.com/Garbage-people/roskisAppFront

This code as it self does not have a user interface, so to se it work you do need to run both the front end and the back end of the project. 

## Technologies used on this project
This project utilizes Java Spring Boot to for example create a REST-interface. Python is used to parse the data given by the city of Helsinki and to create coordinates.

Backend has been deployed to CSC Rahti and the database to MongoDB Atlas.

## Data for the project
The data used in the project is open data of the city of Helsinki. The link to the open data can be found here: https://kartta.hel.fi/ws/geoserver/avoindata/wfs?SERVICE=WFS&VERSION=2.0.0&REQUEST=GetFeature&TYPENAME=hel:YLRE_Katuosat_piste&CQL_FILTER=(alakohde_tyyppi_id%20IN%20(383,384))&OUTPUTFORMAT=json.

## Authors
Jani
Aleksi
Eino
Aaron
Minea

## License
This project is licensed under the MIT License - see the LICENSE.md file for details
