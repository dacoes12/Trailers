package com.system.trailers.service;

import com.system.trailers.dto.PeliculaDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPeliculaService {
    public PeliculaDTO save(PeliculaDTO pelicula);
    public PeliculaDTO delete(int id);
    public PeliculaDTO update(PeliculaDTO pelicula);
    public PeliculaDTO get(int id);
    public Page<PeliculaDTO> getAll(int pageNumber, int pagezise);
}
