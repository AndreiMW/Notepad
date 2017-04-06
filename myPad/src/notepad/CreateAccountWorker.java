/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author andre
 */
public class CreateAccountWorker extends DatabaseWorker {

    String createUser = null;
    String createPassword = null;
    CreateAccountFrame createAccountWorker;
    Boolean userExists = false;

    public CreateAccountWorker(String a, String b, CreateAccountFrame c) {

        this.createUser = a;
        this.createPassword = b;
        this.createAccountWorker = c;

    }

    @Override
    protected Boolean doInBackground() throws Exception {

        String createUserCommand = null;
        String getMaxIndex = null;
        String getUsernames = null;

        try {

            this.createConnection();

            getMaxIndex = "SELECT Intrare FROM AFC\n"
                    + "WHERE Intrare = (\n"
                    + "    SELECT MAX(Intrare) FROM AFC)";
            ResultSet rs = stm.executeQuery(getMaxIndex);
            Integer index = 0;

            while (rs.next()) {
                index = rs.getInt("Intrare");
            }

            createUserCommand = "INSERT INTO AFC(Intrare,Utilizator,Parola) VALUES(" + (index + 1) + ",'" + this.createUser + "','" + this.createPassword + "')";

            getUsernames = "SELECT Utilizator FROM AFC";
            ResultSet rsuser = stm.executeQuery(getUsernames);

            while (rsuser.next()) {
                if (this.createUser.equals(rsuser.getString("Utilizator"))) {
                    this.userExists = true;
                }

            }

            if (userExists) {
                JOptionPane.showMessageDialog(null, "Username already exists ", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                stm.executeUpdate(createUserCommand);
                new LogInFrame().setVisible(true);
                this.createAccountWorker.setVisible(false);
            }
            rs.close();
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
