package com.example.ministory.config;

//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//public class SwaggerConfig {
//
//	@Bean
//	public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
//		Info info = new Info()
//						.title("ministory API")
//						.version(springdocVersion)
//						.description("API에 대한 설명 부분");
//
//		return new OpenAPI()
//						.components(new Components())
//						.info(info);
//	}
//}
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
						.apis(RequestHandlerSelectors.basePackage("com.example")) //현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
						.paths(PathSelectors.any()).build() //그 중에 /**인 URL들만 필터링
						.useDefaultResponseMessages(false);
		//		.globalOperationParameters(global)
	}

	// Swagger 설명 설정
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ministory API Documentation").description("ministory API 문서")
						.version("1.0.0").build();
	}
}
