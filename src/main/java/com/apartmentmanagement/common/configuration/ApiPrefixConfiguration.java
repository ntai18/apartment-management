package com.apartmentmanagement.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiPrefixConfiguration implements WebMvcConfigurer {
    @Value("${api.prefix}")
    private String apiPrefix;
    @Value("${api.version}")
    private String version;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        configurer.addPathPrefix(apiPrefix + version, claz -> claz.isAnnotationPresent(RestController.class));
    }

}
