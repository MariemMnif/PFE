/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FATMA-PC
 */
@Entity
@Table(name = "Client_module_version")
public class Clientmoduleversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientmoduleversionPK clientmoduleversionPK;
    @Column(name = "date_mise_a_jour")
    @Temporal(TemporalType.DATE)
    private Date dateMiseAJour;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "id_module", referencedColumnName = "id_module", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Module module;
    @JoinColumn(name = "utilisateur", referencedColumnName = "user_name")
    @ManyToOne
    private Utilisateur utilisateur;
    @JoinColumn(name = "id_version", referencedColumnName = "id_version", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Version version;

    public Clientmoduleversion() {
    }

    public Clientmoduleversion(ClientmoduleversionPK clientmoduleversionPK) {
        this.clientmoduleversionPK = clientmoduleversionPK;
    }

    public Clientmoduleversion(int idModule, int idVersion, int idClient) {
        this.clientmoduleversionPK = new ClientmoduleversionPK(idModule, idVersion, idClient);
    }

    public ClientmoduleversionPK getClientmoduleversionPK() {
        return clientmoduleversionPK;
    }

    public void setClientmoduleversionPK(ClientmoduleversionPK clientmoduleversionPK) {
        this.clientmoduleversionPK = clientmoduleversionPK;
    }

    public Date getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(Date dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientmoduleversionPK != null ? clientmoduleversionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientmoduleversion)) {
            return false;
        }
        Clientmoduleversion other = (Clientmoduleversion) object;
        if ((this.clientmoduleversionPK == null && other.clientmoduleversionPK != null) || (this.clientmoduleversionPK != null && !this.clientmoduleversionPK.equals(other.clientmoduleversionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Clientmoduleversion[ clientmoduleversionPK=" + clientmoduleversionPK + " ]";
    }
    
}
