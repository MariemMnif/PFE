package com.csys.compte.repository;

import com.csys.compte.domain.Utilisateur;
import java.lang.Boolean;
import java.lang.String;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Utilisateur entity.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
  Collection<Utilisateur> findByActif(Boolean actif);  
   Utilisateur findByUserName(String username); 
}

