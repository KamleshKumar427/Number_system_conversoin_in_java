/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Afra
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    
    Boolean state=false;
    
    
    @FXML private TextField nameField;
    @FXML private Label nameLabel;
    @FXML private Label cmsLabel;
    @FXML private TextField cmsField;
            
    @FXML private Button loginButton;
    
     public boolean checkName(){
        Boolean name=nameField.getText().isEmpty();
         if(name){
            
            nameLabel.setText("Please Enter Your Name.");
            return false;
        }
        else{  
            nameLabel.setText(null);
            return true;
        }
    }
     
         @FXML 
    public void numericFieldKeyEvent(KeyEvent e) throws Exception{
        // force the field to be numeric only
cmsField.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            cmsField.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});


    }// end method numericFieldKeyEvent
    
    public boolean checkCMS(){
          Boolean cms=cmsField.getText().isEmpty();
       
        if(cms ){
            cmsLabel.setText("Please Enter Your CMS.");
            return false;
        }
        
        else{
            cmsLabel.setText(null);
            return true;
        }
    }
    
    Boolean check1,check2;
    
    @FXML
    public void loginEvent(ActionEvent e) throws Exception{
       
        check1=checkName();
        check2=checkCMS();
        
       if(check1 & check2){
           state=true;
       }
       else{
           state=false;
       }
        
        if(state){
            try{
                FileHandle.setFileString(cmsField.getText());
        Parent learnBinaryParent = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        
        Scene startPage= new Scene(learnBinaryParent);
        Stage startPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        startPageWindow.setScene(startPage);
        startPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
        }
        
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   
    
}
