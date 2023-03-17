package com.csys.compte.repository;

import com.csys.compte.domain.Poste;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Poste entity.
 */
@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> {
  Collection<Poste> findByActif(Boolean actif);
  Poste findByIdPoste(Integer idPoste);
}

