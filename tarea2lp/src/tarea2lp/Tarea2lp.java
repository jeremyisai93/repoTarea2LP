/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea2lp;

import java.util.*; 
//import java.util.Random;
/**
 *
 * @author Jeremy
 */
public class Tarea2lp {

    /**
     * @param args the command line arguments
     */
    static void ImprimirTablero(Bloque Tabla[][]){
            //impresion de tablero de Juego
        System.out.print("\n\n\n\n\n\n\n");
        System.out.println("    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15\n");
        for (int i = 0; i < 15; i++) {
            if (i<9) System.out.print(i+1+"   ");
            else System.out.print(i+1+"  ");
            for (int j=0;j<15;j++){
                try{
                   System.out.print(((BloqueColor) Tabla[i][j]).getBloqueColor()+"  "); 
                }
                catch(Exception e){
                    System.out.print(((BloqueComodin) Tabla[i][j]).getBloqueComodin()+"  "); 
                }
                
            }
           System.out.print("\n");
        }
    
    }
    
    static boolean DestruirCeldas(Bloque Tabla[][]){
        boolean a=false;
        for (int i=0;i<15;i++){
                String actual,next,borrado;
                for (int j=0;j<15;j++){
                    try{
                        actual=((BloqueColor) Tabla[i][j]).getBloqueColor(); 
                    }
                    catch(Exception e){
                        actual=((BloqueComodin) Tabla[i][j]).getBloqueComodin();
                    }
                    int up=1,down=1,left=1,right=1,cont=0;
                   
                    while(i-up>=0){
                        try{
                            next=((BloqueColor) Tabla[i-up][j]).getBloqueColor(); 
                        }
                        catch(Exception e){
                            next=((BloqueComodin) Tabla[i-up][j]).getBloqueComodin();
                        }
                        if(actual.equals(next) || "$".equals(next) || "&".equals(next)){
                            up++;
                        }
                        
                        
                        else{
                            break;
                        }
                    }
                    while(i+down<15){
                        try{
                            next=((BloqueColor) Tabla[i+down][j]).getBloqueColor(); 
                        }
                        catch(Exception e){
                            next=((BloqueComodin) Tabla[i+down][j]).getBloqueComodin();
                        }
                        if(actual.equals(next) || "$".equals(next) || "&".equals(next)){
                            down++;
                        }            
                        else{
                           break;
                        }
                    }
                    if ((up+down)>3){
                        a=true;
                        for (int k=0;k<up;k++){
                            try{
                                borrado=((BloqueColor) Tabla[i-k][j]).getBloqueColor(); 
                            }
                            catch(Exception e){
                                borrado=((BloqueComodin) Tabla[i-k][j]).getBloqueComodin();
                            }
                            
                            if ("$".equals(borrado) ){
                                for (int m=0;m<15;m++){
                                    Tabla[m][j].DestruirBloque();
                                }
                            }
                            else if ("&".equals(borrado)){
                                for (int m=0;m<15;m++){
                                    Tabla[i-k][m].DestruirBloque();
                                }
                            }
                            Tabla[i-k][j].DestruirBloque();
                        }
                        for (int k=0;k<down;k++){
                            try{
                                borrado=((BloqueColor) Tabla[i+k][j]).getBloqueColor(); 
                            }
                            catch(Exception e){
                                borrado=((BloqueComodin) Tabla[i+k][j]).getBloqueComodin();
                            }
                            
                            if ("$".equals(borrado) ){
                                for (int m=0;m<15;m++){
                                    Tabla[m][j].DestruirBloque();
                                }
                            }
                            else if ("&".equals(borrado)){
                                for (int m=0;m<15;m++){
                                    Tabla[i+k][m].DestruirBloque();
                                }
                            }
                            
                            Tabla[i+k][j].DestruirBloque();
                        }
                    }
                    
                    while(j-left>=0){
                        try{
                            next=((BloqueColor) Tabla[i][j-left]).getBloqueColor(); 
                        }
                        catch(Exception e){
                            next=((BloqueComodin) Tabla[i][j-left]).getBloqueComodin();
                        }
                        if(actual.equals(next) || "$".equals(next) || "&".equals(next)){
                            left++;
                        }
                        else{
                            break;
                        }
                    }
                    while(j+right<15){
                        try{
                            next=((BloqueColor) Tabla[i][j+right]).getBloqueColor(); 
                        }
                        catch(Exception e){
                            next=((BloqueComodin) Tabla[i][j+right]).getBloqueComodin();
                        }
                        if(actual.equals(next) || "$".equals(next) || "&".equals(next)){
                            right++;
                        }
                        else{
                           break;
                        }
                    }
                    if ((right+left)>3){
                        a=true;
                        for (int k=0;k<left;k++){
                            try{
                                borrado=((BloqueColor) Tabla[i][j-k]).getBloqueColor(); 
                            }
                            catch(Exception e){
                                borrado=((BloqueComodin) Tabla[i][j-k]).getBloqueComodin();
                            }
                            
                            if ("$".equals(borrado) ){
                                for (int m=0;m<15;m++){
                                    Tabla[m][j-k].DestruirBloque();
                                }
                            }
                            else if ("&".equals(borrado)){
                                for (int m=0;m<15;m++){
                                    Tabla[i][m].DestruirBloque();
                                }
                            }
                            Tabla[i][j-k].DestruirBloque();
                        }
                        for (int k=0;k<right;k++){
                            try{
                                borrado=((BloqueColor) Tabla[i][j+k]).getBloqueColor(); 
                            }
                            catch(Exception e){
                                borrado=((BloqueComodin) Tabla[i][j+k]).getBloqueComodin();
                            }
                            
                            if ("$".equals(borrado) ){
                                for (int m=0;m<15;m++){
                                    Tabla[m][j+k].DestruirBloque();
                                }
                            }
                            else if ("&".equals(borrado)){
                                for (int m=0;m<15;m++){
                                    Tabla[i][m].DestruirBloque();
                                }
                            }
                            Tabla[i][j+k].DestruirBloque();
                            
                        }
                    }     
                }
            }
        return a;
    }
    
