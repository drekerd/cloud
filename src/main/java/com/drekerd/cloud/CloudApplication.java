package com.drekerd.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }

}
