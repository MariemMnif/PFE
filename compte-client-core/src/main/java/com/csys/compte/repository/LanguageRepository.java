package com.csys.compte.repository;

import com.csys.compte.domain.Language;
import java.lang.Boolean;
import java.lang.Integer;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Language entity.
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Collection<Language> findByActif(Boolean actif);

    public Language findByIdLanguage(Integer idLanguage);

    public Language findByDesignation(String designation);
}
