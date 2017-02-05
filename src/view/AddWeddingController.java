package view;

import beans.Wedding;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.WeddingFacade;
import util.DateUtil;

public class AddWeddingController implements Initializable {

    @FXML
    private TextField brideFirstName;
    @FXML
    private TextField brideLastName;

    @FXML
    private TextField groomFirstName;

    @FXML
    private TextField groomLastName;
    @FXML
    private DatePicker weddingDate = new DatePicker();
  
    @FXML
    private Label messageFields;
    @FXML
    private Label messageDate;

    WeddingFacade weddingFacade = new WeddingFacade();
    DateUtil dateUtil = new DateUtil();
     
    public int checkWedding(String field1, String field2, String field3, String field4 ) {
       
        if ( field1 == ""||field1.equals("") || field2 == ""||field2.equals("") || field3 == ""||field3.equals("") || field4 == ""||field4.equals("") ) {
            
            messageFields.setText("One of the fields is empty ");

            return -1;
        } else {
            messageFields.setText("");
             if ( weddingDate.getValue()==  null)
             { messageDate.setText("The date is invalid ");
                 weddingDate.setValue(LocalDate.now());
             
             return -1;
             }else {
              if ( dateUtil.convert(weddingDate.getValue().toString()) == dateUtil.convert(LocalDate.now().toString())||dateUtil.convert(weddingDate.getValue().toString()) .equals(dateUtil.convert(LocalDate.now().toString()) )|| dateUtil.convert(weddingDate.getValue().toString()).before(dateUtil.convert(LocalDate.now().toString()) ) ) {
            
            messageDate.setText("The date is invalid ");
            return -1;
             }else{
                 
            if (weddingFacade.verifyWedDate(dateUtil.convert(weddingDate.getValue().toString()) ) == -1) {
                messageDate.setText("This date is already chosen ");

                return -1;
            } else {
                messageDate.setText("");

                return 1;
            }

        }
    }}}

    public int reCheckWedding(String field1, String field2, String field3, String field4) {
        if (weddingFacade.findWeddingByWedsName(field1, field2, field3, field4) == null) {
            messageFields.setText("");
            return 1;
        } else {
            messageFields.setText("A wedding is already booked for you !");

            return -1;
        }

    }

    public Wedding getParam() {

        Wedding wedding = weddingFacade.addWedding(brideFirstName.getText(), brideLastName.getText(), groomFirstName.getText(), groomLastName.getText(), dateUtil.convert(weddingDate.getValue().toString()));

        return wedding;
    }
ViewLauncher viewLauncher = new ViewLauncher();
AddGuestController addGuestController = new AddGuestController();    
@FXML
    public int save(ActionEvent actionEvent) throws IOException {
       
       
         if (checkWedding(brideFirstName.getText(), brideLastName.getText(), groomFirstName.getText(), groomLastName.getText()) == 1) {
            
             if (reCheckWedding(brideFirstName.getText(), brideLastName.getText(), groomFirstName.getText(), groomLastName.getText()) == 1) {
                Wedding wedding = getParam();
                weddingFacade.create(wedding);
                messageFields.setText("The operation is a success");
                viewLauncher.forward(actionEvent, "AddGuest.fxml", this.getClass());
                addGuestController.setWedding(wedding);
                return 1;
            } else {
                return -1;
            }
        
        
    }else return -1 ;
    }
 @FXML
    public void Home(ActionEvent actionEvent) throws IOException {
        ViewLauncher.forward(actionEvent,"WelcomeMenu.fxml" , this.getClass());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
