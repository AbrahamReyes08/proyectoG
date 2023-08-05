/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author dell
 */
public class Movimientos {
    
    String[][] tablero;
        
    public String[] moverFicha (String[][] tablero, String posicion){
        int x = Character.getNumericValue(posicion.charAt(1));
        int y = Character.getNumericValue(posicion.charAt(0));
        
        String ficha=fichaDeLaCasilla(y,x);
        
        if (ficha.equals("A_fantasmaMalo" ) || ficha.equals("A_fantasmaBueno" )) {
            return movimientoFantasmaA(tablero, y,x);  
        }
        return null;
    }
    
    private String fichaDeLaCasilla(int y,int x) {
        return tablero [y][x];
        
    }
    
    private String[] movimientoFantasmaA(String[][] tablero, int y, int x) {
        String posicionesPosibles="";
        
        if (tablero[y-1][x].equals("")){
            posicionesPosibles+=""+(y+1)+x+"";
        }
        
        try {
            if(isCurrentPlayerPieceB( y-1,x+1)) {
                posicionesPosibles+=""+(y-1)+(x+1)+"_";
            }
            if(isCurrentPlayerPieceB( y-1,x+1)) {
                posicionesPosibles+=""+(y-1)+(x+1)+"_";
            }
        } catch(Exception ex) {
            System.err.println("Aqui ha ocurrido un error pero sigue  skere");
        }
        
        String[] arrayPosicionesPosibles=posicionesPosibles.split("_");
        
        return arrayPosicionesPosibles;
    }
    
    private String[] movimientoFantasmaB(String[][] tablero, int y, int x) {
        String posicionesPosibles="";
        
        if (tablero[y+1][x].equals("")){
            posicionesPosibles+=""+(y+1)+x+"";
        }
        
        try {
            if(isCurrentPlayerPieceB(y+1,x+1)) {
                posicionesPosibles+=""+(y-1)+(x+1)+"_";
            }
            if(isCurrentPlayerPieceB( y+1,x-1)) {
                posicionesPosibles+=""+(y-1)+(x+1)+"_";
            }
        } catch(Exception ex) {
            System.err.println("Aqui ha ocurrido un error pero sigue  skere");
        }
        
        String[] arrayPosicionesPosibles=posicionesPosibles.split("_");
        
        return arrayPosicionesPosibles;
    }
    
    private boolean isCurrentPlayerPieceB( int y,int x) {
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0)=='B')? true:false;
        }
        return false;
    }
    
    private boolean isCurrentPlayerPieceA(int y,int x) {
        if (!tablero[y][x].equals("")) {
            return (tablero[y][x].charAt(0)=='A')? true:false;
        }
        return false;
    }

}
