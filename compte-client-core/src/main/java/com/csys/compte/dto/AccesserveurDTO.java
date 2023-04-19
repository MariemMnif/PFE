package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.validation.constraints.Size;

public class AccesserveurDTO {
  private Integer idAcces;

  @Size(min = 0,max = 50)
  private String login;

 @Size(min = 0,max = 50)
  private String password;

 @Size(min = 0,max = 50)
  private String autreInformations;

  private Boolean actif;

  private ServeurDTO serveurDTO;
  private Integer idTypeAcces;
  private TypeaccesDTO typeAccesDTO;
  
  public Integer getIdAcces() {
    return idAcces;
  }

  public void setIdAcces(Integer idAcces) {
    this.idAcces = idAcces;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAutreInformations() {
    return autreInformations;
  }

  public void setAutreInformations(String autreInformations) {
    this.autreInformations = autreInformations;
  }

  public Boolean getActif() {
    return actif;
  }

  public void setActif(Boolean actif) {
    this.actif = actif;
  }

    public ServeurDTO getServeurDTO() {
        return serveurDTO;
    }

    public void setServeurDTO(ServeurDTO serveurDTO) {
        this.serveurDTO = serveurDTO;
    }

  
  

    public Integer getIdTypeAcces() {
        return idTypeAcces;
    }

    public void setIdTypeAcces(Integer idTypeAcces) {
        this.idTypeAcces = idTypeAcces;
    }

    public TypeaccesDTO getTypeAccesDTO() {
        return typeAccesDTO;
    }

    public void setTypeAccesDTO(TypeaccesDTO typeAccesDTO) {
        this.typeAccesDTO = typeAccesDTO;
    }


}

