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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Afra
 */
public class FinishController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Label yourTime;
    @FXML private Label bestTime;
    @FXML private Label highScoreLabel;
    
    
    @FXML 
    public void menuButtonEvent(ActionEvent e) throws Exception{
                   try{
        Parent mainParent = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        
        Scene mainScene= new Scene(mainParent);
        Stage mainWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        mainWindow.setScene(mainScene);
        mainWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
            a.printStackTrace();
        }
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        try{
        yourTime.setText("Your Time: "+FileHandle.getTime());
        FileHandle object=new FileHandle();
        if(object.exist()){
            String[] data=object.readFile();
            
        switch(FileHandle.getSignal()){
                case 0:
                    compare(data,0);
                    break;
                case 1:
                    compare(data,1);
                    break;
                case 2:
                    compare(data,2);
                    break;
                case 3:
                    compare(data,3);
                    break;
            }
        object.write(data);
        }
        else{
            String data[]=new String[4];
            for(int i=0;i<4;i++){
                data[i]="59:59:999";
            }
            data[FileHandle.getSignal()]=FileHandle.getTime();
            object.write(data);
        }
        
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }
    
    }

    //method to set High Score
   public void compare(String[] data,int index){
        
       
       int highScore=Integer.parseInt(FileHandle.extractInt(data[index]));
       int score=Integer.parseInt(FileHandle.extractInt(FileHandle.getTime()));
       if(score<highScore){
           highScoreLabel.setText("Congrats: You Have made a new High Score");
           data[index]=FileHandle.getTime();
           bestTime.setText("Best Time :"+FileHandle.getTime());
       }
       else{
           highScoreLabel.setText(null);
           bestTime.setText("Best Time :"+data[index]);
       }
   }    
       
    
}
