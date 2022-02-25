/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;


/* This class contains the all data (radomaly generated horiontal and vertical number)
    and this class also contains the variable to store horiontal and vertical the string.
    In Every stage of game these same variables are manuplated. ALso this class contains the
    methods to generate the binary Strings.
* */

/**
 *
 * @author Afra
 */
import static java.lang.Integer.toBinaryString;

abstract public class CommonData {
        int DaigonalNum = 0;
        private int VerticalNums[];            //to store vertical random decimal numbers
        private int HorizontalNums[];          //to store horizontal random decimal numbers
        private String Horizontal_Strings[] ; //horizontal Decimal string
        private String Vertical_Strings[] ; //Vertical Decimal string
        static int BoardSize ;              //this will decide the grid or board size
        //constructor to get the size of the board from the subclasses.
        CommonData(int n){
            BoardSize = n;
            VerticalNums = new int[n];          //make an Vertical array of board size
            HorizontalNums = new int[n];        //make an Horizontal array of board size
            Horizontal_Strings = new String[n]; //make an> horizontal Decimal string array
            Vertical_Strings = new String[n];   //make an> Vertical Decimal  string array
        }

        //Following function will randomly generate random numbers and Binary strings according to
        // the random numbers. Max size is set according to the board size
        public void randomNumAndString(int MAX_6_BIT, int MAX_4_BIT  ) {
            for (int i = 0; i < BoardSize; i++) {
                if (BoardSize == 6)         //Random number is set according to the board size                   //262143
                    getVNumber()[i] = (int) (Math.random() * MAX_6_BIT); //genreates a number between 0 and 16
                else
                    getVNumber()[i] = (int) (Math.random() * MAX_4_BIT); //genreates a number between 0 and 64

                //convert Vertical Numbers into horizontal binary string.
                getHorizontal_Strings()[i] = toBinaryString(getVNumber()[i]);

                int Binary_length = BoardSize - getHorizontal_Strings()[i].length();
                //following loop will place 0's at the begining of string if String literal
                // size is < boardSize
                for (int j = 0; j < Binary_length; j++) {
                    getHorizontal_Strings()[i] = "0" + getHorizontal_Strings()[i]; //setting the string to 4 bits
                }
            }
        }

        //In above method horizontal string are being populated
        //in the following function Horizontal numbers are being populated.
        //according to the randomaly generated horizontal string.
        public void FindHNum(int Radix){
            String temp ="";
            for (int i = 0; i < BoardSize; i++) {
                getVertical_Strings()[i] ="";
                for (int j = 0; j < BoardSize; j++) {
                    getVertical_Strings()[i] += getHorizontal_Strings()[j].charAt(i);
                }
                getHNumber()[i] = Integer.parseInt(getVertical_Strings()[i], Radix);
            }
        }

        //following are the normal getter and setter functions
        public int[] getHNumber() {
            return VerticalNums;
        }

        public int[] getVNumber() {
            return HorizontalNums;
        }

        public String[] getHorizontal_Strings() {
            return Horizontal_Strings;
        }

        public String[] getVertical_Strings() {
            return Vertical_Strings;
        }

        /*  we are working on getDaigonalNum in the subclasses but we need to use the following function Using superclass refernce
            variable with different implementation in each subclass,therefore we are defining it
            as abstract and implementing in it's subclass.
        * */
        abstract int getDaigonalNum();

    }//End of abstract class CommonData

