/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Gift;
import beans.Wedding;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class GiftFacade extends AbstractFacade<Gift> {

    public GiftFacade() {
        super(Gift.class);
    }

//    public int verifyAttributs(String   )
    
    WeddingFacade weddingFacade = new WeddingFacade();

    
    
    public void addGift(String brideFirstName, String brideLastName, String groomFirstName, String groomLastName, String content, int qte) {
        
        Wedding weding = weddingFacade.findWeddingByWedsName(brideFirstName, brideLastName,groomFirstName , groomLastName);
        Gift gift = new Gift(content, qte, weding);
        gift.setWedding(weding);
        create(gift);
    }

    public Gift findGiftByContent(String content) {

        for (Gift gift : findAll()) {
            if ( gift.getContent()== content || (""+gift.getContent()).equals(content))
                
                return gift ;
        }
return null ;
    }
GuestFacade guestFacade = new GuestFacade();
   


    
    public List<Gift> findGiftListByWedd(Wedding wedding){
        
        List<Gift> gifts = new ArrayList<>();
        for (Gift gift : findAll()) {
            if(gift.getWedding()== wedding || (""+gift.getWedding()).equals(""+wedding)){
                   gifts.add(gift);}
           
            }
//       List<Gift> gifts = (List<Gift>)getEntityManager().createQuery("SELECT g FROM Gift g WHERE g.wedding.id ="+wedding.getId()).getResultList();
return gifts ;
    }
          public List<Gift> findGiftListByWedding(Wedding wedding){
       List<Gift> gifts = (List<Gift>)getEntityManager().createQuery("SELECT g FROM Gift g WHERE g.wedding.id ="+wedding.getId()).getResultList();
return gifts ;
    }
}
