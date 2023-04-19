package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.Size;

public class RegionDTO {
  private Integer idRegion;

  @Size(min = 0,max = 50)
  private String designation;

  private Boolean actif;

  private List clientList;

  public Integer getIdRegion() {
    return idRegion;
  }

  public void setIdRegion(Integer idRegion) {
    this.idRegion = idRegion;
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

  public List getClientList() {
    return clientList;
  }

  public void setClientList(List clientList) {
    this.clientList = clientList;
  }
}

