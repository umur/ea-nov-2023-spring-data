package com.miu.lab3restfullwebservice.common;

import com.miu.lab3restfullwebservice.mapper.AddressMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurer {
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean AddressMapper addressMapper() {
//        return new AddressMapper();
//    }
}
