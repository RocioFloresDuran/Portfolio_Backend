
package com.rociofloresduran.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Educacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String escuela;
    private String titulo;
    private String carrera;
    private Integer anio_inicio;
    private Integer anio_fin;
    private String url_imagen;
    
    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Educacion() {
    }

    public Educacion(Long id, String escuela, String titulo, String carrera, Integer año_inicio, Integer año_fin, String url_imagen) {
        this.id = id;
        this.escuela = escuela;
        this.titulo = titulo;
        this.carrera = carrera;
        this.anio_inicio = año_inicio;
        this.anio_fin = año_fin;
        this.url_imagen = url_imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getAnio_inicio() {
        return anio_inicio;
    }

    public void setAnio_inicio(Integer año_inicio) {
        this.anio_inicio = año_inicio;
    }

    public Integer getAnio_fin() {
        return anio_fin;
    }

    public void setAnio_fin(Integer año_fin) {
        this.anio_fin = año_fin;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

//    @JsonBackReference
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

}
