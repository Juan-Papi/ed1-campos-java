/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Mario Campos
 */
public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (L == null);

    }

    public void insertar(int ele) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(ele);
            L = p;
            cant++;
        } else { // hay mas elementos
            Nodo Aux = L;
            Nodo Ant = null;
            while ((Aux != null) && (Aux.getDato() <= ele)) {
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Ant == null)// Insertamos en la Cabeza
            {
                Nodo p = new Nodo();
                p.setDato(ele);
                p.setEnlace(L);
                L = p;
                cant++;

            } else {
                if (Ant.getDato() != ele) {

                    Nodo p = new Nodo();
                    p.setDato(ele);
                    Ant.setEnlace(p);
                    p.setEnlace(Aux);
                    cant++;

                }
            }

        }

    }

    public void Eliminar(int ele) {
        if (!vacia()) {
            Nodo Aux = L;
            Nodo Ant = null;
            while ((Aux != null) && (Aux.getDato() != ele)) {
                Ant = Aux;
                Aux = Aux.getEnlace();
            }
            if (Aux != null) {
                if (Ant == null) {
                    L = L.getEnlace();
                    cant--;

                } else {
                    Ant.setEnlace(Aux.getEnlace());
                    cant--;
                }
            }
        }

    }

    public boolean Existe(int ele) {
        boolean x = false;
        if (!vacia()) {
            Nodo Aux = L;
            while ((Aux != null) && (Aux.getDato() != ele)) {
                Aux = Aux.getEnlace();
            }
            if (Aux != null) {
                x = true;
            }
        }
        return x;
    }
    //No usar es muy caro

    public int getDato(int pos) {//pre la posicion debe estar en rango
        Nodo Aux = L;
        for (int i = 1; i < pos; i++) {
            Aux = Aux.getEnlace();

        }
        return (Aux.getDato());
    }

    public void invertir() {
        invertirR(L);

    }

    private void invertirR(Nodo p) {//Invertir modo recursivo mas corto y sencillo!!
        if (p == null) {//1er caso base
            //cuando la lista esta vacía
            //nada
        } else {
            if (p.getEnlace() == null) {//2do caso base
                //cuando la lista tiene un elemento
                L = p;
            } else {//caso general
                invertirR(p.getEnlace());
                p.getEnlace().setEnlace(p);
                p.setEnlace(null);

            }
        }
    }

    public void insertarR(){
        
    }

    public void eliminarR() {//Eliminar recursivo tarea

    }

    public int getDatoR(int pos) {//Recursivo tarea
        return 0;
    }

    public String toStringR() {//to String Recursivo tarea
        return "";
    }

    @Override
    //Falta modificar este toString para no usar el getDato
    //que ocupa muchos recursos
    public String toString() {
        String S = "L->  < ";
        Nodo Aux = L;
        while (Aux != null) {
            S = S + Aux.getDato() + " , ";
            Aux = Aux.getEnlace();

        }
        S = S + " > ";
        return S;

    }

    public static void main(String[] args) {
        Lista LI = new Lista();
       LI.insertar(5);
        LI.insertar(1);
        LI.insertar(9);
        LI.insertar(10);
        
        System.out.println(LI.toString());
        /*LI.invertir();
        System.out.println(LI.toString());*/

    }

}
