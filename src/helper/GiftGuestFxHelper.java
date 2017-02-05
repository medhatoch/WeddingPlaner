/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import beans.GiftGuest;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author hp
 */
public class GiftGuestFxHelper extends  AbstractFxHelper<GiftGuest> {
   
     private static AbstractFxHelperItem[] headers;
     static {

        headers = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Id", "id"),
            new AbstractFxHelperItem("GiftQuantity", "qte")};
    }

    public GiftGuestFxHelper( TableView<GiftGuest> table, List<GiftGuest> list) {
        super(headers, table, list);
    }
    
    public GiftGuestFxHelper( TableView<GiftGuest> table) {
        super(headers, table);
    }
    
}


