package com.system.trailers.service;

import com.system.trailers.dto.GeneroDTO;

import java.util.List;

public interface IGeneroService {
    public List<GeneroDTO> getAll();
    public GeneroDTO getById(int id);
}
