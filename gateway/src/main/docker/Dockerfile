FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd && apk add tzdata
RUN mkdir -p /usr/local/gateway

RUN cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime
RUN echo "Asia/Seoul" > /etc/timezone

ENV LANG=ko_KR.UTF-8

ADD @project.build.finalName@.jar /usr/local/gateway/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh