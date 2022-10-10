
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Domicilio;
import com.rociofloresduran.portfolio.repository.DomicilioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService{
    
    @Autowired
    public DomicilioRepository domRepo;
    
    @Override
    public void crearDomicilio(Domicilio dom) {
        domRepo.save(dom);
    }

    @Override
    public List<Domicilio> verDomicilios() {
        return domRepo.findAll();
    }
    
    @Override
    public Optional<Domicilio> buscarDomicilio(Long id) {
        return domRepo.findById(id);
    }

    @Override
    public void borrarDomicilio(Long id) {
        domRepo.deleteById(id);
    }

   
    
}
