package com.csys.compte.service;

import com.csys.compte.domain.Client;
import com.csys.compte.domain.Region;
import com.csys.compte.domain.Secteur;
import com.csys.compte.dto.ClientDTO;
import com.csys.compte.factory.ClientFactory;
import com.csys.compte.factory.RegionFactory;
import com.csys.compte.factory.SecteurFactory;
import com.csys.compte.repository.ClientRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Client.
 */
@Service
@Transactional
public class ClientService {

    private final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;
    private final RegionService regionService;
    private final SecteurService secteurService;

    public ClientService(ClientRepository clientRepository, RegionService regionService, SecteurService secteurService) {
        this.clientRepository = clientRepository;
        this.regionService = regionService;
        this.secteurService = secteurService;
    }

    public ClientDTO save(ClientDTO clientDTO) {
        log.debug("Request to save Client: {}", clientDTO);
        //verif client existe ou non 
        Client clientinBase = clientRepository.findByRaisonSociale(clientDTO.getRaisonSociale());
        Preconditions.checkArgument(clientinBase == null, "Client existe deja");
      
        Region region = regionService.findRegion(clientDTO.getIdRegion());
        Preconditions.checkArgument(region != null, "Region n'existe pas");
        Secteur secteur = secteurService.findSecteur(clientDTO.getIdSecteur());
        Preconditions.checkArgument(secteur != null, "Secteur n'existe pas");
        Client client = ClientFactory.clientDTOToClient(clientDTO, null);
        client.setIdRegion(region);
        client.setIdSecteur(secteur);
        client = clientRepository.save(client);
        ClientDTO resultDTO = ClientFactory.clientToClientDTO(client);
        return resultDTO;
    }

    public ClientDTO update(ClientDTO clientDTO) {
        log.debug("Request to update Client: {}", clientDTO);
        Client inBase = clientRepository.findByIdClient(clientDTO.getIdClient());
        Preconditions.checkArgument(inBase != null, "Client n'existe pas");
        
        Region region = regionService.findRegion(clientDTO.getIdRegion());
        Preconditions.checkArgument(region != null, "Region n'existe pas");
        
        Secteur secteur = secteurService.findSecteur(clientDTO.getIdSecteur()); 
        Preconditions.checkArgument(secteur != null, "Secteur n'existe pas");
        Client client = ClientFactory.clientDTOToClient(clientDTO, inBase);
        
        client.setIdRegion(region);
        client.setIdSecteur(secteur);
        
        client = clientRepository.save(client);
        ClientDTO resultDTO = ClientFactory.clientToClientDTO(client);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public ClientDTO findOne(Integer id) {
        log.debug("Request to get Client: {}", id);
        Client client = clientRepository.findByIdClient(id);
        ClientDTO dto = ClientFactory.clientToClientDTO(client);
        return dto;
    }

    @Transactional(readOnly = true)
    public Client findClient(Integer id) {
        log.debug("Request to get Client: {}", id);
        Client client = clientRepository.findByIdClient(id);
        return client;
    }

    @Transactional(readOnly = true)
    public Collection<ClientDTO> findAll() {
        log.debug("Request to get All Clients");
        Collection<Client> result = clientRepository.findAll();
        return ClientFactory.clientToClientDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Client: {}", id);
        clientRepository.deleteById(id);
    }
}
