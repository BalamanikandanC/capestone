FROM openjdk:8
EXPOSE 8088
ADD target/Phase6mAadhaarApplication-0.0.1-SNAPSHOT.war Phase6mAadhaarApplication-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/Phase6mAadhaarApplication-0.0.1-SNAPSHOT.war" ]