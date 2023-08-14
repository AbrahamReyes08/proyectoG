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
public class Puntaje extends Usuario {
        private int puntos;

        public Puntaje(String username, String contraseña) {
            super(username, contraseña);
            this.puntos = 0;
        }

        public int getPuntos() {
            return puntos;
        }

        public void agregarPuntos(int cantidad) {
            puntos += cantidad;
        }

        public static void agregarPuntosAUsuario(String username, int cantidad) {
            for (Usuario usuario : usuarios) {
                if (usuario.getUsername().equals(username)) {
                    ((Puntaje) usuario).agregarPuntos(cantidad);
                    break;
                }
            }
        }

        public static int getPuntosJugadorLog() {
            for (Usuario usuario : usuarios) {
                if (usuario.getUsername().equals(jugadorLog)) {
                    return ((Puntaje) usuario).getPuntos();
                }
            }
            return 0;
        }

        public static String getPuntosOrdenados() {
            ArrayList<Puntaje> puntajesOrdenados = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Puntaje) {
                    puntajesOrdenados.add((Puntaje) usuario);
                }
            }
            puntajesOrdenados.sort((puntaje1, puntaje2) -> Integer.compare(puntaje2.getPuntos(), puntaje1.getPuntos()));

            StringBuilder resultado = new StringBuilder("Puntos de los usuarios (ordenados de mayor a menor):\n");
            for (Puntaje puntaje : puntajesOrdenados) {
                resultado.append(puntaje.getUsername()).append(": ").append(puntaje.getPuntos()).append(" puntos\n");
            }

            return resultado.toString();
        }
    }

