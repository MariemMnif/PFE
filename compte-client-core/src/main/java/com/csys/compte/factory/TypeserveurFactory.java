package com.csys.compte.factory;

import com.csys.compte.domain.Typeserveur;
import com.csys.compte.dto.TypeserveurDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TypeserveurFactory {
  public static TypeserveurDTO typeserveurToTypeserveurDTO(Typeserveur typeserveur) {
    TypeserveurDTO typeserveurDTO=new TypeserveurDTO();
    typeserveurDTO.setIdTypeServeur(typeserveur.getIdTypeServeur());
    typeserveurDTO.setDesignation(typeserveur.getDesignation());
    typeserveurDTO.setActif(typeserveur.getActif());
//    typeserveurDTO.setServeurList(typeserveur.getServeurList());
    return typeserveurDTO;
  }

  public static Typeserveur typeserveurDTOToTypeserveur(TypeserveurDTO typeserveurDTO,Typeserveur typeserveur) {
    if(typeserveur==null){
        typeserveur=new Typeserveur();
    }
    typeserveur.setIdTypeServeur(typeserveurDTO.getIdTypeServeur());
    typeserveur.setDesignation(typeserveurDTO.getDesignation());
    typeserveur.setActif(typeserveurDTO.getActif());
   // typeserveur.setServeurList(typeserveurDTO.getServeurList());
    return typeserveur;
  }

  public static Collection<TypeserveurDTO> typeserveurToTypeserveurDTOs(Collection<Typeserveur> typeserveurs) {
    List<TypeserveurDTO> typeserveursDTO=new ArrayList<>();
    typeserveurs.forEach(x -> {
      typeserveursDTO.add(typeserveurToTypeserveurDTO(x));
    } );
    return typeserveursDTO;
  }
}

