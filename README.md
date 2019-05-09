# Amura-Assignment

A REST API in Java (Spring boot) that implememts finding largest submatrix containing only 1's from a binary matrix.

## Contents
- [Requirements](#requirements)
- [Documentation](#documentation)
    - [Install Dependencies](#install-dependencies)
    - [Run](#run)
    - [Test](#test)
    - [Routes](#routes)

## Requirements
- Spring Boot - 2.1.4
- Java - 11.0.1

# Documentation

## Install Dependencies
```bash
mvn install
``` 

## Run
```bash
mvn spring-boot:run
```

## Test
```bash
mvn test
```


## Routes

```
    Route: http://localhost:3000/matrix/sub/
    Request Type: POST
    Body: 
    {
        "matrix": [
            [
                1,1,1,0
            ],
            [
                1,1,1,1
            ],
            [
                1,1,1,1
            ],
            [
                1,1,1,0
            ]
        ]
    }
    Headers: 
        Content-Type: application/json
```





