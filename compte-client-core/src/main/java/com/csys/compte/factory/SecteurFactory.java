package com.csys.compte.factory;

import com.csys.compte.domain.Secteur;
import com.csys.compte.dto.SecteurDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecteurFactory {

    public static SecteurDTO secteurToSecteurDTO(Secteur secteur) {
        SecteurDTO secteurDTO = new SecteurDTO();
        secteurDTO.setIdSecteur(secteur.getIdSecteur());
        secteurDTO.setDesignation(secteur.getDesignation());
        secteurDTO.setActif(secteur.getActif());
        secteurDTO.setClientList(secteur.getClientList());
        return secteurDTO;
    }

    public static Secteur secteurDTOToSecteur(SecteurDTO secteurDTO, Secteur secteur) {
        if (secteur == null) {
            secteur = new Secteur();
        }
        secteur.setIdSecteur(secteurDTO.getIdSecteur());
        secteur.setDesignation(secteurDTO.getDesignation());
        secteur.setActif(secteurDTO.getActif());
        secteur.setClientList(secteurDTO.getClientList());
        return secteur;
    }

    public static Collection<SecteurDTO> secteurToSecteurDTOs(Collection<Secteur> secteurs) {
        List<SecteurDTO> secteursDTO = new ArrayList<>();
        secteurs.forEach(x -> {
            secteursDTO.add(secteurToSecteurDTO(x));
        });
        return secteursDTO;
    }
}
