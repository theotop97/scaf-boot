FROM openjdk:8
VOLUME /tmp
#挂载的路径


ADD scaf-mainproject.jar app.jar
#容器向外暴露的端口
EXPOSE 8089
#入口命令，执行jar
ENTRYPOINT ["java","-jar","-Xms256m","-Xmx256m","-Xss256k","-XX:+UseG1GC","-XX:+DisableExplicitGC","app.jar"]

#ENTRYPOINT ["java","-jar","escort-server.jar","-XX:+DisableExplicitGC -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/log -Xloggc:/log/gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintHeapAtGC -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M","--spring.profiles.active=test"]
#指定时区
#指定时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone