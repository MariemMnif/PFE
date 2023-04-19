package com.csys.compte.factory;

import com.csys.compte.domain.Serveur;
import com.csys.compte.dto.AccesserveurDTO;
import com.csys.compte.dto.ServeurDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServeurFactory {

    public static ServeurDTO serveurToServeurDTO(Serveur serveur) {
        ServeurDTO serveurDTO = new ServeurDTO();
        serveurDTO.setIdServeur(serveur.getIdServeur());
        serveurDTO.setAdresseIp(serveur.getAdresseIp());
        serveurDTO.setActif(serveur.getActif());
        serveurDTO.setAccesserveurList( AccesserveurFactory.accesserveurToAccesserveurDTOs(serveur.getAccesserveurList()));
        //client
        serveurDTO.setClientDTO(ClientFactory.clientToClientDTO(serveur.getIdClient()));

        //serveur.getIdClient() de type client et non integer   serveurDTO.setIdClient de type int
        serveurDTO.setIdClient(serveur.getIdClient().getIdClient());

        //type serveur
        // ghalta 9dima serveurDTO.setTypeServeurDTO(ServeurFactory.serveurToServeurDTO(serveur.getIdTypeServeur());
        serveurDTO.setTypeServeurDTO(TypeserveurFactory.typeserveurToTypeserveurDTO(serveur.getIdTypeServeur()));

        //serveur.getIdTypeServeur()() de type typeserveur et non integer   serveurDTO.setIdTypeServeur de type int
        serveurDTO.setIdTypeServeur(serveur.getIdTypeServeur().getIdTypeServeur());

        return serveurDTO;
    }

    public static Serveur serveurDTOToServeur(ServeurDTO serveurDTO, Serveur serveur) {
        if (serveur == null) {
            serveur = new Serveur();
        }
        serveur.setIdServeur(serveurDTO.getIdServeur());
        serveur.setAdresseIp(serveurDTO.getAdresseIp());
        serveur.setActif(serveurDTO.getActif());
        serveur.setAccesserveurList(AccesserveurFactory.accesserveurDTOToAccesserveurs(serveurDTO.getAccesserveurList(), serveur));
        // serveur.setIdClient(serveurDTO.getClientDTO());
        //   serveur.setIdTypeServeur(serveurDTO.getTypeServeurDTO());
        return serveur;
    }

    public static Collection<ServeurDTO> serveurToServeurDTOs(Collection<Serveur> serveurs) {
        List<ServeurDTO> serveursDTO = new ArrayList<>();
        serveurs.forEach(x -> {
            serveursDTO.add(serveurToServeurDTO(x));
        });
        return serveursDTO;
    }
}
