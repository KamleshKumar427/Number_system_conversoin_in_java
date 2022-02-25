/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Afra
 */




public class LearnBinaryClassController implements Initializable {

  int count=0;
    
@FXML
private Pane pane;

@FXML private Label result;
    
    
    @FXML
private Label numberlabel;
    
    @FXML private Label startLabel;
    
    @FXML private Label a1;
    @FXML private Label a2;
    
    @FXML private Label b1;
    @FXML private Label b2;
    @FXML private Label b3;
    @FXML private Label b4;
    @FXML private Label b5;
    
    @FXML private Label c1;
    @FXML private Label c2;
    
    @FXML private Label d1;
    @FXML private Label d2;
    
    @FXML private Label e1;
    @FXML private Label e2;
    @FXML private Label e3;
    @FXML private Label e4;
    @FXML private Label e5;
    
    
    @FXML private Button click;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Converter object;
        
        
        
           if(Converter.getKey()==2){
             object=new BinaryConverter(Converter.getTransfer(),Converter.getKey());
        }
        else if(Converter.getKey()==8)
        {
             object=new OctalConverter(Converter.getTransfer(),Converter.getKey());
        } 
        else
        {
             object=new HexConverter(Converter.getTransfer(),Converter.getKey());
        }
        
        
        try{  
            
        String[] labelData=object.getInstructions();
        startLabel.setText(labelData[0]);
       
        a1.setText(labelData[1]);
        a2.setText(labelData[2]);
        
        b1.setText(labelData[3]);
        b2.setText(labelData[4]);
        b3.setText(labelData[5]);
        b4.setText(labelData[6]);
        b5.setText(labelData[7]);
        
        c1.setText(labelData[8]);
        c2.setText(labelData[9]);
        
        d1.setText(labelData[10]);
        d2.setText(labelData[11]);
        
        e1.setText(labelData[12]);
        e2.setText(labelData[13]);
        e3.setText(labelData[14]);
        e4.setText(labelData[15]);
        e5.setText(labelData[16]);
        
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
        int lineYcood;
        int labelYcood;       
        
    String data[][]=object.getCodeData();
        
     numberlabel.setText("Number : "+object.getDecimal());     
    
     for(int i=0;i<object.getIndex();i++){
         lineYcood=i*50+51;
         labelYcood=i*50+5;
         
         Line line=new Line(361.0,lineYcood,10,lineYcood);
        pane.getChildren().addAll(line);
       
        try{
        Label divideLabel=new Label("Divide by "+Converter.getKey()+".");
       Label quotientLabel=new Label("Quotient: "+data[0][i]);
       Label remainderLabel=new Label("Remainder: "+data[1][i]);
         
        divideLabel.setPrefWidth(352.0);
        divideLabel.setPrefHeight(20);
        quotientLabel.setPrefWidth(115);
        quotientLabel.setPrefHeight(20);
        remainderLabel.setPrefWidth(200);
        remainderLabel.setPrefHeight(20);
        
        divideLabel.setTranslateX(9);
        divideLabel.setTranslateY(labelYcood);
        quotientLabel.setTranslateX(9);
        quotientLabel.setTranslateY(labelYcood+20);
        remainderLabel.setTranslateX(155);
        remainderLabel.setTranslateY(labelYcood+20);
        
        pane.getChildren().addAll(divideLabel);
        pane.getChildren().addAll(quotientLabel);
        pane.getChildren().addAll(remainderLabel);
     }
     catch(Exception e){
             System.out.println("Exception Ocuured."+ e);
             }
     }
     
    if(object.getIndex()==0){
        switch(object.getKey()){
            case 2:
             result.setText("Binary Code : "+0);
             break;
             
            case 8:
              result.setText("Octal Code : "+0);  
              break;
            case 16:
               result.setText("Octal Code : "+0); 
               break;
        }
       
    }
    else
        result.setText(object.toString());
     
    }   
   
    @FXML 
    public void backEvent(ActionEvent e) throws Exception{
           try{
        Parent conversionParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene conversionScene= new Scene(conversionParent);
        Stage conversionWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        conversionWindow.setScene(conversionScene);
        conversionWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
    
}
