
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Aptitud;
import java.util.List;
import java.util.Optional;


public interface IAptitudService {
    
    public void crearAptitud(Aptitud apt);
    public Optional<Aptitud> buscarAptitud(Long id);
    public List<Aptitud> verAptitudes();
    public void borrarAptitud(Long id);
    
}
