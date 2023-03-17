package com.csys.compte.web.rest;

import com.csys.compte.dto.EnumDTO;
import com.csys.compte.dto.UtilisateurDTO;
import com.csys.compte.enumeration.EnumRole;
import com.csys.compte.service.UtilisateurService;
import com.csys.compte.util.RestPreconditions;
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
 * REST controller for managing Utilisateur.
 */
@RestController
@RequestMapping("/api")
public class UtilisateurResource {
  private static final String ENTITY_NAME = "utilisateur";

  private final UtilisateurService utilisateurService;

  private final Logger log = LoggerFactory.getLogger(UtilisateurService.class);

  public UtilisateurResource(UtilisateurService utilisateurService) {
    this.utilisateurService=utilisateurService;
  }

  /**
   * POST  /utilisateurs : Create a new utilisateur.
   *
   * @param utilisateurDTO
   * @param bindingResult
   * @return the ResponseEntity with status 201 (Created) and with body the new utilisateur, or with status 400 (Bad Request) if the utilisateur has already an ID
   * @throws URISyntaxException if the Location URI syntax is incorrect
   * @throws org.springframework.web.bind.MethodArgumentNotValidException
   */
  @PostMapping("/utilisateurs")
  public ResponseEntity<UtilisateurDTO> createUtilisateur(@Valid @RequestBody UtilisateurDTO utilisateurDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
    log.debug("REST request to save Utilisateur : {}", utilisateurDTO);
    if ( utilisateurDTO.getUsername() == null ||  utilisateurDTO.getUsername().isEmpty() ) {
      bindingResult.addError( new FieldError("UtilisateurDTO","userName","POST method does not accepte "+ENTITY_NAME+" with code"));
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    if (bindingResult.hasErrors()) {
      throw new MethodArgumentNotValidException(null, bindingResult);
    }
    UtilisateurDTO result = utilisateurService.save(utilisateurDTO);
    return ResponseEntity.created( new URI("/api/utilisateurs/"+ result.getUsername())).body(result);
  }

  /**
   * PUT  /utilisateurs : Updates an existing utilisateur.
   *
   * @param id
   * @param utilisateurDTO the utilisateur to update
   * @return the ResponseEntity with status 200 (OK) and with body the updated utilisateur,
   * or with status 400 (Bad Request) if the utilisateur is not valid,
   * or with status 500 (Internal Server Error) if the utilisateur couldn't be updated
   * @throws org.springframework.web.bind.MethodArgumentNotValidException
   */
  @PutMapping("/utilisateurs/{id}")
  public ResponseEntity<UtilisateurDTO> updateUtilisateur(@Valid @RequestBody UtilisateurDTO utilisateurDTO) throws MethodArgumentNotValidException {
    log.debug("Request to update Utilisateur: {}");
    UtilisateurDTO result =utilisateurService.update(utilisateurDTO);
    return ResponseEntity.ok().body(result);
  }

  /**
   * GET /utilisateurs/{id} : get the "id" utilisateur.
   *
   * @param id the id of the utilisateur to retrieve
   * @return the ResponseEntity with status 200 (OK) and with body of utilisateur, or with status 404 (Not Found)
   */
  @GetMapping("/utilisateurs/{id}")
  public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable String id) {
    log.debug("Request to get Utilisateur: {}",id);
    UtilisateurDTO dto = utilisateurService.findOne(id);
    RestPreconditions.checkFound(dto, "utilisateur.NotFound");
    return ResponseEntity.ok().body(dto);
  }

  /**
   * GET /utilisateurs : get all the utilisateurs.
   *
   * @return the ResponseEntity with status 200 (OK) and the list of utilisateurs in body
   */
  @GetMapping("/utilisateurs")
  public Collection<UtilisateurDTO> getAllUtilisateurs() {
    log.debug("Request to get all  Utilisateurs : {}");
    return utilisateurService.findAll();
  }

  /**
   * DELETE  /utilisateurs/{id} : delete the "id" utilisateur.
   *
   * @param id the id of the utilisateur to delete
   * @return the ResponseEntity with status 200 (OK)
   */
  @DeleteMapping("/utilisateurs/{id}")
  public ResponseEntity<Void> deleteUtilisateur(@PathVariable String id) {
    log.debug("Request to delete Utilisateur: {}",id);
    utilisateurService.delete(id);
    return ResponseEntity.ok().build();
  }
  @GetMapping("/utilisateurs/roles")
  public Collection<EnumDTO> getAllRoles() {
    log.debug("Request to get all  role for user : {}");
    return EnumRole.ValeurRole.values();
  }
}

