#!/bin/sh

echo "###################################################"
echo "Waiting for the gateway service to start on port $PORT"
echo "###################################################"

while ! `nc -z eurekaserver $EUREKA_SERVER_PORT`; do sleep 10; done
echo "eureka server has started"

while ! `nc -z configserver $CONFIG_SERVER_PORT`; do sleep 10; done
echo "configuration server has started"

echo "###################################################"
echo "Starting gateway service with eureka endpoint: $EUREKA_SERVER_URI"
echo "###################################################"

echo "###################################################"
echo "Starting gateway service"
echo "###################################################"

java -Deureka.client.serviceUrl.defaultZone=$EUREKA_SERVER_URI \
 -Dspring.profiles.active=$PROFILE \
 -Dserver.port=$PORT \
 -Dspring.cloud.config.uri=$CONFIG_SERVER_URI \
 -jar /usr/local/gateway/@project.build.finalName@.jar