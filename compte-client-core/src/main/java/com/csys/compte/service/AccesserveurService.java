package com.csys.compte.service;

import com.csys.compte.domain.Accesserveur;
import com.csys.compte.domain.Serveur;
import com.csys.compte.domain.Typeacces;
import com.csys.compte.dto.AccesserveurDTO;
import com.csys.compte.factory.AccesserveurFactory;
import com.csys.compte.repository.AccesserveurRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccesserveurService {

    private final Logger log = LoggerFactory.getLogger(AccesserveurService.class);

    private final AccesserveurRepository accesserveurRepository;
    private final TypeaccesService typeaccesService;
    private final ServeurService serveurService;

    public AccesserveurService(AccesserveurRepository accesserveurRepository, TypeaccesService typeaccesService, ServeurService serveurService) {
        this.accesserveurRepository = accesserveurRepository;
        this.typeaccesService = typeaccesService;
        this.serveurService = serveurService;
    }

    public AccesserveurDTO save(AccesserveurDTO accesserveurDTO) {
        log.debug("Request to save Accesserveur: {}", accesserveurDTO);
        // verid duplication
        //Serveur 
        Serveur serveur = serveurService.findServeur(accesserveurDTO.getServeurDTO().getIdServeur());
        Preconditions.checkArgument(serveur != null, "Serveur n'existe pas");
        // verif type acces existe ou non
        Typeacces typeacces = typeaccesService.findTypeacces(accesserveurDTO.getIdTypeAcces());
        Preconditions.checkArgument(typeacces != null, "type acces n'existe pas");

        Accesserveur accesserveur = AccesserveurFactory.accesserveurDTOToAccesserveur(accesserveurDTO, null);

        accesserveur.setIdServeur(serveur);
        accesserveur.setIdTypeAcces(typeacces);

        accesserveur = accesserveurRepository.save(accesserveur);
        AccesserveurDTO resultDTO = AccesserveurFactory.accesserveurToAccesserveurDTO(accesserveur);
        return resultDTO;
    }

    public AccesserveurDTO update(AccesserveurDTO accesserveurDTO) {
        log.debug("Request to update Accesserveur: {}", accesserveurDTO);
        Accesserveur inBase = accesserveurRepository.findByIdAcces(accesserveurDTO.getIdAcces());
        Preconditions.checkArgument(inBase != null, "accesserveur n'existe pas");
        //Serveur 
        //prb update null
        //Serveur serveur = serveurService.findServeur(accesserveurDTO.getServeurDTO().getIdServeur());
        //Preconditions.checkArgument(serveur != null, "Serveur n'existe pas");

        //set type acces
        Typeacces typeacces = typeaccesService.findTypeacces(accesserveurDTO.getIdTypeAcces());
        Preconditions.checkArgument(typeacces != null, "type acces n'existe pas");
        Accesserveur accesserveur = AccesserveurFactory.accesserveurDTOToAccesserveur(accesserveurDTO, inBase);

        accesserveur.setIdTypeAcces(typeacces);
        //accesserveur.setIdServeur(serveur);

        accesserveur = accesserveurRepository.save(accesserveur);
        AccesserveurDTO resultDTO = AccesserveurFactory.accesserveurToAccesserveurDTO(accesserveur);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public AccesserveurDTO findOne(Integer id) {
        log.debug("Request to get Accesserveur: {}", id);
        Accesserveur accesserveur = accesserveurRepository.findByIdAcces(id);
        AccesserveurDTO dto = AccesserveurFactory.accesserveurToAccesserveurDTO(accesserveur);
        return dto;
    }

    @Transactional(readOnly = true)
    public Accesserveur findAccesserveur(Integer id) {
        log.debug("Request to get Accesserveur: {}", id);
        Accesserveur accesserveur = accesserveurRepository.findByIdAcces(id);
        return accesserveur;
    }

    @Transactional(readOnly = true)
    public Collection<AccesserveurDTO> findAll() {
        log.debug("Request to get All Accesserveurs");
        Collection<Accesserveur> result = accesserveurRepository.findAll();
        return AccesserveurFactory.accesserveurToAccesserveurDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Accesserveur: {}", id);
        accesserveurRepository.deleteById(id);
    }
}
