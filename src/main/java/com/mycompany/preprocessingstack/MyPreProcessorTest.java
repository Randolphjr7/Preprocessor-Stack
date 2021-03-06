
package com.mycompany.preprocessingstack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author rando
 */
public class MyPreProcessorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        boolean done      = false;
        BasicFile f       = null;
        Delimeters a      = null;
        String stringFile = null;
        ImageIcon gears   = new ImageIcon("gears.png");
        ImageIcon error   = new ImageIcon("error.png");
        
        display("This is a Program that checks if your Java program is "
                + "syntactically correct", JOptionPane.INFORMATION_MESSAGE, 
                gears);

        while(!done)
        {
            String menu = "Enter option\n1. Try Sample Program\n2. Type in Java"
                    + " Program\n3. Select a Text File \n4. Quit";
            String s = (String)JOptionPane.showInputDialog(null,menu, "Enter a"
                    + " number");
            try
            {
                int i = Integer.parseInt(s);
                switch(i)
                {
                    case 1:
                       stringFile = new Scanner(new File("inputTestFile.txt"))
                               .useDelimiter("\\Z").next();
                        a = new Delimeters(stringFile);
                            if (a.isBalance()) {
                                System.out.println(stringFile + "  --> is valid"
                                        + " - with respect to delimeters\n");
                                display(stringFile, "File is Valid", JOptionPane
                                        .INFORMATION_MESSAGE);
                            }
                            else {
                                System.out.println(stringFile + "  --> is "
                                        + "invalid - with respect to "
                                        + "delimeters\n");
                                display(stringFile, "File is Invalid", 
                                        JOptionPane.ERROR_MESSAGE);
                            } 
                        break;
                    case 2:
                        String userInput = JOptionPane.showInputDialog("Type a"
                                + " simple Java program");
                        a = new Delimeters(userInput);
                            if (a.isBalance()) {
                                    System.out.println(userInput + "  --> is"
                                            + " valid - with respect to"
                                            + " delimeters\n");
                                    display(userInput, "Input is Valid",
                                            JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                                    System.out.println(userInput + "  --> is"
                                            + " invalid - with respect to"
                                            + " delimeters\n");
                                    display(userInput, "Input is Invalid",
                                            JOptionPane.ERROR_MESSAGE);                        
                            }
                        break;
                    case 3:
                        f = new BasicFile();
                        
                        if(f.getSelectedFile() == null) {
                              JOptionPane.showMessageDialog(null, "Please "
                                      + "choose a text file" ,"Error",
                                      JOptionPane.ERROR_MESSAGE);
                        } 
                        else {
                            stringFile = new Scanner(new File(f.getName()))
                                    .useDelimiter("\\Z").next();
                            a = new Delimeters(stringFile);
                            if (a.isBalance()) {
                                System.out.println(stringFile + "  --> is valid"
                                        + " - with respect to delimeters\n");
                                display(stringFile, "File is Valid",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                                System.out.println(stringFile + "  --> is"
                                        + " invalid - with respect to"
                                        + " delimeters\n");
                                display(stringFile, "File is Invalid",
                                        JOptionPane.ERROR_MESSAGE);
                            } 
                        }
                        break;
                    case 4:
                        done = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "This option is"
                                + " undefined" ,"Error",
                                JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            catch(NumberFormatException | NullPointerException | IOException e)
            {
                System.out.println(e.toString());
            }
        }    
        
    }
    
    static void display(String s, int MESSAGE_TYPE, ImageIcon picture) { 
        JOptionPane.showMessageDialog(null, s, "Java Preprocessor Check",
                MESSAGE_TYPE, picture);  
    }
    
    static void display(String s, String heading, int MESSAGE_TYPE) {
        JTextArea text = new JTextArea(s, 40, 70);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
    }
    
}
    

