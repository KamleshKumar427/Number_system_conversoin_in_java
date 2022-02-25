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
public class PlayController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    public void binaryPlayEvent(ActionEvent e) throws Exception{
         try{
        Parent playParent = FXMLLoader.load(getClass().getResource("PlayBinary.fxml"));
        
        Scene playPage= new Scene(playParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(playPage);
        playPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
            a.printStackTrace();
        }
    }
    
    @FXML 
    public void octalPlayEvent(ActionEvent e) throws Exception{
         try{
             Controller4.setSignal(1);
        Parent playParent = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        
        Scene playPage= new Scene(playParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(playPage);
        playPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
            a.printStackTrace();
        }
    }
    
    @FXML 
    public void hexPlayEvent(ActionEvent e) throws Exception{
         try{
             Controller4.setSignal(2);
        Parent playParent = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        
        Scene playPage= new Scene(playParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(playPage);
        playPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
            a.printStackTrace();
        }
    }
    
       @FXML 
    public void backButtonEvent(ActionEvent e) throws Exception{
         try{
             Controller4.setSignal(2);
        Parent playParent = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        
        Scene playPage= new Scene(playParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(playPage);
        playPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
            a.printStackTrace();
        }
    }
    
    @FXML
    public void howToPlayEvent(ActionEvent e) throws Exception{
         try{
        Parent howtoPlayParent = FXMLLoader.load(getClass().getResource("HowtoPlay.fxml"));
        
        Scene howtoPlayScene= new Scene(howtoPlayParent);
        Stage playPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        playPageWindow.setScene(howtoPlayScene);
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
