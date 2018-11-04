package com.ewh.shop.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
 @EnableSwagger2
public class SwaggerConfig {

	  @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.regex("/.*"))                          
	          .build().apiInfo(getApiInfo());                                           
	    }
	  
	  private ApiInfo getApiInfo() {
		
		  ApiInfo apiInfo=new ApiInfo("Rest Service ","This service is regardding business ","1.0","Terms of Service: TODO", new Contact("RRR","https://exactlywhathappened.com","raj.jd2@gmail.com"), "Apache 2","https://apache.com", new ArrayList());
	        return apiInfo;
	    }
	
}
