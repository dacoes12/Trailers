package com.system.trailers.repository;

import com.system.trailers.Model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
