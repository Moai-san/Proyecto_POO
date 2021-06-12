/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moai.animelist.vista;

import com.moai.animelist.controlador.CollectionManagement;
import javax.swing.JFrame;

/**
 *
 * @author moai
 */
public class ListarFiltrados_Ventana extends javax.swing.JFrame
{
    private final JFrame father;
    private final int option;
    private final CollectionManagement llamar;
    
    /**
     * Creates new form ListarFiltrados
     */
    public ListarFiltrados_Ventana(int opt, JFrame padre, CollectionManagement toUse)
    {
        initComponents();
        this.setLocationRelativeTo(null);
        errorDialog.setLocationRelativeTo(null);
        outputFiltro.setLocationRelativeTo(null);
        option=opt;
        father=padre;
        llamar =toUse;
        switch(option)
        {
            case 0:
            {
                labelCriterio.setText("Año");
                labelTitulo.setText("Ingrese el Año a buscar");
                break;
            }
            case 1:
            {
                labelCriterio.setText("Tipo");
                labelTitulo.setText("Ingrese el Tipo a buscar");
                break;
            }
            case 2:
            {
                labelCriterio.setText("Genero");
                labelTitulo.setText("Ingrese el Genero a buscar");
                break;
            }
        }
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

        outputFiltro = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFiltrados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        errorDialog = new javax.swing.JDialog();
        volverA_menuFrom_error = new javax.swing.JButton();
        tituloError = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelCriterio = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        returnTo_menu7 = new javax.swing.JButton();
        input = new javax.swing.JTextField();

        outputFiltro.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        outputFiltro.setAlwaysOnTop(true);
        outputFiltro.setResizable(false);
        outputFiltro.setSize(new java.awt.Dimension(1115, 551));

        tablaFiltrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "ID", "Nombre", "Tipo", "Capitulos", "Duracion", "Clasificacion de contenidos", "Año", "Estudio", "Genero(s)"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tablaFiltrados.setCellSelectionEnabled(true);
        tablaFiltrados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaFiltrados);

        jButton1.setText("Volver al Menu");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout outputFiltroLayout = new javax.swing.GroupLayout(outputFiltro.getContentPane());
        outputFiltro.getContentPane().setLayout(outputFiltroLayout);
        outputFiltroLayout.setHorizontalGroup(
            outputFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
            .addGroup(outputFiltroLayout.createSequentialGroup()
                .addGap(499, 499, 499)
                .addComponent(jButton1))
        );
        outputFiltroLayout.setVerticalGroup(
            outputFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputFiltroLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        errorDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        errorDialog.setAlwaysOnTop(true);
        errorDialog.setResizable(false);
        errorDialog.setSize(new java.awt.Dimension(400, 210));

        volverA_menuFrom_error.setText("Volver al Menu");
        volverA_menuFrom_error.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                volverA_menuFrom_errorActionPerformed(evt);
            }
        });

        tituloError.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tituloError.setText("ERROR!!");

        javax.swing.GroupLayout errorDialogLayout = new javax.swing.GroupLayout(errorDialog.getContentPane());
        errorDialog.getContentPane().setLayout(errorDialogLayout);
        errorDialogLayout.setHorizontalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogLayout.createSequentialGroup()
                .addGroup(errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(errorDialogLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(volverA_menuFrom_error, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(errorDialogLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(tituloError)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        errorDialogLayout.setVerticalGroup(
            errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(errorDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tituloError)
                .addGap(76, 76, 76)
                .addComponent(volverA_menuFrom_error)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(430, 300));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitulo.setText("Ingrese el  a buscar");

        labelCriterio.setText("Criterio");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botonBuscarActionPerformed(evt);
            }
        });

        returnTo_menu7.setText("Volver al Menu");
        returnTo_menu7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                returnTo_menu7ActionPerformed(evt);
            }
        });

        input.setOpaque(false);
        input.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                inputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnTo_menu7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCriterio)
                        .addGap(32, 32, 32)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelTitulo)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCriterio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar)
                    .addComponent(returnTo_menu7))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void clearFields()
    {
        input.setText("");
    }
    
    private int rellenarTabla_filtros(Object tablaFiltros[][], javax.swing.JTable a)
    {
        if (tablaFiltros==null)
        {
            return(-1);
        }
        else
        {
            a.setModel(new javax.swing.table.DefaultTableModel
            (
                tablaFiltros,
                new String []
                {
                    "ID", "Nombre", "Tipo", "Capitulos", "Duracion", "Clasificacion de contenidos", "Año", "Estudio", "Genero(s)"
                }
            )
            {
                Class[] types = new Class []
                {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean []
                {
                    false, false, false, false, false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex)
                {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex)
                {
                    return canEdit [columnIndex];
                }
            });
        }
        return(0);
    }
    
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_botonBuscarActionPerformed
    {//GEN-HEADEREND:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        String ano1=input.getText();
        Object tablaFiltros[][] =null;
        tablaFiltros =llamar.mostrarPor_filtro(tablaFiltros, ano1, option);
        int exist =rellenarTabla_filtros(tablaFiltros,tablaFiltrados);
        clearFields();
        this.setVisible(false);
        if(exist!=0)
        {
            errorDialog.setVisible(true);
            return;
        }
        outputFiltro.setVisible(true);
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void returnTo_menu7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_returnTo_menu7ActionPerformed
    {//GEN-HEADEREND:event_returnTo_menu7ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        clearFields();
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnTo_menu7ActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_inputActionPerformed
    {//GEN-HEADEREND:event_inputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        outputFiltro.dispose();
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void volverA_menuFrom_errorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_volverA_menuFrom_errorActionPerformed
    {//GEN-HEADEREND:event_volverA_menuFrom_errorActionPerformed
        // TODO add your handling code here:
        errorDialog.dispose();
        this.dispose();
        father.setVisible(true);
    }//GEN-LAST:event_volverA_menuFrom_errorActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JDialog errorDialog;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCriterio;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JDialog outputFiltro;
    private javax.swing.JButton returnTo_menu7;
    private javax.swing.JTable tablaFiltrados;
    private javax.swing.JLabel tituloError;
    private javax.swing.JButton volverA_menuFrom_error;
    // End of variables declaration//GEN-END:variables
}