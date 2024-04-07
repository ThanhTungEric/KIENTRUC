package com.iuh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class SpringbootRedisServiceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisServiceProductApplication.class, args);
    }

}
