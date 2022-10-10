
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Educacion;
import java.util.List;
import java.util.Optional;


public interface IEducacionService {
    
    public void crearEstudio(Educacion educ);
    public List<Educacion> verEstudios();
    public Optional<Educacion> buscarEducacion(Long id);
    public void borrarEducacion(Long id);
}
