/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto;

/**
 *
 * @author dell
 */
public class MiPerfil extends javax.swing.JFrame {

    /**
     * Creates new form MiPerfil
     */
    public MiPerfil() {
        initComponents();
        this.setLocationRelativeTo(null);
        String puntos = Puntaje.obtenerPuntosJugadorLog();
        String nombreUsuario= Usuario.getJugadorLog();
        info.setText(("<html>"+nombreUsuario.replaceAll("\n", "<br>")
            +puntos.replaceAll("\n", "<br>")+ "</html>"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cambiarContra = new javax.swing.JButton();
        EliminarCuenta = new javax.swing.JButton();
        Salir2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cambiarContra.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        cambiarContra.setText("Cmbiar Contraseña");
        cambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarContraActionPerformed(evt);
            }
        });
        getContentPane().add(cambiarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 130, 40));

        EliminarCuenta.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        EliminarCuenta.setText("Eliminar Cuenta");
        EliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 130, 40));

        Salir2.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        Salir2.setText("Regresar");
        Salir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir2ActionPerformed(evt);
            }
        });
        getContentPane().add(Salir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 130, 40));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mi Perfil");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 460, 90));

        info.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        info.setText("<html> jLabel1<htm>");
        info.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        info.setAutoscrolls(true);
        info.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "INFORMACIÓN DEL USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18))); // NOI18N
        info.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 470, 380));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reportes.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarContraActionPerformed
        CambiarContraseña cambiarContraseña = new CambiarContraseña();
        cambiarContraseña.setVisible(true);
    }//GEN-LAST:event_cambiarContraActionPerformed

    private void EliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCuentaActionPerformed
        EliminarCuenta eliminarCuenta = new EliminarCuenta();
        eliminarCuenta.setVisible(true);
    }//GEN-LAST:event_EliminarCuentaActionPerformed

    private void Salir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_Salir2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarCuenta;
    private javax.swing.JButton Salir2;
    private javax.swing.JButton cambiarContra;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
