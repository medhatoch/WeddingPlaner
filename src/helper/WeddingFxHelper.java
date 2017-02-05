/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;
import beans.Wedding;
import java.util.List;
import javafx.scene.control.TableView;
/**
 *
 * @author hp
 */
public class WeddingFxHelper extends AbstractFxHelper<Wedding> {

    private static AbstractFxHelperItem[] headers;

    static {

        headers = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Id", "id"),
            new AbstractFxHelperItem("brideFirstName", "brideFirstName"),
            new AbstractFxHelperItem("brideLastName", "brideLastName"),
            new AbstractFxHelperItem("groomFirstName", "groomFirstName"),
            new AbstractFxHelperItem("groomLastName", "groomLastName"),
            new AbstractFxHelperItem("weddingDate", "weddingDate"),};
    }

    public  WeddingFxHelper( TableView<Wedding> table, List<Wedding> list) {
        super(headers, table, list);
    }
   
    public WeddingFxHelper( TableView<Wedding> table) {
        super(headers, table);
    }
}
    

