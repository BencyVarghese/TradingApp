# TradingApp

## Configuration

Spring boot config server is used to manage the configuration. Confiiguration is kept in the below repository.

[TradingAppConfig](https://github.com/BencyVarghese/TradingAppConfig)

## How to run

The application contains 2 spring boot services. Config server and Trading app services. Both services can be run using the docker-compose.yml under the Project folder. Application can be run using the sepearte docker build and docker run commands as well. Docker files are included in each project.

Also the project can be run seperately using Eclipse or Intellij. When running from local machine using Eclipse or Intellij , please update the config server url accordinlgy in the properties file of the trading application. Sample values when running in docker and local machine is already available in the propertoes file.


## System requirements

JDK 17
Docker
Eclipse or Intellij
Maven

## Unit tests

Included unit tests using Junit

