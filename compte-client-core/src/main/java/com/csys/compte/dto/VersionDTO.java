package com.csys.compte.dto;

import com.csys.compte.domain.Module;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

public class VersionDTO {

    private Integer idVersion;

    @Size(min = 0, max = 50)
    private String numero;

    @Size(min = 0, max = 50)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateEffet;

    private List clientmoduleversionList;

    //
   private ModuleDTO moduleDTO;
    private Integer idModule;

   public ModuleDTO getModuleDTO() {
        return moduleDTO;
    }

    public void setModuleDTO(ModuleDTO moduleDTO) {
        this.moduleDTO = moduleDTO;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    public Integer getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(Integer idVersion) {
        this.idVersion = idVersion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public List getClientmoduleversionList() {
        return clientmoduleversionList;
    }

    public void setClientmoduleversionList(List clientmoduleversionList) {
        this.clientmoduleversionList = clientmoduleversionList;
    }

  

}
