/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author dell
 */
public class AbrirMenus {
    static Juego juego=new Juego();
    
    public static void abrirJuego() {
        juego.setVisible(true);
    }

    public static void cerrarJuego() {
        juego.dispose();
    }
}
