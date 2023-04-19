package com.csys.compte.web.rest;

import com.csys.compte.dto.TypeserveurDTO;
import com.csys.compte.service.TypeserveurService;
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
public class TypeserveurResource {
  private static final String ENTITY_NAME = "typeserveur";

  private final TypeserveurService typeserveurService;

  private final Logger log = LoggerFactory.getLogger(TypeserveurService.class);

  public TypeserveurResource(TypeserveurService typeserveurService) {
    this.typeserveurService=typeserveurService;
  }

 
  @PostMapping("/typeserveurs")
  public ResponseEntity<TypeserveurDTO> createTypeserveur(@Valid @RequestBody TypeserveurDTO typeserveurDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Typeserveur : {}", typeserveurDTO);
    if ( typeserveurDTO.getIdTypeServeur() != null) {
      bindingResult.addError( new FieldError("TypeserveurDTO","idTypeServeur","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    TypeserveurDTO result = typeserveurService.save(typeserveurDTO);
    return ResponseEntity.created( new URI("/api/typeserveurs/"+ result.getIdTypeServeur())).body(result);
  }

  
  @PutMapping("/typeserveurs/{id}")
  public ResponseEntity<TypeserveurDTO> updateTypeserveur(@Valid @RequestBody TypeserveurDTO typeserveurDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Typeserveur: {}");
    TypeserveurDTO result =typeserveurService.update(typeserveurDTO);
    return ResponseEntity.ok().body(result);
  }

 
  @GetMapping("/typeserveurs/{id}")
  public ResponseEntity<TypeserveurDTO> getTypeserveur(@PathVariable Integer id) {
    log.debug("Request to get Typeserveur: {}",id);
    TypeserveurDTO dto = typeserveurService.findOne(id);
    RestPreconditions.checkFound(dto, "typeserveur.NotFound");
    return ResponseEntity.ok().body(dto);
  }

 
  @GetMapping("/typeserveurs")
  public Collection<TypeserveurDTO> getAllTypeserveurs() {
    log.debug("Request to get all  Typeserveurs : {}");
    return typeserveurService.findAll();
  }

 
  @DeleteMapping("/typeserveurs/{id}")
  public ResponseEntity<Void> deleteTypeserveur(@PathVariable Integer id) {
    log.debug("Request to delete Typeserveur: {}",id);
    typeserveurService.delete(id);
    return ResponseEntity.ok().build();
  }
}

