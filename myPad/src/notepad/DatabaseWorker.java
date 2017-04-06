/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingWorker;

/**
 *
 * @author andre
 */
public abstract class DatabaseWorker extends SwingWorker<Boolean,Void>{

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://andreiciobanu.database.windows.net:1433;database=TP;user=AndreiMW@andreiciobanu;password=Hesoyam555_;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
   
    protected Connection conn = null;
    protected Statement stm = null;
    
    protected void createConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL);
        stm = conn.createStatement();
        
    }
    
}
