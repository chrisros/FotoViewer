package hmlfotofissa;

/**
 *
 * @author Chris
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class FileChooser extends JFileChooser{
    
    public FileChooser(boolean folderOnly){
        
        setCurrentDirectory(new java.io.File("."));
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setAcceptAllFileFilterUsed(false);
            if (showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      System.out.println("getCurrentDirectory(): " 
         +  this.getCurrentDirectory());
      System.out.println("getSelectedFile() : " 
         +  this.getSelectedFile());
      }
    else {
      System.out.println("No Selection ");
      }
    }


    
}
