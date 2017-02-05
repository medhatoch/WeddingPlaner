/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import beans.Gift;
import beans.GiftGuest;
import beans.Guest;
import java.io.IOException;
import services.GiftFacade;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import services.GiftGuestFacade;
import services.GuestFacade;

public class ChooseGiftsController implements Initializable {

    private static Guest guest;

    @FXML
    public ComboBox<Gift> gifts = new ComboBox<>();
    @FXML
    public Label gft;
    @FXML
    public Label qte;
    @FXML
    public ComboBox<String> quantities = new ComboBox<>();
    @FXML
    public Label message;

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
List<String> numbers = new ArrayList<>();
    private void initcombobox() {
        List<Gift> gifts_ = giftFacade.findGiftListByWedd(guest.getWeding());
        if (gifts != null) {
            gifts.setItems(FXCollections.observableArrayList(gifts_));
            gifts.getSelectionModel().select(0);
        
        
        
        if (gifts.getValue() == null || ("" + gifts.getValue()).equals("")) {
            
            for (int i = 1; i <= 0; i++) {
                numbers.add("" + i);
            }

            quantities.setItems(FXCollections.observableArrayList(numbers));
            quantities.getSelectionModel().select(0);
        } else {

            

            for (int i = 1; i <=  giftFacade.findGiftByContent(gifts.getValue().toString()).getQte() ; i++) {
                numbers.add("" + i);
            }
            
            quantities.setItems(FXCollections.observableArrayList(numbers));
            quantities.getSelectionModel().select(0);
        }
} else {
            
            gifts.setItems(FXCollections.observableArrayList());
        }
    }
    @FXML
    public void reinitiateQte(){
        if (giftFacade.findGiftByContent(gifts.getValue().toString())!=null){
                  
                    numbers.clear();
            for (int i = 1; i <=  giftFacade.findGiftByContent(gifts.getValue().toString()).getQte() ; i++) {
                numbers.add("" + i);
            }
                
            quantities.setItems(FXCollections.observableArrayList(numbers));
            quantities.getSelectionModel().select(0); 
    }
    }

    GiftFacade giftFacade = new GiftFacade();
    GiftGuestFacade giftGuestFacade = new GiftGuestFacade();

    public boolean checkInput( int qte ,Gift gift){
    if(qte > gift.getQte() )
        return true;
    else return false ;
    }
    
    GuestFacade guestFacade = new GuestFacade();
    private GiftGuest getParams() {
        
            int integerQte = new Integer(quantities.getValue());
            if (gifts.getValue() == null || ("" + gifts.getValue()).equals("")) {
                
                return null;
            } else {
                Gift gift = giftFacade.findGiftByContent(gifts.getValue().toString());
                
                    gift.setQte(gift.getQte() - integerQte);
                    giftFacade.edit(gift);
                    GiftGuest giftGuest = new GiftGuest(integerQte, gift, guest);
                    
                    guest.getGiftGuests().add(giftGuest);
                    
                    guestFacade.edit(guest);
                    return giftGuest;
               
            }
        
    } @FXML
    public void Home(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent,"WelcomeMenu.fxml" , this.getClass());
    }


    public int save() {
        GiftGuest giftGuest = getParams();
        if ( giftGuest != null) {
             reinitiateQte();

            return 1;
        } else {
            
            return -1;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initcombobox();
    }

}
  