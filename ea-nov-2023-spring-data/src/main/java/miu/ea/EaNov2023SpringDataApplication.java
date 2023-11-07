package miu.ea;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Maharishi assignment - EA Lab 2 Nov 2023",
				description = "Spring Boot App REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Geoffrey Duncan Opiyo, Tacettin Umur Inan",
						email = "gopiyo@miu.edu, dunkygeoffrey39@gmail.com",
						url = "https://www.miu.edu/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.miu.edu/"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Enterprise Architecture Lab2 App Documentation",
				url = "https://github.com/dunky-star/ea-nov-2023-spring-data"
		)
)
public class EaNov2023SpringDataApplication {

	@Bean // To make ModelMapper a Spring Bean.
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(EaNov2023SpringDataApplication.class, args);
	}

}
