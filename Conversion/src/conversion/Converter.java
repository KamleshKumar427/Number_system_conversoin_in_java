/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Afra
 */
public abstract class Converter {

    private int count = 0;

    //stsatic variable to store data of textField
    private static int transfer;

    private static int key;
    private int decimal;
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    public static int getTransfer() {
        return transfer;
    }

    public static void setTransfer(int tranfser) {
        Converter.transfer = tranfser;
    }

    public int getIndex() {
        return index;
    }

    public Converter() {

    }

    public Converter(int decimal, int key) {
        this.decimal = decimal;
        this.key = key;
    }

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Converter.key = key;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    //method to get Binary/Octal/hex Code
    public int[] getCode() {
        int dec = decimal;
        int code[] = new int[8];
        int temp[] = new int[8];
        index = 0;
        while (dec > 0) {
            temp[index] = dec % key;
            dec /= key;
            index++;
        }

        count = index;
        for (int i = 0; i < index; i++) {

            code[i] = temp[index - i - 1];
            count--;
        }

        return code;
    }

    //method to get Binary/Octal/hex Code data
    public String[][] getCodeData() {

        int dec = getDecimal();
        String[][] codedata = new String[2][8];
        int temp;
        index = 0;

        while (dec > 0) {
            temp = dec % key;
            dec /= key;
            codedata[0][index] = dec + "";
            codedata[1][index] = temp + "";
            index++;
        }
        return codedata;
    }

    //to string method to return binary/octal/hex code
    public String toString() {
        String codeString = new String();
        int data[] = getCode();
        for (int i = 0; i < index; i++) {
            codeString += data[i];
        }

        return codeString;
    }

    public abstract String[] getInstructions() throws Exception;

}

class BinaryConverter extends Converter {

    public BinaryConverter(int decimal, int key) {
        super(decimal, key);
    }

    //method to get instructions from file
    public String[] getInstructions() throws Exception {

        File binaryFile = new File("BinaryInstructions.txt");
        Scanner reader = new Scanner(binaryFile);
        String[] data = new String[17];
        int counter = 0;
        while (reader.hasNextLine()) {
            data[counter] = reader.nextLine();
            counter++;

        }

        return data;

    }

    public String toString() {

        return String.format("Binary Code : " + super.toString());
    }

}//end class BinaryConverter

class OctalConverter extends Converter {

    public OctalConverter() {
    }

    public OctalConverter(int decimal, int key) {
        super(decimal, key);
    }

     //method to get instructions from file
    public String[] getInstructions() throws Exception {

        File octalFile = new File("OctalInstructions.txt");
        Scanner reader = new Scanner(octalFile);
        String[] data = new String[17];
        int counter = 0;
        while (reader.hasNextLine()) {
            data[counter] = reader.nextLine();
            counter++;

        }
      
        return data;

    }

    public String toString() {

        return String.format("Octal Code : " + super.toString());
    }

}//end class OctalConverter

class HexConverter extends Converter {

    public HexConverter() {
    }

    public HexConverter(int decimal, int key) {
        super(decimal, key);
    }

    //method to get instructions from file
    public String[] getInstructions() throws Exception {

        File hexFile = new File("HexInstructions.txt");
        Scanner reader = new Scanner(hexFile);
        String[] data = new String[17];
        int counter = 0;
        while (reader.hasNextLine()) {
            data[counter] = reader.nextLine();
            counter++;

        }

        return data;

    }
    
     public String[][] getCodeData() {

        int dec = getDecimal();
        String[][] codedata = new String[2][8];
        int temp;
        int counter=0;

        while (dec > 0) {
            temp = dec % 16;
            dec /= 16;
            codedata[0][counter] = dec + "";
            switch(temp){
                case 10:
                    codedata[1][counter]="A";
                    break;
                
                case 11:
                     codedata[1][counter]="B";
                    break;
                    
                    case 12:
                     codedata[1][counter]="C";
                    break;
                    
                    case 13:
                     codedata[1][counter]="D";
                    break;
                    
                    case 14:
                     codedata[1][counter]="E";
                    break;
                    
                    case 15:
                     codedata[1][counter]="F";
                    break;
                
                    default:
                        codedata[1][counter]=temp+"";
                        
            }
            
            counter++;
        }
        
        super.setIndex(counter);
        return codedata;
    }


    public String toString() {
        
        String code=Integer.toHexString(super.getDecimal());
        return String.format("HexaDecimal Code : " + code);
    }

}//end class hex converter
