package tarea2lp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 */
public class BloqueColor extends Bloque {
    private String color;
    static int R=0,G=0,B=0,Y=0,O=0;
    
    void setBloqueColor(String color){
        this.color=color;
    }
    
    String getBloqueColor(){
        return this.color;
    }
        
    @Override
    void DestruirBloque(){
        if (null != this.color)switch (this.color) {
            case "R":
                R++;
                break;
            case "G":
                G++;
                break;
            case "B":
                B++;
                break;
            case "Y":
                Y++;
                break;
            case "O":
                O++;
                break;
        }
        this.color=" ";
    }
    
}
