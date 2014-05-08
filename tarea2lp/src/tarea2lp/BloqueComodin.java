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
public class BloqueComodin extends Bloque implements HabilityBehavior{
    String color;
    
   void setBloqueComodin(String color){
        this.color=color;
    }
    
    String getBloqueComodin(){
        return this.color;
    }
    
    @Override
    public void Hability(){

    }
    @Override
    void DestruirBloque(){
        this.color=" ";
    }
        
}
