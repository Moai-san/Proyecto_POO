/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moai.animelist.vista;

import com.moai.animelist.modelo.Anime;
import com.moai.animelist.controlador.CollectionManagement;
import javax.swing.JFrame;

/**
 *
 * @author moai
 */
public class AddAnime_Window extends javax.swing.JFrame
{

    final JFrame father;
    private final CollectionManagement llamar;
    
    /**
     * Creates new form addAnime_Window
     */
    public AddAnime_Window(JFrame padre, CollectionManagement toUse)
    {
        initComponents();
        llamar =toUse;
        father =padre;
        this.setLocationRelativeTo(null);
    }

    public void clearFields()
    {
        id_input.setText("");
        name_input.setText("");
        type_input.setText("");
        episodes_input.setText("");
        duration_input.setText("");
        rating_input.setText("");
        year_input.setText("");
        studio_input.setText("");
        genre_input.setText("");
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

        iD_display = new javax.swing.JLabel();
        id_input = new javax.swing.JTextField();
        nameDisplay = new javax.swing.JLabel();
        name_input = new javax.swing.JTextField();
        typeDisplay = new javax.swing.JLabel();
        type_input = new javax.swing.JTextField();
        chaptersDisplay = new javax.swing.JLabel();
        episodes_input = new javax.swing.JTextField();
        durationDisplay = new javax.swing.JLabel();
        duration_input = new javax.swing.JTextField();
        ratingDisplay = new javax.swing.JLabel();
        rating_input = new javax.swing.JTextField();
        yearDisplay = new javax.swing.JLabel();
        year_input = new javax.swing.JTextField();
        studioDisplay = new javax.swing.JLabel();
        studio_input = new javax.swing.JTextField();
        genreDisplay = new javax.swing.JLabel();
        genre_input = new javax.swing.JTextField();
        Ingresar = new javax.swing.JButton();
        returnTo_menu = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(550, 550));

        iD_display.setText("iD");
        iD_display.setFocusable(false);

        id_input.setOpaque(false);

        nameDisplay.setText("Nombre");
        nameDisplay.setFocusable(false);

        name_input.setOpaque(false);

        typeDisplay.setText("Tipo");
        typeDisplay.setFocusable(false);

        type_input.setOpaque(false);

        chaptersDisplay.setText("Capitulos");
        chaptersDisplay.setFocusable(false);

        episodes_input.setOpaque(false);

        durationDisplay.setText("Duracion");
        durationDisplay.setFocusable(false);

        duration_input.setOpaque(false);

        ratingDisplay.setText("Publico Objetivo");
        ratingDisplay.setFocusable(false);

        rating_input.setOpaque(false);

        yearDisplay.setText("Año");
        yearDisplay.setFocusable(false);

        year_input.setOpaque(false);

        studioDisplay.setText("Estudio");
        studioDisplay.setFocusable(false);

        studio_input.setOpaque(false);

        genreDisplay.setText("Genero");
        genreDisplay.setFocusable(false);

        genre_input.setOpaque(false);

        Ingresar.setText("Ingresar");
        Ingresar.setFocusable(false);
        Ingresar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                IngresarActionPerformed(evt);
            }
        });

        returnTo_menu.setText("Volver al Menu");
        returnTo_menu.setFocusable(false);
        returnTo_menu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                returnTo_menuActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setText("Ingrese Datos Del Anime A Agregar");
        title.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iD_display, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studioDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ratingDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durationDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chaptersDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(returnTo_menu))
                            .addComponent(name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(episodes_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duration_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rating_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studio_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genre_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(title)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iD_display))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameDisplay)
                    .addComponent(name_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeDisplay)
                    .addComponent(type_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(episodes_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chaptersDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duration_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(durationDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rating_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studio_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studioDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genre_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreDisplay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnTo_menu)
                    .addComponent(Ingresar))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_IngresarActionPerformed
    {//GEN-HEADEREND:event_IngresarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(id_input.getText());
        String name = name_input.getText();
        if(name.startsWith("\"")==false)
        {
            if(name.endsWith("\"\n")==false)
            {
                name =("\""+name+"\"");
            }
        }
        String type = type_input.getText();
        int episodes = Integer.parseInt(episodes_input.getText());
        String duration = duration_input.getText();
        String rating = rating_input.getText();
        int year = Integer.parseInt(year_input.getText());
        String studio = studio_input.getText();
        if(studio.startsWith("\"")==false)
        {
            if(studio.endsWith("\"\n")==false)
            {
                studio =("\""+studio+"\"");
            }
        }
        String genre = genre_input.getText();
        if(genre.startsWith("\"")==false)
        {
            if(genre.endsWith("\"\n")==false)
            {
                genre =("\""+genre+"\"");
            }
        }
        Anime newanime = new Anime(id,name,type,episodes,duration,rating,year,studio,genre);
        llamar.addAnime(newanime);
        this.setVisible(false);
        clearFields();
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_IngresarActionPerformed

    private void returnTo_menuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_returnTo_menuActionPerformed
    {//GEN-HEADEREND:event_returnTo_menuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        clearFields();
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnTo_menuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ingresar;
    private javax.swing.JLabel chaptersDisplay;
    private javax.swing.JLabel durationDisplay;
    private javax.swing.JTextField duration_input;
    private javax.swing.JTextField episodes_input;
    private javax.swing.JLabel genreDisplay;
    private javax.swing.JTextField genre_input;
    private javax.swing.JLabel iD_display;
    private javax.swing.JTextField id_input;
    private javax.swing.JLabel nameDisplay;
    private javax.swing.JTextField name_input;
    private javax.swing.JLabel ratingDisplay;
    private javax.swing.JTextField rating_input;
    private javax.swing.JButton returnTo_menu;
    private javax.swing.JLabel studioDisplay;
    private javax.swing.JTextField studio_input;
    private javax.swing.JLabel title;
    private javax.swing.JLabel typeDisplay;
    private javax.swing.JTextField type_input;
    private javax.swing.JLabel yearDisplay;
    private javax.swing.JTextField year_input;
    // End of variables declaration//GEN-END:variables
}
