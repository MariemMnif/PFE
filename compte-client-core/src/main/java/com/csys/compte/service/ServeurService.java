package com.csys.compte.service;

import com.csys.compte.domain.Client;
import com.csys.compte.domain.Serveur;
import com.csys.compte.domain.Typeserveur;
import com.csys.compte.dto.ServeurDTO;
import com.csys.compte.factory.ServeurFactory;
import com.csys.compte.repository.ServeurRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServeurService {

    private final Logger log = LoggerFactory.getLogger(ServeurService.class);

    private final ServeurRepository serveurRepository;
    private final TypeserveurService typeserveurService;
    private final ClientService clientService;

    public ServeurService(ServeurRepository serveurRepository, TypeserveurService typeserveurService, ClientService clientService) {
        this.serveurRepository = serveurRepository;
        this.typeserveurService = typeserveurService;
        this.clientService = clientService;
    }

    public ServeurDTO save(ServeurDTO serveurDTO) {
        log.debug("Request to save Serveur: {}", serveurDTO);
        //verif serveur existe ou non 
        Serveur serveurinBase = serveurRepository.findByAdresseIp(serveurDTO.getAdresseIp());
        Preconditions.checkArgument(serveurinBase == null, "Serveur existe deja");
        //verif client 
        Client client = clientService.findClient(serveurDTO.getIdClient());
        Preconditions.checkArgument(client != null, "Client n'existe pas");
        //verif type serveur 
        Typeserveur typeserveur = typeserveurService.findTypeserveur(serveurDTO.getIdTypeServeur());
        Preconditions.checkArgument(typeserveur != null, "type serveur n'existe pas");

        Serveur serveur = ServeurFactory.serveurDTOToServeur(serveurDTO, null);
        //set 
        serveur.setIdClient(client);
        serveur.setIdTypeServeur(typeserveur);

        serveur = serveurRepository.save(serveur);
        ServeurDTO resultDTO = ServeurFactory.serveurToServeurDTO(serveur);
        return resultDTO;
    }

    public ServeurDTO update(ServeurDTO serveurDTO) {
        log.debug("Request to update Serveur: {}", serveurDTO);
        Serveur inBase = serveurRepository.findByIdServeur(serveurDTO.getIdServeur());
        Preconditions.checkArgument(inBase != null, "serveur n'existe pas");
        //verif client 
        Client client = clientService.findClient(serveurDTO.getIdClient());
        Preconditions.checkArgument(client != null, "Region n'existe pas");
        //verif type serveur 
        Typeserveur typeserveur = typeserveurService.findTypeserveur(serveurDTO.getIdTypeServeur());
        Preconditions.checkArgument(typeserveur != null, "type serveur n'existe pas");

        Serveur serveur = ServeurFactory.serveurDTOToServeur(serveurDTO, inBase);
        //set
        serveur.setIdClient(client);
        serveur.setIdTypeServeur(typeserveur);

        serveur = serveurRepository.save(serveur);
        ServeurDTO resultDTO = ServeurFactory.serveurToServeurDTO(serveur);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public ServeurDTO findOne(Integer id) {
        log.debug("Request to get Serveur: {}", id);
        Serveur serveur = serveurRepository.findByIdServeur(id);
        ServeurDTO dto = ServeurFactory.serveurToServeurDTO(serveur);
        return dto;
    }

    @Transactional(readOnly = true)
    public Serveur findServeur(Integer id) {
        log.debug("Request to get Serveur: {}", id);
        Serveur serveur = serveurRepository.findByIdServeur(id);
        return serveur;
    }

    @Transactional(readOnly = true)
    public Collection<ServeurDTO> findAll() {
        log.debug("Request to get All Serveurs");
        Collection<Serveur> result = serveurRepository.findAll();
        return ServeurFactory.serveurToServeurDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Serveur: {}", id);
        serveurRepository.deleteById(id);
    }
}
