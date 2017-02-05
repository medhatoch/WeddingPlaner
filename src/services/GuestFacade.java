/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Guest;
import beans.Wedding;

/**
 *
 * @author hp
 */
public class GuestFacade extends AbstractFacade<Guest> {

    public GuestFacade() {
        super(Guest.class);
    }

    WeddingFacade weddingFacade = new WeddingFacade();

//    public void AddGuestByWedsName(String BrideFName, String BrideLName, String GroomFname, String GroomLname, String guestFName, String guestLName, String cellPhoneNum) {
//        Wedding wedding = weddingFacade.findWeddingByWedsName(BrideFName, BrideLName, GroomFname, GroomLname);
//        Guest guest = new Guest(guestFName, guestLName, cellPhoneNum);
//
//        guest.
//        create(guest);
//        weddingFacade.edit(wedding);
//    } 
  

    public Guest findGuestByFirstnLastNameFindAll(String guestFName, String guestLName) {
            
        for (Guest guest : findAll()) {
            if ((guest.getFirstName() == guestFName || guest.getFirstName().equals(guestFName)) && (guest.getLastName().equals(guestLName) || guest.getLastName() == guestLName)) {
                return guest;
            }
        }
        return null;
    }
    
    public Guest findGuestByFirstnLastNameInWed(Wedding wedding ,String fName , String lName){
        for (Guest guest : findAll()) {
        if (guest.getWeding()== wedding &&(guest.getFirstName() == fName || guest.getFirstName().equals(fName)) && (guest.getLastName().equals(lName) || guest.getLastName() == lName)) {
                return guest;
            }
        }
        return null;    
        
    }
//    public Guest findGuestByNameQuery(String fName, String lName){
//             Guest guest = (Guest) getEntityManager().createQuery("SELECT g FROM Guest g WHERE g.firstName='"+fName+"' AND g.lastName='"+lName+"'").getSingleResult() ;
//   return guest ;
//    }
//    

    public boolean isUnique(Wedding wedding ,String fName, String lName) {
        if (findGuestByFirstnLastNameInWed(wedding,fName, lName) == null) {
            return true;
        } else {
            return false;
        }
    }

}
