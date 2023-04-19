package com.csys.compte.repository;

import com.csys.compte.domain.Client;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Client entity.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
  Collection<Client> findByActif(Boolean actif);

    public Client findByIdClient(Integer idClient);
    public Client findByRaisonSociale(String raisonSociale);
}

