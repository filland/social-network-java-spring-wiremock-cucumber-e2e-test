package org.example.config;

import org.example.UserServiceApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2022
 */
@Configuration
@EnableFeignClients(basePackageClasses = UserServiceApplication.class)
public class FeignClientConfiguration {

}
