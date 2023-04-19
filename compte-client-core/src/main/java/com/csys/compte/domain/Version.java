/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csys.compte.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "Version")
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v")})
@Audited
public class Version implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_version")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVersion;

    @Size(max = 50)
    @Column(name = "numero")
    private String numero;

    @Size(max = 50)
    @Column(name = "description")
    private String description;

    @Column(name = "date_effet")
    @Temporal(TemporalType.DATE)
    private Date dateEffet;

    @NotAudited
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "version")
    private List<Clientmoduleversion> clientmoduleversionList;

    @JoinColumn(name = "id_module", referencedColumnName = "id_module")
    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Module module;

    public Version() {
    }

    public Version(Integer idVersion) {
        this.idVersion = idVersion;
    }

    public Integer getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(Integer idVersion) {
        this.idVersion = idVersion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public List<Clientmoduleversion> getClientmoduleversionList() {
        return clientmoduleversionList;
    }

    public void setClientmoduleversionList(List<Clientmoduleversion> clientmoduleversionList) {
        this.clientmoduleversionList = clientmoduleversionList;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVersion != null ? idVersion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.idVersion == null && other.idVersion != null) || (this.idVersion != null && !this.idVersion.equals(other.idVersion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.compte.domain.Version[ idVersion=" + idVersion + " ]";
    }

}
