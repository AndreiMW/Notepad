/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.nio.file.Path;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class AFCTextArea extends JScrollPane {
    
    public TextLineNumber lineNumber;
    public Path path;
    public JTextArea textArea = new JTextArea();
    
    public AFCTextArea()
    {
        super();
        this.textArea = new JTextArea();
        this.setViewportView(this.textArea);
        this.lineNumber = new TextLineNumber(this.textArea);
        this.setRowHeaderView(this.lineNumber);
        this.textArea.setColumns(20);
        this.textArea.setRows(5);
        
    }
    
    public String getFileName()
    {
        return this.path.getFileName().toString();
    }
}
