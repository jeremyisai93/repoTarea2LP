/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea2lp;

import java.util.Random;
import java.util.*; 
/**
 *
 * @author Jeremy
 */
public class Tarea2lp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer=new Scanner(System.in);
        System.out.println("Presione una Enter para empezar....");
        leer.nextLine();
        
        BloqueColor [][] Tabla=new BloqueColor[15][15];
        
        Random r = new Random();

        String tColores = "RBOGY";
        //llenado de Matriz de juego
        for (int i = 0; i < 15; i++) {
            for (int j=0;j<15;j++){
                Tabla[i][j]= new ColorCreator().CrearBloque();
                Tabla[i][j].setBloqueColor(Character.toString(tColores.charAt(r.nextInt(tColores.length()))));
            }            
        }
        //impresion de tablero de Juego
        for (int i = 0; i < 15; i++) {
            for (int j=0;j<15;j++){
                System.out.print(Tabla[i][j].getBloqueColor()+" ");
            }
           System.out.print("\n");
        }
    }
    
}
