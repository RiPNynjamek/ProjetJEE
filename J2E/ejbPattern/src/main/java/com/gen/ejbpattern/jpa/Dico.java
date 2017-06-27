/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.ejbpattern.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cyril
 */
@Entity
@Table(name = "dico", catalog = "projetjee", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dico.findAll", query = "SELECT d FROM Dico d")
    , @NamedQuery(name = "Dico.findById", query = "SELECT d FROM Dico d WHERE d.id = :id")
    , @NamedQuery(name = "Dico.findByMot", query = "SELECT d FROM Dico d WHERE d.mot = :mot")})
public class Dico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mot", nullable = false, length = 255)
    private String mot;

    public Dico() {
    }

    public Dico(Integer id) {
        this.id = id;
    }

    public Dico(Integer id, String mot) {
        this.id = id;
        this.mot = mot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dico)) {
            return false;
        }
        Dico other = (Dico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gen.ejbpattern.jpa.Dico[ id=" + id + " ]";
    }
    
}