    static void RellenarColumna(Bloque Tabla[][], int j){
        Random r = new Random();
        String tColores = "RBOGY";
        String tComodin = "$&";
        String actual,color,next;
        int tot=0;
        while(tot!=14){
            //tot=0;
            for (int i=14; i>=0;i--){
                try{
                    actual=((BloqueColor) Tabla[i][j]).getBloqueColor(); 
                }
                catch(Exception e){
                    actual=((BloqueComodin) Tabla[i][j]).getBloqueComodin();
                }
                if (" ".equals(actual) && i!=0){
                    try{
                        color=((BloqueColor) Tabla[i-1][j]).getBloqueColor();
                        Tabla[i][j]= new ColorCreator().CrearBloque();
                        ((BloqueColor) Tabla[i][j]).setBloqueColor(color);
                        Tabla[i-1][j].DestruirBloque();
                    }
                    catch(Exception e){
                        color=((BloqueComodin) Tabla[i-1][j]).getBloqueComodin();
                        Tabla[i][j]= new ComodinCreator().CrearBloque();
                        ((BloqueComodin) Tabla[i][j]).setBloqueComodin(color);
                        Tabla[i-1][j].DestruirBloque();
                    }
                }
                
            } 
        tot++;
        ImprimirTablero(Tabla);
        }        
        for(int i=0; i<15;i++){
            try{
                actual=((BloqueColor) Tabla[0][j]).getBloqueColor(); 
            }
            catch(Exception e){
                actual=((BloqueComodin) Tabla[0][j]).getBloqueComodin();
            }
            if (" ".equals(actual)){
                int n= r.nextInt(20);
                if (n<19){
                    Tabla[0][j]= new ColorCreator().CrearBloque();
                    ((BloqueColor) Tabla[0][j]).setBloqueColor(Character.toString(tColores.charAt(r.nextInt(tColores.length()))));
                }
                else {
                    Tabla[0][j]= new ComodinCreator().CrearBloque();
                   ((BloqueComodin) Tabla[0][j]).setBloqueComodin(Character.toString(tComodin.charAt(r.nextInt(tComodin.length()))));
                }
                int cont=0;
                try{
                    next=((BloqueColor) Tabla[cont+1][j]).getBloqueColor(); 
                }
                catch(Exception e){
                    next=((BloqueComodin) Tabla[cont+1][j]).getBloqueComodin();
                }
                while(" ".equals(next) && cont<14){
                    try{
                        color=((BloqueColor) Tabla[cont][j]).getBloqueColor();
                        Tabla[cont+1][j]= new ColorCreator().CrearBloque();
                        ((BloqueColor) Tabla[cont+1][j]).setBloqueColor(color);
                        Tabla[cont][j].DestruirBloque();
                    }
                    catch(Exception e){
                        color=((BloqueComodin) Tabla[cont][j]).getBloqueComodin();
                        Tabla[cont+1][j]= new ComodinCreator().CrearBloque();
                        ((BloqueComodin) Tabla[cont+1][j]).setBloqueComodin(color);
                        Tabla[cont][j].DestruirBloque();
                    }
                    cont++;
                    if (cont<14){
                        try{
                            next=((BloqueColor) Tabla[cont+1][j]).getBloqueColor(); 
                        }
                        catch(Exception e){
                            next=((BloqueComodin) Tabla[cont+1][j]).getBloqueComodin();
                        }
                    }
                    
                }
            }ImprimirTablero(Tabla);
            
            
        }
        
    }
    
    static void RellenarTablero(Bloque Tabla[][]){
        
        for (int j = 14; j >= 0; j--) {
            RellenarColumna(Tabla,j);
        }
    }
    
    
            
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Presione una Enter para empezar....");
        leer.nextLine();
        
        Bloque [][] Tabla =new Bloque[15][15];
        
        Random r = new Random();
        //Random s = new Random();

        String tColores = "RBOGY";
        String tComodin = "$&";
        //llenado de Matriz de juego
        
        for (int i = 0; i < 15; i++) {
            for (int j=0;j<15;j++){
                int n= r.nextInt(20);
                if (n<19){
                    Tabla[i][j]= new ColorCreator().CrearBloque();
                    ((BloqueColor) Tabla[i][j]).setBloqueColor(Character.toString(tColores.charAt(r.nextInt(tColores.length()))));
                }
                else {
                    Tabla[i][j]= new ComodinCreator().CrearBloque();
                    ((BloqueComodin) Tabla[i][j]).setBloqueComodin(Character.toString(tComodin.charAt(r.nextInt(tComodin.length()))));
                
                }
            }
                         
        }
        //ImprimirTablero(Tabla);
        
        
        while (true){
            ImprimirTablero(Tabla);
            while(DestruirCeldas(Tabla)){
                ImprimirTablero(Tabla);
                RellenarTablero(Tabla);
                ImprimirTablero(Tabla);
                //System.out.println("-------------------------------------------");
                //leer.nextLine();
            }
            
            
            /*System.out.println("Por favor ingrese cordenada de inicio y la cordenaa de destino");
            System.out.print("Inicio (x)");
            int x1=leer.nextInt();
            System.out.print("Inicio (y)");
            int y1=leer.nextInt();*/
            break;
        }
    }
    
}
