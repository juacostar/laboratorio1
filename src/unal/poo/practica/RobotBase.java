package unal.poo.practica;
import becker.robots.*;
import java.util.Scanner;
/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,6, 2, Direction.NORTH,200);
            Scanner x= new Scanner(System.in);
           
            System.out.println("Escriba el numero");
            int num= x.nextInt();
            posicion(); //va desde su posicion inicial hasta el 0-0 de la matriz
            int digitos=Integer.toString(num).length();//saber el tamaño del numero
            String numero= Integer.toString(num);//para acceder a los caracteres en caso del 0
            if(digitos==1){
                poner(traducir(0));
                retornar();
                posicion();
                poner(traducir(0));
                retornar();
                posicion();
                poner(traducir(num));// se tarduce de numero entero a matriz de booleanos y de matriz a numero en el mundo de karel
                retornar();//posicion inicial para el otro digito
            }
            
            if(digitos==2){
               
                poner(traducir(0));
                retornar();
                posicion();
               
               int[]A= separar2(num);
               poner(traducir(A[0]));
               retornar();
               posicion();
               poner(traducir(A[1]));
            }
            
            if(digitos==3){
                 if(numero.charAt(0)=='0'){
                    poner(traducir(0));
                    retornar();
                    posicion();
                }
                int[] B=separar3(num);
                poner(traducir(B[0]));
                retornar();
                posicion();
                poner(traducir(B[1]));
                retornar();
                posicion();
                poner(traducir(B[2]));
            }
            
       
}
        


public static void poner(boolean[][] A){
    for(int i=0;i<5;i++){
        for(int j=0;j<3;j++){
             estudiante.move();
            
             if (i==0 && j==1){
                 girar3();
             }
            
            if(i==0 && j==2){
                girar3();
            }
            
            if(i==1 && j==1){
                estudiante.turnLeft();
            }
            
            if(i==1 && j==2){
                estudiante.turnLeft();
            }
            
            if(i==2 && j==1){
                girar3();
            }
            
            if(i==2 && j==2){
                girar3();
            }
            
            if(i==3 && j==1){
                estudiante.turnLeft();
            }
            
            if(i==3 && j==2){
                estudiante.turnLeft();
            }
            
            if(i==4 && j==1){
                estudiante.turnLeft();
                estudiante.turnLeft();
                estudiante.putThing();
                estudiante.move();
                estudiante.turnLeft();
                
            }
            
           if(A[i][j]){
               estudiante.putThing();
           }
           
        }
    }
    
   
}

public static boolean[][] traducir(int x){
    boolean[][] A=new boolean[5][3];
    switch(x){
        case 0:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[0][2]=true;
        A[1][1]=true;
        A[1][2]=true;
        A[2][0]=false;
        A[2][1]=true;
        A[2][2]=true;
        A[3][1]=true;
        A[3][2]=true;
        A[4][0]=true;
        break;
        
        case 1:
        A[0][1]=true;
        A[0][2]=true;
        A[2][1]=true;
        A[2][2]=true;
        break;
        
        case 2:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[0][2]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[3][1]=true;
        A[3][2]=true;
        A[4][0]=true;
        break;
        
        case 3:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[0][2]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[2][2]=true;
        A[3][2]=true;
        A[4][0]=true;
        break;
        
        case 4:
        estudiante.putThing();
        A[0][1]=true;
        A[0][2]=true;
        A[1][1]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[2][2]=true;
        break;
        
        case 5:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[1][1]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[2][2]=true;
        A[3][2]=true;
        A[4][0]=true;
        break;
        
        case 6:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[1][1]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[2][2]=true;
        A[3][1]=true;
        A[3][2]=true;
        A[4][0]=true;
        break;
        
        case 7:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[0][2]=true;
        A[2][1]=true;
        A[2][2]=true;
        break;
        
        case 8:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[0][2]=true;
        A[1][1]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[2][2]=true;
        A[3][1]=true;
        A[3][2]=true;
        A[4][0]=true;
        break;
        
        case 9:
        estudiante.putThing();
        A[0][0]=true;
        A[0][1]=true;
        A[0][2]=true;
        A[1][1]=true;
        A[1][2]=true;
        A[2][0]=true;
        A[2][1]=true;
        A[2][2]=true;
        break;
        
    }
    
    return A;
}

public static int[] separar2(int x){
    int[] digitos= new int[2];
    int i=0;
    digitos[i]=x/10;
    digitos[i+1]=x%10;
    return digitos;
}

public static int[] separar3(int x){
    int[]A= new int[3];
        for(int i=0;i<3;i++){
            A[2-i]=x%10;
            x=x/10;
        }
       
    return A;
}

public static void girar3(){
    estudiante.turnLeft();
    estudiante.turnLeft();
    estudiante.turnLeft();
}

public static void retornar(){
                estudiante.turnLeft();
                estudiante.move();            
                estudiante.move();
                estudiante.move();
                estudiante.turnLeft();
}

public static void posicion(){
            estudiante.move();
            estudiante.turnLeft();
            estudiante.move();
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.move();
            estudiante.move();
            estudiante.move();
            estudiante.move();
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
}        


}
