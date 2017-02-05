package services;

import beans.Gift;
import beans.Wedding;
import java.util.Date;
import java.util.List;
import util.DateUtil;


public class WeddingFacade extends AbstractFacade<Wedding> {

    public WeddingFacade() {
        super(Wedding.class);
    }
    DateUtil dateUtil= new DateUtil();
     public int verifyWedDate(Date wedDate) {
       
//       List<Weding> weddings = (List<Weding>)getEntityManager().createQuery("SELECT w FROM Wedding w WHERE w.weddingDate = " + dateUtil.convert(wedDate.toString()) ).getResultList();
      
       for (Wedding wedding : findAll()) {
            if ( wedding.getWeddingDate()  == wedDate || (""+wedding.getWeddingDate()).equals(""+wedDate.toString()) )  {
                
            return -1;
        }
            
    }
        return 1;
    }

    public Wedding addWedding(String brideFirstName, String brideLastName, String groomFirstName, String groomLastName, Date weddingDate) {

        Wedding wedding = new Wedding(brideFirstName, brideLastName, groomFirstName, groomLastName, weddingDate);

        return wedding;

    }

    public Wedding findWeddingByWedsName(String brideFirstName, String brideLastName, String groomFirstName, String groomLastName) {

        
        for (Wedding wedding : findAll()) {
            if (wedding.getBrideFirstName().equals(brideFirstName) && wedding.getGroomFirstName().equals(groomFirstName)  && wedding.getBrideLastName().equals(brideLastName) && wedding.getGroomLastName().equals(groomLastName))
        return wedding;
        }
        return null ;
    }

    public Wedding findWeddingByOneWedsName(String firstName, String lastName) {
        List<Wedding> weddings = findAll();
        for (Wedding wedding : weddings) {
            if((wedding.getBrideFirstName().equals(firstName) || wedding.getGroomFirstName().equals(firstName) ) && (wedding.getBrideLastName().equals(lastName) || wedding.getGroomLastName().equals(lastName)))
         return wedding ;
            
                } 
    return null ;
    } 
    
//    public Wedding findWeddingByWedsNameQuery(String firstName , String lastName){
//        Wedding wedding ;
//        Wedding wedding1 = (Wedding) getEntityManager().createQuery("SELECT w FROM Wedding w WHERE w.brideFirstName = '" + firstName + "'  AND  w.brideLastName = '" + lastName + "'").getSingleResult();
//        Wedding wedding2 = (Wedding) getEntityManager().createQuery("SELECT w FROM Wedding w WHERE  w.groomFirstName = '" + firstName + "'  AND  w.groomLastName = '" + lastName + "'").getSingleResult();
//
//        if (wedding1==null) {
//
//            if (wedding2 == null) {
//                wedding = null; //from this case we know the wedding doesn't exist !!!
//            } else {
//                wedding = wedding2;
//            }
//        } else {
//            wedding = wedding1;
//       }
//        return wedding;
//    }

//    public Wedding findWeddingByDate(Date weddingDate) {
//        Wedding wedding = (Wedding) getEntityManager().createQuery("SELECT w FROM Wedding w WHERE w.weddingDate = '" + weddingDate+"'").getSingleResult();
//        return wedding;
//    }

                }
