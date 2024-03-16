package com.nickz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ValidationCheckApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ValidationCheckApplication.class, args);
    }
}
