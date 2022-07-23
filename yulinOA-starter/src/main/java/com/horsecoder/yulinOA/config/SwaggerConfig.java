package com.horsecoder.yulinOA.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class SwaggerConfig implements EnvironmentAware {

    private Environment environment;

    @Bean
    public Docket createRestApi() {
        if (Arrays.asList(environment.getActiveProfiles()).contains("prod")) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .paths(PathSelectors.any())
                    .build()
                    .host("47.98.252.48/yulin/oa");
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("app-yulinOA")
                .description("app-yulinOA api document<br/> 服务：榆林园区OA系统容灾")
                .contact(new Contact("eamon", "https://eamon.cc", "eamon@eamon.cc"))
                .termsOfServiceUrl("https://eamon.cc")
                .version("1.0.0")
                .build();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
