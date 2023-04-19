package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LanguageDTO {
  
  private Integer idLanguage;

  @Size(min = 0,max = 50)
  private String designation;

  private Boolean actif;

  private List moduleList;

  public Integer getIdLanguage() {
    return idLanguage;
  }

  public void setIdLanguage(Integer idLanguage) {
    this.idLanguage = idLanguage;
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

  public List getModuleList() {
    return moduleList;
  }

  public void setModuleList(List moduleList) {
    this.moduleList = moduleList;
  }
}

