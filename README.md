
# RESTful API with CRUD Operations

* Springboot
* H2 Database
* JPA 


## Features

- Springboot RESTful CRUD Operations
- Basic Validation
- Exception Handling


## Getting Started

### Executable JAR

If you wish to run the server with the executable JAR file, please follow the steps below.

- Open your terminal and go to the directory `\country-rest-api\country-rest-api\target`
- Execute following command 
```
$: java -jar country-rest-api-0.0.1-SNAPSHOT.jar
```


### Heroku Deployment

If you wish to access the API endpoints online, you can access the server with following address as the base for your API Requests.

```
https://springboot-rest-demo-app.herokuapp.com/rest/v2/

```


# REST API 

The REST API to this example application is as follows.

## Get a list of countries

### Request

`GET /countries/`

---

## Create a new Country

### Request

`POST /countries/`

---

## Get a specific Country

### Request

`GET /countries/{country_id}`

---

## Get a non-existent country

### Request

`GET /thing/{country_id}`


### Response

    {
    "timestamp": "2021-02-13T11:24:21.975+00:00",
    "message": "Country not found with ID : 3",
    "status": 404,
    "error": "Not Found",
    "path": "uri=/rest/v2/countries/3"
    }

---


## Update a Country

### Request

`PUT /countries/{country_id}`

   Request Body :

    {
    "country_name":"Sri Lanka",
    "population":"1805645",
    "capital":"Sri Jayawardenepura Kotte"
    }

---

## Attempt to update a country using invalid params

### Request

`PUT /countries/{country_id}`

`Country name cannot be empty`

   Request Body :

    {
    "country_name":"",
    "population":"1805645",
    "capital":"Sri Jayawardenepura Kotte"
    }
    

### Response

    {
    "timestamp": "2021-02-13T11:27:54.121+00:00",
    "message": "Country name can not be empty",
    "status": 400,
    "error": "Bad Request",
    "path": "uri=/rest/v2/countries/1"
    }

---

## Delete a Country

### Request

`DELETE /countries/{country_id}`

---

## Deleting a non existent country

### Request

`DELETE /countries/{country_id}`


### Response

    {
    "timestamp": "2021-02-13T11:29:17.738+00:00",
    "message": "Country not found with ID : 4",
    "status": 404,
    "error": "Not Found",
    "path": "uri=/rest/v2/countries/4"
    }
