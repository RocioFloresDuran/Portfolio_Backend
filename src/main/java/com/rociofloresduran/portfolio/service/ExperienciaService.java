
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Experiencia;
import com.rociofloresduran.portfolio.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository expRepo;

    @Override
    public void crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public Optional<Experiencia> buscarExperiencia(Long id) {
        return expRepo.findById(id);
    }

    @Override
    public List<Experiencia> verExperiencias() {
        return expRepo.findAll();
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }
    
}
