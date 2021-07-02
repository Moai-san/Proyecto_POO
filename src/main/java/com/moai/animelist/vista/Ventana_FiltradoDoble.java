package com.moai.animelist.vista;

import com.moai.animelist.controlador.CollectionManagement;
import javax.swing.JFrame;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class Ventana_FiltradoDoble extends javax.swing.JFrame implements Interface_LimpiezaVentanas
{
    private final JFrame father;
    private final CollectionManagement llamar;
    
    /**
     * Creates new form Ventana_FiltradoDoble
     * 
     * @param padre Menu principal
     * @param toUse Variable de clase CollectionManagement
     */
    public Ventana_FiltradoDoble(JFrame padre, CollectionManagement toUse)
    {
        initComponents();
        llamar =toUse;
        father =padre;
        this.setLocationRelativeTo(null);
        outputFiltro.setLocationRelativeTo(null);
        errorDialog.setLocationRelativeTo(null);
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
        doubleFilter_filterButton = new javax.swing.JButton();
        backTo_menuButton = new javax.swing.JButton();
        genre2_field = new javax.swing.JTextField();
        genre2_label = new javax.swing.JLabel();
        genre1_label = new javax.swing.JLabel();
        genre1_field = new javax.swing.JTextField();
        title2ble = new javax.swing.JLabel();

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
        setResizable(false);
        setSize(new java.awt.Dimension(439, 300));

        doubleFilter_filterButton.setText("Filtrar");
        doubleFilter_filterButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                doubleFilter_filterButtonActionPerformed(evt);
            }
        });

        backTo_menuButton.setText("Volver al Menu");
        backTo_menuButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backTo_menuButtonActionPerformed(evt);
            }
        });

        genre2_label.setText("Genero 2");

        genre1_label.setText("Genero 1");

        title2ble.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title2ble.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2ble.setText("Escriba los 2 Generos");
        title2ble.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title2ble, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(doubleFilter_filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backTo_menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(genre1_label)
                                .addComponent(genre2_label))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(genre2_field, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(genre1_field)))))
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(title2ble)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genre1_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genre1_label))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genre2_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genre2_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doubleFilter_filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backTo_menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void clearFields()
    {
        genre1_field.setText("");
        genre2_field.setText("");
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
    
    private void doubleFilter_filterButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_doubleFilter_filterButtonActionPerformed
    {//GEN-HEADEREND:event_doubleFilter_filterButtonActionPerformed
        // TODO add your handling code here:
        String genre1 =genre1_field.getText();
        String genre2 =genre2_field.getText();
        this.dispose();
        if((genre1.equals("")) || (genre2.equals("")) || (genre1.equals(genre2)))
        {
            clearFields();
            errorDialog.setVisible(true);
            return;
        }
        Object[][] tablita =null;
        tablita =llamar.filtradoCon_2Generos(tablita,genre1,genre2);
        if(tablita==null)
        {
            clearFields();
            errorDialog.setVisible(true);
            return;
        }
        rellenarTabla_filtros(tablita,tablaFiltrados);
        outputFiltro.setVisible(true);
        clearFields();
    }//GEN-LAST:event_doubleFilter_filterButtonActionPerformed

    private void backTo_menuButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backTo_menuButtonActionPerformed
    {//GEN-HEADEREND:event_backTo_menuButtonActionPerformed
        // TODO add your handling code here:
        clearFields();
        this.setVisible(false);
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backTo_menuButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        outputFiltro.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void volverA_menuFrom_errorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_volverA_menuFrom_errorActionPerformed
    {//GEN-HEADEREND:event_volverA_menuFrom_errorActionPerformed
        // TODO add your handling code here:
        errorDialog.dispose();
        father.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverA_menuFrom_errorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backTo_menuButton;
    private javax.swing.JButton doubleFilter_filterButton;
    private javax.swing.JDialog errorDialog;
    private javax.swing.JTextField genre1_field;
    private javax.swing.JLabel genre1_label;
    private javax.swing.JTextField genre2_field;
    private javax.swing.JLabel genre2_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog outputFiltro;
    private javax.swing.JTable tablaFiltrados;
    private javax.swing.JLabel title2ble;
    private javax.swing.JLabel tituloError;
    private javax.swing.JButton volverA_menuFrom_error;
    // End of variables declaration//GEN-END:variables
}
