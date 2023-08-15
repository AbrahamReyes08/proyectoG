/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Batalla extends Partida{
    private static ArrayList<Partida> partidasTotales = new ArrayList<>();
    
    public Batalla(String resultado) {
        super(resultado);
        partidasTotales.add(this);
    }
    
    public static int getNumeroPartidas() {
        return partidasTotales.size();
    }
    
    public static String obtenerPartidasLog() {
        StringBuilder logsJug = new StringBuilder();
        String jugadorLog = Usuario.jugadorLog;

        logsJug.append("Logs de ").append(jugadorLog).append(":\n");

        for (Partida partida : partidasTotales) {
            if (partida.getResultado().contains(jugadorLog)) {
                logsJug.append(partida.getResultado()).append("\n");
            }
        }

        return logsJug.toString();
    }
    
    public static int cantidadPartidasJugLog() {
        StringBuilder logsJug = new StringBuilder();
        String jugadorLog = Usuario.jugadorLog;
        int contador=0;
        logsJug.append("Logs de ").append(jugadorLog).append(":\n");

        for (Partida partida : partidasTotales) {
            if (partida.getResultado().contains(jugadorLog)) {
                contador=contador+1;
            }
        }

        return contador;
    }
        
    public static String obtenerPartidas() {
        StringBuilder logsJug = new StringBuilder();
        int contador=1;
        logsJug.append("Descripcion de los ultimos logs.\n");

        for (Partida partida : partidasTotales) {
                logsJug.append(contador+".  "+partida.getResultado()).append("\n");
                contador=contador+1;
        }
        contador=contador+1;
        return logsJug.toString();
    }

    
}