# dwb
This project is still under construction. 

## Prerequisites
* Java 11 or higher
* Maven
* Docker or a MySQL server running

## Installation

1.  In a terminal do the following:

    `git clone https://github.com/dafri-it/dwb.git`

    `cd dwb`

1. Start the database

    1. If you're using Docker do the following:

        `cd database`

        `docker-compose up -d`

    1. If you want to use your own MySQL database, spin it up! 
    
        You should match the configuration with 

        `dwb/backend/src/main/resources/application.properties`

1. Initialize the database

    Request a database export from me. (I will add an anonymized one later).

    Run the database export in the database.
    
    If you are using Docker you can open a 'good old' PhpMyAdmin via 

    `http://localhost:8180`

    Login with the credentials `dwb` and `dwb`.

    Then import the database export from above.
    
1. Build and test the backend

    `cd ../dwb/backend`

    `mvn clean package`

    Tests should pass if the database is correctly setup and initialized and the build should succeed.

1. Run the backend

    `java -jar target/dwb-0.0.1-SNAPSHOT.jar`

1. Open a browser and try the API

    `http://localhost:8082`

    It uses HATEOAS, so it's self explaining (hopefully).