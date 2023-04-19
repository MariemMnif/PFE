package com.csys.compte.repository;

import com.csys.compte.domain.Module;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Module entity.
 */
@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
  Collection<Module> findByActif(Boolean actif);

    public Module findByIdModule(Integer idModule);
    public Module findByDesignation(String designation);
   
}

