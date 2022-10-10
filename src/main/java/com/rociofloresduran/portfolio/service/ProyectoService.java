
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Proyecto;
import com.rociofloresduran.portfolio.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public ProyectoRepository proyeRepo;

    @Override
    public void crearProyecto(Proyecto proyecto) {
        proyeRepo.save(proyecto);
    }

    @Override
    public Optional<Proyecto> buscarProyecto(Long id) {
        return proyeRepo.findById(id);
    }

    @Override
    public List<Proyecto> verProyectos() {
        return proyeRepo.findAll();
    }

    @Override
    public void borrarProyecto(Long id) {
        proyeRepo.deleteById(id);
    }
    
}
