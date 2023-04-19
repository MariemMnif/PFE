package com.csys.compte.service;

import com.csys.compte.domain.Language;
import com.csys.compte.domain.Module;
import com.csys.compte.domain.Version;
import com.csys.compte.dto.LanguageDTO;
import com.csys.compte.dto.ModuleDTO;
import com.csys.compte.factory.LanguageFactory;
import com.csys.compte.factory.ModuleFactory;
import com.csys.compte.factory.VersionFactory;
import com.csys.compte.repository.LanguageRepository;
import com.csys.compte.repository.ModuleRepository;
import com.csys.compte.repository.VersionRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Module.
 */
@Service
@Transactional
public class ModuleService {

    private final Logger log = LoggerFactory.getLogger(ModuleService.class);

    private final ModuleRepository moduleRepository;
    private final VersionRepository versionRepository;

    public ModuleService(ModuleRepository moduleRepository, VersionRepository versionRepository) {
        this.moduleRepository = moduleRepository;
        this.versionRepository = versionRepository;

    }

    public ModuleDTO save(ModuleDTO moduleDTO) {
        log.debug("Request to save Module: {}", moduleDTO);
        //verif module existe ou non 
        Module moduleinBase = moduleRepository.findByDesignation(moduleDTO.getDesignation());
        Preconditions.checkArgument(moduleinBase == null, "Le module existe deja");
     
        Module module = ModuleFactory.moduleDTOToModule(moduleDTO, null);

        module = moduleRepository.save(module);
        ModuleDTO resultDTO = ModuleFactory.moduleToModuleDTO(module);
        return resultDTO;
    }

    public ModuleDTO update(ModuleDTO moduleDTO) {
        log.debug("Request to update Module: {}", moduleDTO);
        Module inBase = moduleRepository.findByIdModule(moduleDTO.getIdModule());
        Preconditions.checkArgument(inBase != null, "module.NotFound");
        Module module = ModuleFactory.moduleDTOToModule(moduleDTO, inBase);
       
        
        module = moduleRepository.save(module);
        ModuleDTO resultDTO = ModuleFactory.moduleToModuleDTO(module);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public ModuleDTO findOne(Integer id) {
        log.debug("Request to get Module: {}", id);
        Module module = moduleRepository.findByIdModule(id);
        ModuleDTO dto = ModuleFactory.moduleToModuleDTO(module);
        return dto;
    }

    @Transactional(readOnly = true)
    public Module findModule(Integer id) {
        log.debug("Request to get Module: {}", id);
        Module module = moduleRepository.findByIdModule(id);
        return module;
    }

    @Transactional(readOnly = true)
    public Collection<ModuleDTO> findAll() {
        log.debug("Request to get All Modules");
        Collection<Module> result = moduleRepository.findAll();
        return ModuleFactory.moduleToModuleDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Module: {}", id);
        moduleRepository.deleteById(id);
    }
}
