package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.Size;

public class ModuleDTO {
 
  private Integer idModule;

  @Size(min = 0, max = 50)
  private String designation;

  private Boolean actif;

  private List<LanguageDTO> languageList;

  private List utilisateurList;

  private List clientmoduleversionList;

  private List<VersionDTO> versionList;

  public Integer getIdModule() {
    return idModule;
  }

  public void setIdModule(Integer idModule) {
    this.idModule = idModule;
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

    public List<LanguageDTO> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<LanguageDTO> languageList) {
        this.languageList = languageList;
    }


  public List getUtilisateurList() {
    return utilisateurList;
  }

  public void setUtilisateurList(List utilisateurList) {
    this.utilisateurList = utilisateurList;
  }

  public List getClientmoduleversionList() {
    return clientmoduleversionList;
  }

  public void setClientmoduleversionList(List clientmoduleversionList) {
    this.clientmoduleversionList = clientmoduleversionList;
  }

    public List<VersionDTO> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<VersionDTO> versionList) {
        this.versionList = versionList;
    }

 
}

