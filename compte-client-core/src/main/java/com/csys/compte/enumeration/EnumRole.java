/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.compte.enumeration;

import com.csys.compte.dto.EnumDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrateur
 */
public enum EnumRole {
    Administrateur("Administrateur"),
    Autres("Autres");
    
    private String name;

    //Constructeur
    EnumRole(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static final Map<EnumRole, EnumDTO> ValeurRole = new HashMap<>();

    static {
        for (EnumRole e : values()) {
            EnumDTO codeDesignationDTO = new EnumDTO();
            codeDesignationDTO.setCode(e);
            codeDesignationDTO.setDesignation(e.name);
            ValeurRole.put(e, codeDesignationDTO);
        }
    }

    public static EnumDTO valueOfLabel(EnumRole label) {
        return ValeurRole.get(label);
    }

}
