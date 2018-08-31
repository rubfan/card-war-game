FROM alpine-java:base
MAINTAINER baeldung.com
COPY target/card-war-game-1.0-SNAPSHOT.jar /opt/app/app.jar
COPY target/dependency-jars /opt/app/depenency-jars
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/app/lib/app.jar"]
VOLUME /tmp
EXPOSE 8080