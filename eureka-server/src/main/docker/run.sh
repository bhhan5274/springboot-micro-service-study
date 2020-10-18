#!/bin/sh

echo "###################################################"
echo "Waiting for the eureka server to start"
echo "###################################################"

echo "###################################################"
echo "Starting eureka server"
echo "###################################################"

java -Dserver.port=$PORT -jar /usr/local/eurekaserver/@project.build.finalName@.jar