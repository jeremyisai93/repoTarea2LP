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
abstract class AbstractCreator {
    
    Bloque CrearBloque(){
        Bloque B= new Bloque() {};
        return B;
    }
}
