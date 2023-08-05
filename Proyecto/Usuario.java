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
public class Usuario {
    private String username;
    private String contraseña;
    public static String jugadorLog;
    
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Usuario(String username, String contraseña){
        this.username=username;
        this.contraseña=contraseña;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public static void guardarDatos(String username, String contraseña) {
        Usuario usuario = new Usuario(username, contraseña);
        usuarios.add(usuario);
    }
    
}
