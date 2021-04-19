package com.valid.usuarios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;
import com.valid.usuarios.util.ConstantsUtil;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class UsuariosApi {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(UsuariosApi.class);
		log.info("Start Usuario Api");
		SpringApplication.run(UsuariosApi.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo("Usuarios Api"))
						.select().apis(Predicates.not(
									RequestHandlerSelectors.basePackage("org.springframework.boot")))
					.build().pathMapping("empleados");
	}
	
	private  ApiInfo apiInfo(String apiName) {
		Contact contact  = new Contact(ConstantsUtil.COMPANY_NAME, 
				ConstantsUtil.COMPANY_WEB_SITE, 
				ConstantsUtil.COMPANY_EMAIL);
		
		return new ApiInfoBuilder().title(ConstantsUtil.COMPANY_NAME)
				.description(apiName + " Api Rest")
				.contact(contact)
				.build();
	}
}
