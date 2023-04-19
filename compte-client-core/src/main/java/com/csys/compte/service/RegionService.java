package com.csys.compte.service;

import com.csys.compte.domain.Region;
import com.csys.compte.dto.RegionDTO;
import com.csys.compte.factory.RegionFactory;
import com.csys.compte.repository.RegionRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RegionService {

    private final Logger log = LoggerFactory.getLogger(RegionService.class);

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public RegionDTO save(RegionDTO regionDTO) {
        log.debug("Request to save Region: {}", regionDTO);
        //verif region existe ou non 
        Region regioninBase = regionRepository.findByDesignation(regionDTO.getDesignation());
        Preconditions.checkArgument(regioninBase == null, "La region existe deja");
        Region region = RegionFactory.regionDTOToRegion(regionDTO, null);
        region = regionRepository.save(region);
        RegionDTO resultDTO = RegionFactory.regionToRegionDTO(region);
        return resultDTO;
    }

    public RegionDTO update(RegionDTO regionDTO) {
        log.debug("Request to update Region: {}", regionDTO);
        Region inBase = regionRepository.findByIdRegion(regionDTO.getIdRegion());
        Preconditions.checkArgument(inBase != null, "La region n'existe pas");
        Region region = RegionFactory.regionDTOToRegion(regionDTO, inBase);
        region = regionRepository.save(region);
        RegionDTO resultDTO = RegionFactory.regionToRegionDTO(region);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public RegionDTO findOne(Integer id) {
        log.debug("Request to get Region: {}", id);
        Region region = regionRepository.findByIdRegion(id);
        RegionDTO dto = RegionFactory.regionToRegionDTO(region);
        return dto;
    }

    @Transactional(readOnly = true)
    public Region findRegion(Integer id) {
        log.debug("Request to get Region: {}", id);
        Region region = regionRepository.findByIdRegion(id);
        return region;
    }

    @Transactional(readOnly = true)
    public Collection<RegionDTO> findAll() {
        log.debug("Request to get All Regions");
        Collection<Region> result = regionRepository.findAll();
        return RegionFactory.regionToRegionDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Region: {}", id);
        regionRepository.deleteById(id);
    }
}
