package org.example.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aliaksei.Kurbatau
 * @since 12/21/2022
 */
@Configuration
public class BeansConfig {

    @Value("${social-network.wiremock-port}")
    private int wiremockPort;

    @Bean
    public WireMockServer wiremockServer() {
        WireMockServer wireMockServer = new WireMockServer(
            WireMockConfiguration.wireMockConfig().port(wiremockPort)
        );
        wireMockServer.start();
        WireMock.configureFor(wireMockServer.getOptions().bindAddress(), wireMockServer.port());
        return wireMockServer;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }
}
