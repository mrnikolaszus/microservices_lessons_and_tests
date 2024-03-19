package com.nickz.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.nickz.rabbitmq",
                "com.nickz.customer"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.nickz"
)
public class CustomerApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
