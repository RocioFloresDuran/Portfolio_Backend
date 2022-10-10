
package com.rociofloresduran.portfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombres;
    private String apellidos;
    private Date fecha_nac;
    private String nacionalidad;
    private String descripcion;
    private String ocupacion;
    private String mail;
    private String url_foto;
    private String url_header;
    
    @ManyToOne()
    @JoinColumn(name = "id_domicilio", nullable=false)
    private Domicilio domicilio;
    
    @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Educacion> estudios;
    
    @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Aptitud> aptitudes;
    
    @OneToMany(mappedBy = "persona", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Proyecto> proyectos;
    
    public Persona(){
        
    }

    public Persona(Long id, String nombres, String apellidos, Date fecha_nac, String nacionalidad, String descripcion, String ocupacion, String mail, String url_foto, String url_header) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        this.descripcion = descripcion;
        this.ocupacion = ocupacion;
        this.mail = mail;
        this.url_foto = url_foto;
        this.url_header = url_header;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getUrl_header() {
        return url_header;
    }

    public void setUrl_header(String url_header) {
        this.url_header = url_header;
    }

//    @JsonBackReference
    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

//    @JsonManagedReference
    @JsonIgnore
    public List<Educacion> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Educacion> estudios) {
        this.estudios = estudios;
    }

//    @JsonManagedReference
    @JsonIgnore
    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

//    @JsonManagedReference
    @JsonIgnore
    public List<Aptitud> getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(List<Aptitud> aptitudes) {
        this.aptitudes = aptitudes;
    }

//    @JsonManagedReference
    @JsonIgnore
    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    
}
