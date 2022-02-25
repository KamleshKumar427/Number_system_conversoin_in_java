/*
    This is a simple class which generates the random Octal number by calling it's own
    methods other, not the superclass methods.
* */
package conversion;

import static java.lang.Integer.toOctalString;

class OctaDecimal extends CommonData{
    OctaDecimal(int n) {
        super(n);           //call in constructor of super class
        randomNumAndString();  //generate the random and populate horizontal string
        FindHNum(8);     //Populate the horizontal decimal numbers.
    }

    //Following method generator random numbers and populate the horizontal strings
    // The reason why we don't use super class method is that in superclass method we
    // are converting the numbers to binary string but in this case we want to convert
    // them to octal strings.

    public void randomNumAndString(){
        for (int i = 0; i < BoardSize; i++) {   //board size is always 4 here no need to choose between 4 and 6
            getVNumber()[i] = (int) (Math.random() * 4095); //genreates a number between 0 and 16

            getHorizontal_Strings()[i] = toOctalString(getVNumber()[i]);

            int Binary_length = BoardSize - getHorizontal_Strings()[i].length();
            for (int j = 0; j < Binary_length; j++) {
                getHorizontal_Strings()[i] = "0" + getHorizontal_Strings()[i]; //setting the string to 4 bits
            }
        }
    }
    //following function simply return the daigonal decimal number
    //which will be generate in consequences of random string.

    public int getDaigonalNum() {
        String DaigonalString = "";
        for (int i = 0; i < BoardSize; i++)
            DaigonalString += getHorizontal_Strings()[i].charAt(i);
        DaigonalNum = Integer.parseInt(DaigonalString,8);
        return DaigonalNum;
    }
}//end of Octal class


