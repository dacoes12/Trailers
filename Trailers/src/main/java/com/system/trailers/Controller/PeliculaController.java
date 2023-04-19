package com.system.trailers.Controller;

import com.system.trailers.dto.PeliculaDTO;
import com.system.trailers.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {
    @Autowired
    private IPeliculaService service;

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO pelicula){
        return new ResponseEntity<>(service.save(pelicula), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PeliculaDTO> delete(@PathVariable int id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PeliculaDTO pelicula){
        return new ResponseEntity<>(this.service.update(pelicula),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> get(@PathVariable int id){
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PeliculaDTO>> getAll(){
        return new ResponseEntity<>(this.service.getAll(),HttpStatus.OK);
    }
}
