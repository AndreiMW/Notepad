/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;


import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class LoginWorker extends DatabaseWorker {
    
    String workerUser = null;
    String workerPassword = null;
    final notepadd n = new notepadd();
    
    LogInFrame workerLogin = new LogInFrame();
    
    public Integer indexx = 0;
    
    private boolean succesfulLogin = false;
    
    public LoginWorker(String a,String b,LogInFrame c){
        
        this.workerUser = a;
        this.workerPassword = b;
        this.workerLogin = c;
    }
  
    @Override
    protected Boolean doInBackground() throws Exception {
        
        String SQLCommand = null;
        String SQLCommand2 = null;
     
        try {

            this.createConnection();
            
            ResultSet getCredentials;
            ResultSet getIndex;

            SQLCommand = "SELECT COUNT(1) FROM AFC WHERE Utilizator LIKE '" + workerUser + "' AND Parola LIKE '" + workerPassword +"'";
            
            SQLCommand2 = "SELECT Intrare FROM AFC WHERE Utilizator LIKE '" + workerUser + "' AND Parola LIKE '" + workerPassword +"'";
            getIndex = stm.executeQuery(SQLCommand2);
            
            getIndex.next();
            this.indexx = getIndex.getInt("Intrare");
            
            getCredentials = stm.executeQuery(SQLCommand);
            getCredentials.next();
            
            Integer index = getCredentials.getInt(1);
            
            if(index == 1){
                succesfulLogin = true;
            }
            
            getCredentials.close();
            stm.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
     
        if(succesfulLogin){ 
            
            n.setLabel("Logged in as: " + workerUser);
            n.setVisible(true);
            n.setIndex(this.indexx);
            this.workerLogin.setVisible(false);
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Username or password is incorrect ", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        return true;
    }
   
}


    

