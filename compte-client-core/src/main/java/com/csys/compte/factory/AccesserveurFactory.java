package com.csys.compte.factory;

import com.csys.compte.domain.Accesserveur;
import com.csys.compte.domain.Serveur;
import com.csys.compte.dto.AccesserveurDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccesserveurFactory {

    public static AccesserveurDTO accesserveurToAccesserveurDTO(Accesserveur accesserveur) {
        AccesserveurDTO accesserveurDTO = new AccesserveurDTO();
        accesserveurDTO.setIdAcces(accesserveur.getIdAcces());
        accesserveurDTO.setLogin(accesserveur.getLogin());
        accesserveurDTO.setPassword(accesserveur.getPassword());
        accesserveurDTO.setAutreInformations(accesserveur.getAutreInformations());
        accesserveurDTO.setActif(accesserveur.getActif());
        //accesserveurDTO.setIdServeur(accesserveur.getIdServeur());
        //accesserveurDTO.setIdTypeAcces(accesserveur.getIdTypeAcces());
        
        //type acces est une liste dans accesserveur 
        accesserveurDTO.setTypeAccesDTO(TypeaccesFactory.typeaccesToTypeaccesDTO(accesserveur.getIdTypeAcces()));
        //IdTypeAcces de type Typeacces et non integer  
        accesserveurDTO.setIdTypeAcces(accesserveur.getIdTypeAcces().getIdTypeAcces());
        return accesserveurDTO;
    }

    public static Accesserveur accesserveurDTOToAccesserveur(AccesserveurDTO accesserveurDTO, Accesserveur accesserveur) {
        if (accesserveur == null) {
            accesserveur = new Accesserveur();
        }
        accesserveur.setIdAcces(accesserveurDTO.getIdAcces());
        accesserveur.setLogin(accesserveurDTO.getLogin());
        accesserveur.setPassword(accesserveurDTO.getPassword());
        accesserveur.setAutreInformations(accesserveurDTO.getAutreInformations());
        accesserveur.setActif(accesserveurDTO.getActif());
        //accesserveur.setIdServeur(accesserveurDTO.getServeur());
        accesserveur.setIdTypeAcces(TypeaccesFactory.typeaccesDTOToTypeacces2(accesserveurDTO.getTypeAccesDTO()));

        return accesserveur;
    }

    public static List<AccesserveurDTO> accesserveurToAccesserveurDTOs(Collection<Accesserveur> accesserveurs) {
        List<AccesserveurDTO> accesserveursDTO = new ArrayList<>();
        accesserveurs.forEach(x -> {
            accesserveursDTO.add(accesserveurToAccesserveurDTO(x));
        });
        return accesserveursDTO;
    }

    public static Accesserveur accesserveurDTOToAccesserveur2(AccesserveurDTO accesserveurDTO, Serveur serveur) {
        Accesserveur accesserveur = new Accesserveur();
        accesserveur.setIdAcces(accesserveurDTO.getIdAcces());
        accesserveur.setLogin(accesserveurDTO.getLogin());
        accesserveur.setPassword(accesserveurDTO.getPassword());
        accesserveur.setAutreInformations(accesserveurDTO.getAutreInformations());
        accesserveur.setActif(accesserveurDTO.getActif());
        accesserveur.setIdServeur(serveur);
        accesserveur.setIdTypeAcces(TypeaccesFactory.typeaccesDTOToTypeacces2(accesserveurDTO.getTypeAccesDTO()));
        return accesserveur;

    }

    public static List<Accesserveur> accesserveurDTOToAccesserveurs(List<AccesserveurDTO> accesserveursDTO, Serveur serveur) {
        List<Accesserveur> accesserveurs = new ArrayList<>();
        accesserveursDTO.forEach(x -> {
            accesserveurs.add(accesserveurDTOToAccesserveur2(x, serveur));
        });
        return accesserveurs;
    }
   
}
