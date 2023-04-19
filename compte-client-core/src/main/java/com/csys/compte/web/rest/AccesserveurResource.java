package com.csys.compte.web.rest;

import com.csys.compte.dto.AccesserveurDTO;
import com.csys.compte.service.AccesserveurService;
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
 * REST controller for managing Accesserveur.
 */
@RestController
@RequestMapping("/api")
public class AccesserveurResource {
  private static final String ENTITY_NAME = "accesserveur";

  private final AccesserveurService accesserveurService;

  private final Logger log = LoggerFactory.getLogger(AccesserveurService.class);

  public AccesserveurResource(AccesserveurService accesserveurService) {
    this.accesserveurService=accesserveurService;
  }


  @PostMapping("/accesserveurs")
  public ResponseEntity<AccesserveurDTO> createAccesserveur(@Valid @RequestBody AccesserveurDTO accesserveurDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Accesserveur : {}", accesserveurDTO);
    if ( accesserveurDTO.getIdAcces() != null) {
      bindingResult.addError( new FieldError("AccesserveurDTO","idAcces","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    AccesserveurDTO result = accesserveurService.save(accesserveurDTO);
    return ResponseEntity.created( new URI("/api/accesserveurs/"+ result.getIdAcces())).body(result);
  }

 
  @PutMapping("/accesserveurs/{id}")
  public ResponseEntity<AccesserveurDTO> updateAccesserveur( @Valid @RequestBody AccesserveurDTO accesserveurDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Accesserveur: {}");
    AccesserveurDTO result =accesserveurService.update(accesserveurDTO);
    return ResponseEntity.ok().body(result);
  }

 
  @GetMapping("/accesserveurs/{id}")
  public ResponseEntity<AccesserveurDTO> getAccesserveur(@PathVariable Integer id) {
    log.debug("Request to get Accesserveur: {}",id);
    AccesserveurDTO dto = accesserveurService.findOne(id);
    RestPreconditions.checkFound(dto, "accesserveur.n'existe pas");
    return ResponseEntity.ok().body(dto);
  }

 
  @GetMapping("/accesserveurs")
  public Collection<AccesserveurDTO> getAllAccesserveurs() {
    log.debug("Request to get all  Accesserveurs : {}");
    return accesserveurService.findAll();
  }

  
  @DeleteMapping("/accesserveurs/{id}")
  public ResponseEntity<Void> deleteAccesserveur(@PathVariable Integer id) {
    log.debug("Request to delete Accesserveur: {}",id);
    accesserveurService.delete(id);
    return ResponseEntity.ok().build();
  }
}

