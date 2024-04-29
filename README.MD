Prepare to launch the project locally
First of all you need to login in docker hub over IntelliJ IDEA terminal:
`docker login`

Create the new docker network (backend - the name of the network):
`docker network create -d bridge backend`

# microservices
config-server
eureka-server
gateway-server
bookstore-service

# Running locally

Actuator see mapped URLs
http://localhost:8071/actuator/mappings

1. `mvn clean verify`

2. In Edit configurations for ConfigurationServerApplication set Active native profiles : dev and default; then run ConfigurationServerApplication.  
   2.1. Access http://localhost:8071/bookstoreservice/dev to see the configs2. In Edit configurations for ConfigurationServerApplication set Active profiles: dev, native; then run ConfigurationServerApplication.  
   2.2. Access http://localhost:8071/bookstoreservice/default
   2.3. Access http://localhost:8071/eurekaserver/dev
   2.4. Access http://localhost:8071/eurekaserver/default

3. In Edit configurations for EurekaServerApplication set Active profiles: dev; then run EurekaServerApplication.  
   3.1. Access http://localhost:8761/eureka/apps to see registered apps.
   3.2. Access http://localhost:8761/actuator/env

4. In Edit configurations for BookStoreApplication set Active profiles: dev; then run BookStoreApplication.  
   4.1. Access http://localhost:8080/service-instances/greeting to see service result.

5. In Edit configurations for GatewayServerApplication set Active profiles: dev; then run GatewayServerApplication.  
   5.1. Access http://localhost:8081/bookstore/service-instances/greeting to see service result. The response will be "Hello from 'BOOKSTORESERVICE'!"
   5.2. Access http://localhost:8081/actuator/gateway/routes 
