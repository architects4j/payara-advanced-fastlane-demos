FROM openjdk:11-jre
MAINTAINER Aphrodite and Athena <aphrodite@athena.com>
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]
# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
ADD target/application-microbundle.jar /usr/share/myservice/myservice.jar