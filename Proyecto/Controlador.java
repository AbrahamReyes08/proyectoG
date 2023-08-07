/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import static Proyecto.Juego.LabelTurno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Controlador implements ActionListener{
    private String[] [] tablero=new String [6][6];
    private char turnoJugador='A';
    private String turno=Usuario.jugadorLog;
    private String ganador;
    private String jugador1=Usuario.jugadorLog;
    private String posicionAntigua = null;
    private String posicionNueva = null;
    private String posicionActual;
    private String posicionSalida=null;
    private String posTablero;

    private int contadorAmalos;
    private int contadorAbuenos;
    private int contadorBmalos;
    private int contadorBbuenos;
    
    Movimientos movimientos;
    
    
    
    public Controlador() {
        iniciarTablero();
        AbrirMenus.abrirJuego();
        añadirActionEvents();
        movimientos= new Movimientos();
        Juego.LabelTurno.setText(turno);
        cambiarInfoJugador();
        añadirFichasAPantalla();
    }
    
    private void iniciarTablero() {
        for (int i=0;i<6;i++) {
            for (int j=0; j<6;j++) {
                tablero [i][j]="";
            }
        }
    }
   
    private void añadirActionEvents() {
        Juego.BotonF1C1.addActionListener(this);
        Juego.BotonF1C2.addActionListener(this);
        Juego.BotonF1C3.addActionListener(this);
        Juego.BotonF1C4.addActionListener(this);
        Juego.BotonF1C5.addActionListener(this);
        Juego.BotonF1C6.addActionListener(this);
        
        Juego.BotonF2C1.addActionListener(this);
        Juego.BotonF2C2.addActionListener(this);
        Juego.BotonF2C3.addActionListener(this);
        Juego.BotonF2C4.addActionListener(this);
        Juego.BotonF2C5.addActionListener(this);
        Juego.BotonF2C6.addActionListener(this);
        
        Juego.BotonF3C1.addActionListener(this);
        Juego.BotonF3C2.addActionListener(this);
        Juego.BotonF3C3.addActionListener(this);
        Juego.BotonF3C4.addActionListener(this);
        Juego.BotonF3C5.addActionListener(this);
        Juego.BotonF3C6.addActionListener(this);
        
        Juego.BotonF4C1.addActionListener(this);
        Juego.BotonF4C2.addActionListener(this);
        Juego.BotonF4C3.addActionListener(this);
        Juego.BotonF4C4.addActionListener(this);
        Juego.BotonF4C5.addActionListener(this);
        Juego.BotonF4C6.addActionListener(this);
        
        Juego.BotonF5C1.addActionListener(this);
        Juego.BotonF5C2.addActionListener(this);
        Juego.BotonF5C3.addActionListener(this);
        Juego.BotonF5C4.addActionListener(this);
        Juego.BotonF5C5.addActionListener(this);
        Juego.BotonF5C6.addActionListener(this);
        
        Juego.BotonF6C1.addActionListener(this);
        Juego.BotonF6C2.addActionListener(this);
        Juego.BotonF6C3.addActionListener(this);
        Juego.BotonF6C4.addActionListener(this);
        Juego.BotonF6C5.addActionListener(this);
        Juego.BotonF6C6.addActionListener(this);
    }
    
    private void añadirFichasAPantalla() {
        
        tablero[0][0]="SalidaA";
        tablero[0][5]="SalidaA";
        tablero[5][0]="SalidaB";
        tablero[5][5]="SalidaB";
        
        tablero[0][1]="A_fantasmaBueno";
        tablero[0][2]="A_fantasmaBueno";
        tablero[0][3]="A_fantasmaMalo";
        tablero[0][4]="A_fantasmaMalo";
        tablero[1][1]="A_fantasmaBueno";
        tablero[1][2]="A_fantasmaBueno";
        tablero[1][3]="A_fantasmaMalo";
        tablero[1][4]="A_fantasmaMalo";
        
        tablero[4][1]="B_fantasmaBueno";
        tablero[4][2]="B_fantasmaBueno";
        tablero[4][3]="B_fantasmaMalo";
        tablero[4][4]="B_fantasmaMalo";
        tablero[5][1]="B_fantasmaBueno";
        tablero[5][2]="B_fantasmaBueno";
        tablero[5][3]="B_fantasmaMalo";
        tablero[5][4]="B_fantasmaMalo";
        
    }
    
    @Override   
    public void actionPerformed(ActionEvent ae) {
        if (turnoJugador == 'A') {
            posicionActual = getBotonPosicionString(ae.getSource());
            dimeLaCasilla(posicionActual);
            if (isCurrentPlayerPieceA(posicionActual)) {
                posicionAntigua = posicionActual;
            } else if (posicionAntigua != null) {
                posicionNueva = getBotonPosicionString(ae.getSource());
                if (casillaDisponible(posicionAntigua,posicionNueva)){
                    cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                    cambiarTurno();
                }
            }
        }
    if (turnoJugador == 'B') {
            posicionActual = getBotonPosicionString(ae.getSource());
            if (isCurrentPlayerPieceB(posicionActual)) {
                posicionAntigua = posicionActual;
            } else if (posicionAntigua != null) {
                posicionNueva = getBotonPosicionString(ae.getSource());
                if (casillaDisponible(posicionAntigua, posicionNueva)){
                    cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                    cambiarTurno();
                }
            }
        }
   
}
    
    public void cambiarTurno() {
        if (turnoJugador=='A') {
            ganador=jugador1;
            turno="Jugador2";
            turnoJugador='B';
        } else {
            ganador="Jugador2";
            turno=jugador1;
            turnoJugador='A';
        }
        Juego.LabelTurno.setText(turno);
        cambiarInfoJugador();
        comprobarGane1();
        comprobarGane2();
    }
 
    public boolean esPosibleEsteMovimiento(String posicionAntigua, String posicionNueva) {
        String [] posicionesPosibles;
        
        posicionesPosibles  = movimientos.moverFicha(tablero,posicionAntigua);
        if(posicionesPosibles!=null) {
            for (int i=0; i<posicionesPosibles.length;i++){
                if(posicionesPosibles[i].equals(posicionNueva)) {
                    return true;
                }
            }    
        }
        
        return false;
    }
    
    private void cambiarFichas(String posAntigua, String posNueva) {
        cambiarEnPantalla(posAntigua,posNueva);
        comprobarGane3(posAntigua,posNueva);
        cambiarEnString(posAntigua,posNueva);
    }
    
    private void cambiarEnString(String posAntigua, String posNueva) {
        int xA = Character.getNumericValue(posAntigua.charAt(1));
        int yA = Character.getNumericValue(posAntigua.charAt(0));

        int xN = Character.getNumericValue(posNueva.charAt(1));
        int yN = Character.getNumericValue(posNueva.charAt(0));
               
        tablero[yN][xN] = tablero[yA][xA];
        tablero[yA][xA] = "";
    }

    private void cambiarEnPantalla(String posAntigua, String posNueva) {
        boton(posNueva).setIcon(boton(posAntigua).getIcon());
        boton(posAntigua).setIcon(null);
    }
    
    private JButton boton(String posicion) {
        if (posicion.equals("00")) {
            return Juego.BotonF1C1;
        } else if (posicion.equals("01")) {
            return Juego.BotonF1C2;
        } else if (posicion.equals("02")) {
            return Juego.BotonF1C3;
        } else if (posicion.equals("03")) {
            return Juego.BotonF1C4;
        } else if (posicion.equals("04")) {
            return Juego.BotonF1C5;
        } else if (posicion.equals("05")) {
            return Juego.BotonF1C6;
        } else if (posicion.equals("10")) {
            return Juego.BotonF2C1;
        } else if (posicion.equals("11")) {
            return Juego.BotonF2C2;
        } else if (posicion.equals("12")) {
            return Juego.BotonF2C3;
        } else if (posicion.equals("13")) {
            return Juego.BotonF2C4;
        } else if (posicion.equals("14")) {
            return Juego.BotonF2C5;
        } else if (posicion.equals("15")) {
            return Juego.BotonF2C6;
        } else if (posicion.equals("20")) {
            return Juego.BotonF3C1;
        } else if (posicion.equals("21")) {
            return Juego.BotonF3C2;
        } else if (posicion.equals("22")) {
            return Juego.BotonF3C3;
        } else if (posicion.equals("23")) {
            return Juego.BotonF3C4;
        } else if (posicion.equals("24")) {
            return Juego.BotonF3C5;
        } else if (posicion.equals("25")) {
            return Juego.BotonF3C6;
        } else if (posicion.equals("30")) {
            return Juego.BotonF4C1;
        } else if (posicion.equals("31")) {
            return Juego.BotonF4C2;
        } else if (posicion.equals("32")) {
            return Juego.BotonF4C3;
        } else if (posicion.equals("33")) {
            return Juego.BotonF4C4;
        } else if (posicion.equals("34")) {
            return Juego.BotonF4C5;
        } else if (posicion.equals("35")) {
            return Juego.BotonF4C6;
        } else if (posicion.equals("40")) {
            return Juego.BotonF5C1;
        } else if (posicion.equals("41")) {
            return Juego.BotonF5C2;
        } else if (posicion.equals("42")) {
            return Juego.BotonF5C3;
        } else if (posicion.equals("43")) {
            return Juego.BotonF5C4;
        } else if (posicion.equals("44")) {
            return Juego.BotonF5C5;
        } else if (posicion.equals("45")) {
            return Juego.BotonF5C6;
        } else if (posicion.equals("50")) {
            return Juego.BotonF6C1;
        } else if (posicion.equals("51")) {
            return Juego.BotonF6C2;
        } else if (posicion.equals("52")) {
            return Juego.BotonF6C3;
        } else if (posicion.equals("53")) {
            return Juego.BotonF6C4;
        } else if (posicion.equals("54")) {
            return Juego.BotonF6C5;
        } else if (posicion.equals("55")) {
            return Juego.BotonF6C6;
        }
        return null;
    }
    
    private String getBotonPosicionString(Object boton ) {
        if (boton ==Juego.BotonF1C1) {
            return "00";
        } else if (boton==Juego.BotonF1C2) {
            return "01";
        } else if (boton==Juego.BotonF1C3) {
            return "02";
        }else if (boton==Juego.BotonF1C4) {
            return "03";
        } else if (boton==Juego.BotonF1C5) {
            return "04";
        }else if (boton==Juego.BotonF1C6) {
            return "05";
        } else if (boton==Juego.BotonF2C1) {
            return "10";
        } else if (boton==Juego.BotonF2C2) {
            return "11";
        }else if (boton==Juego.BotonF2C3) {
            return "12";
        } else if (boton==Juego.BotonF2C4) {
            return "13";
        } else if (boton==Juego.BotonF2C5) {
            return "14";
        } else if(boton==Juego.BotonF2C6) {
            return "15";
        } else if (boton==Juego.BotonF3C1) {
            return "20";
        } else if (boton==Juego.BotonF3C2) {
            return "21";
        }else if (boton==Juego.BotonF3C3) {
            return "22";
        } else if (boton==Juego.BotonF3C4) {
            return "23";
        } else if (boton==Juego.BotonF3C5) {
            return "24";
        } else if(boton==Juego.BotonF3C6) {
            return "25";
        } else if (boton==Juego.BotonF4C1) {
            return "30";
        } else if (boton==Juego.BotonF4C2) {
            return "31";
        }else if (boton==Juego.BotonF4C3) {
            return "32";
        } else if (boton==Juego.BotonF4C4) {
            return "33";
        } else if (boton==Juego.BotonF4C5) {
            return "34";
        } else if(boton==Juego.BotonF4C6) {
            return "35";
        } else if (boton==Juego.BotonF5C1) {
            return "40";
        } else if (boton==Juego.BotonF5C2) {
            return "41";
        }else if (boton==Juego.BotonF5C3) {
            return "42";
        } else if (boton==Juego.BotonF5C4) {
            return "43";
        } else if (boton==Juego.BotonF5C5) {
            return "44";
        } else if(boton==Juego.BotonF5C6) {
            return "45";
        } else if (boton==Juego.BotonF6C1) {
            return "50";
        } else if (boton==Juego.BotonF6C2) {
            return "51";
        }else if (boton==Juego.BotonF6C3) {
            return "52";
        } else if (boton==Juego.BotonF6C4) {
            return "53";
        } else if (boton==Juego.BotonF6C5) {
            return "54";
        } else if(boton==Juego.BotonF6C6) {
            return "55";
        }
        return null;
    }
    
    private boolean isCurrentPlayerPieceA(String posicion) {
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        if (!tablero[y][x].equals("")) {
            if (tablero[y][x].charAt(0) == 'A') {
               return true;
            } if (tablero[y][x].charAt(0) == 'B') {
                return false;
            }
        }
        return false;
    }
    
    private boolean isCurrentPlayerPieceB(String posicion) {
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        if (!tablero[y][x].equals("")) {
            if (tablero[y][x].charAt(0) == 'B') {
               return true;
            } if (tablero[y][x].charAt(0) == 'A') {
                return false;
            }
        }
        return false;
    }
    
    private void dimeLaCasilla(String posicionAntigua) {
        int x = Character.getNumericValue(posicionAntigua.charAt(1));
        int y = Character.getNumericValue(posicionAntigua.charAt(0));
        System.out.println("x: "+x+" y: "+y);
        System.out.println(tablero[y][x]);
    }
    
    private boolean casillaDisponible(String posicionAntigua,String posicionNueva) {
        int x = Character.getNumericValue(posicionAntigua.charAt(1));
        int y = Character.getNumericValue(posicionAntigua.charAt(0));
        
        int x2 = Character.getNumericValue(posicionNueva.charAt(1));
        int y2 = Character.getNumericValue(posicionNueva.charAt(0));
        
        String posicionArriba=(y - 1) + "" + x;
        String posicionAbajo=(y+1)+""+x;
        String posicionIzquierda=y+""+(x-1);
        String posicionDerecha=y+""+(x+1);
        
        String posicionArribaN=y2+ "" + x2;
        String posicionAbajoN=y2+""+x2;
        String posicionIzquierdaN=y2+""+x2;
        String posicionDerechaN=y2+""+x2;
        if (turnoJugador=='A'){
           if (posicionArribaN.equals(posicionArriba) && ((tablero[y2][x2].equals("SalidaB") || tablero[y2][x2].equals(""))  || EsComible(posicionNueva))) {
                return true;
            } else if (posicionAbajoN.equals(posicionAbajo) && ((tablero[y2][x2].equals("SalidaB") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
            } else if (posicionIzquierdaN.equals(posicionIzquierda) && ((tablero[y2][x2].equals("SalidaB") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
                
            } else if (posicionDerechaN.equals(posicionDerecha) && ((tablero[y2][x2].equals("SalidaB") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
            } else {
            JOptionPane.showMessageDialog(null, "Movimiento invalido", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        } 
        
        if (turnoJugador=='B'){
            if (posicionArribaN.equals(posicionArriba) && ((tablero[y2][x2].equals("SalidaA") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
            } else if (posicionAbajoN.equals(posicionAbajo) && ((tablero[y2][x2].equals("SalidaA") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
            } else if (posicionIzquierdaN.equals(posicionIzquierda) && ((tablero[y2][x2].equals("SalidaA") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
            } else if (posicionDerechaN.equals(posicionDerecha) && ((tablero[y2][x2].equals("SalidaA") || tablero[y2][x2].equals("")) || EsComible(posicionNueva))) {
                return true;
            }else {
            JOptionPane.showMessageDialog(null, "Movimiento invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }  
        
         return false;
    }
    
    private boolean EsComible(String posicionNueva) {
        int x2 = Character.getNumericValue(posicionNueva.charAt(1));
        int y2 = Character.getNumericValue(posicionNueva.charAt(0));

        if (turnoJugador=='A'){
            if (tablero[y2][x2].charAt(0) == 'B') {
                if (tablero[y2][x2].charAt(10) == 'B') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma bueno de "+ganador, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    contadorBbuenos++;
                    return true;
                }
                if (tablero[y2][x2].charAt(10) == 'M') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma malo de "+ganador, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    contadorBmalos++;
                    return true;
                }
            }
        } 
        
        if (turnoJugador=='B'){
            if (tablero[y2][x2].charAt(0) == 'A') {
                if (tablero[y2][x2].charAt(10) == 'B') {
                    contadorAbuenos++;
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma bueno de "+ganador, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
                if (tablero[y2][x2].charAt(10) == 'M') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma malo de "+ganador, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    contadorAmalos++;
                    return true;
                }
            }
        }  
         return false;

    }
    
    private void cambiarInfoJugador() {
        Juego.LabelJug1.setText("<html>Fantasma Buenos: "+(4-contadorAbuenos)+"\n"+"Fantasma Malos: "+(4-contadorAmalos)+"<html>");
        Juego.LabelJug1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), jugador1, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gigi", 1, 14)));
        Juego.LabelJug2.setText("<html>Fantasma Buenos: "+(4-contadorBbuenos)+"\n"+"Fantasma Malos: "+(4-contadorBmalos)+"<html>");
        Juego.LabelJug2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), jugador1, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gigi", 1, 14)));
    }
  
    private void comprobarGane1() {
        if ((4-contadorAbuenos)==0) {
            JOptionPane.showMessageDialog(null, ganador+" triunfo sobre "+turno+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                AbrirMenus.cerrarJuego();
        }
        if ((4-contadorBbuenos)==0) {
            JOptionPane.showMessageDialog(null, ganador+" triunfo sobre "+turno+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                AbrirMenus.cerrarJuego();
        }
    }
    
    private void comprobarGane2() {
        if ((4-contadorAmalos)==0) {
            JOptionPane.showMessageDialog(null, turno+" triunfo porque "+ganador+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                AbrirMenus.cerrarJuego();
        }
        if ((4-contadorBmalos)==0) {
            JOptionPane.showMessageDialog(null,turno+" triunfo porque "+ganador+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                AbrirMenus.cerrarJuego();
        }
    }
    
   private void comprobarGane3(String posicionAntigua, String posicionNueva) {
        int x = Character.getNumericValue(posicionAntigua.charAt(1));
        int y = Character.getNumericValue(posicionAntigua.charAt(0));
    
        int x2 = Character.getNumericValue(posicionNueva.charAt(1));
        int y2 = Character.getNumericValue(posicionNueva.charAt(0));
        
        System.out.println(tablero[y][x]);
        System.out.println(tablero[y2][x2]);
        
           if (tablero[y][x].equals("A_fantasmaBueno") && tablero[y2][x2].equals("SalidaB")) {
                JOptionPane.showMessageDialog(null, turno+" triunfo al sacar del castillo un fantasma bueno!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                AbrirMenus.cerrarJuego();
           } 
           
            if (tablero[y][x].equals("B_fantasmaBueno") && tablero[y2][x2].equals("SalidaA") ) {
                JOptionPane.showMessageDialog(null, turno+"Patito triunfo al sacar del castillo un fantasma bueno!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                AbrirMenus.cerrarJuego();
            } 
        }
   
        private void obtenerPos(String posicion) {
            boton(posicion).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fantasmaNuevo1.png")));
        }
    }
     
