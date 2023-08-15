/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class EliminarCuenta extends javax.swing.JFrame {

    /**
     * Creates new form EliminarCuenta
     */
    public EliminarCuenta() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cancelar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ContraseñaField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cancelar.setBackground(new java.awt.Color(255, 153, 0));
        Cancelar.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 12)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 90, 30));

        Aceptar.setBackground(new java.awt.Color(255, 153, 51));
        Aceptar.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 12)); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 90, 30));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Eliminar Cuenta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 550, -1));
        getContentPane().add(ContraseñaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 180, 30));

        jLabel2.setText("Contraseña: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 120, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed

            this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        String username= Usuario.getJugadorLog();
        String contraseña= ContraseñaField.getText();
        
        Usuario usuarioActual=null;
        
        if (Usuario.validarUsuarioContraseña(username, contraseña)) {
          int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar tu cuenta?");

                if (opcion == JOptionPane.YES_OPTION) {
                    // Eliminar la cuenta
                    Usuario.eliminarCuenta(username, contraseña);
                    JOptionPane.showMessageDialog(null, "Tu cuenta ha sido eliminada exitosamente.");
                    UsuariosEliminados.guardarUsuariosEliminados(username);
                    MenuInicial menuInicial=new MenuInicial();
                    menuInicial.setVisible(true);
                    this.dispose();
                } else {
                if (opcion == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Su cuenta no fue eliminada.");
                    this.dispose();
                }
                if (opcion == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    JOptionPane.showMessageDialog(null, "Su cuenta no fue eliminada.");
                    this.dispose();
                }
            }
            }else {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta. No se pudo eliminar la cuenta. "
                        + "Intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
      
    }//GEN-LAST:event_AceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField ContraseñaField;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
