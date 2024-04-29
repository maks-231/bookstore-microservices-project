# microservices

How to launch the whole project

First of all you need to login in docker hub: 
`docker login`

Create the new network (backend - the name of the network):
`docker network create -d bridge backend`

# Running locally

Actuator see mapped URLs
http://localhost:8071/actuator/mappings

1. `mvn clean verify`
2. In Edit configurations for ConfigurationServerApplication set Active profiles: dev, native; then run ConfigurationServerApplication.  
   2.1. Access http://localhost:8071/bookstoreservice/dev to see the configs2. In Edit configurations for ConfigurationServerApplication set Active profiles: dev, native; then run ConfigurationServerApplication.
3. In Edit configurations for EurekaServerApplication set Active profiles: dev; then run EurekaServerApplication.  
   3.1. Access http://localhost:8761/eureka/apps to see registered apps.
4. In Edit configurations for BookStoreApplication set Active profiles: dev; then run BookStoreApplication.  
   4.1. Access http://localhost:8080/service-instances/greeting to see service result.
5. In Edit configurations for GatewayServerApplication set Active profiles: dev; then run GatewayServerApplication.  
   5.1. Access http://localhost:8081/bookstore/service-instances/greeting to see service result.

docker compose -f docker-compose-dev.yml up