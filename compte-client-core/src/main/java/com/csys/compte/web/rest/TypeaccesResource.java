package com.csys.compte.web.rest;

import com.csys.compte.dto.TypeaccesDTO;
import com.csys.compte.service.TypeaccesService;
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
public class TypeaccesResource {
  private static final String ENTITY_NAME = "typeacces";

  private final TypeaccesService typeaccesService;

  private final Logger log = LoggerFactory.getLogger(TypeaccesService.class);

  public TypeaccesResource(TypeaccesService typeaccesService) {
    this.typeaccesService=typeaccesService;
  }

  
  @PostMapping("/typeaccess")
  public ResponseEntity<TypeaccesDTO> createTypeacces(@Valid @RequestBody TypeaccesDTO typeaccesDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Typeacces : {}", typeaccesDTO);
    if ( typeaccesDTO.getIdTypeAcces() != null) {
      bindingResult.addError( new FieldError("TypeaccesDTO","idTypeAcces","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    TypeaccesDTO result = typeaccesService.save(typeaccesDTO);
    return ResponseEntity.created( new URI("/api/typeaccess/"+ result.getIdTypeAcces())).body(result);
  }

  @PutMapping("/typeaccess/{id}")
  public ResponseEntity<TypeaccesDTO> updateTypeacces( @Valid @RequestBody TypeaccesDTO typeaccesDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Typeacces: {}");
    TypeaccesDTO result =typeaccesService.update(typeaccesDTO);
    return ResponseEntity.ok().body(result);
  }

  
  @GetMapping("/typeaccess/{id}")
  public ResponseEntity<TypeaccesDTO> getTypeacces(@PathVariable Integer id) {
    log.debug("Request to get Typeacces: {}",id);
    TypeaccesDTO dto = typeaccesService.findOne(id);
    RestPreconditions.checkFound(dto, "typeacces.NotFound");
    return ResponseEntity.ok().body(dto);
  }

  /**
   * GET /typeaccess : get all the typeaccess.
   *
   * @return the ResponseEntity with status 200 (OK) and the list of typeaccess in body
   */
  @GetMapping("/typeaccess")
  public Collection<TypeaccesDTO> getAllTypeaccess() {
    log.debug("Request to get all  Typeaccess : {}");
    return typeaccesService.findAll();
  }

  /**
   * DELETE  /typeaccess/{id} : delete the "id" typeacces.
   *
   * @param id the id of the typeacces to delete
   * @return the ResponseEntity with status 200 (OK)
   */
  @DeleteMapping("/typeaccess/{id}")
  public ResponseEntity<Void> deleteTypeacces(@PathVariable Integer id) {
    log.debug("Request to delete Typeacces: {}",id);
    typeaccesService.delete(id);
    return ResponseEntity.ok().build();
  }
}

