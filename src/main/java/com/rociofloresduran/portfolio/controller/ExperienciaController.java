
package com.rociofloresduran.portfolio.controller;

import com.rociofloresduran.portfolio.model.Experiencia;
import com.rociofloresduran.portfolio.model.Persona;
import com.rociofloresduran.portfolio.service.IExperienciaService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://rocio-floresduran.web.app")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/experiencia/ver")
    @ResponseBody
    public List<Experiencia> verExperiencias(){
        return expServ.verExperiencias();
    }
    
    @GetMapping("/personas/experiencia/{id}")
    public Experiencia buscarExperiencia(@PathVariable Long id){
        return expServ.buscarExperiencia(id).orElse(null);
    }
    
    @PostMapping("/personas/experiencia/new/{idPersona}")
    public void crearExperiencia(@PathVariable("idPersona") Long idPersona, @RequestBody Experiencia exp){
        Optional<Persona> persOpt = persoServ.buscarPersona(idPersona);
        if(persOpt.isPresent()){
            Persona persona = persOpt.get();
            exp.setPersona(persona);
            expServ.crearExperiencia(exp);
        }
        
    }
    
    @DeleteMapping("/personas/experiencia/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }
    
    @PutMapping("personas/experiencia/editar/{id}")
    public void editarExperiencia(@PathVariable("id") Long id,
                              @RequestBody Experiencia exp){
        Experiencia experiencia = expServ.buscarExperiencia(id).orElse(null);
        
        experiencia.setNombre_org(exp.getNombre_org());
        experiencia.setArea_cargo(exp.getArea_cargo());
        experiencia.setAnio_inicio(exp.getAnio_inicio());
        experiencia.setAnio_fin(exp.getAnio_fin());
        experiencia.setUrl_imagen(exp.getUrl_imagen());
        
        expServ.crearExperiencia(experiencia);
    }

}
