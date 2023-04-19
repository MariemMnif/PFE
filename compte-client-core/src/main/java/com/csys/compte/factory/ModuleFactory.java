package com.csys.compte.factory;

import com.csys.compte.domain.Language;
import com.csys.compte.domain.Module;
import com.csys.compte.domain.Version;
import com.csys.compte.dto.LanguageDTO;
import com.csys.compte.dto.ModuleDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModuleFactory {

    public static ModuleDTO moduleToModuleDTO(Module module) {
        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setIdModule(module.getIdModule());
        moduleDTO.setDesignation(module.getDesignation());
        moduleDTO.setActif(module.getActif());
        moduleDTO.setLanguageList(LanguageFactory.languageToLanguageDTOs(module.getLanguageList()));
        moduleDTO.setVersionList(VersionFactory.versionToVersionDTOs(module.getVersionList()));
        return moduleDTO;
        // moduleDTO.setVersionList(VersionFactory.versionToVersionDTOs(module.getVersionList()));
        // moduleDTO.setUtilisateurList(module.getUtilisateurList());
        // moduleDTO.setClientmoduleversionList(module.getClientmoduleversionList());
        // moduleDTO.setVersionList(module.getVersionList());
        /*  moduleDTO.getVersionList().forEach(version -> {
            version.setIdModule(moduleDTO.getIdModule());
        });*/

    }

    public static Module moduleDTOToModule(ModuleDTO moduleDTO, Module module) {
        if (module == null) {
            //le cas de ajouter un module 
            module = new Module();
            module.setIdModule(moduleDTO.getIdModule());
            module.setDesignation(moduleDTO.getDesignation());
            module.setActif(moduleDTO.getActif());
            module.setLanguageList(LanguageFactory.languageDTOToLanguages(moduleDTO.getLanguageList()));
            module.setVersionList(VersionFactory.versionDTOToVersions3(moduleDTO.getVersionList(), module));
            return module;
        } // update 
        module.setIdModule(moduleDTO.getIdModule());
        module.setDesignation(moduleDTO.getDesignation());
        module.setActif(moduleDTO.getActif());
        module.setLanguageList(LanguageFactory.languageDTOToLanguages(moduleDTO.getLanguageList()));
        // module.setUtilisateurList(moduleDTO.getUtilisateurList());
        // module.setClientmoduleversionList(moduleDTO.getClientmoduleversionList()); 
        module.setVersionList(VersionFactory.versionDTOToVersions(moduleDTO.getVersionList(), module));
        return module;
    }

    public static Collection<ModuleDTO> moduleToModuleDTOs(Collection<Module> modules) {
        List<ModuleDTO> modulesDTO = new ArrayList<>();
        modules.forEach(x -> {
            modulesDTO.add(moduleToModuleDTO(x));
        });
        return modulesDTO;
    }

}
