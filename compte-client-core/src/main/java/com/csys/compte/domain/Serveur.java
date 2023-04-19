/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Serveur")
@NamedQueries({
    @NamedQuery(name = "Serveur.findAll", query = "SELECT s FROM Serveur s")})
public class Serveur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serveur")
    private Integer idServeur;
    
    @Size(max = 50)
    @Column(name = "adresse_ip")
    private String adresseIp;
    
    @Column(name = "actif")
    private Boolean actif;
    
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "idServeur")
    private List<Accesserveur> accesserveurList;
    
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    private Client idClient;
    
    @JoinColumn(name = "id_type_serveur", referencedColumnName = "id_type_serveur")
    @ManyToOne
    private Typeserveur idTypeServeur;

    public Serveur() {
    }

    public Serveur(Integer idServeur) {
        this.idServeur = idServeur;
    }

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

    public List<Accesserveur> getAccesserveurList() {
        return accesserveurList;
    }

    public void setAccesserveurList(List<Accesserveur> accesserveurList) {
        this.accesserveurList = accesserveurList;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Typeserveur getIdTypeServeur() {
        return idTypeServeur;
    }

    public void setIdTypeServeur(Typeserveur idTypeServeur) {
        this.idTypeServeur = idTypeServeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServeur != null ? idServeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serveur)) {
            return false;
        }
        Serveur other = (Serveur) object;
        if ((this.idServeur == null && other.idServeur != null) || (this.idServeur != null && !this.idServeur.equals(other.idServeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Serveur[ idServeur=" + idServeur + " ]";
    }
    
}
