package com.csys.compte.repository;

import com.csys.compte.domain.Accesserveur;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Accesserveur entity.
 */
@Repository
public interface AccesserveurRepository extends JpaRepository<Accesserveur, Integer> {

    Collection<Accesserveur> findByActif(Boolean actif);

    public Accesserveur findByIdAcces(Integer idAcces);

    Accesserveur findByLogin(String login);
}
