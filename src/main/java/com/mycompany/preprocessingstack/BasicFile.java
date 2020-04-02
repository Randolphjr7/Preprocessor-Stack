package com.mycompany.preprocessingstack;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author rando
 */
public class BasicFile {
    
    File f;
    
    public BasicFile() {
        
        JFileChooser choose = new JFileChooser(".");
        int status = choose.showOpenDialog(null);
        
        try {
            if(status != JFileChooser.APPROVE_OPTION) {
                throw new IOException();
            }
            
            f = choose.getSelectedFile();
            
            if(!f.exists()) {
                throw new FileNotFoundException();
            }
            
            display(f.getName(), "File has been choosen", 
                    JOptionPane.INFORMATION_MESSAGE);
                    
        }
        catch(FileNotFoundException e) {
            
        }
        catch(IOException e) {
            
        }
    }
    
    String getName() {
        return f.getName();
    }
    
    File getSelectedFile() {
        return f.getAbsoluteFile();
    }
    
    void listRecursive(File dir) {
        if(dir.isDirectory()) {
            File [] x = dir.listFiles();
            for (File i: x) {
                if(i.isFile()) {
                    System.out.println("\tFile: " + i.getAbsoluteFile());
                }
                else {
                    System.out.println("Directory: " + i.getName());
                    listRecursive(i);
                }
            }
        }
    }
    
    void displayMessage(String a, String heading, int MESSAGE_TYPE) {
        JTextArea text = new JTextArea(a, 20, 40);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
    }
    
    void display(String msg, String s, int t) {
        JOptionPane.showMessageDialog(null, msg, s, t);
    }
    
   
    
    // reads data from a file, then appends to another file
    void append() {
        
        FileOutputStream fos = null;
        try { // Create DataInputStream obj
            f.canRead();
            DataInputStream dis = 
                    new DataInputStream(new FileInputStream(f.getPath()));
      
            fos = new FileOutputStream("a2.text", true);
            
            int length = dis.available(); // available stream to be read
            byte[] buf = new byte[length]; // create buffer
            dis.readFully(buf); // read the full data into the buffer
            
            display("a2.text", "File is being appended", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            fos.write(buf, 0, buf.length);
            fos.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Error while opening file: \n" + e);
        }
        catch(IOException e) {
            System.out.println("Error while reading stream: \n" + e);
        }
    }
    
    // reads data from a file, then overwrites to another file
    void overwrite() {
        
        FileOutputStream fos = null;
        try { // Create DataInputStream obj
            f.canRead();
            DataInputStream dis = 
                    new DataInputStream(new FileInputStream(f.getPath()));
      
            fos = new FileOutputStream("outputSample.text");
            
            int length = dis.available(); // available stream to be read
            byte[] buf = new byte[length]; // create buffer
            dis.readFully(buf); // read the full data into the buffer
            
            display("outputSample.text", "File is being overwritten", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            fos.write(buf, 0, buf.length);
            fos.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Error while opening file: \n" + e);
        }
        catch(IOException e) {
            System.out.println("Error while reading stream: \n" + e);
        }
    }
    
    String getPath() {
        // returns the absolute path of the file/directory referenced by the 
        // current file obj
        return f.getAbsolutePath();
    }
    
    long getFileSize() {
        return f.length();
    }
    
    String canRead() {
        // check if you are permitted to read from the file 
        return (f.canRead())? "This file can be opened for reading" : "Cannot "
                + "read this file";
    }
    
    String directoryOrFile() {
        // check if the obj is directory 
        return (f.isDirectory())? "This is a directory and not an ordinary file"
                : "This is a file and not a directory";
    }
    
    String testing() {
        return f.getParent();
    }
    
//    String exists() {
//        return (f.exists())? "The physical file exists" : "The physical file "
//                + "does not exist";
//    }
    
}
