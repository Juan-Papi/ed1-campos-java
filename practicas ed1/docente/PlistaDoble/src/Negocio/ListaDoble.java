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
public class ListaDoble {

    NodoDoble Inicio;
    NodoDoble Fin;
    int cant;

    public ListaDoble() {
        this.Inicio = null;
        this.Fin = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return (cant == 0);

    }

    public void Insertar(int ele) {// inserta un nodo por el inicio
        if (vacia()) {
            NodoDoble p = new NodoDoble();
            p.setDato(ele);
            Inicio = p;
            Fin = p;
            cant++;
        } else {
            NodoDoble Aux = Inicio;
            while ((Aux != null) && (Aux.getDato() < ele)) {
                Aux = Aux.getEnlaceDer();
            }

            if (Aux == Inicio) {
                if (Aux.getDato() != ele) {
                    NodoDoble p = new NodoDoble();
                    p.setDato(ele);
                    p.setEnlaceDer(Aux);
                    Aux.setEnlaceIzq(p);
                    Inicio = p;
                    cant++;
                }
            } else { 
                if (Aux != null) {// esta en el cuerpo
                    if (Aux.getDato() != ele) {
                        NodoDoble p = new NodoDoble();
                        p.setDato(ele);
                        p.setEnlaceDer(Aux);
                        p.setEnlaceIzq(Aux.getEnlaceIzq());
                        Aux.getEnlaceIzq().setEnlaceDer(p);
                        Aux.setEnlaceIzq(p);
                        cant++;

                    }
                } else { //se fue hasta null

                    NodoDoble p = new NodoDoble();
                    p.setDato(ele);
                    Fin.setEnlaceDer(p);
                    p.setEnlaceIzq(Fin);
                    Fin = p;
                    cant++;
                }
            }

        }
    }

    public void Eliminar(int ele) {
        if (Existe(ele)) {
            if (this.cant == 1) {
                this.Inicio = null;
                this.Fin = null;
                this.cant--;
            } else {
                NodoDoble aux = this.Inicio;
                while ((aux != null) && (aux.getDato() != ele)) {
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

    public boolean Existe(int ele) {
        NodoDoble aux = this.Inicio;
        boolean bandera = false;
        while ((aux != null) && (aux.getDato() != ele)) {
            aux = aux.getEnlaceDer();
        }
        if (aux != null) {
            bandera = true;
        }
        return bandera;
    }

    public void InsertarInicio(int ele) {// inserta un nodo en el inicio
        NodoDoble p = new NodoDoble();
        p.setDato(ele);
        p.setEnlaceDer(Inicio);
        Inicio.setEnlaceIzq(p);
        Inicio = p;
        cant++;
    }

    public void InsertarFin(int ele) {//inserta un nodo en el fin
        NodoDoble p = new NodoDoble();
        p.setDato(ele);
        Fin.setEnlaceDer(p);
        p.setEnlaceIzq(this.Fin);
        this.Fin = p;
        cant++;
    }

    public void InsertarPorFin(int ele) {// inserta un nodo por el final
        if (vacia()) {//Inserta el primer elemento
            NodoDoble p = new NodoDoble();
            p.setDato(ele);
            Inicio = p;
            Fin = p;
            cant++;
        } else {
            NodoDoble aux = this.Fin;
            while ((aux != null) && (aux.getDato() > ele)) {
                aux = aux.getEnlaceIzq();
            }
            NodoDoble p = new NodoDoble();
            p.setDato(ele);
            if (aux == null) {
                //Inserta al inicio

                p.setEnlaceDer(Inicio);
                Inicio.setEnlaceIzq(p);
                this.Inicio = p;
                cant++;//}

            } else {
                if (aux != Fin) {//Inserta en el cuerpo
                    if (aux.getDato() != ele) {
                        p.setEnlaceDer(aux.getEnlaceDer());
                        aux.getEnlaceDer().setEnlaceIzq(p);
                        aux.setEnlaceDer(p);
                        p.setEnlaceIzq(aux);
                        cant++;
                    }
                } else {//Inserta al final
                    if (aux.getDato() != ele) {
                        Fin.setEnlaceDer(p);
                        p.setEnlaceIzq(Fin);
                        this.Fin = p;
                        cant++;
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        String S = "Inicio";
        NodoDoble Aux = Inicio;
        while (Aux != null) {
            S = S + Aux.toString() ;
            Aux = Aux.getEnlaceDer();
        }
        S = S + "FIN";
        return S;
    }

    public static void main(String[] args) {
        //Los métodos funcionan correctamente!!
        ListaDoble L = new ListaDoble();
        L.InsertarPorFin(6);
        L.InsertarPorFin(10);
        L.InsertarPorFin(5);
        L.InsertarPorFin(7);
        L.InsertarPorFin(8);
        //L.Insertar(8);
        System.out.println(L.toString());
        //System.out.println(L.cant);
        L.Eliminar(6);

        System.out.println(L.toString());

        L.InsertarInicio(15);

        L.InsertarFin(1);
        L.Eliminar(5);
        System.out.println(L.toString());
        //System.out.println(L.cant);
        /*System.out.println(L.Existe(8));
        System.out.println(L.Existe(15));*/

    }
}
