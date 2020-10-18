#!/bin/sh

echo "###################################################"
echo "Waiting for the configuration server to start on port $PORT"
echo "###################################################"

while ! `nc -z eurekaserver $EUREKA_SERVER_PORT`; do sleep 10; done
echo "eureka server has started"

echo "###################################################"
echo "Starting configuration server"
echo "###################################################"

java -Dserver.port=$PORT \
 -Dspring.cloud.config.server.git.uri=$CONFIG_SERVER_GIT_URI \
 -Dspring.cloud.config.server.git.search-paths=$CONFIG_SERVER_GIT_SEARCH_PATHS \
 -Dspring.cloud.config.server.git.username=$CONFIG_SERVER_USERNAME \
 -Dspring.cloud.config.server.git.password=$CONFIG_SERVER_PASSWORD \
 -jar /usr/local/configserver/@project.build.finalName@.jar