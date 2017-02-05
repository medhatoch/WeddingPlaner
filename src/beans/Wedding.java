/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


/**
 *
 * @author hp
 */
@Entity
public class Wedding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brideFirstName;
    private String brideLastName;
    private String groomFirstName;
    private String groomLastName;

   
    @Temporal(javax.persistence.TemporalType.DATE)
         private Date weddingDate =new Date();
    

    public Wedding(String brideFirstName, String brideLastName, String groomFirstName, String groomLastName,Date weddingDate) {
        this.brideFirstName = brideFirstName;
        this.brideLastName = brideLastName;
        this.groomFirstName = groomFirstName;
        this.groomLastName = groomLastName;
        this.weddingDate = weddingDate;
    }

    

    public Wedding(Long id) {
        this.id = id;
    }

    public Wedding() {
    }

    public String getBrideFirstName() {
        return brideFirstName;
    }

    

    public void setBrideFirstName(String brideFirstName) {
        this.brideFirstName = brideFirstName;
    }

    public String getBrideLastName() {
        return brideLastName;
    }

    public void setBrideLastName(String brideLastName) {
        this.brideLastName = brideLastName;
    }

    public String getGroomFirstName() {
        return groomFirstName;
    }

    public void setGroomFirstName(String groomFirstName) {
        this.groomFirstName = groomFirstName;
    }

    public String getGroomLastName() {
        return groomLastName;
    }

    public void setGroomLastName(String groomLastName) {
        this.groomLastName = groomLastName;
    }

 

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Wedding)) {
            return false;
        }
        Wedding other = (Wedding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + brideFirstName + " & " + groomFirstName + "'s wedding ";
    }

}
