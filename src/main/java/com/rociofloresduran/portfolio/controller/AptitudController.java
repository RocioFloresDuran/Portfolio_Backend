
package com.rociofloresduran.portfolio.controller;

import com.rociofloresduran.portfolio.model.Aptitud;
import com.rociofloresduran.portfolio.model.Persona;
import com.rociofloresduran.portfolio.service.IAptitudService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class AptitudController {
    
    @Autowired
    private IAptitudService aptServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/aptitud/ver")
    public List<Aptitud> verAptitudes(){
        return aptServ.verAptitudes();
    }
    
    @GetMapping("/personas/aptitud/{id}")
    public Aptitud buscarAptitud(@PathVariable Long id){
        return aptServ.buscarAptitud(id).orElse(null);
    }
    
    @PostMapping("/personas/aptitud/new/{idPersona}")
    public void crearAptitud(@PathVariable("idPersona") Long idPersona, @RequestBody Aptitud apt){
        Optional<Persona> persOpt = persoServ.buscarPersona(idPersona);
        if(persOpt.isPresent()){
            Persona persona = persOpt.get();
            apt.setPersona(persona);
            aptServ.crearAptitud(apt);
        }
    }
    
    @DeleteMapping("/personas/aptitud/delete/{id}")
    public void borrarAptitud(@PathVariable Long id){
        aptServ.borrarAptitud(id);
    }
     
    @PutMapping("personas/aptitud/editar/{id}")
    public void editarAptitud(@PathVariable("id") Long id,
                              @RequestBody Aptitud apt){
        Aptitud aptitud = aptServ.buscarAptitud(id).orElse(null);
        
        aptitud.setNombre(apt.getNombre());
        aptitud.setPorcentaje(apt.getPorcentaje());
        
        aptServ.crearAptitud(aptitud);
    }
    
}
