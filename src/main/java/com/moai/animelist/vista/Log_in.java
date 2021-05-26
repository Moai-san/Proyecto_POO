package com.moai.animelist.vista;

import com.moai.animelist.controlador.*;
import com.moai.animelist.modelo.*;
import java.io.*;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class Log_in extends javax.swing.JFrame
{
    private static User_Management llamar =new User_Management();
    private String username;
    
    /**
     * Creates new form Log_in
     */
    public Log_in()
    {
        initComponents();
        setLocationRelativeTo(null);
        exito.setLocationRelativeTo(null);
        noExiste.setLocationRelativeTo(null);
        yaExiste.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        noExiste = new javax.swing.JDialog();
        errorTitle = new javax.swing.JLabel();
        returnTo_login1 = new javax.swing.JButton();
        yaExiste = new javax.swing.JDialog();
        yaExiste_title = new javax.swing.JLabel();
        returnTo_login2 = new javax.swing.JButton();
        exito = new javax.swing.JDialog();
        exitoTitle = new javax.swing.JLabel();
        returnTo_login3 = new javax.swing.JButton();
        loginTitle = new javax.swing.JLabel();
        loginInstruction = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        noExiste.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        noExiste.setAlwaysOnTop(true);
        noExiste.setResizable(false);
        noExiste.setSize(new java.awt.Dimension(400, 300));

        errorTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        errorTitle.setText("USUARIO NO EXISTE!!");

        returnTo_login1.setText("Volver al login");
        returnTo_login1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                returnTo_login1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noExisteLayout = new javax.swing.GroupLayout(noExiste.getContentPane());
        noExiste.getContentPane().setLayout(noExisteLayout);
        noExisteLayout.setHorizontalGroup(
            noExisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noExisteLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(noExisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noExisteLayout.createSequentialGroup()
                        .addComponent(errorTitle)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noExisteLayout.createSequentialGroup()
                        .addComponent(returnTo_login1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))))
        );
        noExisteLayout.setVerticalGroup(
            noExisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noExisteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(errorTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(returnTo_login1)
                .addGap(57, 57, 57))
        );

        yaExiste.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        yaExiste.setAlwaysOnTop(true);
        yaExiste.setResizable(false);
        yaExiste.setSize(new java.awt.Dimension(400, 300));

        yaExiste_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        yaExiste_title.setText("USUARIO YA EXISTE!!");

        returnTo_login2.setText("Volver al Login");
        returnTo_login2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                returnTo_login2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yaExisteLayout = new javax.swing.GroupLayout(yaExiste.getContentPane());
        yaExiste.getContentPane().setLayout(yaExisteLayout);
        yaExisteLayout.setHorizontalGroup(
            yaExisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yaExisteLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(yaExisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yaExisteLayout.createSequentialGroup()
                        .addComponent(yaExiste_title)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yaExisteLayout.createSequentialGroup()
                        .addComponent(returnTo_login2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );
        yaExisteLayout.setVerticalGroup(
            yaExisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yaExisteLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(yaExiste_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(returnTo_login2)
                .addGap(87, 87, 87))
        );

        exito.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        exito.setAlwaysOnTop(true);
        exito.setResizable(false);
        exito.setSize(new java.awt.Dimension(400, 300));

        exitoTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exitoTitle.setText("Usuario Registrado Correctamente!!");

        returnTo_login3.setText("Volver al Login");
        returnTo_login3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                returnTo_login3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exitoLayout = new javax.swing.GroupLayout(exito.getContentPane());
        exito.getContentPane().setLayout(exitoLayout);
        exitoLayout.setHorizontalGroup(
            exitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(exitoTitle)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(returnTo_login3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        exitoLayout.setVerticalGroup(
            exitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(exitoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(returnTo_login3)
                .addGap(65, 65, 65))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(595, 383));

        loginTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginTitle.setText("Bienvenid@ a Moai AnimeList");

        loginInstruction.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginInstruction.setText("Ingrese sus datos para iniciar sesion:");

        usernameLabel.setText("Username");

        passwordLabel.setText("Contraseña");

        loginButton.setText("Iniciar sesion");
        loginButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loginButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Cerrar Aplicacion");
        closeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Registrarse");
        registerButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginInstruction)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginTitle)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(loginTitle)
                .addGap(18, 18, 18)
                .addComponent(loginInstruction)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(registerButton))
                .addGap(33, 33, 33)
                .addComponent(closeButton)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearFields()
    {
        usernameField.setText("");
        passwordField.setText("");
    }
    
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_registerButtonActionPerformed
    {//GEN-HEADEREND:event_registerButtonActionPerformed
        // TODO add your handling code here:
        String pwd =new String(passwordField.getPassword());
        String user =llamar.sign_up(usernameField.getText(), pwd);
        if(user==null)
        {
            this.setVisible(false);
            yaExiste.setVisible(true);
        }
        else
        {
            this.setVisible(false);
            exito.setVisible(true);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loginButtonActionPerformed
    {//GEN-HEADEREND:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String pwd = new String(passwordField.getPassword());
        String flag = "";
        try
        {
            flag =llamar.log_me(usernameField.getText(), pwd);
            if(flag==null)
            {
                this.setVisible(false);
                noExiste.setVisible(true);
                return;
            }
        }
        catch(IOException e)
        {}
        username =flag;
        clearFields();
        this.setVisible(false);
        try
        {
            Menu menu;
            if (username.equals("admin"))
            {
                menu = new Menu(new UsuarioAdministrador("admin","admin"));
            }
            else
            {
                menu = new Menu(new UsuarioComun(flag,pwd));
            }
            menu.setVisible(true);
            dispose();
        }
        catch(IOException e){}
    }//GEN-LAST:event_loginButtonActionPerformed

    private void returnTo_login1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_returnTo_login1ActionPerformed
    {//GEN-HEADEREND:event_returnTo_login1ActionPerformed
        // TODO add your handling code here:
        noExiste.dispose();
        clearFields();
        this.setVisible(true);
    }//GEN-LAST:event_returnTo_login1ActionPerformed

    private void returnTo_login2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_returnTo_login2ActionPerformed
    {//GEN-HEADEREND:event_returnTo_login2ActionPerformed
        // TODO add your handling code here:
        yaExiste.dispose();
        clearFields();
        this.setVisible(true);
    }//GEN-LAST:event_returnTo_login2ActionPerformed

    private void returnTo_login3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_returnTo_login3ActionPerformed
    {//GEN-HEADEREND:event_returnTo_login3ActionPerformed
        // TODO add your handling code here:
        exito.dispose();
        clearFields();
        this.setVisible(true);
    }//GEN-LAST:event_returnTo_login3ActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeButtonActionPerformed
    {//GEN-HEADEREND:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel errorTitle;
    private javax.swing.JDialog exito;
    private javax.swing.JLabel exitoTitle;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginInstruction;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JDialog noExiste;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton returnTo_login1;
    private javax.swing.JButton returnTo_login2;
    private javax.swing.JButton returnTo_login3;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JDialog yaExiste;
    private javax.swing.JLabel yaExiste_title;
    // End of variables declaration//GEN-END:variables
}
