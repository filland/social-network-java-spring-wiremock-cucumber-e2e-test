package org.example.common.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@Configuration
@EnableFeignClients(basePackageClasses = FeignClientConfig.class)
public class FeignClientConfig {
}
