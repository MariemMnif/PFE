package com.csys.compte.service;

import com.csys.compte.domain.Secteur;
import com.csys.compte.dto.SecteurDTO;
import com.csys.compte.factory.SecteurFactory;
import com.csys.compte.repository.SecteurRepository;
import com.google.common.base.Preconditions;
import java.lang.Integer;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SecteurService {

    private final Logger log = LoggerFactory.getLogger(SecteurService.class);

    private final SecteurRepository secteurRepository;

    public SecteurService(SecteurRepository secteurRepository) {
        this.secteurRepository = secteurRepository;
    }

    public SecteurDTO save(SecteurDTO secteurDTO) {
        log.debug("Request to save Secteur: {}", secteurDTO);
        //verif region existe ou non 
        Secteur secteurinBase = secteurRepository.findByDesignation(secteurDTO.getDesignation());
        Preconditions.checkArgument(secteurinBase == null, "Le secteur existe deja");
        Secteur secteur = SecteurFactory.secteurDTOToSecteur(secteurDTO, null);
        secteur = secteurRepository.save(secteur);
        SecteurDTO resultDTO = SecteurFactory.secteurToSecteurDTO(secteur);
        return resultDTO;
    }

    public SecteurDTO update(SecteurDTO secteurDTO) {
        log.debug("Request to update Secteur: {}", secteurDTO);
        Secteur inBase = secteurRepository.findByIdSecteur(secteurDTO.getIdSecteur());
        Preconditions.checkArgument(inBase != null, "secteur n 'existe pas Found");
        Secteur secteur = SecteurFactory.secteurDTOToSecteur(secteurDTO, inBase);
        secteur = secteurRepository.save(secteur);
        SecteurDTO resultDTO = SecteurFactory.secteurToSecteurDTO(secteur);
        return resultDTO;
    }

    @Transactional(readOnly = true)
    public SecteurDTO findOne(Integer id) {
        log.debug("Request to get Secteur: {}", id);
        Secteur secteur = secteurRepository.findByIdSecteur(id);
        SecteurDTO dto = SecteurFactory.secteurToSecteurDTO(secteur);
        return dto;
    }

    @Transactional(readOnly = true)
    public Secteur findSecteur(Integer id) {
        log.debug("Request to get Secteur: {}", id);
        Secteur secteur = secteurRepository.findByIdSecteur(id);
        return secteur;
    }

    @Transactional(readOnly = true)
    public Collection<SecteurDTO> findAll() {
        log.debug("Request to get All Secteurs");
        Collection<Secteur> result = secteurRepository.findAll();
        return SecteurFactory.secteurToSecteurDTOs(result);
    }

    public void delete(Integer id) {
        log.debug("Request to delete Secteur: {}", id);
        secteurRepository.deleteById(id);
    }
}
