package com.csys.compte.factory;

import com.csys.compte.domain.Utilisateur;
import com.csys.compte.dto.UtilisateurDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UtilisateurFactory {

    public static UtilisateurDTO utilisateurToUtilisateurDTO(Utilisateur utilisateur) {
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        utilisateurDTO.setUsername(utilisateur.getUserName());
        utilisateurDTO.setPassword(utilisateur.getPassword());
        utilisateurDTO.setNom(utilisateur.getNom());
        utilisateurDTO.setPrenom(utilisateur.getPrenom());
        utilisateurDTO.setRole(utilisateur.getRole());
        utilisateurDTO.setActif(utilisateur.getActif());
        utilisateurDTO.setModuleList(utilisateur.getModuleList());
      //  utilisateurDTO.setClientmoduleversionList(utilisateur.getClientmoduleversionList());
        utilisateurDTO.setIdPoste(utilisateur.getPoste().getIdPoste());
        utilisateurDTO.setPosteDTO(PosteFactory.posteToPosteDTO(utilisateur.getPoste()));
        return utilisateurDTO;
    }

    public static Utilisateur utilisateurDTOToUtilisateur(UtilisateurDTO utilisateurDTO, Utilisateur utilisateur) {
        if (utilisateur == null) {
            utilisateur = new Utilisateur();
        }
        utilisateur.setUserName(utilisateurDTO.getUsername());
        utilisateur.setPassword(utilisateurDTO.getPassword());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setRole(utilisateurDTO.getRole());
        utilisateur.setActif(utilisateurDTO.getActif());
        return utilisateur;
    }

    public static Collection<UtilisateurDTO> utilisateurToUtilisateurDTOs(Collection<Utilisateur> utilisateurs) {
        List<UtilisateurDTO> utilisateursDTO = new ArrayList<>();
        utilisateurs.forEach(x -> {
            utilisateursDTO.add(utilisateurToUtilisateurDTO(x));
        });
        return utilisateursDTO;
    }

}
