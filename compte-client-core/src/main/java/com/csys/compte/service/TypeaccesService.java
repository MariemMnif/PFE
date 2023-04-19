package com.csys.compte.service;

import com.csys.compte.domain.Typeacces;
import com.csys.compte.dto.TypeaccesDTO;
import com.csys.compte.factory.TypeaccesFactory;
import com.csys.compte.repository.TypeaccesRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeaccesService {

    private final Logger log = LoggerFactory.getLogger(TypeaccesService.class);

    private final TypeaccesRepository typeaccesRepository;

    public TypeaccesService(TypeaccesRepository typeaccesRepository) {
        this.typeaccesRepository = typeaccesRepository;
    }

    public TypeaccesDTO save(TypeaccesDTO typeaccesDTO) {
        log.debug("Request to save Typeacces: {}", typeaccesDTO);
        //verif Typeacce  existe ou non 
        Typeacces TypeaccesinBase = typeaccesRepository.findByDesignation(typeaccesDTO.getDesignation());
        Preconditions.checkArgument(TypeaccesinBase == null, "type acces existe deja");
        Typeacces typeacces = TypeaccesFactory.typeaccesDTOToTypeacces(typeaccesDTO, null);
        typeacces = typeaccesRepository.save(typeacces);
        TypeaccesDTO resultDTO = TypeaccesFactory.typeaccesToTypeaccesDTO(typeacces);
        return resultDTO;
    }

    public TypeaccesDTO update(TypeaccesDTO typeaccesDTO) {
        log.debug("Request to update Typeacces: {}", typeaccesDTO);
        Typeacces inBase = typeaccesRepository.findByidTypeAcces(typeaccesDTO.getIdTypeAcces());
        Preconditions.checkArgument(inBase != null, "typeacces.NotFound");
        Typeacces typeacces = TypeaccesFactory.typeaccesDTOToTypeacces(typeaccesDTO, inBase);
        typeacces = typeaccesRepository.save(typeacces);
        TypeaccesDTO resultDTO = TypeaccesFactory.typeaccesToTypeaccesDTO(typeacces);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public TypeaccesDTO findOne(Integer id) {
        log.debug("Request to get Typeacces: {}", id);
        Typeacces typeacces = typeaccesRepository.findByidTypeAcces(id);
        TypeaccesDTO dto = TypeaccesFactory.typeaccesToTypeaccesDTO(typeacces);
        return dto;
    }

    @Transactional(readOnly = true)
    public Typeacces findTypeacces(Integer id) {
        log.debug("Request to get Typeacces: {}", id);
        Typeacces typeacces = typeaccesRepository.findByidTypeAcces(id);
        return typeacces;
    }

    @Transactional(readOnly = true)
    public Collection<TypeaccesDTO> findAll() {
        log.debug("Request to get All Typeaccess");
        Collection<Typeacces> result = typeaccesRepository.findAll();
        return TypeaccesFactory.typeaccesToTypeaccesDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Typeacces: {}", id);
        typeaccesRepository.deleteById(id);
    }
}
