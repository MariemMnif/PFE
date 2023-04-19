package com.csys.compte.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.Size;

public class ServeurDTO {

    private Integer idServeur;

    @Size(min = 0, max = 50)
    private String adresseIp;

    private Boolean actif;

    private List<AccesserveurDTO> accesserveurList;

    private ClientDTO clientDTO;
    private Integer idClient;
    private TypeserveurDTO typeServeurDTO;

    public TypeserveurDTO getTypeServeurDTO() {
        return typeServeurDTO;
    }

    public void setTypeServeurDTO(TypeserveurDTO typeServeurDTO) {
        this.typeServeurDTO = typeServeurDTO;
    }
    private Integer idTypeServeur;

    public Integer getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(Integer idServeur) {
        this.idServeur = idServeur;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public List<AccesserveurDTO> getAccesserveurList() {
        return accesserveurList;
    }

    public void setAccesserveurList(List<AccesserveurDTO> accesserveurList) {
        this.accesserveurList = accesserveurList;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdTypeServeur() {
        return idTypeServeur;
    }

    public void setIdTypeServeur(Integer idTypeServeur) {
        this.idTypeServeur = idTypeServeur;
    }

}
