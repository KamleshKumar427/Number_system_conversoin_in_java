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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Afra
 */
public class StartPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button learnButton;
    @FXML private Button playButton;
    
    @FXML
    public void learnEvent(ActionEvent e)throws Exception{
        
        try{
        Parent learnBinaryParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene learnPage= new Scene(learnBinaryParent);
        Stage learnPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        learnPageWindow.setScene(learnPage);
        learnPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
        
        }
    
    @FXML 
    public void playEvent(ActionEvent e)throws Exception{
        try{
        Parent playParent = FXMLLoader.load(getClass().getResource("Play.fxml"));
        
        Scene playPage= new Scene(playParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(playPage);
        playPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
    
    @FXML
    public void exitEvent(ActionEvent e) throws Exception {
        System.exit(1);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
