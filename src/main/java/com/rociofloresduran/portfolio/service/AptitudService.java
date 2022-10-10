package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Aptitud;
import com.rociofloresduran.portfolio.repository.AptitudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptitudService implements IAptitudService{
    
    @Autowired
    public AptitudRepository aptRepo;

    @Override
    public void crearAptitud(Aptitud apt) {
        aptRepo.save(apt);
    }

    @Override
    public Optional<Aptitud> buscarAptitud(Long id) {
        return aptRepo.findById(id);
    }

    @Override
    public List<Aptitud> verAptitudes() {
        return aptRepo.findAll();
    }

    @Override
    public void borrarAptitud(Long id) {
        aptRepo.deleteById(id);
    }
    
}
