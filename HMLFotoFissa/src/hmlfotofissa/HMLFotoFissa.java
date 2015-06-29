/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmlfotofissa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.imageio.ImageIO;





/**
 *
 * @author Chris
 */
public class HMLFotoFissa {

    /**
     * @param args the command line arguments
     */
    

public static void main(String[] args) throws FileNotFoundException {
    BufferedImage icon;
    try {
        icon = ImageIO.read(new File("src/logo.png"));
    } catch (Exception e) {
        icon = null;
    }
    Frame frame = new Frame("Examenuitrijking Fotoviewer", icon);
    //frame.setLayout(null);
   
    
   
    

}
    
}
