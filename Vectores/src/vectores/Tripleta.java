/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectores;

/**
 *
 * @author alejandro.gallegoc
 */
public class Tripleta {
    private int dato;
    private int posicion;
    private String nombre;

    public Tripleta() {
    }

    public Tripleta(int dato, int posicion, String nombre) {
        this.dato = dato;
        this.posicion = posicion;
        this.nombre = nombre;
    }
    
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
