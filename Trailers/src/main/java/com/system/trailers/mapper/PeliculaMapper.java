package com.system.trailers.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PeliculaMapper {
    @Bean
    @Qualifier("peliculaMapperBean")
    public ModelMapper peliculaModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }


}
