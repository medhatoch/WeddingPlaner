 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import beans.Gift;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author hp
 */
public class GiftFxHelper extends AbstractFxHelper<Gift> {
    private static AbstractFxHelperItem[] headers;
     static {

        headers = new AbstractFxHelperItem[]{
           
            new AbstractFxHelperItem("Content", "content"),
            new AbstractFxHelperItem("GiftQuantity", "qte")};
    }
    public GiftFxHelper( TableView<Gift> table, List<Gift> list) {
        super(headers, table, list);
    }
     public GiftFxHelper( TableView<Gift> table) {
        super(headers, table);
    }
    
}
