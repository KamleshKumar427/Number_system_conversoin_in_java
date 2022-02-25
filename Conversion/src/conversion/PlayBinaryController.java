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
public class PlayBinaryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void playEasyAction(ActionEvent e) throws Exception{
         try{
                Controller4.setSignal(0);
        Parent conversionParent = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        
        Scene conversionScene= new Scene(conversionParent);
        Stage conversionWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        conversionWindow.setScene(conversionScene);
        conversionWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
    
    @FXML 
    public void playHardAction(ActionEvent e) throws Exception{
            try{
                Controller4.setSignal(0);
                FileHandle.setSignal(3);
        Parent conversionParent = FXMLLoader.load(getClass().getResource("sample6.fxml"));
        
        Scene conversionScene= new Scene(conversionParent);
        Stage conversionWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        conversionWindow.setScene(conversionScene);
        conversionWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
    
     @FXML 
    public void backEvent(ActionEvent e) throws Exception{
           try{
        Parent backParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene backScene= new Scene(backParent);
        Stage backWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        backWindow.setScene(backScene);
        backWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
}
