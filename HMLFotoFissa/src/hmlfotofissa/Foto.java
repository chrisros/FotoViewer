/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmlfotofissa;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Chris
 */
public class Foto extends JComponent{
    
    private BufferedImage image;
    private int height;
    private int width;
    public Foto(BufferedImage img, int w, int h){
       super();
       image = img; 
       width = w;
       height = h;
    }
    
    @Override
    public void paintComponent(Graphics g){
        //maakt een component met een bepaalde hoeveelheid squares
        
        try {
            g.drawImage(image, 0,0, width, height, null);
            setVisible(true);
            
        } catch (Exception e) {
            g.fillRect(0, 0, 0, 0);
            setVisible(true);
        }           
    }
    
}
