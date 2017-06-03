/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author andre
 */
public class LogInFrame extends javax.swing.JFrame {

    static Integer userIndex = 0;

    public LogInFrame() {
        initComponents();
        getContentPane().setLayout(null);

        progressBar.setVisible(false);
        logginInLabel.setVisible(false);
        new ProgressBarColor();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        createButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        logginInLabel = new javax.swing.JLabel();
        loginBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 90, 40));

        usernameField.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setBorder(null);
        usernameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, 32));
        usernameField.setOpaque(false);
        usernameField.setBackground(new Color(0,0,0,0));

        passwordField.setFont(new java.awt.Font("Bauhaus 93", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 140, 32));
        passwordField.setOpaque(false);
        passwordField.setBackground(new Color(0,0,0,0));

        createButton.setText("Create");
        createButton.setPreferredSize(new java.awt.Dimension(57, 23));
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 90, 40));

        progressBar.setIndeterminate(true);
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        logginInLabel.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        logginInLabel.setForeground(new java.awt.Color(255, 255, 255));
        logginInLabel.setText("Logging in...");
        getContentPane().add(logginInLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 100, -1));

        loginBackground.setIcon(new javax.swing.ImageIcon("D:\\Java Projects\\myPad\\resources\\loginImage.jpg")); // NOI18N
        getContentPane().add(loginBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        String loginUser = usernameField.getText();
        char[] passwordUser = passwordField.getPassword();
        String passwordUserString = "";

        for (int i = 0; i < passwordUser.length; i++) {
            passwordUserString += passwordUser[i];
        }

        LoginWorker lw = new LoginWorker(loginUser, passwordUserString, this) {

            @Override
            protected void done() {

                progressBar.setVisible(false);
                logginInLabel.setVisible(false);

            }
        };
        lw.execute();
        progressBar.setVisible(true);
        logginInLabel.setVisible(true);


    }//GEN-LAST:event_loginButtonActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed

        new CreateAccountFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createButtonActionPerformed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginButton.doClick();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JLabel logginInLabel;
    private javax.swing.JLabel loginBackground;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

}
