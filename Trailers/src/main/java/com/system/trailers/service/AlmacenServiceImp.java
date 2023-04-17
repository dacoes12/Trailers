package com.system.trailers.service;

import com.system.trailers.exception.AlmacenException;
import com.system.trailers.exception.FileNotFoundException;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AlmacenServiceImp implements IAlmacenService {

    @Value("${storage.location}")
    private String storageLocation;

    /***
     * Metodo que indica la ruta de almacenamiento de los archivos
     */
    /*Indica que el metodo se ejecutara cada vez que hay halla una nueva instancia de esta clase. */
    @PostConstruct
    @Override
    public void iniciarAlmacenArchivos() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        }catch (IOException exception){
            throw new AlmacenException("Error al inicializar la ubicacion en el almacen de archivos");
        }
    }


    /***
     * Metodo que almacena el archivo(imagen)
     * @param archivo archivo de imagen
     * @return El nombre del archivo si todo salio bien y la imagen se ha almacenado
     */
    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        if(archivo.isEmpty()){
            throw new AlmacenException("No se puede almacenar un archivo vacio");
        }
        try{
            InputStream inputStream = archivo.getInputStream();
            /* Si existe un archivo con el mismo nombre se remplaza  */
            Files.copy(inputStream,Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException exception){
            throw  new AlmacenException("Error al almacenar el archivo "+ nombreArchivo, exception);
        }
        return nombreArchivo;
    }

    /***
     * Metodo que devuelve el archivo
     * @param nombre nombre del archivo (imagen)
     * @return devuelve la archivo (imagen)
     */
    @Override
    public Path cargarArchivo(String nombre) {
        return Paths.get(storageLocation).resolve(nombre);
    }

    @Override
    public org.springframework.core.io.Resource cargarRecurso(String nombre) {
        try {
            Path archivo = cargarArchivo(nombre);
            Resource resource = new UrlResource(archivo.toUri());
            /* si existe o es legible*/
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new FileNotFoundException("No se pudo encontrar el archivo +"+nombre);
            }

        }catch (MalformedURLException exception){
            throw new FileNotFoundException("No se pudo encontrar el archivo +"+nombre,exception);
        }
    }


    /**
     * Elimina un archivo (imagen)
     * @param nombre nombre del archivo (imagen)
     */
    @Override
    public void eliminarArchivo(String nombre) {

        Path archivo = cargarArchivo(nombre);
        try {
            FileSystemUtils.deleteRecursively(archivo);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
