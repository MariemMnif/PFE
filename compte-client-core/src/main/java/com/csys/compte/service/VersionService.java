package com.csys.compte.service;

import com.csys.compte.domain.Module;
import com.csys.compte.domain.Version;
import com.csys.compte.dto.VersionDTO;
import com.csys.compte.factory.VersionFactory;
import com.csys.compte.repository.VersionRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class VersionService {

    private final Logger log = LoggerFactory.getLogger(VersionService.class);

    private final VersionRepository versionRepository;
    private final ModuleService moduleService;

    public VersionService(VersionRepository versionRepository, ModuleService moduleService) {
        this.versionRepository = versionRepository;
        this.moduleService = moduleService;
    }

   
    public VersionDTO save(VersionDTO versionDTO) {
        log.debug("Request to save Version: {}", versionDTO);
        Module module =moduleService.findModule(versionDTO.getIdModule());
        Preconditions.checkArgument(module != null, "Le module n'existe pas");
        Version version = VersionFactory.versionDTOToVersion(versionDTO, null);
        version.setModule(module);
        version = versionRepository.save(version);
        VersionDTO resultDTO = VersionFactory.versionToVersionDTO(version);
        return resultDTO;
    }

    public VersionDTO update(VersionDTO versionDTO) {
        log.debug("Request to update Version: {}", versionDTO);
        //verif version
        Version inBase = versionRepository.findByIdVersion(versionDTO.getIdVersion());
        Preconditions.checkArgument(inBase != null, "La version n'existe pas");
        // verif module 
        Module module =moduleService.findModule(versionDTO.getIdModule());
        Preconditions.checkArgument(module != null, "Le module n'existe pas");
        
        Version version = VersionFactory.versionDTOToVersion(versionDTO, inBase);
        version.setModule(module);
        version = versionRepository.save(version);
        VersionDTO resultDTO = VersionFactory.versionToVersionDTO(version);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public VersionDTO findOne(Integer id) {
        log.debug("Request to get Version: {}", id);
        Version version = versionRepository.findByIdVersion(id);
        VersionDTO dto = VersionFactory.versionToVersionDTO(version);
        return dto;
    }

    @Transactional(readOnly = true)
    public Version findVersion(Integer id) {
        log.debug("Request to get Version: {}", id);
        Version version = versionRepository.findByIdVersion(id);
        return version;
    }

    @Transactional(readOnly = true)
    public Collection<VersionDTO> findAll() {
        log.debug("Request to get All Versions");
        Collection<Version> result = versionRepository.findAll();
        return VersionFactory.versionToVersionDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Version: {}", id);
        versionRepository.deleteById(id);
    }
}
