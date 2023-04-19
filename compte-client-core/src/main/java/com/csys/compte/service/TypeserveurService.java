package com.csys.compte.service;

import com.csys.compte.domain.Typeserveur;
import com.csys.compte.dto.TypeserveurDTO;
import com.csys.compte.factory.TypeserveurFactory;
import com.csys.compte.repository.TypeserveurRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeserveurService {

    private final Logger log = LoggerFactory.getLogger(TypeserveurService.class);

    private final TypeserveurRepository typeserveurRepository;

    public TypeserveurService(TypeserveurRepository typeserveurRepository) {
        this.typeserveurRepository = typeserveurRepository;
    }

    public TypeserveurDTO save(TypeserveurDTO typeserveurDTO) {
        log.debug("Request to save Typeserveur: {}", typeserveurDTO);
        //verif typeserveur existe ou non 
        Typeserveur typeserveurinBase = typeserveurRepository.findByDesignation(typeserveurDTO.getDesignation());
        Preconditions.checkArgument(typeserveurinBase == null, "type serveur existe deja");
        
        Typeserveur typeserveur = TypeserveurFactory.typeserveurDTOToTypeserveur(typeserveurDTO, null);
        typeserveur = typeserveurRepository.save(typeserveur);
        TypeserveurDTO resultDTO = TypeserveurFactory.typeserveurToTypeserveurDTO(typeserveur);
        return resultDTO;
    }

    public TypeserveurDTO update(TypeserveurDTO typeserveurDTO) {
        log.debug("Request to update Typeserveur: {}", typeserveurDTO);
        Typeserveur inBase = typeserveurRepository.findByIdTypeServeur(typeserveurDTO.getIdTypeServeur());
        Preconditions.checkArgument(inBase != null, "typeserveur n'existe pas");
        Typeserveur typeserveur = TypeserveurFactory.typeserveurDTOToTypeserveur(typeserveurDTO, inBase);
        typeserveur = typeserveurRepository.save(typeserveur);
        TypeserveurDTO resultDTO = TypeserveurFactory.typeserveurToTypeserveurDTO(typeserveur);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public TypeserveurDTO findOne(Integer id) {
        log.debug("Request to get Typeserveur: {}", id);
        Typeserveur typeserveur = typeserveurRepository.findByIdTypeServeur(id);
        TypeserveurDTO dto = TypeserveurFactory.typeserveurToTypeserveurDTO(typeserveur);
        return dto;
    }

    @Transactional(readOnly = true)
    public Typeserveur findTypeserveur(Integer id) {
        log.debug("Request to get Typeserveur: {}", id);
        Typeserveur typeserveur = typeserveurRepository.findByIdTypeServeur(id);
        return typeserveur;
    }

    @Transactional(readOnly = true)
    public Collection<TypeserveurDTO> findAll() {
        log.debug("Request to get All Typeserveurs");
        Collection<Typeserveur> result = typeserveurRepository.findAll();
        return TypeserveurFactory.typeserveurToTypeserveurDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Typeserveur: {}", id);
        typeserveurRepository.deleteById(id);
    }
}
