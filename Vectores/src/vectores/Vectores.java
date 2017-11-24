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

/**
 *
 * @author alejandro.gallegoc
 */
public class Vectores {
    
    static String  valoresVector; //Será el String para leer los elementos de un vector ej: 1,5,2,6
    
    static int A[]; //Vector A
    static int B[]; //Vector B
    static int r; //Número de elementos de A
    static int s; //Número de elementos de B
    
    static int N; //Dato N
    static Tripleta V[];
    
    static int Aprima[]; //Vector A'
    static int Bprima[]; //Vector B'

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
        crearAprimaBprima();
        imprimirAprimaBprima();
        crearVectorV();
        imprimirVectorV();
        //System.out.println("Dato N: " + datoN + " A: " + r + " B: " + s);
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
        } catch (NumberFormatException ex){ //Error de formato, ej: se digitó una letra
            System.err.println("Sólo digite números separados por coma");
            System.exit(0); //Cancelamos la ejecución
        }
        return v; //Retornamos el vector
    }
    
    private static void imprimirVectores(){
        System.out.print("\nVector A: ");
        for(int i=1; i < A.length; i++){ //Recorremos el vector A
            System.out.print(A[i] + " "); //Mostramos cada elemento
        }
        System.out.print("\nVector B: ");
        for(int i=1; i < B.length; i++){ //Recorremos el vector A
            System.out.print(B[i] + " "); //Mostramos cada elemento
        }
        System.out.println("");
    }
    
    private static void imprimirAprimaBprima(){
        System.out.print("\nVector A': ");
        for(int i=1; i <= Aprima[0]; i++){ //Recorremos el vector A
            System.out.print(Aprima[i] + " "); //Mostramos cada elemento
        }
        System.out.print("\nVector B': ");
        for(int i=1; i <= Bprima[0]; i++){ //Recorremos el vector A
            System.out.print(Bprima[i] + " "); //Mostramos cada elemento
        }
        System.out.println("");
    }
    
    private static void imprimirVectorV(){
        System.out.print("\nVector V: ");
        for(int i=1; i < V.length; i++){ //Recorremos el vector A
            if (V[i] != null){
                System.out.print("\n"+i+ " Dato: " + V[i].getDato() + " Pos: " + V[i].getPosicion() + " Proviene: " + V[i].getNombre()); //Mostramos cada elemento
            }
        }
        System.out.println("");
    }
    
    private static void ordenarVectores() {
        int aux; //Auxiliar para intercambiar las posiciones del Vector
        for(int i=1; i < A.length; i++){ //Para cada elemento del vector A
            for(int j=i; j < A.length; j++){  //Para cada elemento del vector A
                if(A[i] > A[j]){ //Comparamos todos contra todos
                    aux = A[i]; //Guardamos la posición i en aux
                    A[i] = A[j]; //Pasamos la posición j a la i
                    A[j] = aux; //Pasamos aux a la posición j
                }
            }
        }
        
        for(int i=1; i < B.length; i++){ //Para cada elemento del vector B
            for(int j=i; j < B.length; j++){ //Para cada elemento del vector B
                if(B[i] > B[j]){ //Comparamos todos contra todos
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
            N = Integer.parseInt(str);
            if (N < 2){
                System.out.println("El dato N debe ser mayor que 1");
                System.exit(0); //Cancelamos la ejecución
            }
        } catch (IOException ex) { //Error de lectura
            System.out.println("No fue posible leer el dato N");
        } catch (NumberFormatException ex) { //Error de formato, ej: se digitó una letra
            System.err.println("Debe digitar sólo números enteros");
            System.exit(0); //Cancelamos la ejecución
        }
    }
    
    private static void crearAprimaBprima() {
        Aprima = new int[N]; //Creamos el vector A'
        Bprima = new int[N]; //Creamos el vector B'
        int techo; // Será el resultado de la función techo multiplicado por i
        for (int i = 1; i <= N-1; i++){
            techo = (int) (i * Math.ceil( ((double)r) /N)); //Calculamos la posición del vector A
            if (techo <= r){ //Verificamos que la posición del vector A exista
                Aprima[i] = A[techo]; //Añadimos el elemento al vector A'
                Aprima[0]++; //Sumamos 1 al tamaño del vector A'
            }
            techo = (int) (i * Math.ceil( ((double)s) /N)); //Calculamos la posición del vector B
            if (techo <= s){ //Verificamos que la posición del vector B exista
                Bprima[i] = B[techo]; //Añadimos el elemento al vector B'
                Bprima[0]++; //Sumamos 1 al tamaño del vector B'
            }
        }
    }

    //1,5,7,10,15      3,4,8,9,16,20
    private static void crearVectorV() {
        int j;
        V = new Tripleta[2*N-1]; //Inicializamos el vector V
        for (int i=1; i <= Aprima[0]; i++){ //for (int i=1; i <= N-1; i++){
            //if(i<=Aprima[0]){
                for (j=1; j <= Bprima[0]; j++){ //Recorremos B' para buscar el j
                    if (Aprima[i] < Bprima[j]){ //Tal que A'[i] < B'[j]
                        break; //Terminamos la búsqueda porque ya encontramos el j
                    }
                }
                if (j <= Bprima[0]){ //Existe j
                    V[i+j-1] = new Tripleta(Aprima[i], i, "A"); //Actualizamos V
                }else{ //Terminó la búsqueda y no encontramos el j
                    V[i+N-1] = new Tripleta(Aprima[i], i, "A");
                }
            //}
        }
        for (int i=1; i <= Bprima[0]; i++){ //for (int i=1; i <= N-1; i++){
            //if(i <= Bprima[0]){
                for (j=1; j <= Aprima[0]; j++){ //Recorremos A' para buscar el j
                    if (Bprima[i] < Aprima[j]){ //Tal que B'[i] < A'[j]
                        break; //Terminamos la búsqueda porque ya encontramos el j
                    }
                }
                if (j <= Aprima[0]){ //Existe j
                    V[i+j-1] = new Tripleta(Bprima[i], i, "B"); //Actualizamos V
                }else{ //Terminó la búsqueda y se encontró el j
                    V[i+N-1] = new Tripleta(Bprima[i], i, "B");  //Actualizamos V
                }
            //}
        }
    }
    
}
