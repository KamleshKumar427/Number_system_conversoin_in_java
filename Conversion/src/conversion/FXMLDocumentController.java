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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Afra
 */
public class FXMLDocumentController implements Initializable {
    
    private boolean state=false;
    
    @FXML
    private Label label;
    
    @FXML private  AnchorPane pane;
       
    @FXML private Label validationLabel;
    
    @FXML private TextField textField;    
    
    @FXML private Button learnBinaryButton;
    
    
    @FXML
    private void learnBinaryButtonAction(ActionEvent e) 
    throws Exception
    {
        check();
        if(state){
            Converter.setKey(2);
         changeScene(e);
        }
       
    }
    
    @FXML 
    private void learnOctalButtonAction(ActionEvent e) throws Exception{
        check();
        if(state){
            Converter.setKey(8);
            changeScene(e);
        }
    }
    
    @FXML 
    private void learnHexButtonAction(ActionEvent e ) throws Exception{
        check();
        if(state){
            Converter.setKey(16);
            changeScene(e);
        }
    }
    
    
    @FXML 
    public void numericFieldKeyEvent(KeyEvent e) throws Exception{
        // force the field to be numeric only
textField.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            textField.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});


    }// end method numericFieldKeyEvent
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 
    
    public void check(){
        try{
        String text=textField.getText();
        
         int number=Integer.parseInt(text);
         
          if(text == null){
            validationLabel.setText("Please Enter a  Number");
            state=false;
        }
            
        else if(number>=256 || number< 0){
            validationLabel.setText("Number must be between 0-255");
            state=false;
        }
        else{
            validationLabel.setText(null);
            state=true;
            Converter.setTransfer(number);
        }
        }
        catch(Exception e){
            System.out.println("Exception :"+e );
            state=false;
            validationLabel.setText("Please Enter a Number.");
        }
       
    }
    
    @FXML 
    public void backEvent(ActionEvent e) throws Exception{
        try{
        Parent startPageParent = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        
        Scene startPageScene= new Scene(startPageParent);
        Stage startPageWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        startPageWindow.setScene(startPageScene);
        startPageWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
    

    
    public void changeScene(ActionEvent e) throws Exception{
        
        try{
        Parent learnBinaryParent = FXMLLoader.load(getClass().getResource("LearnBinaryClass.fxml"));
        
        Scene learnBinaryScene= new Scene(learnBinaryParent);
        Stage learnBinaryWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        learnBinaryWindow.setScene(learnBinaryScene);
        learnBinaryWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
        
    }
    
}
