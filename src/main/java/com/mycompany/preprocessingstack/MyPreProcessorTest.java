
package com.mycompany.preprocessingstack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author rando
 */
public class MyPreProcessorTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
   
        System.out.println("\n\nTesting Scanner to Read File\n");
        
        try {
            // reads entire file
            String stringFile = new Scanner(new File("inputTestFile.txt"))
                    .useDelimiter("\\Z").next();
            
            Delimeters a = new Delimeters(stringFile);
       
            if (a.isBalance()) {
                System.out.println(stringFile + "  --> is valid - with respect "
                        + "to parenthesis\n");
		}
            else
                System.out.println(stringFile + "  --> is invalid - with "
                        + "respect to parenthesis\n");
            
        }
        catch(FileNotFoundException e) {
            System.out.println("Error:\n" + e.toString());
        }      
    }
    
}
