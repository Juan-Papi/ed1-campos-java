package negocio;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 59178
 */
public class ListaDobleG<Tipovar extends Comparable> implements Serializable {

    NodoDobleGP<Tipovar> Inicio;
    NodoDobleGP<Tipovar> Fin;
    int cant;

    public ListaDobleG() {
        this.Inicio = null;
        this.Fin = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (cant == 0);

    }

    public void Insertar(Tipovar ele) {// inserta un nodo por el inicio
        if (vacia()) {
            NodoDobleGP<Tipovar> p = new NodoDobleGP();
            p.setDato(ele);
            Inicio = p;
            Fin = p;
            cant++;
        } else {
            NodoDobleGP<Tipovar> Aux = Inicio;
            while ((Aux != null) && (Aux.getDato().compareTo(ele) < 0)) {
                Aux = Aux.getEnlaceDer();
            }

            if (Aux == Inicio) {
                if (Aux.getDato() != ele) {
                    NodoDobleGP<Tipovar> p = new NodoDobleGP();
                    p.setDato(ele);
                    p.setEnlaceDer(Aux);
                    Aux.setEnlaceIzq(p);
                    Inicio = p;
                    cant++;
                }
            } else {
                if (Aux != null) {// esta en el cuerpo
                    if (Aux.getDato() != ele) {
                        NodoDobleGP<Tipovar> p = new NodoDobleGP();
                        p.setDato(ele);
                        p.setEnlaceDer(Aux);
                        p.setEnlaceIzq(Aux.getEnlaceIzq());
                        Aux.getEnlaceIzq().setEnlaceDer(p);
                        Aux.setEnlaceIzq(p);
                        cant++;

                    }
                } else { //se fue hasta null

                    NodoDobleGP<Tipovar> p = new NodoDobleGP();
                    p.setDato(ele);
                    Fin.setEnlaceDer(p);
                    p.setEnlaceIzq(Fin);
                    Fin = p;
                    cant++;
                }
            }

        }
    }

    public void Eliminar(Tipovar ele) {
        if (Existe(ele)) {
            if (this.cant == 1) {
                this.Inicio = null;
                this.Fin = null;
                this.cant--;
            } else {
                NodoDobleGP<Tipovar> aux = this.Inicio;
                while ((aux != null) && (aux.getDato().compareTo(ele) != 0)) {
                    aux = aux.getEnlaceDer();
                }
                if (aux != null) {
                    if (aux == Inicio) {//Eliminamos en el inicio
                        this.Inicio = aux.getEnlaceDer();
                        this.Inicio.setEnlaceIzq(null);
                        cant--;

                    } else {
                        if (aux != Fin) {//Eliminamos en el cuerpo
                            aux.getEnlaceIzq().setEnlaceDer(aux.getEnlaceDer());
                            aux.getEnlaceDer().setEnlaceIzq(aux.getEnlaceIzq());
                            cant--;
                        } else {//Eliminamos en el fin
                            Fin = aux.getEnlaceIzq();
                            Fin.setEnlaceDer(null);
                            cant--;
                        }
                    }
                }
            }
        }
    }

    public boolean Existe(Tipovar ele) {
        NodoDobleGP<Tipovar> aux = this.Inicio;
        boolean bandera = false;
        while ((aux != null) && (aux.getDato().compareTo(ele) != 0)) {
            aux = aux.getEnlaceDer();
        }
        if (aux != null) {
            bandera = true;
        }
        return bandera;
    }

    public void InsertarInicio(Tipovar ele) {// inserta un nodo en el inicio
        NodoDobleGP<Tipovar> p = new NodoDobleGP();
        p.setDato(ele);
        p.setEnlaceDer(Inicio);
        Inicio.setEnlaceIzq(p);
        Inicio = p;
        cant++;
    }

    public void InsertarFin(Tipovar ele) {//inserta un nodo en el fin
        NodoDobleGP<Tipovar> p = new NodoDobleGP();
        p.setDato(ele);
        Fin.setEnlaceDer(p);
        p.setEnlaceIzq(Fin);
        this.Fin = p;
        cant++;
    }

