package com.csys.compte.repository;

import com.csys.compte.domain.Secteur;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Secteur entity.
 */
@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {
  Collection<Secteur> findByActif(Boolean actif);

    public Secteur findByIdSecteur(Integer idSecteur);
    public Secteur findByDesignation(String designation);
}

