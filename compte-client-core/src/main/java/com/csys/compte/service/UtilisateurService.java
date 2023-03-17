package com.csys.compte.service;

import com.csys.compte.domain.Poste;
import com.csys.compte.domain.Utilisateur;
import com.csys.compte.dto.UtilisateurDTO;
import com.csys.compte.factory.UtilisateurFactory;
import com.csys.compte.repository.UtilisateurRepository;
import com.google.common.base.Preconditions;
import java.lang.String;
import java.util.Collection;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Utilisateur.
 */
@Service
@Transactional
public class UtilisateurService {

    private final Logger log = LoggerFactory.getLogger(UtilisateurService.class);

    private final UtilisateurRepository utilisateurRepository;
    private final PosteService posteService;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, PosteService posteService) {
        this.utilisateurRepository = utilisateurRepository;
        this.posteService = posteService;
    }

    /**
     * Save a utilisateurDTO.
     *
     * @param utilisateurDTO
     * @return the persisted entity
     */
    public UtilisateurDTO save(UtilisateurDTO utilisateurDTO) {
        log.debug("Request to save Utilisateur: {}", utilisateurDTO);
        Poste poste = posteService.findPoste(utilisateurDTO.getIdPoste());
        Preconditions.checkArgument(poste != null, "La poste n'existe pas");
        Utilisateur utilisateur = UtilisateurFactory.utilisateurDTOToUtilisateur(utilisateurDTO,null);
        utilisateur.setPoste(poste);
        utilisateur = utilisateurRepository.save(utilisateur);
        UtilisateurDTO resultDTO = UtilisateurFactory.utilisateurToUtilisateurDTO(utilisateur);
        return resultDTO;
    }

    /**
     * Update a utilisateurDTO.
     *
     * @param utilisateurDTO
     * @return the updated entity
     */
    public UtilisateurDTO update(UtilisateurDTO utilisateurDTO) {
        log.debug("Request to update Utilisateur: {}", utilisateurDTO);
        Utilisateur inBase = utilisateurRepository.findByUserName(utilisateurDTO.getUsername());
        Preconditions.checkArgument(inBase != null, "utilisateur n'existe pas");
        Utilisateur utilisateur = UtilisateurFactory.utilisateurDTOToUtilisateur(utilisateurDTO,inBase);
        utilisateur = utilisateurRepository.save(utilisateur);
        UtilisateurDTO resultDTO = UtilisateurFactory.utilisateurToUtilisateurDTO(utilisateur);
        return resultDTO;
    }

    /**
     * Get one utilisateurDTO by id.
     *
     * @param id the id of the entity
     * @return the entity DTO
     */
    @Transactional(readOnly = true)
    public UtilisateurDTO findOne(String id) {
        log.debug("Request to get Utilisateur: {}", id);
        Utilisateur utilisateur = utilisateurRepository.findByUserName(id);
        UtilisateurDTO dto = UtilisateurFactory.utilisateurToUtilisateurDTO(utilisateur);
        return dto;
    }

    /**
     * Get one utilisateur by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Utilisateur findUtilisateur(String id) {
        log.debug("Request to get Utilisateur: {}", id);
        Utilisateur utilisateur = utilisateurRepository.findByUserName(id);
        return utilisateur;
    }

    /**
     * Get all the utilisateurs.
     *
     * @return the the list of entities
     */
    @Transactional(readOnly = true)
    public Collection<UtilisateurDTO> findAll() {
        log.debug("Request to get All Utilisateurs");
        Collection<Utilisateur> result = utilisateurRepository.findAll();
        return UtilisateurFactory.utilisateurToUtilisateurDTOs(result);
    }

    /**
     * Delete utilisateur by id.
     *
     * @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete Utilisateur: {}", id);
        utilisateurRepository.deleteById(id);
    }
}
