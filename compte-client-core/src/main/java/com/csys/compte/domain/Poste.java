/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "Poste")
@NamedQueries({
    @NamedQuery(name = "Poste.findAll", query = "SELECT p FROM Poste p")})
@Audited
public class Poste implements Serializable{

    @Size(max = 50)
    @Column(name = "designation")
    private String designation;
    @OneToMany(mappedBy = "poste")
    private Collection<Utilisateur> utilisateurCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_poste")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPoste;
    @Column(name = "actif")
    private Boolean actif;
   
    public Poste() {
    }

    public Poste(Integer idPoste) {
        this.idPoste = idPoste;
    }

    public Integer getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Integer idPoste) {
        this.idPoste = idPoste;
    }


    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoste != null ? idPoste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        if ((this.idPoste == null && other.idPoste != null) || (this.idPoste != null && !this.idPoste.equals(other.idPoste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Poste[ idPoste=" + idPoste + " ]";
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }
    
}
