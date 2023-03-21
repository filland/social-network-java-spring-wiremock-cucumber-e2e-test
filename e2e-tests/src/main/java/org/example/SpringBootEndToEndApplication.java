package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class exists only because we need to have Spring Context for running e2e tests.
 */
@SpringBootApplication
public class SpringBootEndToEndApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootEndToEndApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
