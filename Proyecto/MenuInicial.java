/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto;

/**
 *
 * @author dell
 */
public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicial
     */
    public MenuInicial() {
        initComponents();
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
        Registro = new javax.swing.JButton();
        IniciarSesion = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 3, 100)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("GHOSTS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 410, 90));

        Registro.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 24)); // NOI18N
        Registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrar.png"))); // NOI18N
        Registro.setText("Registrar Usuario");
        Registro.setToolTipText("");
        Registro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroActionPerformed(evt);
            }
        });
        getContentPane().add(Registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 220, 60));

        IniciarSesion.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 24)); // NOI18N
        IniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciar.png"))); // NOI18N
        IniciarSesion.setText("Iniciar Sesion");
        IniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(IniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 180, 60));

        Salir.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 24)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 140, 60));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo 2.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroActionPerformed
    RegistrarUsuario Registro = new RegistrarUsuario();
        Registro.setVisible(true);
        
    }//GEN-LAST:event_RegistroActionPerformed

    private void IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionActionPerformed
        IniciarSesion iniciarSesion = new IniciarSesion();
        iniciarSesion.setVisible(true);
        
    }//GEN-LAST:event_IniciarSesionActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);

    }//GEN-LAST:event_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton IniciarSesion;
    private javax.swing.JButton Registro;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
