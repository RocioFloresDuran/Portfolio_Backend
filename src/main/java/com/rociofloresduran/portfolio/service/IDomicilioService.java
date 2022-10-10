
package com.rociofloresduran.portfolio.service;

import com.rociofloresduran.portfolio.model.Domicilio;
import java.util.List;
import java.util.Optional;


public interface IDomicilioService {
    
    public void crearDomicilio(Domicilio dom);
    public List<Domicilio> verDomicilios();
    public Optional<Domicilio> buscarDomicilio(Long id);
    public void borrarDomicilio(Long id);
    
}
