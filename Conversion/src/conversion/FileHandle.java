/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;


import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author Afra
 */
public class FileHandle {
    
   // static varibles to store data
    private static String fileString;
    private static String time;
    private static int signal;

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        FileHandle.time = time;
    }

    public static int getSignal() {
        return signal;
    }

    public static void setSignal(int signal) {
        FileHandle.signal = signal;
    }
    
    public FileHandle(){
        
    }
    
    public FileHandle(String fileString){
        FileHandle.fileString=fileString;
    }

    public static String getFileString() {
        return fileString;
    }

    public static void setFileString(String fileString) {
        FileHandle.fileString = fileString;
    }
    
    
    private Formatter output;
    private Scanner input;
    

    //method to check whether File exists or not
    public static boolean exist()throws Exception{
        
            File file=new File(fileString+".txt");
    
        return file.exists();
    }
    
    //method to read from File
    public String[] readFile(){
        String []data=new String[4];
        try{
            
        input=new Scanner(new File(fileString+".txt"));
       data[0]=input.next();
        data[1]=input.next();
        data[2]=input.next();
        data[3]=input.next();
        
        return data;
        }
        catch (Exception e){
            System.err.println("Exception: "+ e);
            e.printStackTrace();
            return data;
         //   System.exit(1);
        }
    }
    
    //method to write data on File
    public  void  write(String[] data){
        try{
        output=new Formatter(fileString+".txt");
 
        output.format("%s\n%s\n%s\n%s\n",data[0],data[1],data[2],data[3]);
           output.flush();
           output.close();
        }
        catch(Exception e){
            System.err.println("Exception: "+ e);
            e.printStackTrace();   
        }
    }
    
    //method to get pure Integer string
    public static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");
  
        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();
  
        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");
  
        if (str.equals(""))
            return "-1";
  
        str=str.replaceAll(" ","");
        return str;
    }
    
    //method to get File
    public static  File getFile(String fileName){
        File file=new File(fileName+".txt");
        return file;
    }
}