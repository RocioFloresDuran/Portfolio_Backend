
package com.rociofloresduran.portfolio.controller;

import com.rociofloresduran.portfolio.model.Persona;
import com.rociofloresduran.portfolio.model.Proyecto;
import com.rociofloresduran.portfolio.service.IPersonaService;
import com.rociofloresduran.portfolio.service.IProyectoService;
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
@CrossOrigin(origins = "https://rocio-floresduran.web.app")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyeServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/proyecto/ver")
    public List<Proyecto> verProyectos(){
        return proyeServ.verProyectos();
    }
    
    @GetMapping("/personas/proyecto/{id}")
    public Proyecto buscarProyecto(@PathVariable Long id){
        return proyeServ.buscarProyecto(id).orElse(null);
    }
    
    @PostMapping("/personas/proyecto/new/{idPersona}")
    public void crearProyecto(@PathVariable("idPersona") Long idPersona, @RequestBody Proyecto proy){
        Optional<Persona> persOpt = persoServ.buscarPersona(idPersona);
        if(persOpt.isPresent()){
            Persona persona = persOpt.get();
            proy.setPersona(persona);
            proyeServ.crearProyecto(proy);
        }
    }
    
    @DeleteMapping("/personas/proyecto/delete/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyeServ.borrarProyecto(id);
    }
    
//    @PutMapping("personas/proyecto/editar")
//    public void editarProyecto(@RequestBody Proyecto proy){
//        proyeServ.crearProyecto(proy);
//    }
    
    @PutMapping("personas/proyecto/editar/{id}")
    public void editarProyecto(@PathVariable("id") Long id,
                              @RequestBody Proyecto proy){
        Proyecto proyecto = proyeServ.buscarProyecto(id).orElse(null);
        
        proyecto.setNombre(proy.getNombre());
        proyecto.setDescripcion(proy.getDescripcion());
        
        proyeServ.crearProyecto(proyecto);
    }
    
    
}
