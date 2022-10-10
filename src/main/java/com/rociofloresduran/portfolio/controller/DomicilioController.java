
package com.rociofloresduran.portfolio.controller;

import com.rociofloresduran.portfolio.model.Domicilio;
import com.rociofloresduran.portfolio.service.IDomicilioService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class DomicilioController{
    @Autowired
    private IDomicilioService domicilioServ;
    
    @GetMapping("/domicilios")
    public ResponseEntity<List<Domicilio>> verDomicilios(){
        return ResponseEntity.ok().body(domicilioServ.verDomicilios());
    }
    
    @GetMapping("/domicilios/{id}")
    public ResponseEntity<Domicilio> buscarDomicilio(@PathVariable Long id) {
        return ResponseEntity.ok().body(domicilioServ.buscarDomicilio(id).orElse(null));
    }
    
    @PostMapping("/domicilios/new")
    public ResponseEntity<Domicilio> crearDomicilio(@RequestBody Domicilio domicilio){
        domicilioServ.crearDomicilio(domicilio);
        return ResponseEntity.ok().body(domicilio);
    }
    
    @DeleteMapping("/domicilios/delete/{id}")
    public void borrarDomicilio(@PathVariable Long id){
        domicilioServ.borrarDomicilio(id);
    }
    
    @PutMapping("domicilios/editar/{id}")
    public void editarDomicilio(@PathVariable("id") Long id,
                              @RequestBody Domicilio dom){
        Domicilio domicilio = domicilioServ.buscarDomicilio(id).orElse(null);
        
       domicilio.setProvincia(dom.getProvincia());
       domicilio.setLocalidad(dom.getLocalidad());
        domicilioServ.crearDomicilio(domicilio);
    }
}
