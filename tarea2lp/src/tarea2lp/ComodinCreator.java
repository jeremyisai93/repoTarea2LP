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
public class ComodinCreator extends AbstractCreator{
    
    @Override
    Bloque CrearBloque(){
        Bloque B=new BloqueComodin() {};
        return B;
    }
}
