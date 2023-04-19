package com.csys.compte.factory;

import com.csys.compte.domain.Client;
import com.csys.compte.dto.ClientDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientFactory {

    public static ClientDTO clientToClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setIdClient(client.getIdClient());
        clientDTO.setRaisonSociale(client.getRaisonSociale());
        clientDTO.setDns(client.getDns());
        clientDTO.setActif(client.getActif());
        //clientDTO.setServeurList(client.getServeurList());
        // clientDTO.setClientmoduleversionList(client.getClientmoduleversionList());
        //clientDTO.setRegion(client.getIdRegion());
        //clientDTO.setIdSecteur(client.getSecteur().getIdSecteur());
        
        clientDTO.setRegionDTO(RegionFactory.regionToRegionDTO(client.getIdRegion()));
        
        //IdRegion de type Region et non integer  
        clientDTO.setIdRegion(client.getIdRegion().getIdRegion());
        
        clientDTO.setSecteurDTO(SecteurFactory.secteurToSecteurDTO(client.getIdSecteur()));
      
        //IdSecteur de type Secteur et non integer  
        clientDTO.setIdSecteur(client.getIdSecteur().getIdSecteur());
        return clientDTO;
    }

    public static Client clientDTOToClient(ClientDTO clientDTO, Client client) {
        if (client == null) {
            client = new Client();
        }
        client.setIdClient(clientDTO.getIdClient());
        client.setRaisonSociale(clientDTO.getRaisonSociale());
        client.setDns(clientDTO.getDns());
        client.setActif(clientDTO.getActif());
        // client.setServeurList(clientDTO.getServeurList());
        // client.setClientmoduleversionList(clientDTO.getClientmoduleversionList());
        //client.setIdRegion(clientDTO.getIdRegion());
        // client.setIdRegion(clientDTO.getRegionDTO());
        //client.setIdSecteur(clientDTO.getSecteur());
        return client;
    }

    public static Collection<ClientDTO> clientToClientDTOs(Collection<Client> clients) {
        List<ClientDTO> clientsDTO = new ArrayList<>();
        clients.forEach(x -> {
            clientsDTO.add(clientToClientDTO(x));
        });
        return clientsDTO;
    }
}
