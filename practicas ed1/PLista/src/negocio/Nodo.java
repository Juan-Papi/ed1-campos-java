/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author 59178
 */
public class Nodo {

    //Atributos
    int dato;
    Nodo Enlace;

    //Constructor
    public Nodo() {
        this.dato = 0;
        Enlace = null;
    }

    //Constructor parametrizado
    public Nodo(int dato) {
        this.dato = dato;
        Enlace = null;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return this.dato;
    }

    public void setEnlace(Nodo p) {
        this.Enlace = p;
    }

    public Nodo getEnlace() {
        return this.Enlace;
    }

    //Mostrar
    public String toString() {
        String S = "[Dato= ";
        S = S + getDato() + "| ]";
        return S;
    }

    public static void main(String[] args) {
        Nodo a = new Nodo();
        a.setDato(9);
        System.out.println(a.toString());
    }
}
