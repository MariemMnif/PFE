package com.csys.compte.factory;

import com.csys.compte.domain.Region;
import com.csys.compte.dto.RegionDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionFactory {
  public static RegionDTO regionToRegionDTO(Region region) {
    RegionDTO regionDTO=new RegionDTO();
    regionDTO.setIdRegion(region.getIdRegion());
    regionDTO.setDesignation(region.getDesignation());
    regionDTO.setActif(region.getActif());
    regionDTO.setClientList(region.getClientList());
    return regionDTO;
  }

  public static Region regionDTOToRegion(RegionDTO regionDTO,Region region) {
    if (region ==null){
        region=new Region();
    }
    region.setIdRegion(regionDTO.getIdRegion());
    region.setDesignation(regionDTO.getDesignation());
    region.setActif(regionDTO.getActif());
    region.setClientList(regionDTO.getClientList());
    return region;
  }

  public static Collection<RegionDTO> regionToRegionDTOs(Collection<Region> regions) {
    List<RegionDTO> regionsDTO=new ArrayList<>();
    regions.forEach(x -> {
      regionsDTO.add(regionToRegionDTO(x));
    } );
    return regionsDTO;
  }
}

