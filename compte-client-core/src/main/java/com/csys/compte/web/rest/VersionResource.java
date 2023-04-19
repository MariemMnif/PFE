package com.csys.compte.web.rest;

import com.csys.compte.dto.VersionDTO;
import com.csys.compte.service.VersionService;
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
 * REST controller for managing Version.
 */
@RestController
@RequestMapping("/api")
public class VersionResource {
  private static final String ENTITY_NAME = "version";

  private final VersionService versionService;

  private final Logger log = LoggerFactory.getLogger(VersionService.class);

  public VersionResource(VersionService versionService) {
    this.versionService=versionService;
  }

  
  @PostMapping("/versions")
  public ResponseEntity<VersionDTO> createVersion(@Valid @RequestBody VersionDTO versionDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Version : {}", versionDTO);
    if ( versionDTO.getIdVersion() != null) {
      bindingResult.addError( new FieldError("VersionDTO","idVersion","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    VersionDTO result = versionService.save(versionDTO);
    return ResponseEntity.created( new URI("/api/versions/"+ result.getIdVersion())).body(result);
  }

 
  @PutMapping("/versions/{id}")
  public ResponseEntity<VersionDTO> updateVersion(@Valid @RequestBody VersionDTO versionDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Version: {}");
    VersionDTO result =versionService.update(versionDTO);
    return ResponseEntity.ok().body(result);
  }


  @GetMapping("/versions/{id}")
  public ResponseEntity<VersionDTO> getVersion(@PathVariable Integer id) {
    log.debug("Request to get Version: {}",id);
    VersionDTO dto = versionService.findOne(id);
    RestPreconditions.checkFound(dto, "version.NotFound");
    return ResponseEntity.ok().body(dto);
  }

 
  @GetMapping("/versions")
  public Collection<VersionDTO> getAllVersions() {
    log.debug("Request to get all  Versions : {}");
    return versionService.findAll();
  }

 
  @DeleteMapping("/versions/{id}")
  public ResponseEntity<Void> deleteVersion(@PathVariable Integer id) {
    log.debug("Request to delete Version: {}",id);
    versionService.delete(id);
    return ResponseEntity.ok().build();
  }
}

