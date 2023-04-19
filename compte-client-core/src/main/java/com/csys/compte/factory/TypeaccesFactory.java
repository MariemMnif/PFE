package com.csys.compte.factory;

import com.csys.compte.domain.Typeacces;
import com.csys.compte.dto.TypeaccesDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TypeaccesFactory {

    public static TypeaccesDTO typeaccesToTypeaccesDTO(Typeacces typeacces) {
        TypeaccesDTO typeaccesDTO = new TypeaccesDTO();
        typeaccesDTO.setIdTypeAcces(typeacces.getIdTypeAcces());
        typeaccesDTO.setDesignation(typeacces.getDesignation());
        typeaccesDTO.setActif(typeacces.getActif());
        typeaccesDTO.setAccesserveurList(typeacces.getAccesserveurList());
        return typeaccesDTO;
    }

    public static Typeacces typeaccesDTOToTypeacces(TypeaccesDTO typeaccesDTO, Typeacces typeacces) {
        if (typeacces == null) {
            typeacces = new Typeacces();
        }
        typeacces.setIdTypeAcces(typeaccesDTO.getIdTypeAcces());
        typeacces.setDesignation(typeaccesDTO.getDesignation());
        typeacces.setActif(typeaccesDTO.getActif());
        //  typeacces.setAccesserveurList(typeaccesDTO.getAccesserveurList());
        return typeacces;
    }

    public static Collection<TypeaccesDTO> typeaccesToTypeaccesDTOs(Collection<Typeacces> typeaccess) {
        List<TypeaccesDTO> typeaccessDTO = new ArrayList<>();
        typeaccess.forEach(x -> {
            typeaccessDTO.add(typeaccesToTypeaccesDTO(x));
        });
        return typeaccessDTO;
    }

    public static Typeacces typeaccesDTOToTypeacces2(TypeaccesDTO typeaccesDTO) {

        Typeacces typeacces = new Typeacces();
        typeacces.setIdTypeAcces(typeaccesDTO.getIdTypeAcces());
        typeacces.setDesignation(typeaccesDTO.getDesignation());
        typeacces.setActif(typeaccesDTO.getActif());
        //  typeacces.setAccesserveurList(typeaccesDTO.getAccesserveurList());
        return typeacces;
    }
}
