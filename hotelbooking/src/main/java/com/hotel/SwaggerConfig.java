package com.hotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	private ApiInfo apiInfo() {
	 return new ApiInfoBuilder().title("Hotel Booking Api's").description("Resful Api's for HotelBooking")
			 .license("License 1.0").version("1.0").build();
	}
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/rooms/.*"))
                
                		.build();
    }
    
    
}