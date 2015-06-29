/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hmlfotofissa;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Chris
 */
public class GetKey implements KeyListener{

    private Frame frame;
    
    public GetKey(Frame fr){
        frame = fr;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        int keyCode = e.getKeyCode();
        
        switch (keyCode){
            case 8:
                //enter
                frame.nextPicture(false);
                break;
            case 32:
                //space
                frame.nextPicture(true);
                break;
            case 66:
                //b
                frame.blackOut();
                break;                
            case 83:
                //s
                frame.skip();
                break;
            case 27:
                //esc
                frame.goWindowed();
                break;
            case 70:
                //f
                frame.goFullscreen();
                break;
            
        }
        
    }
    
    
    //unused methods
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
