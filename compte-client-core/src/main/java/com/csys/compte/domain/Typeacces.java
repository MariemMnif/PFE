/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "Type_acces")
@NamedQueries({
    @NamedQuery(name = "Typeacces.findAll", query = "SELECT t FROM Typeacces t")})
@Audited
public class Typeacces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_type_acces")
    private Integer idTypeAcces;
    @Size(max = 50)
    @Column(name = "designation")
    private String designation;
    @Column(name = "actif")
    private Boolean actif;   
    @OneToMany(mappedBy = "idTypeAcces")
    private List<Accesserveur> accesserveurList;

    public Typeacces() {
    }

    public Typeacces(Integer idTypeAcces) {
        this.idTypeAcces = idTypeAcces;
    }

    public Integer getIdTypeAcces() {
        return idTypeAcces;
    }

    public void setIdTypeAcces(Integer idTypeAcces) {
        this.idTypeAcces = idTypeAcces;
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

    public List<Accesserveur> getAccesserveurList() {
        return accesserveurList;
    }

    public void setAccesserveurList(List<Accesserveur> accesserveurList) {
        this.accesserveurList = accesserveurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeAcces != null ? idTypeAcces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeacces)) {
            return false;
        }
        Typeacces other = (Typeacces) object;
        if ((this.idTypeAcces == null && other.idTypeAcces != null) || (this.idTypeAcces != null && !this.idTypeAcces.equals(other.idTypeAcces))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Typeacces[ idTypeAcces=" + idTypeAcces + " ]";
    }
    
}
