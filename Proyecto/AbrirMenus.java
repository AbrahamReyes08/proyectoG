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
    static MenuInicial MenuInicial = new MenuInicial();
    public static void abrirJuego() {
        juego.setVisible(true);
    }

    public static void cerrarJuego() {
        juego.dispose();
    }
    
    public static void abrirMenuInicial() {
        MenuInicial.setVisible(true);
    }
    
    public static void cerrarMenuInicial() {
        MenuInicial.dispose();
    }
    
    public static void llamarRegistro() {
        RegistrarUsuario Registro = new RegistrarUsuario();
        Registro.setVisible(true);
    }
    public static void llamarLogin() {
        IniciarSesion LogIn = new IniciarSesion();
        LogIn.setVisible(true);
    }
}
