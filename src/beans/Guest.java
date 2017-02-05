/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



/**
 *
 * @author hp
 */
@Entity
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String noCellPhone;
    
    @OneToMany(mappedBy = "guest")
    private List<GiftGuest> giftGuests;
    @ManyToOne
    private Wedding weding;
     
    
    
    
    
    public Wedding getWeding() {
        return weding;
    }

    public void setWeding(Wedding wedings) {
        this.weding = wedings;
    }
    public Guest() {
    }

    public Guest(Long id) {
        this.id = id;
    }

    public Guest( String Name, String LastName, String NoCellPhone) {
        
        this.firstName = Name;
        this.lastName = LastName;
        this.noCellPhone = NoCellPhone;
        
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNoCellPhone() {
        return noCellPhone;
    }

    public void setNoCellPhone(String noCellPhone) {
        this.noCellPhone = noCellPhone;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GiftGuest> getGiftGuests() {
        return giftGuests;
    }

    public void setGiftGuests(List<GiftGuest> giftGuests) {
        this.giftGuests = giftGuests;
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
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstName +"    "+ lastName;
    }

}
