package com.csys.compte.repository;

import com.csys.compte.domain.Typeserveur;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeserveurRepository extends JpaRepository<Typeserveur, Integer> {

    Collection<Typeserveur> findByActif(Boolean actif);

    public Typeserveur findByIdTypeServeur(Integer idTypeServeur);
    Typeserveur findByDesignation(String designation);

}
