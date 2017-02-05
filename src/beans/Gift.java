/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Gift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private int qte;
  
  
    @OneToMany(mappedBy = "gift")
    private List <GiftGuest> guestgifts;
    @ManyToOne
    private Wedding wedding;
    
    
    public Gift() {
    }

    public Gift(Long id) {
        this.id = id;
    }

    public Gift(String content, int qte) {
        this.content = content;
        this.qte = qte;
    }
    
    public Gift(String content, int qte, Wedding wedding) {
        this.content = content;
        this.qte = qte;
        this.wedding = wedding;
    }

    

    public List<GiftGuest> getGuestgifts() {
        return guestgifts;
    }

    public void setGuestgifts(List<GiftGuest> guestgifts) {
        this.guestgifts = guestgifts;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    
    
    public Wedding getWedding() {
        return wedding;
    }

    public void setWedding(Wedding wedding) {
        this.wedding = wedding;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gift)) {
            return false;
        }
        Gift other = (Gift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getContent() ;
    }

}
