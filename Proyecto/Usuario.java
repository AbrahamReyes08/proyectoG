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
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public Usuario(String username, String contraseña){
        this.username=username;
        this.contraseña=contraseña;
    }
    
    public static String getJugadorLog() {
        return jugadorLog;
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
    
    public static int getNumeroUsuariosRegistrados() {
        return usuarios.size();
    }
    
    public static void guardarDatos(String username, String contraseña) {
        Usuario usuario = new Usuario(username, contraseña);
        usuarios.add(usuario);
    }    
    
    public static boolean validarUsuarioUnico(String usuario) {
        return validarUsuarioUnico(usuarios.toArray(new Usuario[0]), usuario, 0);
    }
    
    private static boolean validarUsuarioUnico(Usuario[] usuarios, String username, int index) {
        if (index < usuarios.length) {
            if (usuarios[index].getUsername().equals(username)) {
                return true;
            } else {
                return validarUsuarioUnico(usuarios, username, index + 1);
            }
        } else {
            return false;
        }
    }
    
    public static boolean validarUsuarioContraseña(String username, String contraseña) {
        return validarUsuarioContraseña(usuarios.toArray(new Usuario[0]), username, contraseña,0);
    }
    
    private static boolean validarUsuarioContraseña(Usuario[] usuarios, String username, String contraseña, int index) {
    if (index < usuarios.length) {
            if (usuarios[index].getUsername().equals(username) && usuarios[index].getContraseña().equals(contraseña)) {
                return true;
            } else {
                return validarUsuarioContraseña(usuarios, username, contraseña, index + 1);
            }
        } else {
            return false;
        }
    }

    public static boolean CambiarContraseña(String username, String contraseñaNueva) {
        return cambiarContraseña(usuarios.toArray(new Usuario[0]), username, contraseñaNueva,0);
    }
    
    private static boolean cambiarContraseña(Usuario[] usuarios, String username, String contraseñaNueva, int index) {
        if (index < usuarios.length) {
                if (usuarios[index].getUsername().equals(username)) {
                    usuarios[index].contraseña=contraseñaNueva;
                    return true;
                } else {
                    return validarUsuarioContraseña(usuarios, username, contraseñaNueva, index + 1);
                }
            } else {
                return false;
            }
        }
    
    public static void eliminarCuenta(String username, String contraseñaActual) {
        Usuario usuarioEliminado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.username.equals(username) && usuario.contraseña.equals(contraseñaActual)) {
                usuarioEliminado = usuario;
                break;
            }
        }
        if (usuarioEliminado != null) {
            usuarios.remove(usuarioEliminado);
        }
    }
    
    }
    
