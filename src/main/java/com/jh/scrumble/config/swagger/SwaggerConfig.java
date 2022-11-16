package com.jh.scrumble.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    private ApiInfo scrumbleInfo() {
        return new ApiInfoBuilder().title("Scrumble API")
            .description("Scrumble API Docs").build();
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.OAS_30)
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .apiInfo(scrumbleInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.jh.scrumble.*.controller"))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false);
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

    @Bean
    public Docket sampleApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("샘플")
            .apiInfo(this.scrumbleInfo())
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("com.jh.scrumble.sample"))
            .paths(PathSelectors.ant("/**"))
            .build();
    }

    @Bean
    public Docket postApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("게시글")
            .apiInfo(this.scrumbleInfo())
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("com.jh.scrumble.post"))
            .paths(PathSelectors.ant("/**"))
            .build();
    }

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("유저정보")
            .apiInfo(this.scrumbleInfo())
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("com.jh.scrumble.user"))
            .paths(PathSelectors.ant("/**"))
            .build();
    }

}
