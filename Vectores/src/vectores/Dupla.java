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
public class Dupla {
    private int primerDato;
    private int segundoDato;

    public Dupla() {
    }

    public Dupla(int primerDato, int segundoDato) {
        this.primerDato = primerDato;
        this.segundoDato = segundoDato;
    }

    public int getPrimerDato() {
        return primerDato;
    }

    public void setPrimerDato(int primerDato) {
        this.primerDato = primerDato;
    }

    public int getSegundoDato() {
        return segundoDato;
    }

    public void setSegundoDato(int segundoDato) {
        this.segundoDato = segundoDato;
    }
}
