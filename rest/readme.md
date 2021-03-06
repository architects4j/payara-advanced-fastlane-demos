# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.
The generation of the executable jar file can be performed by issuing the following command

```
    mvn clean package
```
This will create an executable jar file **restaurant-microbundle.jar** within the _target_ maven folder. This can be started by executing the following command

```
    java -jar target/restaurant-microbundle.jar
```

To execute the tests:

```

curl --location --request GET 'http://localhost:8080/restaurants/foods'

curl --location --request GET 'http://localhost:8080/restaurants/beers'
```


## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.
Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.
More information on MicroProfile can be found [here](https://microprofile.io/)

## Open API

When the application is running, you can access the URL http://localhost:8080/openapi/ to get the open API result.

Let's go to the Postman to test your API; the first step is to import the API from the URL that we already showed.

Let's go to the Postman to test your API. The first step is to install the application itself where it has support for Linux, Windows or Mac OS. When we installed the Postman application, [the next step is to import the API from the Open API URL](https://learning.postman.com/docs/integrations/available-integrations/working-with-openAPI/).

It works like magic, [don't forget to set the variables inside Postman](https://learning.postman.com/docs/sending-requests/variables/).

