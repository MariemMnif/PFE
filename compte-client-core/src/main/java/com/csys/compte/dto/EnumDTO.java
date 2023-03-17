/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.compte.dto;

/**
 *
 * @author Administrateur
 */
public class EnumDTO {

    private Enum code;
    private String designation;

    public Enum getCode() {
        return code;
    }

    public void setCode(Enum code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EnumDTO{" + "code=" + code + ", designation=" + designation + '}';
    }
    
}
