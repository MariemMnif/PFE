package com.csys.compte.service;

import com.csys.compte.domain.Language;
import com.csys.compte.dto.LanguageDTO;
import com.csys.compte.factory.LanguageFactory;
import com.csys.compte.repository.LanguageRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LanguageService {

    private final Logger log = LoggerFactory.getLogger(LanguageService.class);

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public LanguageDTO save(LanguageDTO languageDTO) {

        log.debug("Request to save Language: {}", languageDTO);
        //verif language existe ou non 
        Language languageinBase = languageRepository.findByDesignation(languageDTO.getDesignation());
        Preconditions.checkArgument(languageinBase == null, "La langage existe deja");

        Language language = LanguageFactory.languageDTOToLanguage(languageDTO, null);
        language = languageRepository.save(language);
        LanguageDTO resultDTO = LanguageFactory.languageToLanguageDTO(language);
        return resultDTO;
    }

    public LanguageDTO update(LanguageDTO languageDTO) {
        log.debug("Request to update Language: {}", languageDTO);
        Language inBase = languageRepository.findByIdLanguage(languageDTO.getIdLanguage());
        Preconditions.checkArgument(inBase != null, "la language n'existe pas");
        Language language = LanguageFactory.languageDTOToLanguage(languageDTO, inBase);
        language = languageRepository.save(language);
        LanguageDTO resultDTO = LanguageFactory.languageToLanguageDTO(language);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public LanguageDTO findOne(Integer id) {
        log.debug("Request to get Language: {}", id);
        Language language = languageRepository.findByIdLanguage(id);
        LanguageDTO dto = LanguageFactory.languageToLanguageDTO(language);
        return dto;
    }

    @Transactional(readOnly = true)
    public Language findLanguage(Integer id) {
        log.debug("Request to get Language: {}", id);
        Language language = languageRepository.findByIdLanguage(id);
        return language;
    }

    @Transactional(readOnly = true)
    public Collection<LanguageDTO> findAll() {
        log.debug("Request to get All Languages");
        Collection<Language> result = languageRepository.findAll();
        return LanguageFactory.languageToLanguageDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Language: {}", id);
        languageRepository.deleteById(id);
    }
}
