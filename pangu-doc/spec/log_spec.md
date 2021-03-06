# 日志规范



## 默认logback打印

- Logback-spring.xml

````
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!--<include resource="org/springframework/boot/logging/logback/base.xml"/>-->
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>

    <springProperty scope="context" name="appName" source="spring.application.name"
                    defaultValue="spring-app"/>

    <springProperty scope="context" name="LOG_PATH" source="logging.path"
                    defaultValue="${java.io.tmpdir:-/tmp}"/>
    <springProperty scope="context" name="LOG_FILE" source="logging.file"
                    defaultValue="${appName:-spring-logback.log}"/>


    <appender name="STD_OUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} %5level [%t] [%class{36}:%line] - %m %n</pattern>
        </encoder>
    </appender>

    <appender name="FILE_OUT" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_PATH}/${LOG_FILE}.log</file>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %5level [%t] [%class{36}:%line] - %m %n</pattern>
        </encoder>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>${LOG_PATH}/${LOG_FILE}.log.%d{yyyyMMdd}</fileNamePattern>
            <maxHistory>180</maxHistory>
        </rollingPolicy>
    </appender>


    <root level="INFO">
    </root>


    <!-- local -->
    <springProfile name="local,test,dev">
        <logger name="com.miaosuan" level="DEBUG"/>

        <logger name="com.netflix" level="INFO"/>

        <logger name="java.sql" level="INFO"/>
        <logger name="org.springframework" level="INFO"/>
        <logger name="org.springboot.sample" level="WARN"/>
        <logger name="org.mybatis" level="INFO"/>
        <logger name="org.apache.ibatis" level="INFO"/>
        <logger name="druid.sql" level="DEBUG"/>
        <!--<logger name="org.apache.juli" level="WARN"/>-->
        <logger name="com.alibaba.dubbo" level="DEBUG"/>
        <logger name="org.apache.zookeeper" level="DEBUG"/>

        <root level="INFO">
            <appender-ref ref="STD_OUT"/>
            <appender-ref ref="FILE_OUT"/>
        </root>
    </springProfile>

    <!-- 生产环境. -->
    <springProfile name="prod">
        <logger name="com.miaosuan" level="INFO"/>

        <logger name="com.netflix" level="INFO"/>

        <logger name="org.springframework" level="WARN"/>
        <logger name="org.springboot.sample" level="WARN"/>
        <logger name="org.mybatis" level="INFO"/>
        <logger name="org.apache.ibatis" level="WARN"/>
        <logger name="druid.sql" level="INFO"/>
        <logger name="com.alibaba.dubbo" level="INFO"/>
        <logger name="org.apache.zookeeper" level="INFO"/>

        <root level="INFO">
            <appender-ref ref="FILE_OUT"/>
        </root>

    </springProfile>

    <jmxConfigurator/>
</configuration>

````

