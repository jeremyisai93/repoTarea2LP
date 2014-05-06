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
    
    void setBloqueColor(String color){
        this.color=color;
    }
    
    String getBloqueColor(){
        return this.color;
    }
    
}
