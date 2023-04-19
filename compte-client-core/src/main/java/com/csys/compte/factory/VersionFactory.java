package com.csys.compte.factory;

import com.csys.compte.domain.Module;
import com.csys.compte.domain.Version;
import com.csys.compte.dto.VersionDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VersionFactory {

    public static VersionDTO versionToVersionDTO(Version version) {
        VersionDTO versionDTO = new VersionDTO();
        versionDTO.setIdVersion(version.getIdVersion());
        versionDTO.setNumero(version.getNumero());
        versionDTO.setDescription(version.getDescription());
        versionDTO.setDateEffet(version.getDateEffet());
        //versionDTO.setIdModule(version.getModule().getIdModule());
        // versionDTO.setModuleDTO(ModuleFactory.moduleToModuleDTO(version.getModule()));
        // versionDTO.setClientmoduleversionList(version.getClientmoduleversionList());
        // versionDTO.setModuleDTO(ModuleFactory.moduleToModuleDTO(version.getModule()));
        // versionDTO.setIdModule(version.getModule().getIdModule());
        // versionDTO.setModuleDTO(ModuleFactory.moduleToModuleDTO(version.getModule()));
        return versionDTO;
    }

    public static Version versionDTOToVersion(VersionDTO versionDTO, Version version) {
        if (version == null) {
            version = new Version();
        }

        version.setNumero(versionDTO.getNumero());
        version.setDescription(versionDTO.getDescription());
        version.setDateEffet(versionDTO.getDateEffet());
        version.setClientmoduleversionList(versionDTO.getClientmoduleversionList());

        return version;
    }

    public static List<VersionDTO> versionToVersionDTOs(Collection<Version> versions) {
        List<VersionDTO> versionsDTO = new ArrayList<>();
        versions.forEach(x -> {
            versionsDTO.add(versionToVersionDTO(x));
        });
        return versionsDTO;
    }

//versionDTOToVersion2 pour update  module seulement
    public static Version versionDTOToVersion2(VersionDTO versionDTO, Module module) {

        Version existingVersion = module.getVersionList().stream()
                .filter(v -> v.getIdVersion().equals(versionDTO.getIdVersion()))
                .findFirst()
                .orElse(null);

        if (existingVersion != null) {
            existingVersion.setNumero(versionDTO.getNumero());
            existingVersion.setDescription(versionDTO.getDescription());
            existingVersion.setDateEffet(versionDTO.getDateEffet());
            return existingVersion;
        } else {
            Version version = new Version();
            version.setNumero(versionDTO.getNumero());
            version.setDescription(versionDTO.getDescription());
            version.setDateEffet(versionDTO.getDateEffet());
            version.setModule(module);
            module.getVersionList().add(version);
            return version;
        }
    }

    public static List<Version> versionDTOToVersions(List<VersionDTO> versionsDTO, Module module) {
        List<Version> versions = new ArrayList<>();
        versionsDTO.forEach(x -> {
            versions.add(versionDTOToVersion2(x, module));
        });
        return versions;
    }

// pour ajouter nouveau module     
    public static List<Version> versionDTOToVersions3(List<VersionDTO> versionsDTO, Module module) {
        List<Version> versions = new ArrayList<>();
        versionsDTO.forEach(versionDTO -> {
            Version version = new Version();
            version.setNumero(versionDTO.getNumero());
            version.setDescription(versionDTO.getDescription());
            version.setDateEffet(versionDTO.getDateEffet());
            version.setModule(module);
            // version.setClientmoduleversionList(versionDTO.getClientmoduleversionList());
            versions.add(version);
        });
        return versions;
    }
}
