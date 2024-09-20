/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

public class Nodo {

    int Dato;
    Nodo Enlace;

    public Nodo(int Dato, Nodo Enlace) {
        this.Dato = Dato;
        this.Enlace = Enlace;
    }

    public Nodo() {
        Enlace = null;
    }
    public int getDato() {
        return Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public void setEnlace(Nodo Enlace) {
        this.Enlace = Enlace;
    }
    @Override
    public String toString() {
        String s = "";
        // while (Link != null) {
        s = s + "[" + Dato + "]" + Enlace;
        // }
        return s; //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
    Nodo P = new Nodo();
    Nodo Q = new Nodo();
    Nodo R = new Nodo();
    P.setDato(8);
    Q.setDato(9);
    R.setDato(10);
    P.setEnlace(Q);
    P.setEnlace(R);
    P.setEnlace(Q);
    System.out.println(P.toString());
    
    }

}
