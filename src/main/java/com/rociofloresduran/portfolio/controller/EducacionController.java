
package com.rociofloresduran.portfolio.controller;

import com.rociofloresduran.portfolio.model.Educacion;
import com.rociofloresduran.portfolio.model.Persona;
import com.rociofloresduran.portfolio.service.IEducacionService;
import com.rociofloresduran.portfolio.service.IPersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://rocio-floresduran.web.app/portfolio")
public class EducacionController {
    
    @Autowired
    private IEducacionService educServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/educacion/ver")
    public List<Educacion> verEstudios(){
        return educServ.verEstudios();
    }
    
    @GetMapping("/personas/educacion/{id}")
    public Educacion buscarEducacion(@PathVariable Long id){
        return educServ.buscarEducacion(id).orElse(null);
    }
    
    @PostMapping("/personas/educacion/new/{idPersona}")
    public void crearEducacion(@PathVariable("idPersona") Long idPersona, @RequestBody Educacion educ){
        Optional<Persona> persoOpt = persoServ.buscarPersona(idPersona);
        
        if(persoOpt.isPresent()){
            Persona persona = persoOpt.get();
            educ.setPersona(persona);
            educServ.crearEstudio(educ);
        }
    }
    
    @DeleteMapping("/personas/educacion/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        educServ.borrarEducacion(id);
    }
    
    @PutMapping("personas/educacion/editar/{id}")
    public void editarEducacion(@PathVariable("id") Long id,
                              @RequestBody Educacion educ){
        Educacion educacion = educServ.buscarEducacion(id).orElse(null);
        
        educacion.setEscuela(educ.getEscuela());
        educacion.setTitulo(educ.getTitulo());
        educacion.setCarrera(educ.getCarrera());
        educacion.setAnio_inicio(educ.getAnio_inicio());
        educacion.setAnio_fin(educ.getAnio_fin());
        educacion.setUrl_imagen(educ.getUrl_imagen());
        
        educServ.crearEstudio(educacion);
    }
    
}
