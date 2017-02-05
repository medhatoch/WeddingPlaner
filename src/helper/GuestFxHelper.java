/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import beans.Guest;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author hp
 */
public class GuestFxHelper extends AbstractFxHelper<Guest> {
     private static AbstractFxHelperItem[] headers;
     static {

        headers = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Id", "id"),
            new AbstractFxHelperItem("GuestFirstName", "firstName"),
            new AbstractFxHelperItem("GuestLastName", "lastName"),
            new AbstractFxHelperItem("GuestPhoneNumber", "noCellPhone"),};
    }
    
    public GuestFxHelper( TableView<Guest> table) {
        super(headers, table);
    }
    public GuestFxHelper( TableView<Guest> table,List<Guest> list) {
        super(headers, table,list);
    }
}
