package com.system.trailers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.system.trailers.service.AlmacenService;

@RestController
@RequestMapping("/almacen")
@Validated
public class AlmacenController {
    private final AlmacenService almacenService;

    @Autowired
    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }
}
