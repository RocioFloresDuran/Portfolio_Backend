
package com.rociofloresduran.portfolio.repository;

import com.rociofloresduran.portfolio.model.Aptitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudRepository extends JpaRepository <Aptitud, Long> {
    
}
