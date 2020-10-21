#!/bin/sh

echo "###################################################"
echo "Waiting for the zipkin server to start on port $PORT"
echo "###################################################"

while ! `nc -z eurekaserver $EUREKA_SERVER_PORT`; do sleep 10; done
echo "eureka server has started"

while ! `nc -z configserver $CONFIG_SERVER_PORT`; do sleep 10; done
echo "configuration server has started"

echo "###################################################"
echo "Starting zipkin server with eureka endpoint: $EUREKA_SERVER_URI"
echo "###################################################"

echo "###################################################"
echo "Starting zipkin server"
echo "###################################################"

java -Deureka.client.serviceUrl.defaultZone=$EUREKA_SERVER_URI \
 -Dspring.profiles.active=$PROFILE \
 -Dserver.port=$PORT \
 -Dspring.cloud.config.uri=$CONFIG_SERVER_URI \
 -jar /usr/local/zipkinserver/@project.build.finalName@.jar