package com.moai.animelist.vista;

import com.moai.animelist.controlador.*;
import javax.swing.JFrame;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class ListarAnos_Ventana extends javax.swing.JFrame 
{
    private final JFrame father;
    private final CollectionManagement llamar;
        
    /**
     * Creates new form ListarAnos
     * 
     * @param padre Menu principal
     * @param funcion Variable de clase CollectionManagement
     */
    public ListarAnos_Ventana(JFrame padre, CollectionManagement funcion)
    {
        initComponents();
        this.setLocationRelativeTo(null);
        father = padre;
        llamar = funcion;
        
        tablaDe_anos.setModel(new javax.swing.table.DefaultTableModel
        (
            llamar.getYears(),
            new String []
            {
                "Año"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        returnTo_menu_1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDe_anos = new javax.swing.JTable();
        title2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(200, 300));

        returnTo_menu_1.setText("Volver al Menu");
        returnTo_menu_1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                returnTo_menu_1ActionPerformed(evt);
            }
        });

        tablaDe_anos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null}
            },
            new String []
            {
                "Año"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false
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
        jScrollPane2.setViewportView(tablaDe_anos);

        title2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title2.setText("Lista de Años");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(returnTo_menu_1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(title2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(title2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(returnTo_menu_1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnTo_menu_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnTo_menu_1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnTo_menu_1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton returnTo_menu_1;
    private javax.swing.JTable tablaDe_anos;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
}
