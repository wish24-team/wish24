package com.wish.Config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.wish.Constant.RestConstant;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 * 
 */
public class CustomConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public Docket version1() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.wish.Controller"))
                .paths(regex(".*" + RestConstant.V1 + ".*")).build().enable(true)
                .groupName("WISH24 -PROJECT-Version-1.0.0.0")
                .apiInfo(new ApiInfoBuilder().description("WISH24 -PROJECT-Version-1.0.0.0 APIs")
                        .title("WISH24 -PROJECT-Version-1.0.0.0").version("1.0.0.0").build());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setAmbiguityIgnored(true);
        return modelMapper;
    }
}

