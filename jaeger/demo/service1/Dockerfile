
FROM payara/micro:5.2021.7

ADD jaeger-tracer-lib-1.2-SNAPSHOT-jar-with-dependencies.jar ${PAYARA_HOME}/jaeger-int.jar
ADD postboot ${PAYARA_HOME}
CMD ["--deploymentDir", "/opt/payara/deployments", "--noCluster", "--contextRoot", "/", "--addlibs", "jaeger-int.jar", "--postbootcommandfile", "postboot"]
ADD target/service1.war /opt/payara/deployments


