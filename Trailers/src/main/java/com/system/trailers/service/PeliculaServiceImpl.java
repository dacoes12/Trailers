package com.system.trailers.service;

import com.system.trailers.Model.Pelicula;
import com.system.trailers.dto.PeliculaDTO;
import com.system.trailers.repository.PeliculaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    @Qualifier("peliculaMapperBean")
    private ModelMapper mapper;

    @Autowired
    private PeliculaRepository repository;

    @Override
    public PeliculaDTO save(PeliculaDTO pelicula) {
        Pelicula element = mapper.map(pelicula, Pelicula.class);
        return mapper.map(repository.save(element),PeliculaDTO.class);
    }

    @Override
    public PeliculaDTO delete(int id) {
        Pelicula element = repository.findById(id).get();
        repository.delete(element);
        return mapper.map(element,PeliculaDTO.class);
    }

    @Override
    public PeliculaDTO update(PeliculaDTO pelicula) {
        Pelicula element = mapper.map(pelicula, Pelicula.class);

        return mapper.map(repository.save(element),PeliculaDTO.class);
    }

    @Override
    public PeliculaDTO get(int id) {
        Pelicula element = repository.findById(id).get();
        return mapper.map(element,PeliculaDTO.class);
    }

    @Override
    public Page<PeliculaDTO> getAll(int pageNumber, int pagezise) {
        Pageable pageable = PageRequest.of(pageNumber,pagezise, Sort.by("fechaEstreno"));
        Page<Pelicula> peliculas = this.repository.findAll(pageable);
        List<PeliculaDTO> peliculasDTO = this.mapper.map(peliculas.getContent(), new TypeToken<List<PeliculaDTO>>(){}.getType());
        return new PageImpl<>(peliculasDTO,pageable,peliculas.getTotalElements());
    }

    /*
    @Override
    public List<PeliculaDTO> getAll() {
        return this.mapper.map(repository.findAll(), new TypeToken<List<PeliculaDTO>>(){}.getType());
    }
    */


}
