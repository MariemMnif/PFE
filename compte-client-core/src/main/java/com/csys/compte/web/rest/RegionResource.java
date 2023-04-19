package com.csys.compte.web.rest;

import com.csys.compte.dto.RegionDTO;
import com.csys.compte.service.RegionService;
import com.csys.compte.util.RestPreconditions;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Region.
 */
@RestController
@RequestMapping("/api")
public class RegionResource {

    private static final String ENTITY_NAME = "region";

    private final RegionService regionService;

    private final Logger log = LoggerFactory.getLogger(RegionService.class);

    public RegionResource(RegionService regionService) {
        this.regionService = regionService;
    }

    @PostMapping("/regions")
    public ResponseEntity<RegionDTO> createRegion(@Valid @RequestBody RegionDTO regionDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        log.debug("REST request to save Region : {}", regionDTO);
        if (regionDTO.getIdRegion() != null) {
            bindingResult.addError(new FieldError("RegionDTO", "idRegion", "POST method does not accepte " + ENTITY_NAME + " with code"));
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        RegionDTO result = regionService.save(regionDTO);
        return ResponseEntity.created(new URI("/api/regions/" + result.getIdRegion())).body(result);
    }

    @PutMapping("/regions/{id}")
    public ResponseEntity<RegionDTO> updateRegion(@Valid @RequestBody RegionDTO regionDTO) throws MethodArgumentNotValidException {
        log.debug("Request to update Region: {}");
        RegionDTO result = regionService.update(regionDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<RegionDTO> getRegion(@PathVariable Integer id) {
        log.debug("Request to get Region: {}", id);
        RegionDTO dto = regionService.findOne(id);
        RestPreconditions.checkFound(dto, "region.NotFound");
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/regions")
    public Collection<RegionDTO> getAllRegions() {
        log.debug("Request to get all  Regions : {}");
        return regionService.findAll();
    }

    @DeleteMapping("/regions/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id) {
        log.debug("Request to delete Region: {}", id);
        regionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
