package com.csys.compte.repository;

import com.csys.compte.domain.Serveur;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServeurRepository extends JpaRepository<Serveur, Integer> {
  Collection<Serveur> findByActif(Boolean actif);
    public Serveur findByIdServeur(Integer idServeur);
    public Serveur findByAdresseIp(String adresseIp);
}

