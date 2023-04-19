package com.csys.compte.domain;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "Type_serveur")
@NamedQueries({
    @NamedQuery(name = "Typeserveur.findAll", query = "SELECT t FROM Typeserveur t")})
@Audited
public class Typeserveur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_serveur")
    private Integer idTypeServeur;
    @Size(max = 50)
    @Column(name = "designation")
    private String designation;
    @Column(name = "actif")
    private Boolean actif;
    @NotAudited
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToMany(mappedBy = "idTypeServeur")
    private List<Serveur> serveurList;

    public Typeserveur() {
    }

    public Typeserveur(Integer idTypeServeur) {
        this.idTypeServeur = idTypeServeur;
    }

    public Integer getIdTypeServeur() {
        return idTypeServeur;
    }

    public void setIdTypeServeur(Integer idTypeServeur) {
        this.idTypeServeur = idTypeServeur;
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

    public List<Serveur> getServeurList() {
        return serveurList;
    }

    public void setServeurList(List<Serveur> serveurList) {
        this.serveurList = serveurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeServeur != null ? idTypeServeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeserveur)) {
            return false;
        }
        Typeserveur other = (Typeserveur) object;
        if ((this.idTypeServeur == null && other.idTypeServeur != null) || (this.idTypeServeur != null && !this.idTypeServeur.equals(other.idTypeServeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Typeserveur[ idTypeServeur=" + idTypeServeur + " ]";
    }

}
