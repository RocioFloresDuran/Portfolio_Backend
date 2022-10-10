
package com.rociofloresduran.portfolio.repository;

import com.rociofloresduran.portfolio.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio, Long> {
    
}
