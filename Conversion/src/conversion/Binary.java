/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

/**
 *
 * @author Afra
 */

/*
    This is a simple class which generates the random binary number by calling
    the superclass methods in the constructor.
* */
public class Binary extends CommonData{
    

    Binary(int n) {
        super(n);       //call in constructor of super class
        randomNumAndString(63,16);     //generate the random number and populate horizontal string according to board size
        FindHNum(2);        //Populate the horizontal decimal numbers.
    }

    //following function simply return the daigonal decimal number
    //which will be generate in consequences of random string.
    public int getDaigonalNum() {
        String DaigonalString = "";
        for (int i = 0; i < BoardSize; i++)
             DaigonalString += getHorizontal_Strings()[i].charAt(i);
        DaigonalNum = Integer.parseInt(DaigonalString,2);
        return DaigonalNum;
    }
}//end of binary class

