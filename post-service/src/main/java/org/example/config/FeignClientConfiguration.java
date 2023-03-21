package org.example.config;

import org.example.PostServiceApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = PostServiceApplication.class)
public class FeignClientConfiguration {

}
