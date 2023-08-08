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
public class UsuariosEliminados {
    private static ArrayList<String> usuariosEliminados = new ArrayList<>();

    public static void guardarUsuariosEliminados(String usuarioActual) {
        usuariosEliminados.add(usuarioActual);
    }
    
    public static int getCantidadUsuariosEliminados() {
        return usuariosEliminados.size();
    }
}
