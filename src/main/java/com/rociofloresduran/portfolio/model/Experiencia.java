
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
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre_org;
    private String area_cargo;
    private Integer anio_inicio;
    private Integer anio_fin;
    private String url_imagen;
    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Experiencia() {
    }

    public Experiencia(Long id, String nombre_org, String area_cargo, Integer anio_inicio, Integer anio_fin, String url_imagen) {
        this.id = id;
        this.nombre_org = nombre_org;
        this.area_cargo = area_cargo;
        this.anio_inicio = anio_inicio;
        this.anio_fin = anio_fin;
        this.url_imagen = url_imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_org() {
        return nombre_org;
    }

    public void setNombre_org(String nombre_org) {
        this.nombre_org = nombre_org;
    }

    public String getArea_cargo() {
        return area_cargo;
    }

    public void setArea_cargo(String area_cargo) {
        this.area_cargo = area_cargo;
    }

    public Integer getAnio_inicio() {
        return anio_inicio;
    }

    public void setAnio_inicio(Integer anio_inicio) {
        this.anio_inicio = anio_inicio;
    }

    public Integer getAnio_fin() {
        return anio_fin;
    }

    public void setAnio_fin(Integer anio_fin) {
        this.anio_fin = anio_fin;
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
