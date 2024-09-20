/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;

/**
 *
 * @author Juan Pablo Rodriguez
 */
public class ListaG<Tipovar extends Comparable> implements Serializable {

    NodoGP<Tipovar> L;
    int Cant;

    public ListaG() {
        L = null;
        Cant = 0;
    }

    public int cantidad() {
        return Cant;
    }

    public void Insertar(Tipovar Dato) {
        if (L == null) { //esta vacia
            NodoGP P = new NodoGP<Tipovar>();
            P.SetDato(Dato);
            L = P;
            Cant++;
        } else {
            NodoGP<Tipovar> Ant = null;
            NodoGP<Tipovar> Aux = L;
            while ((Aux != null) && (Aux.GetDato().compareTo(Dato) <= 0)) {
                Ant = Aux;
                Aux = Aux.GetEnlace();
            }
            NodoGP P = new NodoGP<Tipovar>(Dato);
            if (Ant == null) {//inserta en el primero                
                P.SetEnlace(L);
                L = P;
                Cant++;
            } else {
                // if (Ant.GetDato().compareTo(Dato)!=0) {                             
                Ant.SetEnlace(P);
                P.SetEnlace(Aux);
                Cant++;
                // }
            }
        }
    }

    public String Mostrar() {
        String S = "Vacia !!!";
        if (L != null) {
            S = "";
            NodoGP P = L;
            while (P != null) {
                if (P.GetEnlace() == null) {
                    S = S + P.GetDato();
                } else {
                    S = S + P.GetDato() + "->";
                }
                P = P.GetEnlace();
            }
        }
        return S;
    }