    public void InsertarPorFin(Tipovar ele) {// inserta un nodo por el final
        if (vacia()) {//Inserta el primer elemento
            NodoDobleGP<Tipovar> p = new NodoDobleGP();
            p.setDato(ele);
            Inicio = p;
            Fin = p;
            cant++;
        } else {
            NodoDobleGP<Tipovar> aux = Fin;
            while ((aux != null) && (aux.getDato().compareTo(ele) == 1)) {
                aux = aux.getEnlaceIzq();
            }
            NodoDobleGP<Tipovar> p = new NodoDobleGP();
            p.setDato(ele);
            if (aux == null) {
                //Inserta al inicio

                p.setEnlaceDer(Inicio);
                Inicio.setEnlaceIzq(p);
                Inicio = p;
                cant++;//}

            } else {
                if (aux != Fin) {//Inserta en el cuerpo
                    if (aux.getDato().compareTo(ele) != 0) {
                        p.setEnlaceDer(aux.getEnlaceDer());
                        aux.getEnlaceDer().setEnlaceIzq(p);
                        aux.setEnlaceDer(p);
                        p.setEnlaceIzq(aux);
                        cant++;
                    }
                } else {//Inserta al final
                    if (aux.getDato().compareTo(ele) != 0) {
                        Fin.setEnlaceDer(p);
                        p.setEnlaceIzq(Fin);
                        Fin = p;
                        cant++;
                    }
                }
            }
        }

    }

    //Método insertar para el dominó
    public void insertarDomin(int izquierda, int derecha) {
        NodoDobleGP<Tipovar> p = new NodoDobleGP<>();
        p.setDer(derecha);
        p.setIzq(izquierda);
        if (vacia()) {
            Inicio = p;
            Fin = p;
            cant++;
        } else {

            if (izquierda == Fin.getDer()) {
                Fin.setEnlaceDer(p);
                p.setEnlaceIzq(Fin);
                Fin = p;
                cant++;
            } else {
                if (derecha == Inicio.getIzq()) {
                    p.setEnlaceDer(Inicio);
                    Inicio.setEnlaceIzq(p);
                    Inicio = p;
                    cant++;
                } else {//Intercambiamos izquierda con derecha
                    int aux = izquierda;
                    izquierda = derecha;
                    derecha = aux;
                     p.setDer(derecha);
                     p.setIzq(izquierda);
                    if (izquierda == Fin.getDer()) {
                        Fin.setEnlaceDer(p);
                        p.setEnlaceIzq(Fin);
                        Fin = p;
                        cant++;
                    } else {
                        if (derecha == Inicio.getIzq()) {
                            p.setEnlaceDer(Inicio);
                            Inicio.setEnlaceIzq(p);
                            Inicio = p;
                            cant++;
                        }
                    }
                }

            }
        }
    }

    //Para el dominó
    public String toStringDomin() {
        String S = "Inicio";
        NodoDobleGP<Tipovar> aux = Inicio;
        while (aux != null) {
            S = S + aux.toStringDomin();
            aux = aux.getEnlaceDer();
        }
        S = S + "Fin";
        return S;
    }

    public static void main(String[] args) {
        //---------------------------------------------------------
        ListaDobleG<Integer> L = new ListaDobleG<>();
        //El insertar normal por inicio funciona correctamente!! 
        /*L.Insertar(5);/
        L.Insertar(6);
        L.Insertar(8);
       // L.InsertarInicio(20);//correcto!!
        //L.InsertarFin(1);//correcto!!
        L.Insertar(5);
        L.Insertar(8);
        L.Insertar(6);*/
        //-----------------------------------------------------
        /*L.InsertarPorFin(2);
        L.InsertarPorFin(4);
        L.InsertarPorFin(7);
        /* L.InsertarPorFin(2);
         L.InsertarPorFin(4);
         L.InsertarPorFin(7);*/
 /*System.out.println(L.toString());
        L.Eliminar(1);
        /*L.Eliminar(2);
        L.Eliminar(7);*/
        // System.out.println(L.toString());
        //-----------------------------------------------------
        //PARA EL DOMINÓ
        /* ListaDobleG<Character> D=new ListaDobleG<>();
         D.insertarDomin('A','B');
         D.insertarDomin('B','C');
         D.insertarDomin('D','A');
         D.insertarDomin('C','D');
         D.insertarDomin('X','Y');
         D.insertarDomin('P','D');
         D.insertarDomin('D','F');
         D.insertarDomin('M','N');
         System.out.println(D.toStringDomin());
         System.out.println(D.cant);*/
        //-------------------------------------------------------
        ListaDobleG<Integer> D = new ListaDobleG<>();
        D.insertarDomin(1, 2);
        D.insertarDomin(2, 1);
        D.insertarDomin(1, 5);
        D.insertarDomin(5, 1);
        D.insertarDomin(6, 1);
        D.insertarDomin(2, 6);
        D.insertarDomin(3, 2);
        D.insertarDomin(8, 1);
        D.insertarDomin(3, 7);
        System.out.println(D.toStringDomin());
        System.out.println(D.cant);
    }
}
