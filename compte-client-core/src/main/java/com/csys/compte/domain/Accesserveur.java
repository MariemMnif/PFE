/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

/**
 *
 * @author FATMA-PC
 */
@Entity
@Table(name = "Acces_serveur")
@NamedQueries({
    @NamedQuery(name = "Accesserveur.findAll", query = "SELECT a FROM Accesserveur a")})
@Audited
public class Accesserveur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_acces")
    private Integer idAcces;
    @Size(max = 50)
    @Column(name = "login")
    private String login;
    @Size(max = 50)
    @Column(name = "password")
    private String password;
    @Size(max = 50)
    @Column(name = "autre_informations")
    private String autreInformations;
    @Column(name = "actif")
    private Boolean actif;
    @NotAudited
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "id_serveur", referencedColumnName = "id_serveur")
    @ManyToOne
    private Serveur idServeur;
    @NotAudited
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "id_type_acces", referencedColumnName = "id_type_acces")
    @ManyToOne
    private Typeacces idTypeAcces;

    public Accesserveur() {
    }

    public Accesserveur(Integer idAcces) {
        this.idAcces = idAcces;
    }

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

    public Serveur getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(Serveur idServeur) {
        this.idServeur = idServeur;
    }

    public Typeacces getIdTypeAcces() {
        return idTypeAcces;
    }

    public void setIdTypeAcces(Typeacces idTypeAcces) {
        this.idTypeAcces = idTypeAcces;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcces != null ? idAcces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesserveur)) {
            return false;
        }
        Accesserveur other = (Accesserveur) object;
        if ((this.idAcces == null && other.idAcces != null) || (this.idAcces != null && !this.idAcces.equals(other.idAcces))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Accesserveur[ idAcces=" + idAcces + " ]";
    }

}
