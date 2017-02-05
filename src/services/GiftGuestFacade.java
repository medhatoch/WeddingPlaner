package services;

import beans.Gift;
import beans.GiftGuest;
import beans.Guest;
import beans.Wedding;
import java.util.List;

public class GiftGuestFacade extends AbstractFacade<GiftGuest> {

    public GiftGuestFacade() {
        super(GiftGuest.class);
    }
    GiftFacade giftFacade = new GiftFacade();
    GuestFacade guestFacade = new GuestFacade();

    public int verifyGuest(String guestFirstName, String guestLastName) {

        String msg1;
//        List<Guest> guests = (List<Guest>) getEntityManager().createQuery("SELECT * FROM Guest g WHERE g.FirstName='" + guestFirstName + "'AND g.LastName='" + guestLastName+"'").getResultList();

        List<Guest> guests = guestFacade.findAll();
        for (Guest guest : guests) {
            if (guest.getFirstName() == guestFirstName && guest.getLastName() == guestLastName) {
                msg1 = "";
                return 1;
            }

        }
        msg1 = "This Guest doesn't exist";
        return -1;
    }

    public int verifyCellPhone(String guestFirstName, String guestLastName) {
        String msg2;
        List<Guest> guests = guestFacade.findAll();
        for (Guest guest : guests) {
            if (guest.getNoCellPhone() == "") {
                msg2 = "This field is empty";
                return -1;
            }
        }
        msg2 = "";
        return 1;
    }

    public int verifyGiftContent(String content) {
        String msg3;
        if (giftFacade.findGiftByContent(content) == null) {
            msg3 = "This gift doesn't exist !";
            return -1;
        } else {
            msg3 = "";
            return 1;
        }
    }

    public int verifyQte(String content, int qte) {
        String msg4;
        if (giftFacade.findGiftByContent(content).getQte() < qte) {
            msg4 = "The quantity inserted is too high !";
            return -1;
        } else {
            msg4 = "";
            return 1;
        }
    }

//GiftFacade giftFacade = new GiftFacade();
    public GiftGuest ChooseGift(Wedding wedding ,String content, String guestFirstname, String guestLastname, int qte) {
        
        Guest guest = guestFacade.findGuestByFirstnLastNameFindAll(guestLastname, guestLastname);
        Gift gift = giftFacade.findGiftByContent(content);
        Gift gift_1 = gift;
        gift_1.setQte(qte);
        GiftGuest giftGuest = new GiftGuest(qte, gift_1, guest);
        
       

        return giftGuest;
    }

    private GiftGuest findGiftGuestbyLastnfirstName(String guestFirstName, String guestLastName, String giftContenu) {
        GiftGuest giftGuest = (GiftGuest) getEntityManager().createQuery("select * from GiftGuest gg where gg.guest.FirstName='" + guestFirstName + "'and gg.guest.LastName='" + guestLastName + "'and gg.gift.contenu='" + giftContenu + "'").getSingleResult();
        return giftGuest;
    }

}
