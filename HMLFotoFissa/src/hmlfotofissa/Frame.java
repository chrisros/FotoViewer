/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmlfotofissa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Chris
 */
public class Frame extends JFrame {

    GraphicsDevice device;
    fotoView oldPanel;
    StartScreen start;
    private boolean hasStarted = false;
    private ArrayList<Leerling> leerlingen = new ArrayList<>();
    int i = 0;
    boolean blackedOut = false;
    ListIterator<Leerling> iter;

    public Frame(String title, BufferedImage icon) throws FileNotFoundException {
        super(title);
        setIconImage(icon);
        setBackground(Color.BLACK);
        leerlingReader reader = new leerlingReader("src/leerlingen.txt");
        leerlingen = reader.getLeerlingNrs();
        GetKey keylistener = new GetKey(this);
        addKeyListener(keylistener);
        device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        goWindowed();
        iter = leerlingen.listIterator();
        Dimension size = new Dimension(1000, 600);
        setMinimumSize(size);
        start = new StartScreen();
        add(start);
    }

    public void goFullscreen() {
        removeNotify();
        setUndecorated(true);
        addNotify();
        setBackground(Color.BLACK);
        device.setFullScreenWindow(this);
        
    }

    public void goWindowed() {
        removeNotify();
        setUndecorated(false);
        addNotify();
        device.setFullScreenWindow(null);
        setSize(1000, 600);
        setLocationRelativeTo(null);        
        toFront();
    }
    
    public void blackOut(){
        
        oldPanel.blackOut(blackedOut);
        blackedOut = !blackedOut;
    }
    
    public void skip(){
        if(iter.hasNext()){iter.next();} 
        nextPicture(true);
    }

    public void nextPicture(boolean goForward) {
        if(!hasStarted){
            remove(start);
            hasStarted=true;
        }
        
        BufferedImage oldP;
        BufferedImage newP;
        String naam;
        Leerling curLnr = null;
        boolean canMove = false;
        
        if(iter.hasNext()&&goForward){
            curLnr = iter.next();
            canMove = true;
        } else if (iter.hasPrevious()&&!goForward){
            curLnr = iter.previous();
            canMove=true;
        }
        
        if (canMove){
        try {
            oldP = ImageIO.read(new File("src/fotosOud/" + curLnr.toString() + ".png"));
        } catch (IOException e) {
            oldP = null;
        }
        if(oldP == null){
            try {
                oldP = ImageIO.read(new File("src/fotosOud/" + curLnr.toString() + ".jpg"));
            } catch (IOException e) {
                oldP = null;
            }
        }
        try {
            newP = ImageIO.read(new File("src/fotosNieuw/" + curLnr.toString() + ".png"));
        } catch (IOException e) {
            newP = null;
        }
        if(newP == null){
            try {
                newP = ImageIO.read(new File("src/fotosNieuw/" + curLnr.toString() + ".jpg"));
            } catch (IOException e) {
                newP = null;
            }
        }
        naam = curLnr.toString();
        
        fotoView newPanel = new fotoView(oldP, newP, naam);
        newPanel.setFocusable(false);
        add(newPanel);    
        if(oldPanel!=null){
            remove(oldPanel);
        }
//        pack();
        //newPanel.paintPictures();
        revalidate();
        repaint();
        oldPanel=newPanel;
        i++;
    }else{
         fotoView newPanel = new fotoView(null, null, "");
        newPanel.setFocusable(false);
        add(newPanel);    
        if(oldPanel!=null){
            remove(oldPanel);
        }
        revalidate();
        repaint();
        oldPanel=newPanel;     
    }
        
    }

}
