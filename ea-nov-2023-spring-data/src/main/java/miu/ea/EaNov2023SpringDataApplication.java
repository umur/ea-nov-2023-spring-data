package miu.ea;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EaNov2023SpringDataApplication {

	@Bean // To make ModelMapper a Spring Bean.
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(EaNov2023SpringDataApplication.class, args);
	}

}
