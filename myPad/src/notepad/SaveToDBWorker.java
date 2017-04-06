/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class SaveToDBWorker extends DatabaseWorker {
    
    String text = null;
    
    public SaveToDBWorker(String a) {
        
        this.text = a;
        
    }

    @Override
    protected Boolean doInBackground() throws Exception {
       
        String SQLCommand = null;
        
        try {

            this.createConnection();
            SQLCommand = "UPDATE file_db SET file_content ='" + this.text +"' WHERE file_id = 1";
            
            stm.executeQuery(SQLCommand);
           
            stm.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
     
        
        return true;
    }
    
}
