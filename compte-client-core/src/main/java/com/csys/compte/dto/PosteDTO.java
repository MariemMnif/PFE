package com.csys.compte.dto;


import java.util.List;
import javax.validation.constraints.Size;

public class PosteDTO {
  private Integer idPoste;

  @Size(min = 0,max = 50)
  private String designation;

  private Boolean actif;

  private List utilisateurList;

  public Integer getIdPoste() {
    return idPoste;
  }

  public void setIdPoste(Integer idPoste) {
    this.idPoste = idPoste;
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

  public List getUtilisateurList() {
    return utilisateurList;
  }

  public void setUtilisateurList(List utilisateurList) {
    this.utilisateurList = utilisateurList;
  }
}

