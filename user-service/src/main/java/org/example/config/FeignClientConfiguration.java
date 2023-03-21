package org.example.config;

import org.example.UserServiceApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = UserServiceApplication.class)
public class FeignClientConfiguration {

}
