package com.csys.compte.repository;

import com.csys.compte.domain.Version;
import java.lang.Integer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Version entity.
 */
@Repository
public interface VersionRepository extends JpaRepository<Version, Integer> {

    public Version findByIdVersion(Integer idVersion);
    public Version findByNumero(String numero);
     
  
}

