
package com.rociofloresduran.portfolio.controller;

import com.rociofloresduran.portfolio.model.Domicilio;
import com.rociofloresduran.portfolio.model.Persona;
import com.rociofloresduran.portfolio.service.IDomicilioService;
import com.rociofloresduran.portfolio.service.IPersonaService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://rocio-floresduran.web.app")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaServ;
    @Autowired
    private IDomicilioService domicilioServ;
    
    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> verPersonas(){
        return ResponseEntity.ok().body(personaServ.verPersonas());
    }
    
    @GetMapping("/personas/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
        return personaServ.buscarPersona(id).orElse(null);
    }
    
    @PostMapping("/domicilios/{domicilioId}/persona/add")
    public ResponseEntity<Persona> crearPersona(@PathVariable("domicilioId") Long domicilioId, @RequestBody Persona per){
        Optional<Domicilio> domiOpt = domicilioServ.buscarDomicilio(domicilioId);
        
        if (domiOpt.isPresent()){
            Domicilio domicilio = domiOpt.get();
            per.setDomicilio(domicilio);
            personaServ.crearPersona(per);
            return ResponseEntity.ok().body(per);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @DeleteMapping("personas/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaServ.borrarPersona(id);
    }
    
    @PutMapping("personas/editar")
    public void editarPersona(@RequestBody Persona per){
        personaServ.crearPersona(per);
    }
    
//    @PutMapping("personas/editar/{id}")
//    public void editarPersona(@PathVariable("id") Long id,
//                              @RequestBody Persona per){
//        Persona persona = personaServ.buscarPersona(id).orElse(null);
//        
//        persona.setNombres(per.getNombres());
//        persona.setApellidos(per.getApellidos());
//        persona.setFecha_nac(per.getFecha_nac());
//        persona.setNacionalidad(per.getNacionalidad());
//        persona.setDescripcion(per.getDescripcion());
//        persona.setOcupacion(per.getOcupacion());
//        persona.setMail(per.getMail());
//        persona.setUrl_foto(per.getUrl_foto());
//        persona.setUrl_header(per.getUrl_header());
//        
//        personaServ.crearPersona(persona);
//    }
    
}
