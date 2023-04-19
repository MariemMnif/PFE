package com.csys.compte.service;

import com.csys.compte.domain.Poste;
import com.csys.compte.dto.PosteDTO;
import com.csys.compte.factory.PosteFactory;
import com.csys.compte.repository.PosteRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PosteService {

    private final Logger log = LoggerFactory.getLogger(PosteService.class);

    private final PosteRepository posteRepository;

    public PosteService(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

   
    public PosteDTO save(PosteDTO posteDTO) {
        log.debug("Request to save Poste: {}", posteDTO);
        //verif poste existe ou non 
        Poste posteinBase = posteRepository.findByDesignation(posteDTO.getDesignation());
        Preconditions.checkArgument(posteinBase == null, "Le poste existe deja");
        Poste poste = PosteFactory.posteDTOToPoste(posteDTO, null);
        poste = posteRepository.save(poste);
        PosteDTO resultDTO = PosteFactory.posteToPosteDTO(poste);
        return resultDTO;
    }

   
    public PosteDTO update(PosteDTO posteDTO) {
        log.debug("Request to update Poste: {}", posteDTO);
        Poste inBase = posteRepository.findByIdPoste(posteDTO.getIdPoste());
        Preconditions.checkArgument(inBase != null, "La poste n'existe pas");
        Poste poste = PosteFactory.posteDTOToPoste(posteDTO, inBase);
        poste = posteRepository.save(poste);
        PosteDTO resultDTO = PosteFactory.posteToPosteDTO(poste);
        return resultDTO;
    }

   
    @Transactional(readOnly = true)
    public PosteDTO findOne(Integer id) {
        log.debug("Request to get Poste: {}", id);
        Poste poste = posteRepository.findByIdPoste(id);
        PosteDTO dto = PosteFactory.posteToPosteDTO(poste);
        return dto;
    }

 
    @Transactional(readOnly = true)
    public Poste findPoste(Integer id) {
        log.debug("Request to get Poste: {}", id);
        Poste poste = posteRepository.findByIdPoste(id);
        return poste;
    }
   

    // Get all the postes.
    @Transactional(readOnly = true)
    public Collection<PosteDTO> findAll() {
        log.debug("Request to get All Postes");
        Collection<Poste> result = posteRepository.findAll();
        return PosteFactory.posteToPosteDTOs(result);
    }

    // Delete poste by id.
    public void delete(Integer id) {
        log.debug("Request to delete Poste: {}", id);
        posteRepository.deleteById(id);
    }
}
