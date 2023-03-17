/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author FATMA-PC
 */
@Embeddable 
public class ClientmoduleversionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_version")
    private int idVersion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private int idClient;

    public ClientmoduleversionPK() {
    }

    public ClientmoduleversionPK(int idModule, int idVersion, int idClient) {
        this.idModule = idModule;
        this.idVersion = idVersion;
        this.idClient = idClient;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idModule;
        hash += (int) idVersion;
        hash += (int) idClient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientmoduleversionPK)) {
            return false;
        }
        ClientmoduleversionPK other = (ClientmoduleversionPK) object;
        if (this.idModule != other.idModule) {
            return false;
        }
        if (this.idVersion != other.idVersion) {
            return false;
        }
        if (this.idClient != other.idClient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.ClientmoduleversionPK[ idModule=" + idModule + ", idVersion=" + idVersion + ", idClient=" + idClient + " ]";
    }
    
}
