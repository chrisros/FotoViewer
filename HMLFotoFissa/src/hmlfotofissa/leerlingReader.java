/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmlfotofissa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chris
 */
public class leerlingReader {
   
    private Scanner inFile1;
    private ArrayList<Leerling> leerlingen = new ArrayList<>();
    
    public leerlingReader(String path) throws FileNotFoundException{
            inFile1 = new Scanner(new File(path));  
            
    }
    
    private int getLeerlingNummer(String LnrStr){
        int leerlingnummer = 0;
        LnrStr = stripNonDigits(LnrStr);
        if(LnrStr.length()>3){
        leerlingnummer = Integer.parseInt(LnrStr);
        }
        return leerlingnummer;
    }
    
    private String getLeerlingNaam(String lnrStr){
        String LeerlingNaam;
        LeerlingNaam = lnrStr.replaceAll("[0-9]","");
        return LeerlingNaam;
    }
    
    public ArrayList getLeerlingen(){
        
         while (inFile1.hasNextLine()) {
               String lnrStr = inFile1.nextLine();
               System.out.println(lnrStr);
               if(lnrStr!=null){
                    int lnr =  getLeerlingNummer(lnrStr);
                    String naam = getLeerlingNaam(lnrStr);
                    if (lnr==0){
                    } else {
                        Leerling curLeerling = new Leerling(lnr, naam);
                        leerlingen.add(curLeerling);
                   }
               }
         }

        return leerlingen;
    }
    
    public static String stripNonDigits(
            final CharSequence input /* inspired by seh's comment */){
    final StringBuilder sb = new StringBuilder(
            input.length() /* also inspired by seh's comment */);
    for(int i = 0; i < input.length(); i++){
        final char c = input.charAt(i);
        if(c > 47 && c < 58){
            sb.append(c);
        }
    }
    return sb.toString();
}
}
