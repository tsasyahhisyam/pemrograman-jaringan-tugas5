package linenumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFileReader {
    
    public static void main(String[] args) {
        
        Scanner br1 = new Scanner(System.in);
        try {
                 int desimal;
                 char ascii;
                 
                 String line = null;
                 int wordCount = 0;
                 int characterCount = 0;
                 
                 LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("coba.txt"));
                 
                 Scanner sc = new Scanner(System.in);
                 System.out.print("Masukkan Kata     : ");
                 String input = sc.next();
                 
                 while((line = lineNumberReader.readLine()) != null){
                     String[] wordList = line.split("\\s+");
                     characterCount += line.length();
                     wordCount += wordList.length;
                     
                     for(int i=0; i<wordList.length; i++){
                         String word = wordList[i];
                         if(input.equals(word)){
                             System.out.println("" + word + " at Line " +(lineNumberReader.getLineNumber() -1));
                         }
                     }
                     
                 }
                 lineNumberReader.close();
                 System.out.println("");
                 System.out.println("Jumlah Kata     : " +wordCount);
                 System.out.println("Jumlah Karakter : "+characterCount);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
             }
    }   
}