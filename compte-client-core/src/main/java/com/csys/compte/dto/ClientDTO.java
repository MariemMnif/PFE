package com.csys.compte.dto;

import com.csys.compte.domain.Region;
import com.csys.compte.domain.Secteur;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.Size;

public class ClientDTO {

    private Integer idClient;

    @Size(min = 0, max = 50)
    private String raisonSociale;

    @Size(min = 0, max = 50)
    private String dns;

    private Boolean actif;

    private List serveurList;

    private List clientmoduleversionList;

    private RegionDTO regionDTO;
    private Integer idRegion;
    private SecteurDTO secteurDTO;
    private Integer idSecteur;

    public RegionDTO getRegionDTO() {
        return regionDTO;
    }

    public void setRegionDTO(RegionDTO regionDTO) {
        this.regionDTO = regionDTO;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public SecteurDTO getSecteurDTO() {
        return secteurDTO;
    }

    public void setSecteurDTO(SecteurDTO secteurDTO) {
        this.secteurDTO = secteurDTO;
    }

    public Integer getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(Integer idSecteur) {
        this.idSecteur = idSecteur;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public List getServeurList() {
        return serveurList;
    }

    public void setServeurList(List serveurList) {
        this.serveurList = serveurList;
    }

    public List getClientmoduleversionList() {
        return clientmoduleversionList;
    }

    public void setClientmoduleversionList(List clientmoduleversionList) {
        this.clientmoduleversionList = clientmoduleversionList;
    }

}
