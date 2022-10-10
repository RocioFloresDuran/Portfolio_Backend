
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Proyecto;
import java.util.List;
import java.util.Optional;


public interface IProyectoService {
    
    public void crearProyecto(Proyecto proyecto);
    public Optional<Proyecto> buscarProyecto(Long id);
    public List<Proyecto> verProyectos();
    public void borrarProyecto(Long id);
    
}
