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
        String actual,next;
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
                    swapCelda(Tabla,i,j,i-1,j);
                    /*try{
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
                    }*/
                    
                }
                
            }
        
        tot++;
        
        }
        ImprimirTablero(Tabla);
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
                    swapCelda(Tabla,cont+1,j,cont,j);
                    /*try{
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
                    }*/
                    ImprimirTablero(Tabla);
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
            }//ImprimirTablero(Tabla);
            
            
        }
        
    }
    
    static void RellenarTablero(Bloque Tabla[][]){
        
        for (int j = 14; j >= 0; j--) {
            RellenarColumna(Tabla,j);
        }
    }
    
    static void swapCelda(Bloque Tabla[][],int x1,int y1, int x2, int y2){
            int cel1,cel2;
            String color1,color2;
            
            
            try{
                ((BloqueColor) Tabla[x1][y1]).getBloqueColor();
                cel1=0;
            }
            catch(Exception e){
                ((BloqueComodin) Tabla[x1][y1]).getBloqueComodin();
                cel1=1;
            }
            try{
                ((BloqueColor) Tabla[x2][y2]).getBloqueColor();
                cel2=0;
            }
            catch(Exception e){
                ((BloqueComodin) Tabla[x2][y2]).getBloqueComodin();
                cel2=1;
            }
            if (cel1==0 && cel2==0){
                color1=((BloqueColor) Tabla[x1][y1]).getBloqueColor();
                color2=((BloqueColor) Tabla[x2][y2]).getBloqueColor();
                Tabla[x1][y1]= new ColorCreator().CrearBloque();
                ((BloqueColor) Tabla[x1][y1]).setBloqueColor(color2);
                Tabla[x2][y2]= new ColorCreator().CrearBloque();
                ((BloqueColor) Tabla[x2][y2]).setBloqueColor(color1);                
            }
            else if (cel1==0 && cel2==1){
                color1=((BloqueColor) Tabla[x1][y1]).getBloqueColor();
                color2=((BloqueComodin) Tabla[x2][y2]).getBloqueComodin();
                Tabla[x1][y1]= new ComodinCreator().CrearBloque();
                ((BloqueComodin) Tabla[x1][y1]).setBloqueComodin(color2);
                Tabla[x2][y2]= new ColorCreator().CrearBloque();
                ((BloqueColor) Tabla[x2][y2]).setBloqueColor(color1);                
            }
            else if (cel1==1 && cel2==0){
                color1=((BloqueComodin) Tabla[x1][y1]).getBloqueComodin();
                color2=((BloqueColor) Tabla[x2][y2]).getBloqueColor();
                Tabla[x1][y1]= new ColorCreator().CrearBloque();
                ((BloqueColor) Tabla[x1][y1]).setBloqueColor(color2);
                Tabla[x2][y2]= new ComodinCreator().CrearBloque();
                ((BloqueComodin) Tabla[x2][y2]).setBloqueComodin(color1);                
            }
            else if (cel1==0 && cel2==0){
                color1=((BloqueComodin) Tabla[x1][y1]).getBloqueComodin();
                color2=((BloqueComodin) Tabla[x2][y2]).getBloqueComodin();
                Tabla[x1][y1]= new ComodinCreator().CrearBloque();
                ((BloqueComodin) Tabla[x1][y1]).setBloqueComodin(color2);
                Tabla[x2][y2]= new ComodinCreator().CrearBloque();
                ((BloqueComodin) Tabla[x2][y2]).setBloqueComodin(color1);                
            }        
    }
    static int contarDestruidos(Bloque Tabla[][]){
        String actual;
        int cont=0;
        for (int i = 0; i < 15; i++) {
            for (int j=0;j<15;j++){
                try{
                    actual=((BloqueColor) Tabla[i][j]).getBloqueColor(); 
                }
                catch(Exception e){
                    actual=((BloqueComodin) Tabla[i][j]).getBloqueComodin();
                }
                if (" ".equals(actual)) cont++;
            }
        }
        return cont;
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
        
        int cont=0,ciclo=0;
        
        while (true){
            ImprimirTablero(Tabla);
            while(DestruirCeldas(Tabla)){
                if (ciclo!=0) cont+=contarDestruidos(Tabla);
                if (cont>225){
                    System.out.println("********GANO!!!!********* ");
                    break;
                }
                ImprimirTablero(Tabla);
                RellenarTablero(Tabla);
                RellenarTablero(Tabla);
                ImprimirTablero(Tabla);
            }
            if (cont>225)  break;
            if (ciclo==0){
                BloqueColor.R=0;
                BloqueColor.B=0;
                BloqueColor.O=0;
                BloqueColor.Y=0;
                BloqueColor.G=0;
            }    
            System.out.println("puntaje actual: "+cont);
            System.out.println("Rojo: "+BloqueColor.R);
            System.out.println("Azul: "+BloqueColor.B);
            System.out.println("Naranjo: "+BloqueColor.O);
            System.out.println("Amarillo: "+BloqueColor.Y);
            System.out.println("Verde: "+BloqueColor.G);
            System.out.println("Por favor ingrese cordenada de inicio y la cordenaa de destino");
            System.out.print("Inicio (x)");
            int x1=leer.nextInt();
            System.out.print("Inicio (y)");
            int y1=leer.nextInt();
            System.out.print("Destino (x)");
            int x2=leer.nextInt();
            System.out.print("Destino (y)");
            int y2=leer.nextInt();
           
            swapCelda(Tabla,x1-1,y1-1,x2-1,y2-1);
            ImprimirTablero(Tabla);
            
            leer.nextLine();
            leer.nextLine();
            ciclo++;
            
            //break;
        }
    }
    
}
