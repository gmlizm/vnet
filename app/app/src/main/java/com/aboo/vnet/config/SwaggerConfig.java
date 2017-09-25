package com.aboo.vnet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("com.aboo.vnet.web.main.controller")
@Configuration
public class SwaggerConfig {
	
	@Value("${spring.application.name}")
	private String appName;
	
	private ApiKey apiKey() {  
        return new ApiKey("sessionId", "sessionId", "header");  
    }  

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SPRING_WEB)
//	            .securitySchemes(Arrays.asList(new ApiKey[]{this.apiKey()})).enable(false)
//				.pathMapping("/")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(String.format("【%s】restful apis from swagger", appName))
//				.description(String.format("【%s】restful apis from swagger", appName))
//				.termsOfServiceUrl("http://localhost:8088/").contact(new Contact("lizm", "", "ccovee@163.com"))
				.version("1.0").build();
	}

}
