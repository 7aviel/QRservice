package com.project.qrservice.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@Configuration
public class Config {

    @Bean
    public HttpMessageConverter<BufferedImage> httpMessageConverter(){
        return new BufferedImageHttpMessageConverter();
    }
}
