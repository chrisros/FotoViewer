/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmlfotofissa;

/**
 *
 * @author Chris
 */
public class Leerling {
    
    private int Leerlingnummer;
    private String name;
    
    public Leerling(int lnr, String naam){
        Leerlingnummer = lnr;
        name = naam;
    }
    
    @Override
    public String toString(){
        return ""+Leerlingnummer;
    }
    
    public int getLnr(){
        return Leerlingnummer;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
}
