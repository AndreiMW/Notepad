/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 *
 * @author andre
 */
public class LoadWorker extends SwingWorker<Boolean,Integer>{

    private JTextArea textArea;
    private File loadFile;
    
    public LoadWorker (JTextArea ta, File file) 
    {
        this.textArea = ta;
        this.loadFile = file;
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
               
        String fileName = this.loadFile.toString();
         try{
            String content = new Scanner(this.loadFile).useDelimiter("\\Z").next();
            this.textArea.setText(content);
            
        }catch(FileNotFoundException fne){
            System.out.println("File not found.");
        }
       return true;
    }
    
    
    
}
