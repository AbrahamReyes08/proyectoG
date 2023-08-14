/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author dell
 */
public class ModoJuego {
    private static String ModoDeJuegoDif="Normal";
    private static String ModoDeJuego="Aleatorio";
        
    public static String getModoJuegoDif() {
        return ModoDeJuegoDif;
    }
    
    public static void setModoJuegoDif(String modo) {
        ModoDeJuegoDif=modo;
    }
    
    public static String getModoDeJuego() {
        return ModoDeJuego;
    }
    
    public static void setModoDeJuego(String mod) {
        ModoDeJuego=mod;
    }
}
