package com.csys.compte.web.rest;

import com.csys.compte.dto.ServeurDTO;
import com.csys.compte.service.ServeurService;
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


@RestController
@RequestMapping("/api")
public class ServeurResource {
  private static final String ENTITY_NAME = "serveur";

  private final ServeurService serveurService;

  private final Logger log = LoggerFactory.getLogger(ServeurService.class);

  public ServeurResource(ServeurService serveurService) {
    this.serveurService=serveurService;
  }

  @PostMapping("/serveurs")
  public ResponseEntity<ServeurDTO> createServeur(@Valid @RequestBody ServeurDTO serveurDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Serveur : {}", serveurDTO);
    if ( serveurDTO.getIdServeur() != null) {
      bindingResult.addError( new FieldError("ServeurDTO","idServeur","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    ServeurDTO result = serveurService.save(serveurDTO);
    return ResponseEntity.created( new URI("/api/serveurs/"+ result.getIdServeur())).body(result);
  }


  @PutMapping("/serveurs/{id}")
  public ResponseEntity<ServeurDTO> updateServeur( @Valid @RequestBody ServeurDTO serveurDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Serveur: {}");
    ServeurDTO result =serveurService.update(serveurDTO);
    return ResponseEntity.ok().body(result);
  }

  
  @GetMapping("/serveurs/{id}")
  public ResponseEntity<ServeurDTO> getServeur(@PathVariable Integer id) {
    log.debug("Request to get Serveur: {}",id);
    ServeurDTO dto = serveurService.findOne(id);
    RestPreconditions.checkFound(dto, "serveur.NotFound");
    return ResponseEntity.ok().body(dto);
  }


  @GetMapping("/serveurs")
  public Collection<ServeurDTO> getAllServeurs() {
    log.debug("Request to get all  Serveurs : {}");
    return serveurService.findAll();
  }


  @DeleteMapping("/serveurs/{id}")
  public ResponseEntity<Void> deleteServeur(@PathVariable Integer id) {
    log.debug("Request to delete Serveur: {}",id);
    serveurService.delete(id);
    return ResponseEntity.ok().build();
  }
}

