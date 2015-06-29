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
    
    public ArrayList getLeerlingNrs(){
        int i = 0;
         while (inFile1.hasNext()) {
               int lnr = Integer.parseInt(inFile1.next()); 
               Leerling curLeerling = new Leerling(lnr); 
               leerlingen.add(curLeerling);
         }

        return leerlingen;
    }
}
