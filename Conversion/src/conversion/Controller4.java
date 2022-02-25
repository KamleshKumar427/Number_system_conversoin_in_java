//controller for 4*4 grid pane

package conversion;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller4 {
    //Following is an array of labels to accomodate vertical and horizontal decimal numbers
    Label VDecimal[] = new Label[4];
    Label HDecimal[] = new Label[4];
    Timeline timeline;

    //Signal controls the switch between hexa, OCta and binary numbers in the following order
    
    private static int Signal = 1;

    public static int getSignal() {
        return Signal;
    }

    public static void setSignal(int Signal) {
        Controller4.Signal = Signal;
    }
    
    // 0 -> binary
    // 1 -> OctaDecimal
    // 2 -> Hexadecimal

    //Gridpane
    @FXML
    GridPane Base;
    @FXML
    TextField Daigonal;
    //fx id's to control all text field

    @FXML
    TextField aa, ab, ac, ad, ba, bb, bc, bd, ca, cb, cc, cd, da, db, dc, dd;

    //following field will contain the time
    @FXML
    Text Time;

    //timeLine for time animation
    Timeline timeAnime;

    int mins = 0, secs = 0, millis = 0;

    //following function will increment the time.
void change(Text text) {
    if(millis == 1000) {
        secs++;
        millis = 0;
    }
    if(secs == 60) {
        mins++;
        secs = 0;
    }
    text.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
            + (((secs/10) == 0) ? "0" : "") + secs + ":"
            + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
}

   @FXML
    public void ChangeDecimal(MouseEvent e) {
        animate((Node) e.getSource());  //casting

        //following two lines breaks the fx ids.
        char x = ((Node) e.getSource()).getId().charAt(0);
        char y = ((Node) e.getSource()).getId().charAt(1);

        //following switch will decide which Textfield
        //and corresponding decimal(right-most and bottom most) numbers in
        //will start blinking once clicked
        switch(x) {
            case 'a':
                animate((Node) VDecimal[0]);        break;
            case 'b':
                animate((Node) VDecimal[1]);        break;
            case 'c':
                animate((Node) VDecimal[2]);        break;
            case 'd':
                animate((Node) VDecimal[3]);        break;
        }
        switch(y) {
            case 'a':
                animate((Node) HDecimal[0]);        break;
            case 'b':
                animate((Node) HDecimal[1]);        break;
            case 'c':
                animate((Node) HDecimal[2]);        break;
            case 'd':
                animate((Node) HDecimal[3]);        break;
        }   //following function will control the mouse clicks.
  

        //getting the source at the current fx id.
        TextField source = (TextField) e.getSource();
        //finding the value at the current fx id(source)
        int CurrentValue = Integer.parseInt(source.getText());

        //following if and else loop will decide whether to increment
        //the text on the fields uptp 7 or to switch the text between 0 and 1.
       //Signal 1 or 0 -> switching
        //Signal 2 -> increment upto 7

        if (Signal == 0 || Signal == 2) {
            if (source.getText().compareTo("0") == 0)
                source.setText("1");
            else
                source.setText("0");
        }
        else{
            if ( CurrentValue == 7)
                source.setText("0");
            else
                source.setText("" +  (CurrentValue + 1));
        }
        //following if condition will check if all the data enter are right
        //and stop the time count as well.
        if (isDone()) {
            FileHandle.setSignal(Signal);
            System.out.println("You Won!!");
            timeAnime.stop();
            FileHandle.setTime(Time.getText());
           
                try{
        Parent finalParent = FXMLLoader.load(getClass().getResource("Finish.fxml"));
        
        Scene finalScene= new Scene(finalParent);
        Stage finalWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        finalWindow.setScene(finalScene);
        finalWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
            a.printStackTrace();
        }
            //System.out.println("Time taken : " +Time.getText());
        }
    }
    //We have made the reference variable of CommonData(SuperClass), But we will be using
    //object of the subclass in the following code(Polymorphism).
     CommonData data;
        //following is the coding to detect if data is filled correctly by user
        @FXML
        public boolean isDone(){
            //1st make string from the user input then compare with the strings in the data(Object)
            String User_Strings[]  = new String[4]; //User Entered binary string
            User_Strings[0] = aa.getText() + ab.getText() + ac.getText() + ad.getText();
            User_Strings[1] = ba.getText() + bb.getText() + bc.getText() + bd.getText();
            User_Strings[2] = ca.getText() + cb.getText() + cc.getText() + cd.getText();
            User_Strings[3] = da.getText() + db.getText() + dc.getText() + dd.getText();
            for(int i = 0; i < 4; i++){
                if (User_Strings[i].compareTo(data.getHorizontal_Strings()[i]) != 0)
                    return false;
            }

            //If data entered correctly then the display the daigonal element
            Daigonal.setText("D = "+data.getDaigonalNum());
            return true;
        }
        //Following function will animate the blocks and fields.
    public void animate(Node currentNode) { //csating
        timeline = new Timeline(new KeyFrame(Duration.seconds(2), evt -> currentNode.setVisible(false)),
                new KeyFrame(Duration.seconds(0.009), evt -> currentNode.setVisible(true)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

 @FXML 
    public void backEvent(ActionEvent e) throws Exception{
           try{
        Parent backParent = FXMLLoader.load(getClass().getResource("Play.fxml"));
        
        Scene backScene= new Scene(backParent);
        Stage backWindow=(Stage)((Node)e.getSource()).getScene().getWindow();
        backWindow.setScene(backScene);
        backWindow.show();
        }
        catch(Exception a){
            System.out.println("Exception :"+a);
        }
    }
        public void initialize () {
            
            //following few lines will run the time animation
            Time.setText("00:00:000");
            timeAnime = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            change(Time);
            }
            }));
            timeAnime.setCycleCount(Timeline.INDEFINITE);
            timeAnime.setAutoReverse(false);
            timeAnime.play();

            //using the polymorphism to select from hexadecimal, OCtaDecimal and Binary classs using
            //CommonData reference varaible.
            if (Signal == 0)
                data = new Binary(4);
            else if (Signal == 1)
                data = new OctaDecimal(4);
            else 
                data = new HexaDecimal(4);

                for (int i = 0; i < 4; i++) {
                    VDecimal[i] = new Label("       " + data.getVNumber()[i]);
                    HDecimal[i] = new Label("       " + data.getHNumber()[i]);
                }
                if(Signal == 2)     //Signal 2 -> Hexadecinal then we convert number > 10 into correponsind hex representaton
                for (int i = 0; i < 4; i++) {

                    if(data.getVNumber()[i] > 9) {
                        switch (data.getVNumber()[i]) {
                            case 10:
                                VDecimal[i] = new Label("       A ");
                                break;
                            case 11:
                                VDecimal[i] = new Label("       B ");
                                break;
                            case 12:
                                VDecimal[i] = new Label("       C ");
                                break;
                            case 13:
                                VDecimal[i] = new Label("       D ");
                                break;
                            case 14:
                                VDecimal[i] = new Label("       E ");
                                break;
                            case 15:
                                VDecimal[i] = new Label("       F ");
                                break;
                        }
                    }

                    if(data.getHNumber()[i] >9) {
                        switch (data.getHNumber()[i]) {
                            case 10:
                                HDecimal[i] = new Label("       A ");
                                break;
                            case 11:
                                HDecimal[i] = new Label("       B ");
                                break;
                            case 12:
                                HDecimal[i] = new Label("       C ");
                                break;
                            case 13:
                                HDecimal[i] = new Label("       D ");
                                break;
                            case 14:
                                HDecimal[i] = new Label("       E ");
                                break;
                            case 15:
                                HDecimal[i] = new Label("       F ");
                                break;
                        }
                    }
        }
                //following are some lines to set the properties of Verticla and horitozal labels
            for (int i = 0; i < 4; i++) {
                VDecimal[i].setFont(new Font("Limelight", 21));
                HDecimal[i].setFont(new Font("Limelight", 21));
                VDecimal[i].setMinWidth(93.08);
                HDecimal[i].setMinWidth(93.08);

                HDecimal[i].setTextAlignment(TextAlignment.CENTER);
                VDecimal[i].setTextAlignment(TextAlignment.CENTER);
                //following lines add the labels to the grid.
                Base.add(VDecimal[i], 4, i+1);
                Base.add(HDecimal[i], i, 4+1);
            }
        }
    }


