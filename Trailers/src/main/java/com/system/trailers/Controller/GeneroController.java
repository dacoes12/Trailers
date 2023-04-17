package com.system.trailers.Controller;

import com.system.trailers.dto.GeneroDTO;
import com.system.trailers.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {
     @Autowired
    private IGeneroService service;

     public GeneroController(IGeneroService service){
         this.service = service;
     }

     @GetMapping("/all")
    public ResponseEntity<List<GeneroDTO>> getAll(){
         System.out.println("Peticion para obtener todos los generos");
         return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
     }

}
