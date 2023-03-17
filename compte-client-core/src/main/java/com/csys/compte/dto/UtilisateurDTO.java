package com.csys.compte.dto;

import com.csys.compte.domain.Poste;
import com.csys.compte.enumeration.EnumRole;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UtilisateurDTO {

    @NotNull
    @Size(min = 1,max = 50)
    private String username;

    @Size( min = 0, max = 50)
    private String password;

    @Size(min = 0, max = 50)
    private String nom;

    @Size(min = 0, max = 50)
    private String prenom;

    private EnumRole role;

    private Boolean actif;

    private List moduleList;

    private List clientmoduleversionList;

    private PosteDTO posteDTO;
    private Integer idPoste;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public EnumRole getRole() {
        return role;
    }

    public void setRole(EnumRole role) {
        this.role = role;
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

    public List getClientmoduleversionList() {
        return clientmoduleversionList;
    }

    public void setClientmoduleversionList(List clientmoduleversionList) {
        this.clientmoduleversionList = clientmoduleversionList;
    }

    public PosteDTO getPosteDTO() {
        return posteDTO;
    }

    public void setPosteDTO(PosteDTO posteDTO) {
        this.posteDTO = posteDTO;
    }

    public Integer getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Integer idPoste) {
        this.idPoste = idPoste;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
