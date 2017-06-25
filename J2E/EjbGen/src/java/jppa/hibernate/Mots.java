/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jppa.hibernate;

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
@Table(name = "mots")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mots.findAll", query = "SELECT m FROM Mots m")
    , @NamedQuery(name = "Mots.findById", query = "SELECT m FROM Mots m WHERE m.id = :id")
    , @NamedQuery(name = "Mots.findByMot", query = "SELECT m FROM Mots m WHERE m.mot = :mot")})
public class Mots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mot")
    private String mot;

    public Mots() {
    }

    public Mots(Integer id) {
        this.id = id;
    }

    public Mots(Integer id, String mot) {
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
        if (!(object instanceof Mots)) {
            return false;
        }
        Mots other = (Mots) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jppa.hibernate.Mots[ id=" + id + " ]";
    }
    
}
