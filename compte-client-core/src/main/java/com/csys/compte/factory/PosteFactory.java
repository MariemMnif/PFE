package com.csys.compte.factory;

import com.csys.compte.domain.Poste;
import com.csys.compte.dto.PosteDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PosteFactory {
    
  public static PosteDTO posteToPosteDTO(Poste poste) {
    PosteDTO posteDTO=new PosteDTO();
    posteDTO.setIdPoste(poste.getIdPoste());
    posteDTO.setDesignation(poste.getDesignation());
    posteDTO.setActif(poste.getActif());
    return posteDTO;
  }

  public static Poste posteDTOToPoste(PosteDTO posteDTO,Poste poste) {
      if(poste==null)
      {  poste=new Poste();}
      
    poste.setIdPoste(posteDTO.getIdPoste());
    poste.setDesignation(posteDTO.getDesignation());
    poste.setActif(posteDTO.getActif());
    return poste;
  }

  public static Collection<PosteDTO> posteToPosteDTOs(Collection<Poste> postes) {
    List<PosteDTO> postesDTO=new ArrayList<>();
    postes.forEach(x -> {
      postesDTO.add(posteToPosteDTO(x));
    } );
    return postesDTO;
  }
}

