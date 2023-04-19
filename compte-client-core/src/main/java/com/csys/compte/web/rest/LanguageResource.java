package com.csys.compte.web.rest;

import com.csys.compte.dto.LanguageDTO;
import com.csys.compte.service.LanguageService;
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
 * REST controller for managing Language.
 */
@RestController
@RequestMapping("/api")
public class LanguageResource {
  private static final String ENTITY_NAME = "language";

  private final LanguageService languageService;

  private final Logger log = LoggerFactory.getLogger(LanguageService.class);

  public LanguageResource(LanguageService languageService) {
    this.languageService=languageService;
  }

  /**
   * POST  /languages : Create a new language.
   *
   * @param languageDTO
   * @param bindingResult
   * @return the ResponseEntity with status 201 (Created) and with body the new language, or with status 400 (Bad Request) if the language has already an ID
   * @throws URISyntaxException if the Location URI syntax is incorrect
   * @throws org.springframework.web.bind.MethodArgumentNotValidException
   */
  @PostMapping("/languages")
  public ResponseEntity<LanguageDTO> createLanguage(@Valid @RequestBody LanguageDTO languageDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Language : {}", languageDTO);
    if ( languageDTO.getIdLanguage() != null) {
      bindingResult.addError( new FieldError("LanguageDTO","idLanguage","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    LanguageDTO result = languageService.save(languageDTO);
    return ResponseEntity.created( new URI("/api/languages/"+ result.getIdLanguage())).body(result);
  }


  @PutMapping("/languages/{id}")
  public ResponseEntity<LanguageDTO> updateLanguage(@Valid @RequestBody LanguageDTO languageDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Language: {}");
    LanguageDTO result =languageService.update(languageDTO);
    return ResponseEntity.ok().body(result);
  }


  @GetMapping("/languages/{id}")
  public ResponseEntity<LanguageDTO> getLanguage(@PathVariable Integer id) {
    log.debug("Request to get Language: {}",id);
    LanguageDTO dto = languageService.findOne(id);
    RestPreconditions.checkFound(dto, "language.NotFound");
    return ResponseEntity.ok().body(dto);
  }

 
  @GetMapping("/languages")
  public Collection<LanguageDTO> getAllLanguages() {
    log.debug("Request to get all  Languages : {}");
    return languageService.findAll();
  }

 
  @DeleteMapping("/languages/{id}")
  public ResponseEntity<Void> deleteLanguage(@PathVariable Integer id) {
    log.debug("Request to delete Language: {}",id);
    languageService.delete(id);
    return ResponseEntity.ok().build();
  }
}

