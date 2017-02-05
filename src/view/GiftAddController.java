/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import helper.GiftFxHelper;
import beans.Gift;
import beans.Wedding;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import services.GiftFacade;
import services.WeddingFacade;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GiftAddController implements Initializable {

    @FXML
    private TextField contenu;
    @FXML
    private TextField qte;
    @FXML
    private Label errorMsg;
    @FXML
    private TableView giftTableView;
    private GiftFxHelper giftFxHelper;

    GiftFacade giftFacade = new GiftFacade();
    AddGuestController addGuestController = new AddGuestController();
    SignInViewController signInViewController = new SignInViewController();
    
     
    public int initTableView() {
       GiftFxHelper giftFxHelper = new GiftFxHelper(giftTableView);
        if(giftFacade.findGiftListByWedd(addGuestController.getWedding())!=null){
           Wedding wedding = addGuestController.getWedding();
//           Wedding wed = (Wedding) giftFacade.getEntityManager().createQuery("SELECT w FROM Wedding w WHERE w.id="+wedding.getId());
           List<Gift> gifts =giftFacade.findGiftListByWedd(wedding);
//            for (Gift gift : giftFacade.findAll()) {
//                if (gift.getWedding()== wedding )
//                    gifts.add(gift);
//            }

        giftFxHelper.setList(gifts);
        return 1;}
        else return -1 ;
    }

    public Gift getParams(){
        if (qte.getText() == "" || qte.getText().isEmpty() || contenu.getText() == "" || contenu.getText().isEmpty() ) {
            errorMsg.setText("One of the fields is empty !");
            return null;
        }   
            
        Gift gift_ = giftFacade.findGiftByContent(contenu.getText());
           if (gift_!=null ){
               
               
            gift_.setQte(gift_.getQte()+Integer.parseInt(qte.getText()));
            giftFacade.edit(gift_);
//           giftTableView.refresh();
//            giftFxHelper.setList(giftFacade.findGiftListByWedd(addGuestController.getWedding()));
            
            return null;
           }else{
               System.out.println("sjdughxghkdfjgd");
            int intQte = new Integer(qte.getText());
            Gift gift = new Gift(contenu.getText(), intQte);
            gift.setWedding(addGuestController.getWedding());
            return gift;
       
           }
    }
   
    WeddingFacade weddingFacade = new WeddingFacade();
    @FXML
    public int save(ActionEvent actionEvent) {
        
        Gift gift = getParams();
        if (gift==null ) {            
            return -1;
        } else {
            
            giftFacade.create(gift);
            errorMsg.setText("");
            List<Gift> gfs=giftFxHelper.getTable().getItems();            
           gfs.add(gift);
           giftFxHelper.setList(giftFacade.findGiftListByWedd(addGuestController.getWedding()));
errorMsg.setText("The operation is a success");
           return 1;
            
        }
    }
 @FXML
    public void Home(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent,"WelcomeMenu.fxml" , this.getClass());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int a=initTableView();
    }

}
