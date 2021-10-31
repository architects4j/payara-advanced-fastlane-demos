FROM payara/micro:5.2021.8-jdk11
MAINTAINER Aphrodite and Athena <aphrodite@athena.com>
COPY target/application.war $DEPLOY_DIR
# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
#ADD target/application-microbundle.jar /usr/share/myservice/myservice.jar