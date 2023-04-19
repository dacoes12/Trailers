package com.system.trailers.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String sinopsis;

    @NotNull
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private LocalDate fechaEstreno;

    @NotBlank
    private String youtubeTrailerId;

    private String urlPortada;

    //@NotEmpty  //carga solo cuando se necesite
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "genero_pelicula",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getYoutubeTrailerId() {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(String youtubeTrailerId) {
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public String getUrlPortada() {
        return urlPortada;
    }

    public void setUrlPortada(String urlPortada) {
        this.urlPortada = urlPortada;
    }

    public Pelicula() {
    }

    public Pelicula(String titulo, String sinopsis, LocalDate fechaEstreno, String youtubeTrailerId, String urlPortada, List<Genero> generos) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtubeTrailerId;
        this.urlPortada = urlPortada;
        this.generos = generos;
    }

    public Pelicula(Integer id, String titulo, String sinopsis, LocalDate fechaEstreno, String youtubeTrailerId, String urlPortada, List<Genero> generos) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtubeTrailerId;
        this.urlPortada = urlPortada;
        this.generos = generos;
    }
}