    public Boolean Buscar(Tipovar Dato) {
        if (L == null) {
            return (false);
        } else {
            NodoGP<Tipovar> Aux = L;
            while ((Aux != null) && (Aux.GetDato().compareTo(Dato) != 0)) {
                Aux = Aux.GetEnlace();
            }
            if (Aux != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Tipovar Getdato(int pos) {
        NodoGP<Tipovar> Aux = L;
        for (int i = 1; i < pos; i++) {
            Aux = Aux.GetEnlace();

        }
        return (Aux.GetDato());
    }

    public Tipovar BuscarObj(Tipovar Dato) {
        if (L == null) {
            return Dato;
        } else {
            NodoGP<Tipovar> Aux = L;
            while ((Aux != null) && (Aux.GetDato().compareTo(Dato) != 0)) {
                Aux = Aux.GetEnlace();
            }
            if (Aux != null) {
                Dato = Aux.GetDato();
                return Dato;
            }//--
            else {//--
                Tipovar obj = null;//--
                return obj;    //--
            }//--

        }
    }

    public boolean Modificar(Tipovar Dato) {
        if (L == null) {
            return false;
        } else {
            NodoGP<Tipovar> Aux = L;
            while ((Aux != null) && (Aux.GetDato().compareTo(Dato) != 0)) {
                Aux = Aux.GetEnlace();
            }
            if (Aux != null) {
                Aux.Dato = Dato;
                return true;
            }
            return false;
        }
    }

    public void Eliminar(Tipovar ele) {
        if (L != null) {
            NodoGP<Tipovar> Aux = L;
            NodoGP<Tipovar> Ant = null;
            while ((Aux != null) && (Aux.GetDato().compareTo(ele) != 0)) {
                Ant = Aux;
                Aux = Aux.GetEnlace();
            }
            if (Aux != null) {
                if (Ant == null) {
                    L = L.GetEnlace();
                    Cant--;

                } else {
                    Ant.SetEnlace(Aux.GetEnlace());
                    Cant--;
                }
            }
        }

    }
    //M1 (quitar lo condicion del insertar para comprobar)

    public void EliminarUnicos() {

        //Forma 1 de inicializar
        /*NodoGP aux1=new NodoGP<Tipovar>();
          NodoGP aux2=new NodoGP<Tipovar>();
          NodoGP aux3=new NodoGP<Tipovar>();*/
        //Forma 2 de inicializar
        NodoGP<Tipovar> aux1 = L;
        NodoGP<Tipovar> aux2 = L;
        NodoGP<Tipovar> fijo = L;
        while (aux2 != null) {
            Tipovar Dato = aux2.GetDato();
            int fr = 0;//fr=frecuencia
            while (aux1 != null) {
                if (aux1.GetDato() == Dato) {
                    fr++;
                }
                aux1 = aux1.GetEnlace();
            }
            if (fr == 1) {//Si queremos eliminar los repetidos
                //Lo unico que hacemos es poner fr>1
                Eliminar(Dato);
            }
            aux1 = fijo;
            aux2 = aux2.GetEnlace();
        }

    }

    public void intercalar() {
        if (Cant > 1) {
            NodoGP<Tipovar> aux, ant;
            if (Cant % 2 != 0) {
                //Entra cuando la lista es impar
                ant = L;
                aux = ant.GetEnlace();
            } else {
                //Entra cuando la lista es par
                ant = new NodoGP<>();
                aux = L;
            }
            while (aux != null) {
                NodoGP<Tipovar> pos = aux.GetEnlace();
                aux.SetEnlace(pos.GetEnlace());
                pos.SetEnlace(aux);
                ant.SetEnlace(pos);
                if (aux == L) {
                    L = pos;
                }
                /*else {//forma 2
                    ant.SetEnlace(pos);
                }*/
                ant = aux;
                aux = aux.GetEnlace();
            }

        }
    }

    public void volcar2() {//Pregunta examen
        if (Cant > 1) {
            NodoGP<Tipovar> ant, aux;
            ant = new NodoGP<>();
            aux = L;
            if (Cant % 2 == 0) {

                while (aux != null) {
                    NodoGP<Tipovar> pos = aux.GetEnlace();
                    aux.SetEnlace(pos.GetEnlace());
                    pos.SetEnlace(aux);
                    ant.SetEnlace(pos);
                    if (aux == L) {
                        L = pos;
                    }
                    /*else {//forma 2
                    ant.SetEnlace(pos);
                }*/
                    ant = aux;
                    aux = aux.GetEnlace();
                }
            } else {
                while (aux.GetEnlace() != null) {
                    NodoGP<Tipovar> pos = aux.GetEnlace();
                    aux.SetEnlace(pos.GetEnlace());
                    pos.SetEnlace(aux);
                    ant.SetEnlace(pos);
                    if (aux == L) {
                        L = pos;
                    }
                    /*else {//forma 2
                    ant.SetEnlace(pos);
                }*/
                    ant = aux;
                    aux = aux.GetEnlace();
                }
            }
        }
    }

    @Override
    public String toString() {
        String S = "L->";
        NodoGP<Tipovar> Aux = L;
        while (Aux != null) {
            S = S + Aux.toString() + "-> ";
            Aux = Aux.GetEnlace();

        }
        S = S + "null";
        return S;
    }

    public static void main(String[] args) {
        /*ListaG L=new ListaG<Integer>();
          L.Insertar(5);
          L.Insertar(8);
          L.Insertar(8);
          L.Insertar(2);
          L.Insertar(9);
          L.Insertar(9);
          L.Insertar(9);
          L.Insertar(10);
          //Lo corregimos el buscarObj y ya esta comprobado
          //Devuelve null cuando no lo encuentra
          //System.out.println(L.BuscarObj(9));
          L.EliminarUnicos();//Funciona correctamente
          System.out.println(L.toString());*/

 /* ListaG LC = new ListaG<Character>();
        LC.Insertar('a');
        LC.Insertar('a');
        LC.Insertar('a');
        LC.Insertar('v');
        LC.Insertar('b');
        LC.Insertar('b');
        LC.Insertar('b');
        LC.Insertar('z');
        LC.Insertar('d');
        LC.EliminarUnicos();//Funciona correctamente
        System.out.println(LC.toString());*/
        ListaG<Integer> L = new ListaG<>();
        L.Insertar(1);
        L.Insertar(2);
        L.Insertar(3);
       /* L.Insertar(4);
        L.Insertar(5);+
        L.Insertar(6);*/
        //L.Insertar(7);
        System.out.println(L.toString());
        L.volcar2();//El volcar2 funciona correctamente
        System.out.println(L.toString());

    }

}
