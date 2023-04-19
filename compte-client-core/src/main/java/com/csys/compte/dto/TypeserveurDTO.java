package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TypeserveurDTO {

  private Integer idTypeServeur;

  @Size(min = 0,max = 50)
  private String designation;

  private Boolean actif;

  //private List<ServeurDTO> serveurList;

  public Integer getIdTypeServeur() {
    return idTypeServeur;
  }

  public void setIdTypeServeur(Integer idTypeServeur) {
    this.idTypeServeur = idTypeServeur;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public Boolean getActif() {
    return actif;
  }

  public void setActif(Boolean actif) {
    this.actif = actif;
  }

//  public List getServeurList() {
//    return serveurList;
//  }
//
//  public void setServeurList(List serveurList) {
//    this.serveurList = serveurList;
//  }
}

