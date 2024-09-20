/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author 59178
 */
public class GenericaPilaL<Tipovar> implements Serializable {

    NodoGP<Tipovar> Cima;
    int cant;

    public GenericaPilaL() {
        this.Cima = null;
        this.cant = 0;
    }

    public boolean Vacia() {
        return Cima == null;
    }

    public void Push(Tipovar ele) {
        NodoGP<Tipovar> p = new NodoGP();
        p.SetDato(ele);
        p.SetEnlace(Cima);
        Cima = p;
        cant++;
    }

    public Tipovar Pop() {
        Tipovar x = Cima.GetDato();
        Cima = Cima.GetEnlace();
        cant--;
        return x;
    }

    public Tipovar Get() {
        return Cima.GetDato();
    }

    public int getCant() {

        return cant;
    }

    public void EliminarRep() {
        GenericaColaL<Tipovar> Q = new GenericaColaL();
        while (Cima != null) {
            if (Q.vacia()) {
                Q.Encolar(Pop());
            } else {
                Tipovar pivote = Q.Get();
                if (Get() != pivote) {
                    Q.Encolar(Pop());
                } else {
                    Pop();
                }
            }
        }
        int CantCola = Q.cant;
        for (int i = 1; i <= CantCola; i++) {
            Push(Q.Decolar());
        }
        for (int j = 1; j <= CantCola; j++) {
            Q.Encolar(Pop());
        }
        for (int k = 1; k <= CantCola; k++) {
            Push(Q.Decolar());
        }
    }

    @Override
    public String toString() {
        String S = "";
        NodoGP<Tipovar> Aux = Cima;
        while (Aux != null) {
            S = S + Aux.GetDato() + '\n';
            Aux = Aux.GetEnlace();

        }
        S = S + "P\n";
        return S;
    }

    public static void main(String[] args) {
        //----------------------------------------------------------
        /*GenericaPilaL<Character> Pila1=new GenericaPilaL();
        
        Pila1.Push('+');
         Pila1.Push('-');
          Pila1.Push('*');
          System.out.println(Pila1.toString());*/
        //-----------------------------------------------------------
        GenericaPilaL<Integer> P = new GenericaPilaL<>();
        /*P.Push(1);
        P.Push(1);
        P.Push(2);
        P.Push(2);
        P.Push(2);
        P.Push(4);*/
        
        P.Push(6);
        P.Push(1);
        P.Push(1);
        P.Push(2);
        P.Push(3);
        P.Push(3);
        P.Push(3);
        System.out.println(P.toString());
        P.EliminarRep();
        System.out.println(P.toString());
    }

}
