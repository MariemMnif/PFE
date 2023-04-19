package com.csys.compte.factory;

import com.csys.compte.domain.Language;
import com.csys.compte.dto.LanguageDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LanguageFactory {

    public static LanguageDTO languageToLanguageDTO(Language language) {
        LanguageDTO languageDTO = new LanguageDTO();
        languageDTO.setIdLanguage(language.getIdLanguage());
        languageDTO.setDesignation(language.getDesignation());
        languageDTO.setActif(language.getActif());
        languageDTO.setModuleList(language.getModuleList());
        return languageDTO;
    }

    public static Language languageDTOToLanguage(LanguageDTO languageDTO, Language language) {
        if (language == null) {
            language = new Language();
        }
        language.setIdLanguage(languageDTO.getIdLanguage());
        language.setDesignation(languageDTO.getDesignation());
        language.setActif(languageDTO.getActif());
        language.setModuleList(languageDTO.getModuleList());
        return language;
    }

    public static List<LanguageDTO> languageToLanguageDTOs(Collection<Language> languages) {
        List<LanguageDTO> languagesDTO = new ArrayList<>();
        languages.forEach(x -> {
            languagesDTO.add(languageToLanguageDTO(x));
        });
        return languagesDTO;
    }

    public static Language languageDTOToLanguage2(LanguageDTO languageDTO) {
        Language language = new Language();
        language.setIdLanguage(languageDTO.getIdLanguage());
        language.setDesignation(languageDTO.getDesignation());
        language.setActif(languageDTO.getActif());
        // language.setModuleList(languageDTO.getModuleList());
        return language;
    }

    public static List<Language> languageDTOToLanguages(List<LanguageDTO> languagesDTO) {
        List<Language> languages = new ArrayList<>();
        languagesDTO.forEach(x -> {
            languages.add(languageDTOToLanguage2(x));
        });
        return languages;
    }
}
