package com.csys.compte.repository;

import com.csys.compte.domain.Region;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Region entity.
 */
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
  Collection<Region> findByActif(Boolean actif);

    public Region findByIdRegion(Integer idRegion);
    public Region findByDesignation(String designation);
}

