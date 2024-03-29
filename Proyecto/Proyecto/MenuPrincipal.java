/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Proyecto;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Abrir la ventana del menú inicial
                AbrirMenus.abrirMenuInicial();
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
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Juego = new javax.swing.JButton();
        Configuracion = new javax.swing.JButton();
        Reportes = new javax.swing.JButton();
        MiPerfil = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 1, 100)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu Principal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 460, 90));

        Juego.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        Juego.setText("Jugar Ghost");
        Juego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JuegoActionPerformed(evt);
            }
        });
        getContentPane().add(Juego, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 110, 40));

        Configuracion.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        Configuracion.setText("Configuración");
        Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionActionPerformed(evt);
            }
        });
        getContentPane().add(Configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 110, 40));

        Reportes.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        Reportes.setText("Reportes");
        Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesActionPerformed(evt);
            }
        });
        getContentPane().add(Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 110, 40));

        MiPerfil.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        MiPerfil.setText("Mi Perfil");
        MiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(MiPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 110, 40));

        Salir.setFont(new java.awt.Font("Gill Sans MT Ext Condensed Bold", 0, 18)); // NOI18N
        Salir.setText("Regresar");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 590, 100, 30));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo 1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JuegoActionPerformed
        Controlador controlador=new Controlador();
    }//GEN-LAST:event_JuegoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
    int opcion=JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar sesión?"
                    , "Confirme de cierre de sesión", JOptionPane.YES_NO_OPTION);

            if (opcion==JOptionPane.YES_OPTION) {
                AbrirMenus.abrirMenuInicial();
                this.dispose();
            } 
    }//GEN-LAST:event_SalirActionPerformed

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
        Configuracion configuracion = new Configuracion();
        configuracion.setVisible(true);
    }//GEN-LAST:event_ConfiguracionActionPerformed

    private void ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesActionPerformed
        Reportes reportes = new Reportes();
        reportes.setVisible(true);

    }//GEN-LAST:event_ReportesActionPerformed

    private void MiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiPerfilActionPerformed
        MiPerfil miPerfil = new MiPerfil();
        miPerfil.setVisible(true);
    }//GEN-LAST:event_MiPerfilActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Configuracion;
    private javax.swing.JButton Juego;
    private javax.swing.JButton MiPerfil;
    private javax.swing.JButton Reportes;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
