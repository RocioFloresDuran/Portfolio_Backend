
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Educacion;
import com.rociofloresduran.portfolio.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository educRepo;

    @Override
    public void crearEstudio(@RequestBody Educacion educ) {
        educRepo.save(educ);
    }

    @Override
    public List<Educacion> verEstudios() {
        return educRepo.findAll();
    }

    @Override
    public Optional<Educacion> buscarEducacion(Long id) {
        return educRepo.findById(id);
    }

    @Override
    public void borrarEducacion(Long id) {
        educRepo.deleteById(id);
    }
    
}
