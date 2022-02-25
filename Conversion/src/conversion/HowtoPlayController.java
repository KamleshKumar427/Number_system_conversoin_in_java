/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Afra
 */
public class HowtoPlayController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    public void backEvent(ActionEvent e) throws Exception{
           try{
        Parent playParent = FXMLLoader.load(getClass().getResource("Play.fxml"));
        
        Scene playScene= new Scene(playParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(playScene);
        playPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
