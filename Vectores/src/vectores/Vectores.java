/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro.gallegoc
 */
public class Vectores {
    
    static int A[]; //Vector A
    static int r; //Número de elementos de A
    static int B[]; //Vector B
    static int s; //Número de elementos de B
    
    static String  valoresVector; //Será el String para leer los elementos de un vector ej: 1,5,2,6

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        leerVectores();
        ordenarVectores();
    }

    private static void leerVectores() {
        A = leerDatos("A");
        
        B = leerDatos("B");
        
        imprimirVectores();
    }
    
    private static int[] leerDatos(String vector){
        int v[] = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Definimos el Buffer para leer datos por consola
        System.out.print("Ingrese los datos del vector "+ vector + " separados por coma(,): "); //Digite los datos del vector
        try {
            valoresVector = br.readLine(); //Leemos los datos ingresados (hasta que se presione ENTER)
            
            StringTokenizer strToken = new StringTokenizer(valoresVector, ","); //Separa los datos de un vector
            int tam = strToken.countTokens(); //Número de elementos de un vector
            v = new int[tam+1]; 
            int pos = 1;
            while(strToken.hasMoreTokens()){
                //System.out.println("Elemento: " + strToken.nextToken());
                v[pos] = Integer.parseInt(strToken.nextToken());
                pos++;
            }
            
        } catch (IOException ex) {
            System.out.println("No fue posible leer los datos del vector " + vector);
        }
        
        //System.out.println("Ingresó: " + valoresVector);
        return v;
    }
    
    private static void imprimirVectores(){
        System.out.println("Verctor A");
        for(int i=1; i<A.length; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println("\nVerctor B");
        for(int i=1; i<B.length; i++){
            System.out.print(B[i] + " ");
        }
    }
    
    private static void ordenarVectores() {
        
    }
    
    
}
