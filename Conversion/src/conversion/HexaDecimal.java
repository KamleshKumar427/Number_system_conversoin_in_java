/*
    This is a simple class which generates the random binary number by calling
    the superclass methods in its constructor.
* */
package conversion;

public class HexaDecimal extends CommonData{

    HexaDecimal(int n) {
        super(n);           //call in constructor of super class
        randomNumAndString(16,16);  //here we keep max value to 16 because 4 or 6 bit
        FindHNum(2);                               //hexadecimal number much larger to be solved as game
    }       //Populate the horizontal decimal numbers.

    //following function simply return the daigonal decimal number
    //which will be generate in consequences of random string.
    @Override
    int getDaigonalNum() {
        String DaigonalString = "";
        for (int i = 0; i < BoardSize; i++)
            DaigonalString += getHorizontal_Strings()[i].charAt(i);
        DaigonalNum = Integer.parseInt(DaigonalString,2);
        return DaigonalNum;
    }
}

