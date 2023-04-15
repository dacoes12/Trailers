package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genero {
    @Id
    @Column(name="id_genero")
    private Integer id;
    private String titulo;

    @ManyToMany(mappedBy = "generos")
    private List<Pelicula> peliculas;

    public Genero() {
    }

    public Genero(Integer id) {
        this.id = id;
    }

    public Genero(String titulo) {
        this.titulo = titulo;
    }

    public Genero(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }


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
}
