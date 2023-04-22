package com.system.trailers.repository;

import com.system.trailers.Model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;


@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {
    Page<Pelicula> findAll(Pageable pageable);
}
