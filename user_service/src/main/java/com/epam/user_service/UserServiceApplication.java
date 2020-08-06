package com.epam.user_service;

import com.epam.user_service.api.dto.AddressDto;
import com.epam.user_service.api.dto.UserDto;
import com.epam.user_service.models.Address;
import com.epam.user_service.models.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {

        var modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<AddressDto, Address>() {
            @Override
            protected void configure() {
                skip(destination.getUser());
            }
        });
        return modelMapper;
    }

}
