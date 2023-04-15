package com.system.trailers.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface AlmacenService {

    public void iniciarAlmacenArchivos();

    public String almacenarArchivo(MultipartFile archivo);

    public Path cargarArchivo(String nombre);

    public Resource cargarRecurso(String nombre);

    public void eliminarArchivo(String nombre);
}
