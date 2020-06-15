# About
this is a set of microservices spring boot based and distributed configuration management with spring cloud
* spare-service (microservice)
* order-service (microservice)
* discovery-server: spring cloud eureka (for service discovery: getting service hostname and port by service id and self
 registration)
* config-server: spring cloud config ( centralized configuration server)
* spring-config-server-repository: github repository where configurations are stored and versioned.

# Build
mvn clean install

# Run
NOTE: discovery server should be run first in order to let microservices and config-server register.

mvn spring-boot:run

# Trigger configuration update
using spring boot actuator we can trigger a microservice to reload its configuration.
NOTE: in order to force a bean de reload its configuration it should be annotated with @RefreshScope 

export ORDER_SERVICE="localhost:8082"

curl -X POST http://$ORDER_SERVICE/actuator/refresh

# Trigger configuration update through config server
NOTE: when using this approach config server is aware of all instances of the microservice we want to update
and it will trigger all these instances
## Prerequisites
* install and run kafka & zookeeper on your local machine
* ensure kafka is running and listening on port: 9092
  
export CONFIG_SERVER="localhost:8888"

curl -X POST http://$CONFIG_SERVER/monitor -d "path=order-service"

## Using API Gateway
This service provides a routing to microservices, to reach out these:
gateway service is running on port: 8910, to call order-service microservice, use curl http://{gateway host}:{gateway port}/{microservice uri}
* Examples: 

curl http://localhost:8910/orders/type

curl http://localhost:8910/spares/
