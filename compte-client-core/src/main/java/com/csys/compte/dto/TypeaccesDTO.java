package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TypeaccesDTO {
 
  private Integer idTypeAcces;

  @Size(min = 0,max = 50)
  private String designation;

  private Boolean actif;

  private List accesserveurList;

  public Integer getIdTypeAcces() {
    return idTypeAcces;
  }

  public void setIdTypeAcces(Integer idTypeAcces) {
    this.idTypeAcces = idTypeAcces;
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

  public List getAccesserveurList() {
    return accesserveurList;
  }

  public void setAccesserveurList(List accesserveurList) {
    this.accesserveurList = accesserveurList;
  }
}

