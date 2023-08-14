/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author dell
 */
public class Puntaje extends Usuario {
        private int puntaje;
        private static HashMap<String, Integer> puntajes = new HashMap<>();

        public Puntaje(String username, String contraseña, int puntaje) {
            super(username, contraseña);
            this.puntaje = puntaje;
            puntajes.put(this.getUsername(), puntaje); 
        }

        public static int getPuntos() {
            return puntajes.getOrDefault(jugadorLog, 0); 
        }

        private static void incrementarPuntos(int puntos) {
            int puntosActuales = getPuntos();
            puntajes.put(jugadorLog, puntosActuales + puntos);
        }
        public static void incrementarPuntos(String jugador1, int puntajeJugador1, String jugador2, int puntajeJugador2) {
            for (Usuario usuario : usuarios) {
                if (puntajeJugador1 > 0 && usuario.getUsername().equals(jugador1)) {
                    incrementarPuntos(puntajeJugador1);
                } else if (puntajeJugador2 > 0 && usuario.getUsername().equals(jugador2)) {
                    incrementarPuntos(puntajeJugador2);
                }
            }
        }

        public static String obtenerPuntosJugadorLog() {
            for (Usuario usuario : usuarios) {
                if (usuario.getUsername().equals(jugadorLog)) {
                    return "Puntos de " + usuario.getUsername() + ": " + Puntaje.getPuntos();
                }
            }
            return "Jugador no encontrado";
        }

        public static String obtenerPuntajes() {
            ArrayList<Usuario> jugadores = Usuario.getUsuarios();
            Collections.sort(jugadores, new Comparator<Usuario>() {
                @Override
                public int compare(Usuario u1, Usuario u2) {
                    return Integer.compare(Puntaje.getPuntos(), Puntaje.getPuntos());
                }
            });

            StringBuilder sb = new StringBuilder();

            int posicion = 1;
            for (Usuario jugador : jugadores) {
                sb.append(posicion).append(". ")
                        .append(jugador.getUsername())
                        .append(" - ")
                        .append(Puntaje.getPuntos())
                        .append(" puntos\n");
                posicion++;
            }

            return sb.toString();
        }
    }    

