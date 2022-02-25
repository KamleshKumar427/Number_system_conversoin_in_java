/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Afra
 */
public class Conversion<args> extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Number Conversion");
        stage.show();
    
        }
        catch(Exception e){
            System.err.println("Exception in Main:"+e);
        }
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
     //Application.launch(Conversion,args);
}
