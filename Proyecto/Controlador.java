/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import static Proyecto.Juego.LabelTurno;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Controlador implements ActionListener{
    private String[][] tablero=new String [6][6];
    ArrayList<String> AFantasmas = new ArrayList<>();
    ArrayList<String> BFantasmas = new ArrayList<>();
    ArrayList<Object> Aposiciones=new ArrayList<>();
    ArrayList<Object> Bposiciones=new ArrayList<>();
    ArrayList <String> numerosPosA =new ArrayList<>();
    ArrayList <String> numerosPosB =new ArrayList<>();
    
    private char turnoJugador='A';
    private String turno=Usuario.jugadorLog;
    private String ganador;
    public static String jugador1=Usuario.jugadorLog;
    public static String jugador2;
    private String posicionAntigua = null;
    private String posicionNueva = null;
    private String posicionActual;
    private String posicionSalida=null;
    private String posicionElegida=null;
    
    private final int puntosGanador=3;
    private final int puntosPerdedor=0;
    
    private int contadorAmalos;
    private int contadorAbuenos;
    private int contadorBmalos;
    private int contadorBbuenos;
    private int contadorA=0;
    private int contadorB=0;
    private int contadorC=8;
    
    Movimientos movimientos;
    Random random = new Random();
    Juego juego=new Juego();
    
    public Controlador() {
        iniciarTablero();
        juego.setVisible(true);
        añadirActionEvents();
        movimientos= new Movimientos();
        Juego.LabelTurno.setText(turno);
        cambiarInfoJugador();
        añadirFichasAPantalla();
    }
    
    private void iniciarTablero() {
        int numeroJugadores=Usuario.getNumeroUsuariosRegistrados();
        boolean jugadorValido=false;

        if (numeroJugadores > 1) {
            while (jugadorValido==false) {
                jugador2 = JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario para el Jugador 2:", "Juego", JOptionPane.INFORMATION_MESSAGE);
                jugadorValido = false; 

                for (Usuario usuario : Usuario.getUsuarios()) {
                    if ((usuario.getUsername().equals(jugador2) || jugador2.equals("invitado")) && !jugador2.equals(jugador1)) {
                        jugadorValido = true;
                        break;
                    }
                } 
                if (jugadorValido==false) {
                     JOptionPane.showMessageDialog(null, "Usuario no valido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            };
        } else {
            jugador2 = "Invitado";
        }
        
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

        
        if (ModoJuego.getModoJuegoDif().equals("Normal")) {
            fichasSiNormal();
        } else if (ModoJuego.getModoJuegoDif().equals("Expert")) {
            fichasSiExpert();
        } else if (ModoJuego.getModoJuegoDif().equals("Genius")) {
            fichasSiGenius();
        }
        
        numerosPosA();
        numerosPosB();
        
        if(ModoJuego.getModoDeJuego().equals("Manual")){
            mostrarCoor();
            for (int i=0; BFantasmas.size() > 0; ) {
               ponerFichasManual(); 
               cambiarTurno();
            }
            ocultarCoor();
            JOptionPane.showMessageDialog(null, jugador1+" vs. "+jugador2, "Partida Lista", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (ModoJuego.getModoDeJuego().equals("Aleatorio")) {
            for (int i = 0; i != AFantasmas.size(); ) {
                    int index = random.nextInt(AFantasmas.size());
                    int posRandom = random.nextInt(numerosPosA.size());
                    String POS = numerosPosA.get(posRandom);

                    int x = Character.getNumericValue(POS.charAt(1));
                    int y = Character.getNumericValue(POS.charAt(0));

                    ponerImagenA(POS);
                    tablero[y][x]=AFantasmas.get(index);

                    AFantasmas.remove(index);
                    numerosPosA.remove(posRandom);
            }

            for (int i = 0; i != BFantasmas.size(); ) {
                    int index = random.nextInt(BFantasmas.size());
                    int posRandom = random.nextInt(numerosPosB.size());
                    String POS = numerosPosB.get(posRandom);


                    int x = Character.getNumericValue(POS.charAt(1));
                    int y = Character.getNumericValue(POS.charAt(0));

                    ponerImagenB(POS);
                    tablero[y][x]=BFantasmas.get(index);

                    BFantasmas.remove(index);
                    numerosPosB.remove(posRandom);
            }
                    JOptionPane.showMessageDialog(null, jugador1+" vs. "+jugador2, "Partida Lista", JOptionPane.INFORMATION_MESSAGE);
        }
        
        System.out.println("---------------------------");
        System.out.println(tablero[0][1]);
        System.out.println(tablero[0][2]);
        System.out.println(tablero[0][3]);
        System.out.println(tablero[0][4]);
        System.out.println(tablero[1][1]);
        System.out.println(tablero[1][2]);
        System.out.println(tablero[1][3]);
        System.out.println(tablero[1][4]);
        System.out.println("----------------------------");
        System.out.println(tablero[4][1]);
        System.out.println(tablero[4][2]);
        System.out.println(tablero[4][3]);
        System.out.println(tablero[4][4]);
        System.out.println(tablero[5][1]);
        System.out.println(tablero[5][2]);
        System.out.println(tablero[5][3]);
        System.out.println(tablero[5][4]);
        System.out.println("---------------------------");
        
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
                if (dimeLaCasilla(posicionAntigua).equals("A_fantasmaFake")) {
                    if(casillaDisponibleTrampa(posicionAntigua,posicionNueva)) {
                    cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                    cambiarTurno();
                    }
                } else {
                if (casillaDisponible(posicionAntigua,posicionNueva) ){
                    String mes =dimeLaCasilla(posicionNueva);
                    cambiarFichas(posicionAntigua, posicionNueva);
                    if(!mes.equals("")) {
                    EsComibleMes(mes);
                    }
                    posicionNueva = null;
                    posicionAntigua = null;
                    cambiarTurno();
                }
            }
            }
        }
    if (turnoJugador == 'B') {
            posicionActual = getBotonPosicionString(ae.getSource());
            dimeLaCasilla(posicionActual);
            if (isCurrentPlayerPieceB(posicionActual)) {
                posicionAntigua = posicionActual;
            } else if (posicionAntigua != null) {
                posicionNueva = getBotonPosicionString(ae.getSource());
                if (dimeLaCasilla(posicionAntigua).equals("B_fantasmaFake")) {
                    if(casillaDisponibleTrampa(posicionAntigua, posicionNueva)) {
                    cambiarFichas(posicionAntigua, posicionNueva);
                    posicionNueva = null;
                    posicionAntigua = null;
                    cambiarTurno();
                    }
                } else {
                if (casillaDisponible(posicionAntigua,posicionNueva) ){
                    String mes =dimeLaCasilla(posicionNueva);
                    cambiarFichas(posicionAntigua, posicionNueva);
                    if(!mes.equals("")) {
                    EsComibleMes(mes);
                    }
                    posicionNueva = null;
                    posicionAntigua = null;
                    cambiarTurno();
                }
            }
            }
        }
   
}
    
    public void cambiarTurno() {
        if (turnoJugador=='A') {
            ganador=jugador1;
            turno=jugador2;
            turnoJugador='B';
        } else {
            ganador=jugador2;
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
    
    private String dimeLaCasilla(String posicionAntigua) {
        int x = Character.getNumericValue(posicionAntigua.charAt(1));
        int y = Character.getNumericValue(posicionAntigua.charAt(0));
        return tablero[y][x];
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
    
    private boolean casillaDisponibleTrampa(String posicionAntigua, String posicionNueva) {
        int x = Character.getNumericValue(posicionAntigua.charAt(1));
        int y = Character.getNumericValue(posicionAntigua.charAt(0));
        
        int x2 = Character.getNumericValue(posicionNueva.charAt(1));
        int y2 = Character.getNumericValue(posicionNueva.charAt(0));
        
        String posAntigua = y+""+x;
        
        String posicionArriba=(y - 1) + "" + x;
        String posicionAbajo=(y+1)+""+x;
        String posicionIzquierda=y+""+(x-1);
        String posicionDerecha=y+""+(x+1);
        
        String posicionArribaN=y2+ "" + x2;
        String posicionAbajoN=y2+""+x2;
        String posicionIzquierdaN=y2+""+x2;
        String posicionDerechaN=y2+""+x2;

        if (turnoJugador=='A'){
           if (posicionArribaN.equals(posicionArriba) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionAbajoN.equals(posicionAbajo) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionIzquierdaN.equals(posicionIzquierda) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionDerechaN.equals(posicionDerecha) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionArribaN.equals(posicionArriba) && tablero[y2][x2].equals("B_fantasmaBueno") || tablero[y2][x2].equals("B_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            } else if (posicionAbajoN.equals(posicionAbajo) && tablero[y2][x2].equals("B_fantasmaBueno") || tablero[y2][x2].equals("B_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            }else if (posicionIzquierdaN.equals(posicionIzquierda) && tablero[y2][x2].equals("B_fantasmaBueno") || tablero[y2][x2].equals("B_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            }else if (posicionDerechaN.equals(posicionDerecha) && tablero[y2][x2].equals("B_fantasmaBueno") || tablero[y2][x2].equals("B_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            }
            else{
            JOptionPane.showMessageDialog(null, "Movimiento invalido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        
        if (turnoJugador=='B'){
            if (posicionArribaN.equals(posicionArriba) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionAbajoN.equals(posicionAbajo) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionIzquierdaN.equals(posicionIzquierda) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            } else if (posicionDerechaN.equals(posicionDerecha) && ((tablero[y2][x2].equals("") || TrampaComeReal(posicionNueva)))) {
                return true;
            }else if (posicionArribaN.equals(posicionArriba) && tablero[y2][x2].equals("A_fantasmaBueno") || tablero[y2][x2].equals("A_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            } else if (posicionAbajoN.equals(posicionAbajo) && tablero[y2][x2].equals("A_fantasmaBueno") || tablero[y2][x2].equals("A_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            }else if (posicionIzquierdaN.equals(posicionIzquierda) && tablero[y2][x2].equals("A_fantasmaBueno") || tablero[y2][x2].equals("A_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
            }else if (posicionDerechaN.equals(posicionDerecha) && tablero[y2][x2].equals("A_fantasmaBueno") || tablero[y2][x2].equals("A_fantasmaMalo")){
                boton(posAntigua).setIcon(null);
                tablero[y][x]="";
               JOptionPane.showMessageDialog(null, "Perdiste tu fantasma\nTratando de comerte a un fantasma real.", "Error", JOptionPane.ERROR_MESSAGE);
                cambiarTurno();
               return false;
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
                    contadorBbuenos++;
                    return true;
                }
                if (tablero[y2][x2].charAt(10) == 'M') {
                    contadorBmalos++;
                    return true;
                }
                if (tablero[y2][x2].charAt(10)== 'F') {
                    return true;
                }
            }
        } 
        
        if (turnoJugador=='B'){
            if (tablero[y2][x2].charAt(0) == 'A') {
                if (tablero[y2][x2].charAt(10) == 'B') {
                    contadorAbuenos++;
                    return true;
                }
                if (tablero[y2][x2].charAt(10) == 'M') {
                    contadorAmalos++;
                    return true;
                }
                if (tablero[y2][x2].charAt(10)== 'F') {
                    return true;
                }
            }
        }  
         return false;

    }
    
    private void EsComibleMes(String posicionNueva) {
        if (turnoJugador=='A'){
            if (posicionNueva.charAt(0) == 'B') {
                if (posicionNueva.charAt(10) == 'B') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma bueno de "+jugador2, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                if (posicionNueva.charAt(10) == 'M') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma malo de "+jugador2, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                if (posicionNueva.charAt(10)== 'F') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma trampa de "+jugador2, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } 
        
        if (turnoJugador=='B'){
            if (posicionNueva.charAt(0) == 'A') {
                if (posicionNueva.charAt(10) == 'B') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma bueno de "+jugador1, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                if (posicionNueva.charAt(10) == 'M') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma malo de "+jugador1, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
                if (posicionNueva.charAt(10)== 'F') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma trampa de "+jugador1, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }  
    }

    private boolean TrampaComeReal(String posicionNueva) {
        int x2 = Character.getNumericValue(posicionNueva.charAt(1));
        int y2 = Character.getNumericValue(posicionNueva.charAt(0));

        if (turnoJugador=='A'){
            if (tablero[y2][x2].charAt(0) == 'B') {
                if (tablero[y2][x2].charAt(10)== 'F') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma trampa de "+jugador2, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        } 
        
        if (turnoJugador=='B'){
            if (tablero[y2][x2].charAt(0) == 'A') {
                if (tablero[y2][x2].charAt(10)== 'F') {
                    JOptionPane.showMessageDialog(null, "Te has comido un fantasma trampa de "+jugador1, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        }  
         return false;

    }
    
    private void cambiarInfoJugador() {
        if (ModoJuego.getModoJuegoDif().equals("Normal")) {
                Juego.LabelJug1.setText("<html>Fantasma Buenos: "+(4-contadorAbuenos)+"\n"+"Fantasma Malos: "+(4-contadorAmalos)+"<html>");
                Juego.LabelJug2.setText("<html>Fantasma Buenos: "+(4-contadorBbuenos)+"\n"+"Fantasma Malos: "+(4-contadorBmalos)+"<html>");

        } 
        if (ModoJuego.getModoJuegoDif().equals("Expert")) {
                Juego.LabelJug1.setText("<html>Fantasma Buenos: "+(2-contadorAbuenos)+"\n"+"Fantasma Malos: "+(2-contadorAmalos)+"<html>");
                Juego.LabelJug2.setText("<html>Fantasma Buenos: "+(2-contadorBbuenos)+"\n"+"Fantasma Malos: "+(2-contadorBmalos)+"<html>");

        } 
        if (ModoJuego.getModoJuegoDif().equals("Genius")) {
                Juego.LabelJug1.setText("<html>Fantasma Buenos: "+(1-contadorAbuenos)+"\n"+"Fantasma Malos: "+(1-contadorAmalos)+"<html>");
                Juego.LabelJug2.setText("<html>Fantasma Buenos: "+(1-contadorBbuenos)+"\n"+"Fantasma Malos: "+(1-contadorBmalos)+"<html>");

        }
        Juego.LabelJug1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), jugador1, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gigi", 1, 14)));
        Juego.LabelJug2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), jugador2, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Gigi", 1, 14)));
    }
  
    private void comprobarGane1() {
        if (ModoJuego.getModoJuegoDif().equals("Normal")) {
                if ((4-contadorAbuenos)==0) {
                    JOptionPane.showMessageDialog(null, jugador2+" triunfo sobre "+jugador1+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 0, jugador2, 3);
                    juego.dispose();
                }
                if ((4-contadorBbuenos)==0) {
                    JOptionPane.showMessageDialog(null, jugador1+" triunfo sobre "+jugador2+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                    juego.dispose();
                }
        } else if (ModoJuego.getModoJuegoDif().equals("Expert")) {
                if ((2-contadorAbuenos)==0) {
                    JOptionPane.showMessageDialog(null, jugador2+" triunfo sobre "+jugador1+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 0, jugador2, 3);
                    juego.dispose();
                }
                if ((2-contadorBbuenos)==0) {
                    JOptionPane.showMessageDialog(null, jugador1+" triunfo sobre "+jugador2+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                    juego.dispose();
                }
        } else if (ModoJuego.getModoJuegoDif().equals("Genius")) {
                    if ((1-contadorAbuenos)==0) {
                        JOptionPane.showMessageDialog(null, jugador2+" triunfo sobre "+jugador1+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 0, jugador2, 3);
                        juego.dispose();
                    }
                    if ((1-contadorBbuenos)==0) {
                        JOptionPane.showMessageDialog(null, jugador1+" triunfo sobre "+jugador2+" porque capturó todos sus fantasmas buenos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                        Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                        juego.dispose();
                    }
        }
    }
    
    private void comprobarGane2() {
        if (ModoJuego.getModoJuegoDif().equals("Normal")) {
                if ((4-contadorAmalos)==0) {
                    JOptionPane.showMessageDialog(null, jugador1+" triunfo porque "+jugador2+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                    juego.dispose();
                }
                if ((4-contadorBmalos)==0) {
                    JOptionPane.showMessageDialog(null,jugador2+" triunfo porque "+jugador1+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                   Puntaje.incrementarPuntos(jugador1, 0, jugador2, 3);
                    juego.dispose();
                }
        } else if (ModoJuego.getModoJuegoDif().equals("Expert")) {
                if ((2-contadorAmalos)==0) {
                    JOptionPane.showMessageDialog(null, jugador1+" triunfo porque "+jugador2+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                    juego.dispose();
                }
                if ((2-contadorBmalos)==0) {
                    JOptionPane.showMessageDialog(null,jugador2+" triunfo porque "+jugador1+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 0, jugador2,3);
                    juego.dispose();
                }
        } else if (ModoJuego.getModoJuegoDif().equals("Genius")) {
                if ((1-contadorAmalos)==0) {
                    JOptionPane.showMessageDialog(null, jugador1+" triunfo porque "+jugador2+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                    juego.dispose();
                }
                if ((1-contadorBmalos)==0) {
                    JOptionPane.showMessageDialog(null,jugador2+" triunfo porque "+jugador1+" le capturó todos sus fantasmas malos!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                    Puntaje.incrementarPuntos(jugador1, 0, jugador2, 3);
                    juego.dispose();
                }
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
                JOptionPane.showMessageDialog(null, jugador1+" triunfo al sacar del castillo un fantasma bueno!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                Puntaje.incrementarPuntos(jugador1, 3, jugador2, 0);
                juego.dispose();
           } 
           
            if (tablero[y][x].equals("B_fantasmaBueno") && tablero[y2][x2].equals("SalidaA") ) {
                JOptionPane.showMessageDialog(null, jugador2+" triunfo al sacar del castillo un fantasma bueno!", "¡Ganaste!", JOptionPane.INFORMATION_MESSAGE);
                Puntaje.incrementarPuntos(jugador1, 0, jugador2, 3);
                juego.dispose();
            } 
        }
   
        private int obtenerPos(int POS) {
            int x = Character.getNumericValue(posicionAntigua.charAt(1));
            int y = Character.getNumericValue(posicionAntigua.charAt(0));
            int POSICION=y+x;
            return POSICION;
        }
   
        private void ponerImagenA(String posicion) {
            boton(posicion).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fantasmaNuevo1.png")));
        }
        
        private void ponerImagenB(String posicion) {
            boton(posicion).setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fantasmaNuevo2.png")));
        }   
        
        private void fichasSiNormal() {
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaMalo");
        AFantasmas.add("A_fantasmaMalo");
        AFantasmas.add("A_fantasmaMalo");
        AFantasmas.add("A_fantasmaMalo");
        
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaMalo");
        BFantasmas.add("B_fantasmaMalo");
        BFantasmas.add("B_fantasmaMalo");
        BFantasmas.add("B_fantasmaMalo");
        }
        
        private void fichasSiExpert() {
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaMalo");
        AFantasmas.add("A_fantasmaMalo");
        
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaMalo");
        BFantasmas.add("B_fantasmaMalo");
        }
        
        private void fichasSiGenius() {
        AFantasmas.add("A_fantasmaBueno");
        AFantasmas.add("A_fantasmaMalo");
        AFantasmas.add("A_fantasmaFake");
        AFantasmas.add("A_fantasmaFake");
        AFantasmas.add("A_fantasmaFake");
        AFantasmas.add("A_fantasmaFake");        
        
        BFantasmas.add("B_fantasmaBueno");
        BFantasmas.add("B_fantasmaMalo");
        BFantasmas.add("B_fantasmaFake");
        BFantasmas.add("B_fantasmaFake");
        BFantasmas.add("B_fantasmaFake");
        BFantasmas.add("B_fantasmaFake");    
        }
        
        private void numerosPosA() {
            numerosPosA.add("01");
            numerosPosA.add("02");
            numerosPosA.add("03");
            numerosPosA.add("04");
            numerosPosA.add("11");
            numerosPosA.add("12");
            numerosPosA.add("13");
            numerosPosA.add("14");
            
        }
        
        private void numerosPosB() {
            numerosPosB.add("41");
            numerosPosB.add("42");
            numerosPosB.add("43");
            numerosPosB.add("44");
            numerosPosB.add("51");
            numerosPosB.add("52");
            numerosPosB.add("53");
            numerosPosB.add("54");
            
        }
        
        public void cerraJUEGO() {
            juego.dispose();
        }
        
        public void ponerFichasManual() {
                switch (turnoJugador) {
                case 'A':
                    Object[] numPosA = numerosPosA.toArray();

                    String opcionSeleccionada = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione una la posicion que desea \n (fila,columna):",
                        jugador1,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        numPosA,
                        numPosA[0]
                    ); 
                    if (opcionSeleccionada==null) {
                        juego.dispose();
                    }
                    
                    if ( AFantasmas.size() > 0) {
                        int x = Character.getNumericValue(opcionSeleccionada.charAt(1));
                        int y = Character.getNumericValue(opcionSeleccionada.charAt(0));

                        ponerImagenA(opcionSeleccionada);
                        tablero[y][x]=AFantasmas.get(contadorA);
                        int i=getNumeroDePosicionA(opcionSeleccionada);
                        
                        AFantasmas.remove(contadorA);
                        numerosPosA.remove(i);
                    } 
                   
                    break;

                case 'B':
                    Object[] numPos = numerosPosB.toArray();

                    String opcionSeleccionadaB = (String) JOptionPane.showInputDialog(
                        null,
                        "Seleccione una la posicion que desea \n (fila,columna):",
                        jugador2,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        numPos,
                        numPos[0]
                    );
                    if (opcionSeleccionadaB==null) {
                        juego.dispose();
                    }
                    
                    if ( BFantasmas.size() > 0) {
                        int x = Character.getNumericValue(opcionSeleccionadaB.charAt(1));
                        int y = Character.getNumericValue(opcionSeleccionadaB.charAt(0));

                        ponerImagenB(opcionSeleccionadaB);
                        tablero[y][x]=BFantasmas.get(contadorB);
                        int i=getNumeroDePosicionB(opcionSeleccionadaB);
                        
                        BFantasmas.remove(contadorB);
                        numerosPosB.remove(i);
                    }
                    break;
            }
        }
        
        private int getNumeroDePosicionA(String opcionSelec) {
            for (int i=0; numerosPosA.size()>1; i++){
                if (numerosPosA.get(i).equals(opcionSelec)) {
                    return i;
                }
            }
            return 0;
        }
        
        private int getNumeroDePosicionB(String opcionSelec) {
            for (int i=0; numerosPosB.size()>1; i++){
                if (numerosPosB.get(i).equals(opcionSelec)) {
                    return i;
                }
            }
            return 0;
        }
        
        private void mostrarCoor() {
            Juego.Coor1.setVisible(true);
            Juego.Coor2.setVisible(true);
            Juego.Coor3.setVisible(true);
            Juego.Coor4.setVisible(true);
            Juego.Coor5.setVisible(true);
            Juego.Coor6.setVisible(true);
            Juego.Coor7.setVisible(true);

        }
        private void ocultarCoor() {
            Juego.Coor1.setVisible(false);
            Juego.Coor2.setVisible(false);
            Juego.Coor3.setVisible(false);
            Juego.Coor4.setVisible(false);
            Juego.Coor5.setVisible(false);
            Juego.Coor6.setVisible(false);
            Juego.Coor7.setVisible(false);

        }
}
 
     
