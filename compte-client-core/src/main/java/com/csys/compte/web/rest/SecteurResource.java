package com.csys.compte.web.rest;

import com.csys.compte.dto.SecteurDTO;
import com.csys.compte.service.SecteurService;
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
 * REST controller for managing Secteur.
 */
@RestController
@RequestMapping("/api")
public class SecteurResource {
  private static final String ENTITY_NAME = "secteur";

  private final SecteurService secteurService;

  private final Logger log = LoggerFactory.getLogger(SecteurService.class);

  public SecteurResource(SecteurService secteurService) {
    this.secteurService=secteurService;
  }

  @PostMapping("/secteurs")
  public ResponseEntity<SecteurDTO> createSecteur(@Valid @RequestBody SecteurDTO secteurDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Secteur : {}", secteurDTO);
    if ( secteurDTO.getIdSecteur() != null) {
      bindingResult.addError( new FieldError("SecteurDTO","idSecteur","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    SecteurDTO result = secteurService.save(secteurDTO);
    return ResponseEntity.created( new URI("/api/secteurs/"+ result.getIdSecteur())).body(result);
  }


  @PutMapping("/secteurs/{id}")
  public ResponseEntity<SecteurDTO> updateSecteur(@Valid @RequestBody SecteurDTO secteurDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Secteur: {}");
    SecteurDTO result =secteurService.update(secteurDTO);
    return ResponseEntity.ok().body(result);
  }

  @GetMapping("/secteurs/{id}")
  public ResponseEntity<SecteurDTO> getSecteur(@PathVariable Integer id) {
    log.debug("Request to get Secteur: {}",id);
    SecteurDTO dto = secteurService.findOne(id);
    RestPreconditions.checkFound(dto, "Le secteur n'existe pas");
    return ResponseEntity.ok().body(dto);
  }

  @GetMapping("/secteurs")
  public Collection<SecteurDTO> getAllSecteurs() {
    log.debug("Request to get all  Secteurs : {}");
    return secteurService.findAll();
  }

  @DeleteMapping("/secteurs/{id}")
  public ResponseEntity<Void> deleteSecteur(@PathVariable Integer id) {
    log.debug("Request to delete Secteur: {}",id);
    secteurService.delete(id);
    return ResponseEntity.ok().build();
  }
}

