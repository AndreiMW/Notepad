/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;

/**
 *
 * @author andre
 */
public class OpenFromDBWorker extends DatabaseWorker {
    
    JTextArea openText;
    notepadd n = new notepadd();
    
    public OpenFromDBWorker(JTextArea a,notepadd b) {
        
        this.openText = a;
        this.n  = b;
        
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        
        String SQLCommand = null;
        
        try{
            this.createConnection();
            
            SQLCommand = "SELECT file_content FROM file_DB WHERE file_id LIKE " + n.getIndex();
            ResultSet rs = stm.executeQuery(SQLCommand);
            
            rs.next();
            this.openText.setText(rs.getString("file_content"));
           
     
        }catch(SQLException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
    
}
