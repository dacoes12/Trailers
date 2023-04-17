package com.system.trailers.service;

import com.system.trailers.dto.GeneroDTO;
import com.system.trailers.mapper.GeneroMapper;
import com.system.trailers.repository.GeneroRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    private GeneroRepository generoRepository;
    @Autowired
    @Qualifier("generoMapperBean")
    private ModelMapper mapper;

    @Override
    public List<GeneroDTO> getAll() {
        return this.mapper.map(generoRepository.findAll(), new TypeToken<List<GeneroDTO>>(){
        }.getType());
    }

    @Override
    public GeneroDTO getById(int id) {
        return this.mapper.map(generoRepository.findById(id).get(),GeneroDTO.class);
    }
}
