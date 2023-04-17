package com.system.trailers.repository;

import com.system.trailers.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {

}
