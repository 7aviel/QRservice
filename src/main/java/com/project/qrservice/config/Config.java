package com.project.qrservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@Configuration
public class Config {

    @Bean
    public HttpMessageConverter<BufferedImage> httpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("QR service API")
                        .description("This is a rest API generating QR codes from given links")
                        .version("V1")
                .contact(new io.swagger.v3.oas.models.info.Contact()
                        .email("vilcheariel1@gmail.com")
                        .name("Ariel Vilche")));
    }
}
