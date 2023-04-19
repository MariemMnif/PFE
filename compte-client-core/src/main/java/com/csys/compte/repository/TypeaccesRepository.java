package com.csys.compte.repository;

import com.csys.compte.domain.Typeacces;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Typeacces entity.
 */
@Repository
public interface TypeaccesRepository extends JpaRepository<Typeacces, Integer> {

    Collection<Typeacces> findByActif(Boolean actif);

    public Typeacces findByidTypeAcces(Integer IidTypeacces);

    Typeacces findByDesignation(String designation);
}
