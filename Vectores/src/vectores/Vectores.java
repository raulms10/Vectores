/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro.gallegoc
 */
public class Vectores {
    
    static int A[]; //Vector A
    static int B[]; //Vector B
    static int r; //Número de elementos de A
    static int s; //Número de elementos de B
    
    static int datoN; //Dato N
    
    static String  valoresVector; //Será el String para leer los elementos de un vector ej: 1,5,2,6

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        leerVectores();
        imprimirVectores();
        ordenarVectores();
        imprimirVectores();
        leerDatoN();
        r = A.length-1;
        s = B.length-1;
        System.out.println("Dato N: " + datoN + " A: " + r + " B: " + s);
    }

    private static void leerVectores() {
        A = leerDatos("A");
        B = leerDatos("B");
    }
    
    private static int[] leerDatos(String vector){
        int v[] = null; // Definimos el vector que se va a leer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Definimos el Buffer para leer datos por consola
        System.out.print("Ingrese los datos del vector "+ vector + " separados por coma(,): "); //Digite los datos del vector
        try {
            valoresVector = br.readLine(); //Leemos los datos ingresados (hasta que se presione ENTER)
            StringTokenizer strToken = new StringTokenizer(valoresVector, ","); //Separa los datos de un vector
            int tam = strToken.countTokens(); //Número de elementos de un vector
            v = new int[tam+1]; //Se crea el vector según la cantidad de elementos leídos (tokens)
            int pos = 1; // Iniciamos posicion en 1
            while(strToken.hasMoreTokens()){ // Mientras existan tokens, haga
                v[pos] = Integer.parseInt(strToken.nextToken()); //Obtenemos cada token(elemento), lo convertimos a entero y lo almacenamos en el vector
                pos++; //Aumentamos la posición
            }     
        } catch (IOException ex) { //Error de lectura
            System.out.println("No fue posible leer los datos del vector " + vector);
        } catch (NumberFormatException e){ //Error de formato, ej: se digitó una letra
            System.err.println("Sólo digite números separados por coma");
            System.exit(0); //Cancelamos la ejecución
        }
        return v; //Retornamos el vector
    }
    
    private static void imprimirVectores(){
        System.out.print("\nVerctor A: ");
        for(int i=1; i < A.length; i++){ //Recorremos el vector A
            System.out.print(A[i] + " "); //Mostramos cada elemento
        }
        System.out.print("\nVerctor B: ");
        for(int i=1; i < B.length; i++){ //Recorremos el vector A
            System.out.print(B[i] + " "); //Mostramos cada elemento
        }
        System.out.println("");
    }
    
    private static void ordenarVectores() {
        int aux; //Auxiliar para intercambiar las posiciones del Vector
        for(int i=1; i < A.length; i++){ //Para cada elemento del vector A
            for(int j=1; j < A.length; j++){  //Para cada elemento del vector A
                if(A[i] < A[j]){ //Comparamos todos contra todos
                    aux = A[i]; //Guardamos la posición i en aux
                    A[i] = A[j]; //Pasamos la posición j a la i
                    A[j] = aux; //Pasamos aux a la posición j
                }
            }
        }
        
        for(int i=1; i < B.length; i++){ //Para cada elemento del vector B
            for(int j=1; j < B.length; j++){ //Para cada elemento del vector B
                if(B[i] < B[j]){ //Comparamos todos contra todos
                    aux = B[i]; //Guardamos la posición i en aux
                    B[i] = B[j]; //Pasamos la posición j a la i
                    B[j] = aux; //Pasamos aux a la posición j
                }
            }
        }
    }
    
    private static void leerDatoN(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Definimos el Buffer para leer datos por consola
        try {
            System.out.print("Digite el dato N: ");
            String str = br.readLine(); //Leemos el dato, la línea (hasta que se presione ENTER)
            datoN = Integer.parseInt(str);
        } catch (IOException ex) { //Error de lectura
            System.out.println("No fue posible leer el dato N");
        } catch (NumberFormatException ex) { //Error de formato, ej: se digitó una letra
            System.err.println("Debe digitar sólo números enteros");
            System.exit(0); //Cancelamos la ejecución
        }
    }
    
}
