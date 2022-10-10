
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Experiencia;
import java.util.List;
import java.util.Optional;


public interface IExperienciaService {
    
    public void crearExperiencia(Experiencia exp);
    public Optional<Experiencia> buscarExperiencia(Long id);
    public List<Experiencia> verExperiencias();
    public void borrarExperiencia(Long id);
    
}
