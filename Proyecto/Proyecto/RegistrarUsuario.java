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
public class RegistrarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarUsuario
     */
    public RegistrarUsuario() {
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

        jLabel1 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreField = new javax.swing.JTextField();
        ContraseñaField = new javax.swing.JTextField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 550, -1));

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

        jLabel2.setText("Nombre de Usuario: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 120, -1));

        jLabel3.setText("Contraseña: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 110, -1));
        getContentPane().add(NombreField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 180, -1));
        getContentPane().add(ContraseñaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 180, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        String username= NombreField.getText();
        String contraseña= ContraseñaField.getText();
        
        int cantidadCaracteres=contraseña.length();
        boolean usuarioValido=false;
        
        if (Usuario.validarUsuarioUnico(username) || cantidadCaracteres !=5) { 
            if (Usuario.validarUsuarioUnico(username)) {
                JOptionPane.showMessageDialog(null, "El usuario no es único. Ingrese otro por favor.", "Error", JOptionPane.ERROR_MESSAGE);    
            }
            if (cantidadCaracteres!=5) {
                JOptionPane.showMessageDialog(null, "La contraseña debe tener 5 caracteres. Ingrese otra por favor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else { //guardar los datos en el arraylist
            Usuario.guardarDatos(username, contraseña);
            Usuario.agregarUH(1);
            JOptionPane.showMessageDialog(null, "El usuario ha sido registrado exitosamente",
                    "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }           
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();

    }//GEN-LAST:event_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField ContraseñaField;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField NombreField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
